package user.service;

import base.Message;
import user.pojo.User;

/**
 * 数据处理层（服务层），进行数据处理，返回servlet需要的数据
 * @author Lvxin
 **/
public interface UserService {

    Message save(User user);

    Message Login(User user);
}
