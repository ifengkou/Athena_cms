package cn.ifengkou.athena.controller;

import cn.ifengkou.athena.common.id.IdGen;
import cn.ifengkou.athena.model.Reply;
import cn.ifengkou.athena.model.Topic;
import cn.ifengkou.athena.model.Ups;
import cn.ifengkou.athena.model.User;
import cn.ifengkou.athena.service.ReplyService;
import cn.ifengkou.athena.service.TopicService;
import cn.ifengkou.athena.service.UserService;
import junit.framework.Assert;
import org.junit.Test;

import javax.annotation.Resource;

/**
 * Created by Sloong on 2015/12/10.
 */
public class ReplyTest extends SpringTest{

    @Resource
    ReplyService replyService;

    @Resource
    UserService userService;

    @Resource
    TopicService topicService;

    @Test
    public void test_addReply(){
        User user = userService.getUserByLoginName(TestData.loginName);

        long id = IdGen.genId();

        Reply reply = new Reply();
        reply.setId(id);
        reply.setContent("大家好！");
        reply.setContentIsHtml(false);

        Topic topic = topicService.get(TestData.topicId);
        reply.setTopicId(topic.getId());

        reply.setAuthorId(user.getId());

        replyService.add(reply);

        Reply reply1 = replyService.get(id);

        Assert.assertEquals("大家好！", reply1.getContent());

        Reply reply2 = replyService.getFullReply(id);

        Assert.assertEquals("大家好！",reply2.getContent());
    }

    @Test
    public void test_UpReply(){
        Reply reply = replyService.get(TestData.replyId);

        User user = userService.getUserByLoginName(TestData.loginName);

        if(reply.getAuthorId()== user.getId()){
            System.out.println("不能为自己点赞^.^");
        }

        Ups ups = replyService.getUpsByReplyIdAndUserId(reply.getId(), user.getId());

        String action;
        if(ups==null){
            action = "up";
            ups = new Ups();
            ups.setUserId(user.getId());
            ups.setReplyId(reply.getId());
            replyService.addUps(ups);
        }else{
            action = "down";
            replyService.deleteUps(ups);
        }

        System.out.println(action);
    }
}
