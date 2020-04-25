package user.dao;

import user.pojo.Forum;

import java.util.List;

public interface ForumDao {
    //增加
    int add(Forum forum);
    //删除
    int delect(Integer id);
    //修改
    int update(Forum forum);
    //查询
    List<Forum> list(Forum forum);
}
