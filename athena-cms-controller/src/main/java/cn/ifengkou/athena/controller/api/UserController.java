package cn.ifengkou.athena.controller.api;

import cn.ifengkou.athena.controller.exception.IllegalException;
import cn.ifengkou.athena.model.Topic;
import cn.ifengkou.athena.model.TopicCollect;
import cn.ifengkou.athena.model.User;
import cn.ifengkou.athena.model._SystemConstants;
import cn.ifengkou.athena.service.TopicService;
import cn.ifengkou.athena.service.UserService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Sloong on 2015/12/1.
 */
@RestController("userControllerAPI")
@RequestMapping("api")
public class UserController {
    @Resource
    UserService userService;

    @Resource
    TopicService topicService;

    @RequestMapping(method= RequestMethod.GET,value = "/user/{loginname}")
    @ResponseBody
    public User get(@PathVariable("loginname")String loginName) throws Exception {
        User user = userService.getUserByLoginName(loginName);
        if(user==null) throw new IllegalException("user '"+loginName+"' is not exists");
        //获取最新5条创建的主题
        HashMap<String,Object> queryParams = new HashMap<>();
        queryParams.put("authorId", user.getId());
        List<Topic> topicList = topicService.getTopics(queryParams);
        return user;
    }
    @RequestMapping(method= RequestMethod.GET,value = "/accesstoken")
    @ResponseBody
    public String verifyAccessToken(String accessToken) throws IllegalException{
        User user = userService.verifyAccessToken(accessToken);
        if(user==null) throw new IllegalException("validation fails");
        return user.getLoginName();
    }

    @RequestMapping(method= RequestMethod.GET,value = "/collection")
    @ResponseBody
    public List<TopicCollect> getTopicCollect(HttpServletRequest request){
        User user = (User)request.getAttribute(_SystemConstants.SESSION_NAME_USER);
        return userService.getCollectTopicByUserId(user.getId());
    }

}
