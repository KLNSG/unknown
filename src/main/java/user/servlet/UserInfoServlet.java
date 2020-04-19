package user.servlet;

import base.Message;
import com.alibaba.fastjson.JSON;
import user.pojo.User;
import user.pojo.UserInfo;
import user.service.UserInfoService;
import user.service.impl.UserInfoServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "UserInfoServlet",urlPatterns = "/info")
public class UserInfoServlet extends HttpServlet {
    UserInfoService service=new UserInfoServiceImpl();

    private void printMessage(HttpServletResponse response, Message message) {
       PrintWriter writer=null;
        try {
           response.getWriter();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String str=JSON.toJSONString(message);
        writer.write(str);
        writer.flush();
        writer.close();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");
        String opt = request.getParameter("opt");
        if (opt==null){

        }else {
            switch (opt){
                case "add":
                    add(request,response);
                    break;
                case "update":
                    update(request,response);
                    break;
                default:
            }
        }
    }

    private void add(HttpServletRequest request, HttpServletResponse response) throws IOException {
        UserInfo userInfo=new UserInfo();
        userInfo.setInfoGender(Integer.valueOf(request.getParameter("infoGender")));
        userInfo.setInfoPhone(request.getParameter("infoPhone"));
        userInfo.setInfoEmail(request.getParameter("infoEmail"));
        userInfo.setInfoComment(request.getParameter("infoComment"));
        userInfo.setUserId(Integer.valueOf(request.getParameter("userId")));
        Message message = service.infoAdd(userInfo);
        printMessage(response,message);
    }
    private void update(HttpServletRequest request, HttpServletResponse response){
        UserInfo userInfo=new UserInfo();
        userInfo.setInfoGender(Integer.valueOf(request.getParameter("infoGender")));
        userInfo.setInfoPhone(request.getParameter("infoPhone"));
        userInfo.setInfoEmail(request.getParameter("infoEmail"));
        userInfo.setInfoComment(request.getParameter("infoComment"));
        userInfo.setUserId(Integer.valueOf(request.getParameter("userId")));
        Message message = service.update(userInfo);
        printMessage(response,message);
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      doPost(request,response);
    }
}
