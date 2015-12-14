package cn.ifengkou.athena.controller;

import cn.ifengkou.athena.common.id.IdGen;
import cn.ifengkou.athena.common.id.UUIDTools;
import cn.ifengkou.athena.common.util.MD5Utils;
import cn.ifengkou.athena.model.TopicCollect;
import cn.ifengkou.athena.model.User;
import cn.ifengkou.athena.service.UserService;
import junit.framework.Assert;
import org.junit.Test;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Sloong on 2015/11/30.
 */
public class UserTest extends SpringTest {
    @Resource
    UserService userService;

    @Test
    public void test_addUser(){

        User user = userService.getUserByLoginName(TestData.loginName);
        if(user == null){
            user = new User();

            user.setId(IdGen.genId());
            user.setLoginName(TestData.loginName);
            user.setName(TestData.loginName);
            String pass = "123456";
            user.setPass(MD5Utils.md5Encode(pass));
            user.setAccessToken(UUIDTools.uuid());
            userService.add(user);
        }

    }

    /**
     * 测试用户收藏的topic集合
     */
    @Test
    public void getCollectionByUserId(){
        String loginName = "admin";
        User user = userService.getUserByLoginName(loginName);
        if(user!=null) {
            long userId = user.getId();
            List<TopicCollect> collects = userService.getCollectTopicByUserId(userId);
            System.out.print(collects.get(0).getTopic().getAuthor().getName());
            Assert.assertEquals(2, collects.size());
        }
    }
}
