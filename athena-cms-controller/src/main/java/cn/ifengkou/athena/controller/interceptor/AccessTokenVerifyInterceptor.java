package cn.ifengkou.athena.controller.interceptor;

import cn.ifengkou.athena.common.util.StringUtils;
import cn.ifengkou.athena.model._SystemConstants;
import cn.ifengkou.athena.model.User;
import cn.ifengkou.athena.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 验证token有效性
 * Created by Sloong on 2015/12/2.
 */
@Component
public class AccessTokenVerifyInterceptor extends HandlerInterceptorAdapter {
    @Resource
    UserService userService;

    private final static Logger LOG = LoggerFactory.getLogger(AccessTokenVerifyInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        LOG.info("AccessTokenVerifyInterceptor executing.......");
        boolean flag = false;
        String accessToken = request.getParameter("accesstoken");
        if(StringUtils.notEmpty(accessToken)) {
            //验证accessToken
            //verifyAccessToken 已做缓存处理
            User user = userService.verifyAccessToken(accessToken);
            if(user!=null){
                flag = true;
                //塞到request中去，供controller里面调用
                request.setAttribute(_SystemConstants.SESSION_NAME_USER,user);
            }
        }

        if(!flag){
            response.setStatus(HttpStatus.FORBIDDEN.value());
            response.getWriter().print("wrong access token");
        }
        return flag;
    }
}
