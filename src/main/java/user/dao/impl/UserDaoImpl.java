package user.dao.impl;

import java.util.*;


import base.dao.BaseDao;
import user.dao.UserDao;
import user.pojo.User;
import util.ObjectToParmterUtil;
import util.StringUtil;

/**
 * 持久层实现
 *
 * @author Lvxin
 **/
public class UserDaoImpl extends BaseDao implements UserDao {

    @Override
    public List<User> listUserByIds(String[] userids) {
        List<User> list = new ArrayList<User>();
        con = getConnection();
        String sql = "select * from user where user_id in (?)";
        try {
            pstat = con.prepareStatement(sql);
            pstat.setString(1, StringUtil.toString(userids));
            rs = pstat.executeQuery();
            while (rs.next()) {
                User u = new User();
                u.setUserId(rs.getInt("user_id"));
                u.setUserName(rs.getString("user_name"));
                u.setUserPassword(rs.getString("user_password"));
                u.setUserPoto(rs.getString("user_poto"));
                u.setCreateTime(rs.getDate("create_time"));
                u.setIsEnable(rs.getInt("is_enable"));
                list.add(u);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public List<User> listUserByInfo(User user) {
        List<User> list = new ArrayList<User>();
        con = getConnection();
        StringBuilder sql = new StringBuilder("select * from user where 1=1 ");
        if (user.getUserId() != null) {
            sql.append("and user_id=? ");
        }
        if (user.getUserName() != null) {
            sql.append("and user_name=? ");
        }
        try {
            pstat = con.prepareStatement(sql.toString());
            pstat = ObjectToParmterUtil.getParameterLocation(sql.toString(), pstat, user);
            rs = pstat.executeQuery();
            while (rs.next()) {
                User u = new User();
                u.setUserId(rs.getInt("user_id"));
                u.setUserName(rs.getString("user_name"));
                u.setUserPassword(rs.getString("user_password"));
                u.setUserPoto(rs.getString("user_poto"));
                u.setCreateTime(rs.getDate("create_time"));
                u.setIsEnable(rs.getInt("is_enable"));
                list.add(u);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public int addUser(User user) {
       String sql="INSERT INTO user VALUES (NULL,?,?,?,?,?);";
       Object[] objects={user.getUserName(),user.getUserPassword(),user.getUserPoto(),
               user.getCreateTime(),user.getIsEnable()};
       return executeUpdate(sql,objects);
    }

    @Override
    public int delUser(String[] userid) {
        return 0;
    }

    @Override
    public int updateUser(User user) {
        return 0;
    }

}
