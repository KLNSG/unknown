package user.service;

import com.sun.xml.internal.ws.wsdl.writer.document.Message;
import user.pojo.Forum;

import java.util.List;

public interface ForumService {
    //增加
    Message add(Forum forum);
    //删除
    Message delect(Integer id);
    //修改
    Message update(Forum forum);
    //查询
    List<Forum> list(Forum forum);
}
