package cn.ifengkou.athena.controller;

import cn.ifengkou.athena.model.User;
import cn.ifengkou.athena.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by Sloong on 2015/11/24.
 */
@Controller
@RequestMapping("user")
public class UserController {
    @Resource
    UserService userService;

    @RequestMapping(value = "login", method = RequestMethod.GET)
    public String login(HttpServletRequest request){
        User user= (User)request.getSession().getAttribute("user");
        if(user !=null){
            return "redirect:/";
        }else{
            return "login";
        }
    }

    @RequestMapping(value = "login", method = RequestMethod.POST)
    public String login(HttpServletRequest request,String loginName,String pass){
        User user = userService.getUserByLoginName(loginName);

        //TODO:混合校验
        //String kaptcha = (String)request.getSession().getAttribute("kaptcha");

        if(user!=null && pass.equals(user.getPass())){
            return "redirect:/";
        }
        request.setAttribute("message", "登录失败");
        return "login";
    }
}
