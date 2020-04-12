package user.servlet;
import	java.awt.TrayIcon.MessageType;

import base.Message;
import com.alibaba.fastjson.JSON;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import user.pojo.User;
import user.service.UserService;
import user.service.impl.UserServiceImpl;
import util.PassEncryptUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.util.*;

@WebServlet(name = "UserServlet", urlPatterns = "/user")
public class UserServlet extends HttpServlet {

    private void printMessage(HttpServletResponse response, Message message) {
        PrintWriter writer = null;
        try {
            writer = response.getWriter();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String str = JSON.toJSONString(message);
        writer.write(str);
        writer.flush();
        writer.close();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");
        String opt = request.getParameter("opt");
        if (opt == null) {

        } else {
            switch (opt) {
                case "login":
                    login(request, response);
                    break;
                case "add":
                    add(request, response);
                    break;
                default:
            }
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    UserService userService = new UserServiceImpl();

    private void login(HttpServletRequest request, HttpServletResponse response) {
        Map<String, String[]> parameterMap = request.getParameterMap();
        String username = parameterMap.get("username")[0];
        String password = parameterMap.get("password")[0];
        //TODO 加密密码
        Message login = userService.Login(new User(null, username, password));
        printMessage(response, login);
    }


    private void add(HttpServletRequest request, HttpServletResponse response) {
        Map<String, Object> data = new HashMap<>();
        try {
            data = getFilePath(request);
        } catch (Exception e) {
            e.printStackTrace();
        }
        String name = (String) data.get("name");
        String pass = (String) data.get("pass");
        String photo = (String) data.get("photo");
        //TODO 现在已经可以得到值了，重新设计下用户的数据库，要带头像状态满足需求，请用下划线 如 数据库 user_img，Java属性为 userImg
        /**改善了ObjectToParmterUtil 动态传参的方法，数据库字段下划线，java属性 驼峰即可识别*/
        printMessage(response,Message.FAIL());
    }

    private static Map<String, Object> getFilePath(HttpServletRequest request) throws Exception {
        int memory_threshold = 1024 * 1024 * 3;
        int max_file_size = 1024 * 1024 * 40;
        int max_request_size = 1024 * 1024 * 50;

        /*处理上传文件*/
        DiskFileItemFactory factory = new DiskFileItemFactory();
        factory.setSizeThreshold(memory_threshold);
        factory.setRepository(new File(System.getProperty("java.io.tmpdir")));

        ServletFileUpload upload = new ServletFileUpload(factory);
        upload.setFileSizeMax(max_file_size);
        upload.setSizeMax(max_request_size);
        upload.setHeaderEncoding("UTF-8");

        String uploadPath = request.getSession().getServletContext().getRealPath("Div") + "\\";
        String fileName = "";
        String filePath = "";
        File uploadDir = new File(uploadPath);
        if (!uploadDir.exists()) {
            uploadDir.mkdirs();
        }
        Map<String, Object> data = new HashMap<>();
        List<FileItem> formItems = upload.parseRequest(request);
        if (formItems != null && formItems.size() > 0) {
            for (FileItem item : formItems) {
                if (!item.isFormField()) {
                    StringBuilder suffixBuilder = new StringBuilder(item.getName());
                    String suffix = suffixBuilder.substring(suffixBuilder.indexOf("."));
                    StringBuilder imgNameBuilder = new StringBuilder(PassEncryptUtil.getToken(LocalDateTime.now().toString()));
                    String imgName = imgNameBuilder.substring(imgNameBuilder.length()-(int)(Math.random()*10+1));
                    fileName = new File(imgName+suffix).getName();
                    filePath = uploadPath + fileName;
                    File storeFile = new File(filePath);
                    item.write(storeFile);
                    data.put("fileName", fileName);
                    data.put("filePath", filePath);
                } else {
                    String value = item.getString("utf-8");
                    data.put(item.getFieldName(), value);
                }
            }
        }
        return data;
    }
}
