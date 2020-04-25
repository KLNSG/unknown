package user.dao.impl;

import base.dao.BaseDao;
import user.dao.ForumDao;
import user.pojo.Forum;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ForumDaoImpl extends BaseDao implements ForumDao {
    @Override
    public int add(Forum forum) {
        String sql="INSERT INTO `forum` VALUES(null,'?','?',?);";
        Object[] objects={forum.getForumId(),forum.getForumContent(),forum.getForumTime()};
        return executeUpdate(sql,objects);
    }

    @Override
    public int delect(Integer id) {
        String sql="DELETE FROM `luntan`.`forum` WHERE forum_id =?";
        Object[] obj={id};
        return executeUpdate(sql,obj);
    }

    @Override
    public int update(Forum forum) {
        String sql="UPDATE forum SET `forum_id`,`forum_content`,`forum_time`,`user_id`  WHERE forum_id=?";
        Object[] objects={forum.getForumId(),forum.getForumContent(),forum.getForumTime()};
        return executeUpdate(sql,objects);
    }

    @Override
    public List<Forum> list(Forum forum) {
        String sql="SELECT * FROM `luntan`.`forum`";
        con=getConnection();
        List<Forum> list=new ArrayList<>();
        try {
            pstat=con.prepareStatement(sql);
            rs=pstat.executeQuery();
            while (rs.next()){
               forum.setForumId(rs.getInt("forumId"));
               forum.setForumContent(rs.getString("forumContent"));
               forum.setForumTime(rs.getDate("forumTime"));
               forum.setUserId(rs.getInt("user_id"));
               list.add(forum);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }}