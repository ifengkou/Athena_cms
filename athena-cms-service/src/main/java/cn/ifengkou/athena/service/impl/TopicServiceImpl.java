package cn.ifengkou.athena.service.impl;

import cn.ifengkou.athena.common.id.IdGen;
import cn.ifengkou.athena.dao.ReplyDao;
import cn.ifengkou.athena.dao.TopicCollectDao;
import cn.ifengkou.athena.dao.TopicDao;
import cn.ifengkou.athena.dao.UserDao;
import cn.ifengkou.athena.model.Topic;
import cn.ifengkou.athena.model.TopicCollect;
import cn.ifengkou.athena.model.User;
import cn.ifengkou.athena.service.TopicService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Sloong on 2015/12/4.
 */
@Service("topicService")
public class TopicServiceImpl implements TopicService {
    @Resource
    TopicDao topicDao;

    @Resource
    UserDao userDao;

    @Resource
    TopicCollectDao topicCollectDao;

    @Resource
    ReplyDao replyDao;

    @Override
    public List<Topic> getTopics(HashMap<String,Object> params) {
        return topicDao.queryAll(params);
    }

    public Topic getFullTopic(long topicId){
        Topic topic = topicDao.getFullTopic(topicId);
        topic.setReplys(replyDao.getRepliesByTopicId(topic.getId()));
        return topic;
    }

    public Topic get(long topicId){
        return topicDao.get(topicId);
    }

    @Override
    public long add(Topic topic){
        long id = IdGen.genId();
        topic.setId(id);
        topicDao.add(topic);

        User author = userDao.get(topic.getAuthorId());

        if(author!=null){
            author.setScore(author.getScore()+5);
            author.setTopicCount(author.getTopicCount() + 1);
            userDao.update(author);
        }

        return id;
    }

    public int update(Topic topic){
        return topicDao.update(topic);
    }

    public int delete(Topic topic){
        //return topicDao.delete(topic);
        return -1;
    }

    /**
     * 收藏 topic
     * @param user
     * @param topic
     * @return
     */
    public int collectTopic(User user,Topic topic){
        HashMap<String,Object> map = new HashMap();
        map.put("userId",user.getId());
        map.put("topicId",topic.getId());
        TopicCollect topicCollect = topicCollectDao.get(map);
        if(null == topicCollect){
            topicCollect = new TopicCollect();
            topicCollect.setUserId(user.getId());
            topicCollect.setTopicId(topic.getId());
            topicCollectDao.add(topicCollect);

            user.setCollectTopicCount(user.getCollectTopicCount()+1);
            topic.setCollectCount(topic.getCollectCount() + 1);
            userDao.update(user);
            topicDao.update(topic);
        }
        return 1;
    }

    /**
     * 取消收藏 topic
     * @param user
     * @param topic
     * @return
     */
    public int deCollectTopic(User user,Topic topic){
        HashMap<String,Object> map = new HashMap();
        map.put("userId",user.getId());
        map.put("topicId",topic.getId());
        TopicCollect topicCollect = topicCollectDao.get(map);
        if(null != topicCollect){
            topicCollectDao.delete(topicCollect);

            user.setCollectTopicCount(user.getCollectTopicCount()-1);
            topic.setCollectCount(topic.getCollectCount() - 1);
            userDao.update(user);
            topicDao.update(topic);
        }
        return 1;
    }

}
