package com.pikaqiu.fwk.jersey;

import com.pikaqiu.fwk.exception.BusinessException;
import jersey.repackaged.com.google.common.collect.ImmutableMap;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;

/**
 * jersey 统一异常处理器. jersey托管的类发现了异常,抛出给jersey的异常处理器,该异常处理器直接返回自定义的错误代码.
 *
 * 异常处理器要实现ExceptionMapper<Exception>接口,并复写返回方法
 */
public class GenericExceptionMapper implements ExceptionMapper<Throwable> {

    private static final int requestStatus = 1000000;//该值必须与 GenericResponseFilter 中的 requestStatus 相等

    /**
     * 异常处理
     *
     * @param exception
     * @return 异常处理后的Response对象
     */
    @Override
    public Response toResponse(Throwable exception) {
        exception.printStackTrace();
        //截取自定义 业务异常BusinessException
        if (exception instanceof BusinessException) {
            BusinessException businessException = (BusinessException) exception;
            return Response.status(requestStatus).entity(ImmutableMap.<String, Object>of(
                    "code", businessException.getCode(),
                    "message", businessException.getMessage()
            )).build();
        } else {
            return Response.status(getStatus(exception))
                    .entity(ImmutableMap.<String, Object>of(
                            "code", getStatus(exception),
                            "message", Response.Status.INTERNAL_SERVER_ERROR.getReasonPhrase()
                    )).build();
        }
    }

    private int getStatus(Throwable ex) {
        if (ex instanceof WebApplicationException) {
            return ((WebApplicationException) ex).getResponse().getStatus();
        } else {
            return Response.Status.INTERNAL_SERVER_ERROR.getStatusCode();
        }
    }
}
