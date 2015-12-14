package cn.ifengkou.athena.controller.interceptor;

import cn.ifengkou.athena.model._SystemConstants;
import cn.ifengkou.athena.model.User;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by Sloong on 2015/12/2.
 */
public class UserLoginInterceptor extends HandlerInterceptorAdapter {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        boolean flag = false;
        if (!flag) {
            HttpSession session = request.getSession();
            User user = (User) session.getAttribute(_SystemConstants.SESSION_NAME_USER);
            if (user == null) {
                response.sendRedirect(request.getContextPath() + "/login");
                flag = false;
            } else {
                flag = true;
            }
        }
        return flag;
    }
}
