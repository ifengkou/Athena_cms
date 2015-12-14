package cn.ifengkou.athena.controller.exception;

import cn.ifengkou.athena.controller.common.JsonDto;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * Created by Sloong on 2015/12/1.
 */
@EnableWebMvc
@ControllerAdvice
public class GlobalControllerExceptionHandler {
    @ExceptionHandler(NullPointerException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public String handleIOException(NullPointerException ex) {
        //String className = ClassUtils.getShortName(ex.getClass());
        return  "NullPointException";
    }

    @ExceptionHandler(AccessForbidException.class)
    @ResponseStatus(HttpStatus.FORBIDDEN)
    @ResponseBody
    public String handleAccessForbidException(){
        return "access token is invalidation";
    }

    @ExceptionHandler(IllegalException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public JsonDto handleIllegalException(IllegalException ex){
        return new JsonDto(false,ex.getMessage());
    }
}
