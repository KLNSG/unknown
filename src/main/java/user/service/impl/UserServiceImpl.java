package user.service.impl;

import base.Message;
import user.dao.UserDao;
import user.dao.impl.UserDaoImpl;
import user.pojo.User;
import user.service.UserService;

import java.util.List;

public class UserServiceImpl implements UserService {

    UserDao userDao=new UserDaoImpl();

    private boolean checkUsername(String userName){
        User user = new User();
        user.setUserName(userName);
        List<User> userList = userDao.listUserByInfo(user);
        if (userList==null || userList.isEmpty()){
            return true;
        }
        return false;
    }

    @Override
    public Message save(User user) {
        boolean b = checkUsername(user.getUserName());
        if (b){
            int i = userDao.addUser(user);
            if (i>0){
                return Message.SUCCESS();
            }
        }
        return new Message(-1,"用户名重复",null);
    }

    @Override
    public Message Login(User user) {
        User data=new User();
        data.setUserName(user.getUserName());
        List<User> users = userDao.listUserByInfo(data);
        if (users==null || users.isEmpty()){
            return new Message(-1,"没有找到该用户");
        }
        data= users.get(0);
        if (User.IS_DISABLE.equals(data.getIsEnable())){
            return new Message(-1,"该用户已被禁用");
        }
        if (user.getUserPassword().equals(data.getUserPassword())) {
            return new Message<User>(1,"成功",data);
        }
        return new Message(-1,"用户名或密码错误");
    }

    @Override
    public Message checkUserName(String userName) {
        boolean isCheckRepeat = checkUsername(userName);
        if (isCheckRepeat){
            return Message.SUCCESS();
        }
        return Message.FAIL();
    }
}
