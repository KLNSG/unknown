package user.pojo;

import java.util.Date;

public class Forum {
    private  Integer forumId;
    private String forumContent;
    private Date forumTime;
    private Integer userId;

    public Forum() {
    }

    public Forum(Integer forumId, String forumContent, Date forumTime,Integer userId) {
        this.forumId = forumId;
        this.forumContent = forumContent;
        this.forumTime = forumTime;
        this.userId=userId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getForumId() {
        return forumId;
    }

    public void setForumId(Integer forumId) {
        this.forumId = forumId;
    }

    public String getForumContent() {
        return forumContent;
    }

    public void setForumContent(String forumContent) {
        this.forumContent = forumContent;
    }

    public Date getForumTime() {
        return forumTime;
    }

    public void setForumTime(Date forumTime) {
        this.forumTime = forumTime;
    }

    @Override
    public String toString() {
        return "Forum{" +
                "forumId=" + forumId +
                ", forumContent='" + forumContent + '\'' +
                ", forumTime=" + forumTime +
                ", userId=" + userId +
                '}';
    }
}
