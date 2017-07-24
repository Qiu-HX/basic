package com.pikaqiu.fwk.jersey;

import org.glassfish.jersey.jackson.JacksonFeature;
import org.glassfish.jersey.media.multipart.MultiPartFeature;
import org.glassfish.jersey.message.GZipEncoder;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.filter.EncodingFilter;

/**
 * Created by user on 2016/7/19.
 */
public class WebRestApplication extends ResourceConfig {
    public WebRestApplication() {
        //注册JSON转换器
        register(JacksonFeature.class);

        //注册jersey统一异常处理器
        register(GenericExceptionMapper.class);

        //注册Response过滤器
        register(GenericResponseFilter.class);
    }
}
