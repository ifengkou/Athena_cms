package cn.ifengkou.athena.service;

import cn.ifengkou.athena.model.Topic;
import cn.ifengkou.athena.model.User;

import java.util.HashMap;
import java.util.List;

/**
 * Created by Sloong on 2015/12/4.
 */
public interface TopicService {

    List<Topic> getTopics(HashMap<String,Object> params);

    Topic getFullTopic(long topicId);

    Topic get(long topicId);

    long add(Topic topic);

    int update(Topic topic);

    @Deprecated
    int delete(Topic topic);

    int collectTopic(User user,Topic topic);

    int deCollectTopic(User user,Topic topic);


}
