package user.pojo;

public class UserInfo {

    private  Integer infoId;
    private  Integer infoGender;
    private  String  infoPhone;
    private  String infoEmail;
    private  String infoComment;
    private  Integer userId;
    public UserInfo() {
    }
    public UserInfo(Integer infoId, Integer infoGender, String infoPhone, String infoEmail, String infoComment, Integer userId) {
        this.infoId = infoId;
        this.infoGender = infoGender;
        this.infoPhone = infoPhone;
        this.infoEmail = infoEmail;
        this.infoComment = infoComment;
        this.userId = userId;
    }

    public Integer getInfoId() {
        return infoId;
    }

    public void setInfoId(Integer infoId) {
        this.infoId = infoId;
    }

    public Integer getInfoGender() {
        return infoGender;
    }

    public void setInfoGender(Integer infoGender) {
        this.infoGender = infoGender;
    }

    public String getInfoPhone() {
        return infoPhone;
    }

    public void setInfoPhone(String infoPhone) {
        this.infoPhone = infoPhone;
    }

    public String getInfoEmail() {
        return infoEmail;
    }

    public void setInfoEmail(String infoEmail) {
        this.infoEmail = infoEmail;
    }

    public String getInfoComment() {
        return infoComment;
    }

    public void setInfoComment(String infoComment) {
        this.infoComment = infoComment;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "infoId=" + infoId +
                ", infoGender=" + infoGender +
                ", infoPhone='" + infoPhone + '\'' +
                ", infoEmail='" + infoEmail + '\'' +
                ", infoComment='" + infoComment + '\'' +
                ", userId=" + userId +
                '}';
    }
}
