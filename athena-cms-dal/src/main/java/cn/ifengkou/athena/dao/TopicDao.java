package cn.ifengkou.athena.dao;

import cn.ifengkou.athena.model.Topic;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

/**
 * Created by Sloong on 2015/11/26.
 */
@Repository
public interface TopicDao {

    int getCount();

    List<Topic> queryAll(HashMap<String, Object> map);

    Topic getFullTopic(long id);

    int updateLastReply(long id);

    int reduceReplyCount(long id);

    Topic get(long id);

    int update(Topic topic);

    int add(Topic topic);

    int delete(Topic topic);


}
