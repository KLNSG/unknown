package user.service.impl;

import base.dao.BaseDao;
import com.sun.xml.internal.ws.wsdl.writer.document.Message;
import user.pojo.Forum;
import user.service.ForumService;

import java.util.List;

public class ForumServiceImpl extends BaseDao implements ForumService {
    @Override
    public Message add(Forum forum) {
        return null;
    }

    @Override
    public Message delect(Integer id) {
        return null;
    }

    @Override
    public Message update(Forum forum) {
        return null;
    }

    @Override
    public List<Forum> list(Forum forum) {
        return null;
    }
}
