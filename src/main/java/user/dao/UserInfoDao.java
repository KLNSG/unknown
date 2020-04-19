package user.dao;

import user.pojo.UserInfo;

public interface UserInfoDao {
     //增加
     int addInfo(UserInfo info);

     //修改
     int update(UserInfo info);
}
