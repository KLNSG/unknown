package user.servlet;

import java.util.Date;

public class ForumServlet {
    private  Integer forumId;
    private String forumContent;
    private Date forumTime;

    public ForumServlet() {
    }

    public ForumServlet(Integer forumId, String forumContent, Date forumTime) {
        this.forumId = forumId;
        this.forumContent = forumContent;
        this.forumTime = forumTime;
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
                '}';
    }
}
