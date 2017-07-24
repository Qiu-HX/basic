package com.pikaqiu.manage.web.util;

import com.pikaqiu.fwk.jersey.WebRestApplication;

/**
 * Created by user on 2016/9/23.
 */
public class RestApplication extends WebRestApplication {
    public RestApplication() {
        //jersey 扫描的包路径
        packages("com.pikaqiu.manage.web.rest.resource");
    }
}
