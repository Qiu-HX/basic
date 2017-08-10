package com.pikaqiu.manage.web.rest.resource;

import com.pikaqiu.dal.model.SysUser;
import com.pikaqiu.fwk.common.Error;
import com.pikaqiu.fwk.exception.BusinessException;
import com.pikaqiu.manage.biz.service.SysUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import javax.ws.rs.*;
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

    @Autowired
    private SysUserService sysUserService;

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

    @POST
    @Path("insert")
    @ApiOperation(value = "新增运维用户接口", httpMethod = "POST")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "运维用户新增成功")})
    public Response login(SysUser sysUser) {
        sysUserService.insertUser(sysUser);
        return Response.ok().build();
    }
}
