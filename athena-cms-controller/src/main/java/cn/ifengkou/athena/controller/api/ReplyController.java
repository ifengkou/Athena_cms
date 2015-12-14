package cn.ifengkou.athena.controller.api;

import cn.ifengkou.athena.controller.common.JsonDto;
import cn.ifengkou.athena.model.Reply;
import cn.ifengkou.athena.model.Ups;
import cn.ifengkou.athena.model.User;
import cn.ifengkou.athena.model._SystemConstants;
import cn.ifengkou.athena.service.ReplyService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by Sloong on 2015/12/9.
 */
@RestController
@RequestMapping("/api")
public class ReplyController {
    @Resource
    ReplyService replyService;

    @ResponseBody
    @RequestMapping(value = "/topic/{topicId}/replies",method = RequestMethod.POST)
    public JsonDto addReply(@PathVariable("topicId")long topicId
            ,@RequestParam(value = "replyId",defaultValue = "")long replyId
                            ,Reply reply
            ,HttpServletRequest request){
        User user = (User)request.getAttribute(_SystemConstants.SESSION_NAME_USER);
        reply.setAuthorId(user.getId());
        if(!"".equals(replyId)) {
            reply.setParentReplyId(replyId);
        }
        long objectId = replyService.add(reply);

        return new JsonDto(true,null,objectId);
    }

    @ResponseBody
    @RequestMapping(value = "/reply/{replyId}/ups",method = RequestMethod.POST)
    public JsonDto upReply(@PathVariable("replyId")long replyId
            ,HttpServletRequest request){
        User user = (User)request.getAttribute(_SystemConstants.SESSION_NAME_USER);
        Reply reply = replyService.get(replyId);
        if(reply.getAuthorId()== user.getId()){
            return new JsonDto(false,"不能为自己点赞^.^");
        }

        Ups ups = replyService.getUpsByReplyIdAndUserId(reply.getId(),user.getId());

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
        return new JsonDto(true,null,action);
    }
}
