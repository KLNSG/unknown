package user.dao.impl;

import base.dao.BaseDao;
import user.dao.UserInfoDao;
import user.pojo.UserInfo;

public class UserInfoDaoImpl extends BaseDao implements UserInfoDao {
    @Override
    public int addInfo(UserInfo info) {
        String sql="insert into  user_info  values(null,?,?,?,?,?)";
        Object[] objects={info.getInfoGender(),info.getInfoPhone(),
         info.getInfoEmail(),info.getInfoComment(),info.getUserId()};
        return executeUpdate(sql,objects);
    }

    @Override
    public int update(UserInfo info) {
       String sql="UPDATE user_info SET info_gender=?,info_phone=?,info_email=?,info_comment=? WHERE user_id=?";
       Object[] objects={info.getInfoGender(),info.getInfoPhone(),
                info.getInfoEmail(),info.getInfoComment(),info.getUserId()};
        return executeUpdate(sql,objects);
    }
}
