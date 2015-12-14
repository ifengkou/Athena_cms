package cn.ifengkou.athena.dao;

import cn.ifengkou.athena.model.Reply;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Sloong on 2015/11/26.
 */
@Repository
public interface ReplyDao {
    Reply getFullReply(long replyId);
    Reply get(long replyId);

    List<Reply> getRepliesByTopicId(long topicId);

    int add(Reply reply);

    int update(Reply reply);

    int delete(String replyId);

    Reply getLastReplyByTopId(long topicId);

    List<Reply> getRepliesByAuthorId(long authorId);

    int getCountByAuthorId(long authorId);


}
