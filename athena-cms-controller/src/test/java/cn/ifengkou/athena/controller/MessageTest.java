package cn.ifengkou.athena.controller;

import cn.ifengkou.athena.common.id.IdGen;
import cn.ifengkou.athena.model.Message;
import cn.ifengkou.athena.model.User;
import cn.ifengkou.athena.service.MessageService;
import cn.ifengkou.athena.service.UserService;
import junit.framework.Assert;
import org.junit.Test;

import javax.annotation.Resource;

/**
 * Created by Sloong on 2015/11/30.
 */
public class MessageTest extends SpringTest {
    @Resource
    MessageService messageService;

    @Resource
    UserService userService;

    @Test
    public void test_addUser(){
        String loginName = "admin";
        User user = userService.getUserByLoginName(loginName);
        Message message = new Message();
        message.setId(IdGen.genId());
        message.setAuthorId(user.getId());
    }
    @Test
    public void getById(){
        int id =1;
        Message message = messageService.get(id);

        Assert.assertEquals(id,message.getId());
    }
}
