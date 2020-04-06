package user.service.impl;

import base.Message;
import user.dao.UserDao;
import user.dao.impl.UserDaoImpl;
import user.pojo.User;
import user.service.UserService;

import java.util.List;

public class UserServiceImpl implements UserService {

    UserDao userDao=new UserDaoImpl();

    @Override
    public Message save(User user) {
        return null;
    }

    @Override
    public Message Login(User user) {
        User data=new User();
        data.setName(user.getName());
        List<User> users = userDao.listUserByInfo(data);
        if (users==null || users.isEmpty()){
            return new Message(-1,"没有找到该用户",null);
        }
        data= users.get(0);
        if (user.getPassword().equals(data.getPassword())){
            return Message.SUCCESS();
        }
        return new Message(-1,"用户名或密码错误",null);
    }
}
