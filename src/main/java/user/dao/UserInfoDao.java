package user.dao;

import user.pojo.UserInfo;

import java.util.List;

public interface UserInfoDao {
     //增加
     int addInfo(UserInfo info);

     //修改
     int update(UserInfo info);

     UserInfo getUserInfoByUserId(Integer userId);

}
