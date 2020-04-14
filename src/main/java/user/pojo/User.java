package user.pojo;

import java.util.Date;

public class User {

    /**
     * 使用
     * */
    public static final Integer IS_ENABLE=1;

    /**
     * 禁用
     * */
    public static final Integer IS_DISABLE=0;

    private Integer userId;
    private String  userName;
    private  String userPassword;
    private  String userPoto;
    private Date  createTime;
    private Integer isEnable;

    public User() {
    }

    public User(Integer userId, String userName, String userPassword) {
        this.userId = userId;
        this.userName = userName;
        this.userPassword = userPassword;
    }

    public User(Integer userId, String userName, String userPassword, String userPoto, Date createTime, Integer isEnable) {
        this.userId = userId;
        this.userName = userName;
        this.userPassword = userPassword;
        this.userPoto = userPoto;
        this.createTime = createTime;
        this.isEnable = isEnable;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserPoto() {
        return userPoto;
    }

    public void setUserPoto(String userPoto) {
        this.userPoto = userPoto;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getIsEnable() {
        return isEnable;
    }

    public void setIsEnable(Integer isEnable) {
        this.isEnable = isEnable;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", userPassword='" + userPassword + '\'' +
                ", userPoto='" + userPoto + '\'' +
                ", createTime=" + createTime +
                ", isEnable=" + isEnable +
                '}';
    }
}
