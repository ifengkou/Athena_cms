package cn.ifengkou.athena.controller;

import cn.ifengkou.athena.common.id.IdGen;
import cn.ifengkou.athena.model.Topic;
import cn.ifengkou.athena.model.TopicCollect;
import cn.ifengkou.athena.model.User;
import cn.ifengkou.athena.service.TopicService;
import cn.ifengkou.athena.service.UserService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import junit.framework.Assert;
import org.junit.Test;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Sloong on 2015/12/9.
 */
public class TopicTest extends SpringTest {

    @Resource
    TopicService topicService;

    @Resource
    UserService userService;

    @Test
    public void test_addTopic() {
        User user = userService.getUserByLoginName(TestData.loginName);

        long id = IdGen.genId();
        Topic topic = new Topic();
        topic.setId(id);
        topic.setAuthorId(user.getId());
        topic.setContent("Hello Athena!");
        topic.setTitle("HI");
        topic.setContentIsHtml(false);
        topic.setTab("share");

        topicService.add(topic);

        Topic topic1 = topicService.get(id);

        Assert.assertEquals("Hello Athena!",topic1.getContent());
    }

    @Test
    public void test_collectTopic() {
        Topic topic = topicService.getFullTopic(TestData.topicId);
        User user = userService.getUserByLoginName(TestData.loginName);

        topicService.collectTopic(user, topic);

        List<TopicCollect> topics = userService.getCollectTopicByUserId(user.getId());

        String title ="";
        for (TopicCollect bean :topics){
            title = bean.getTopic().getTitle();
            System.out.println(title);
        }

        Assert.assertEquals("HI",title);
    }

    @Test
    public void test_queryTopics() {
        HashMap<String,Object> queryParams = new HashMap<>();
        queryParams.put("tab","all");

        PageHelper.startPage(1, 10);
        PageHelper.orderBy("t.id desc");
        List<Topic> topics = topicService.getTopics(queryParams);


        Assert.assertEquals(1,topics.size());

        Assert.assertEquals(1, ((Page) topics).getTotal());
    }
}
