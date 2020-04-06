package user.dao;


import user.pojo.User;

import java.util.List;

/**
* 数据持久化层，只负责搬运数据，不参与处理
* */
public interface UserDao {

    /**
     * 根据用户Id查用户
     * @param userids
     * @return java.util.List<user.pojo.User>
     * @author Lvxin
     **/
    List<User> listUserByIds(String[] userids);

    /**
     * 根据用户信息查用户
     * @param user
     * @return java.util.List<user.pojo.User>
     * @author Lvxin
     **/
    List<User> listUserByInfo(User user);

    /**
     * 增加用户
     * @param user
     * @return
     * @author Lvxin
     **/
    int addUser(User user);

    /**
     * 删除用户
     * @param userid
     * @return int
     * @author Lvxin
     **/
    int delUser(String[] userid);

    /**
     * 修改用户
     * @param user
     * @return int
     * @author Lvxin
     **/
    int updateUser(User user);
}
