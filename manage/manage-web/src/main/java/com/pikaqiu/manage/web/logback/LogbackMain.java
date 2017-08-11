package com.pikaqiu.manage.web.logback;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by user on 2017/8/11.
 */
public class LogbackMain {

    private final static Logger logger = LoggerFactory.getLogger(LoggerFactory.class);

    public static void main(String[] args) {
        logger.trace("logback 成功了 trace");
        logger.debug("logback 成功了 debug");
        logger.info("logback 成功了 info");
        logger.warn("logback 成功了 warn");
        logger.error("logback 成功了 error");
    }
}
