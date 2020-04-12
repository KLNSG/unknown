package user.service;

import base.Message;
import user.pojo.User;

/**
 * 数据处理层（服务层），进行数据处理，返回servlet需要的数据
 * @author Lvxin
 **/
public interface UserService {

    /**
     * 增加用户，用户名不能相同，密码加密
     * @param user
     * @return base.Message
     * @author Lvxin
     **/
    Message save(User user);

    /**
     * 登陆逻辑，根据用户名查找加密后的密码与前端密码进行匹配
     * @param user
     * @return base.Message
     * @author Lvxin
     **/
    Message Login(User user);

    Message checkUserName(String userName);
}
