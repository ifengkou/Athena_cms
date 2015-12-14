package cn.ifengkou.athena.controller.api;

import cn.ifengkou.athena.model.Message;
import cn.ifengkou.athena.model._SystemConstants;
import cn.ifengkou.athena.model.User;
import cn.ifengkou.athena.service.MessageService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Sloong on 2015/12/1.
 */
@RestController
@RequestMapping("api")
public class MessageController {
    @Resource
    MessageService messageService;

    /**
     * 用户消息总数
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping(method = RequestMethod.GET, value = "/message/count")
    @ResponseStatus(HttpStatus.OK)
    public int count(HttpServletRequest request){
        User user = (User)request.getAttribute(_SystemConstants.SESSION_NAME_USER);
        return messageService.getMessagesCount(user.getId());
    }

    /**
     * 获取用户消息
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping(method = RequestMethod.GET,value = "/messages")
    public HashMap<String,Object> getMessages(HttpServletRequest request){
        User user = (User)request.getAttribute(_SystemConstants.SESSION_NAME_USER);
        List<Message> readMessageList = messageService.getReadMessagesByUserId(user.getId());
        List<Message> unReadMessageList = messageService.getReadMessagesByUserId(user.getId());

        HashMap<String,Object> map = new HashMap<>();
        map.put("has_read_messages",readMessageList);
        map.put("hasnot_read_messages",unReadMessageList);
        return map;
    }

    /**
     * 标记消息已读
     * @return
     */
    @ResponseBody
    @RequestMapping(method = RequestMethod.POST,value = "/message/mark_all")
    public HashMap<String,Object> markAllMessages(HttpServletRequest request,long[] messages){
        User user = (User)request.getAttribute(_SystemConstants.SESSION_NAME_USER);
        int num = messageService.updateMessagesToRead(user.getId(), messages);
        HashMap<String,Object> map = new HashMap<>();
        map.put("success",true);
        map.put("num",num);
        map.put("marked_msgs",messages);
        return map;
    }
}
