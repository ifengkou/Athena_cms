package cn.ifengkou.athena.service.impl;

import cn.ifengkou.athena.common.id.IdGen;
import cn.ifengkou.athena.dao.ReplyDao;
import cn.ifengkou.athena.dao.UpsDao;
import cn.ifengkou.athena.dao.UserDao;
import cn.ifengkou.athena.model.Reply;
import cn.ifengkou.athena.model.Ups;
import cn.ifengkou.athena.model.User;
import cn.ifengkou.athena.service.ReplyService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Sloong on 2015/12/9.
 */
@Service
public class ReplyServiceImpl implements ReplyService {

    @Resource
    ReplyDao replyDao;

    @Resource
    UpsDao upsDao;

    @Resource
    UserDao userDao;

    @Override
    public List<Reply> getRepliesByTopicId(long topicId) {
        return replyDao.getRepliesByTopicId(topicId);
    }

    @Override
    public Reply getLastReplyByTopId(long topicId) {
        return replyDao.getLastReplyByTopId(topicId);
    }

    @Override
    public List<Reply> getRepliesByAuthorId(long authorId) {
        return replyDao.getRepliesByAuthorId(authorId);
    }

    @Override
    public int getCountByAuthorId(long authorId) {
        return replyDao.getCountByAuthorId(authorId);
    }

    @Override
    public Reply get(long id) {
        return replyDao.get(id);
    }

    @Override
    public Reply getFullReply(long id) {
        return replyDao.getFullReply(id);
    }

    @Override
    public long add(Reply reply) {
        long id = IdGen.genId();
        reply.setId(id);
        replyDao.add(reply);

        User author = userDao.get(reply.getAuthorId());

        if(author!=null){
            author.setScore(author.getScore()+5);
            author.setTopicCount(author.getTopicCount()+1);
            userDao.update(author);
        }

        return id;
    }

    @Override
    public int update(Reply reply) {
        return replyDao.update(reply);
    }

    @Override
    public int delete(Reply reply) {
        reply.setDeleted(true);
        return replyDao.update(reply);
    }

    @Override
    public Ups getUpsByReplyIdAndUserId(long replyId, long userId) {
        HashMap<String,Object> map = new HashMap<>();
        map.put("replyId",replyId);
        map.put("userId",userId);
        return upsDao.getUpsByReplyIdAndUserId(map);
    }

    @Override
    public long addUps(Ups ups) {
        long id = IdGen.genId();
        ups.setId(id);
        upsDao.add(ups);
        return id;
    }

    @Override
    public int deleteUps(Ups ups) {
        return upsDao.delete(ups);
    }
}
