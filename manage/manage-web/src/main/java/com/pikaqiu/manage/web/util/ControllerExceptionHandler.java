package com.pikaqiu.manage.web.util;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.NoSuchRequestHandlingMethodException;

/**
 * Created by user on 2017/8/21.
 */
@ControllerAdvice
public class ControllerExceptionHandler {

    /**
     * 404统一处理页面
     * @return
     */
    @ExceptionHandler(NoSuchRequestHandlingMethodException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ModelAndView NoSuchRequestException() {
        return new ModelAndView("error/error404");
    }

    /**
     * 404统一处理页面
     * @return
     */
    /*@ExceptionHandler(NoHandlerFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ModelAndView pageNotFoundException() {
        return new ModelAndView("error/error404");
    }*/
}
