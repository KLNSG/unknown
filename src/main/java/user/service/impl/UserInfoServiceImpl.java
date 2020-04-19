package user.service.impl;

import base.Message;
import user.dao.UserInfoDao;
import user.dao.impl.UserInfoDaoImpl;
import user.pojo.UserInfo;
import user.service.UserInfoService;

public class UserInfoServiceImpl implements UserInfoService {
    UserInfoDao userInfoDao=new UserInfoDaoImpl();

    @Override
    public Message infoAdd(UserInfo userInfo) {
        return userInfoDao.addInfo(userInfo)>0?Message.SUCCESS():Message.FAIL();
    }

    @Override
    public Message update(UserInfo userInfo) {
        return userInfoDao.update(userInfo)>0?Message.SUCCESS():Message.FAIL();
    }
}
