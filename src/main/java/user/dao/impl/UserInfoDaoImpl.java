package user.dao.impl;

import base.dao.BaseDao;
import user.dao.UserInfoDao;
import user.pojo.UserInfo;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserInfoDaoImpl extends BaseDao implements UserInfoDao {
    @Override
    public int addInfo(UserInfo info) {
        String sql = "insert into  user_info  values(null,?,?,?,?,?)";
        Object[] objects = {info.getInfoGender(), info.getInfoPhone(),
                info.getInfoEmail(), info.getInfoComment(), info.getUserId()};
        return executeUpdate(sql, objects);
    }

    @Override
    public int update(UserInfo info) {
        String sql = "UPDATE user_info SET info_gender=?,info_phone=?,info_email=?,info_comment=? WHERE user_id=?";
        Object[] objects = {info.getInfoGender(), info.getInfoPhone(),
                info.getInfoEmail(), info.getInfoComment(), info.getUserId()};
        return executeUpdate(sql, objects);
    }

    @Override
    public UserInfo getUserInfoByUserId(Integer userId) {
        UserInfo info=null;
        con = getConnection();
        String sql = "select info_id, info_gender, info_phone, info_email, info_comment from user_info where user_id=?";
        try {
            pstat = con.prepareStatement(sql);
            pstat.setInt(1, userId);
            rs = pstat.executeQuery();
            if (rs.next()) {
                info = new UserInfo();
                info.setInfoId(rs.getInt("info_id"));
                info.setInfoGender(rs.getInt("info_gender"));
                info.setInfoPhone(rs.getString("info_phone"));
                info.setInfoEmail(rs.getString("info_email"));
                info.setInfoComment(rs.getString("info_comment"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return info;
    }



}
