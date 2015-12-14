package cn.ifengkou.athena.controller.api;

import cn.ifengkou.athena.controller.common.JsonDto;
import cn.ifengkou.athena.controller.exception.IllegalException;
import cn.ifengkou.athena.model.Topic;
import cn.ifengkou.athena.model.User;
import cn.ifengkou.athena.model._SystemConstants;
import cn.ifengkou.athena.service.TopicService;
import com.github.pagehelper.PageHelper;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Sloong on 2015/12/4.
 */
@RestController
@RequestMapping("api")
public class TopicController {
    @Resource
    TopicService topicService;

    @ResponseBody
    @RequestMapping(method = RequestMethod.GET, value = "/topics")
    @ResponseStatus(HttpStatus.OK)
    public List<Topic> getList(@RequestParam(value = "page",defaultValue = "1")int page
            ,@RequestParam(value = "limit",defaultValue = "10")int limit
            ,@RequestParam(value = "tab",defaultValue = "all")String tab
            ,@RequestParam(value = "mdrender",defaultValue = "true")String mdrender){

        HashMap<String,Object> queryParams = new HashMap<>();
        queryParams.put("tab",tab);

        PageHelper.startPage(page, limit, "id desc");
        List<Topic> topics = topicService.getTopics(queryParams);

        return topics;
    }

    @ResponseBody
    @RequestMapping(method = RequestMethod.GET, value = "/topics/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Topic getTopic(@PathVariable("id")long id){
        return topicService.getFullTopic(id);
    }

    @ResponseBody
    @RequestMapping(method = RequestMethod.POST, value = "/topics")
    @ResponseStatus(HttpStatus.OK)
    public JsonDto addTopic(HttpServletRequest request,Topic topic){
        User user = (User)request.getAttribute(_SystemConstants.SESSION_NAME_USER);
        topic.setAuthorId(user.getId());
        long objectId = topicService.add(topic);
        return new JsonDto(true,null,objectId);
    }

    @ResponseBody
    @RequestMapping(method = RequestMethod.PUT, value = "/topics")
    @ResponseStatus(HttpStatus.OK)
    public JsonDto updateTopic(Topic topic){
        Topic _topic = topicService.get(topic.getId());
        _topic.setTitle(topic.getTitle());
        _topic.setContent(topic.getContent());
        topicService.update(_topic);
        return new JsonDto(true,null,topic.getId());
    }

    @ResponseBody
    @RequestMapping(method = {RequestMethod.PUT,RequestMethod.POST}, value = "/topic/collect")
    @ResponseStatus(HttpStatus.OK)
    public JsonDto collectTopic(HttpServletRequest request,long topicId) throws IllegalException {
        User user = (User)request.getAttribute(_SystemConstants.SESSION_NAME_USER);
        Topic topic = topicService.get(topicId);
        if(topic == null){
            throw new IllegalException("主题不存在");
        }
        topicService.collectTopic(user, topic);
        return new JsonDto(true);
    }

    @ResponseBody
    @RequestMapping(method = {RequestMethod.PUT,RequestMethod.POST}, value = "/topic/de_collect")
    @ResponseStatus(HttpStatus.OK)
    public JsonDto deCollectTopic(HttpServletRequest request,long topicId) throws IllegalException {
        User user = (User)request.getAttribute(_SystemConstants.SESSION_NAME_USER);
        Topic topic = topicService.get(topicId);
        if(topic == null){
            throw new IllegalException("主题不存在");
        }
        topicService.deCollectTopic(user, topic);
        return new JsonDto(true);
    }



}
