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
        String sql = "select * from admin where id in (?)";
        try {
            pstat = con.prepareStatement(sql);
            pstat.setString(1, StringUtil.toString(userids));
            rs = pstat.executeQuery();
            while (rs.next()) {
                User u = new User();
                u.setId(rs.getInt("id"));
                u.setName(rs.getString("name"));
                u.setPassword(rs.getString("password"));
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
        StringBuilder sql = new StringBuilder("select * from admin where 1=1 ");
        if (user.getId() != null) {
            sql.append("and id=? ");
        }
        if (user.getName() != null) {
            sql.append("and name=? ");
        }
        if (user.getPassword() != null) {
            sql.append("and password=?");
        }
        try {
            pstat = con.prepareStatement(sql.toString());
            pstat = ObjectToParmterUtil.getParameterLocation(sql.toString(), pstat, user);
            rs = pstat.executeQuery();
            while (rs.next()) {
                User u = new User();
                u.setId(rs.getInt("id"));
                u.setName(rs.getString("name"));
                u.setPassword(rs.getString("password"));
                list.add(u);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public int addUser(User user) {
        return 0;
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
