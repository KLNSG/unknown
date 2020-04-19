package user.service;

import base.Message;
import user.pojo.UserInfo;

public interface UserInfoService {
    Message infoAdd(UserInfo userInfo);

    Message update(UserInfo userInfo);

    Message getInfo(Integer userId);
}
