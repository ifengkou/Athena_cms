package cn.ifengkou.athena.service;

import cn.ifengkou.athena.model.Reply;
import cn.ifengkou.athena.model.Ups;

import java.util.List;

/**
 * Created by Sloong on 2015/12/9.
 */
public interface ReplyService {
    /**
     * 根据主题ID，获取回复列表
     * @param topicId
     * @return
     */
    List<Reply> getRepliesByTopicId(long topicId);

    /**
     * 根据topicId查询到最新的一条未删除回复
     * @param topicId
     * @return
     */
    Reply getLastReplyByTopId(long topicId);


    /**
     * 通过 author_id 获取回复
     * @param authorId
     * @return
     */
    List<Reply> getRepliesByAuthorId(long authorId);

    /**
     * 通过 author_id 获取回复总数
     * @param authorId
     * @return
     */
    int getCountByAuthorId(long authorId);

    /**
     * 根据回复ID，获取回复
     * @param id
     * @return
     */
    Reply get(long id);

    /**
     * 根据回复ID，获取回复(含关联对象）
     * @param id
     * @return
     */
    Reply getFullReply(long id);

    long add(Reply reply);

    int update(Reply reply);

    int delete(Reply reply);

    Ups getUpsByReplyIdAndUserId(long replyId,long userId);

    long addUps(Ups ups);

    int deleteUps(Ups ups);
}
