package com.pikaqiu.manage.web.rest.resource;

import com.pikaqiu.fwk.common.Error;
import com.pikaqiu.fwk.exception.BusinessException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * jersey hello
 * @Produces    是定义返回值给客户端的 MIME 媒体类型, 设置为json类型
 */
@Path("hello")
@Produces({MediaType.APPLICATION_JSON})
@Api(value = "/hello", description = "hello Resource API")
public class HelloResource {

    @GET
    @Path("login")
    @ApiOperation(value = "登录测试接口", httpMethod = "GET")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "登录成功")})
    public Response login(@QueryParam("userName") String userName, @QueryParam("password") String password) {
        if(userName == null || userName.isEmpty()) {
            throw new BusinessException(Error.TestException.TEST_EXP);
        }
        if(password == null || password.isEmpty()) {
            throw new BusinessException(Error.TestException.TEST_OTHER);
        }

        String resp = "rest login ok!";

        return Response.ok(resp).build();
    }
}
