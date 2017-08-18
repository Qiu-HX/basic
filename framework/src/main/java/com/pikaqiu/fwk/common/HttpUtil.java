package com.pikaqiu.fwk.common;


import javax.servlet.http.HttpServletRequest;

/**
 * Http请求工具类
 */
public class HttpUtil {
    /**
     * 获取客户端IP
     * @param request 请求对象
     * @return IP
     */
    public static String getClientIP(HttpServletRequest request) {
        String ip = request.getHeader("X-Forwarded-For");
        if (isUnknow(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (isUnknow(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (isUnknow(ip)) {
            ip = request.getHeader("X-Real-IP");
        }
        if (isUnknow(ip)) {
            ip = request.getRemoteAddr();
        }
        return getMultistageReverseProxyIp(ip);
    }

    /**
     * 检测是否https
     * @param url URL
     * @return 是否https
     */
    public static boolean isHttps(String url) {
        return url.toLowerCase().startsWith("https");
    }

    /**
     * 判断http请求是否是手机请求
     * @return isMobile 是否手机请求
     */
    public static boolean isMobileRequest(HttpServletRequest request) {
        String[] MOBILE_AGENTS = {"iphone", "android", "phone", "mobile", "wap", "netfront", "java", "opera mobi",
                "opera mini", "ucweb", "windows ce", "symbian", "series", "webos", "sony", "blackberry", "dopod",
                "nokia", "samsung", "palmsource", "xda", "pieplus", "meizu", "midp", "cldc", "motorola", "foma",
                "docomo", "up.browser", "up.link", "blazer", "helio", "hosin", "huawei", "novarra", "coolpad", "webos",
                "techfaith", "palmsource", "alcatel", "amoi", "ktouch", "nexian", "ericsson", "philips", "sagem",
                "wellcom", "bunjalloo", "maui", "smartphone", "iemobile", "spice", "bird", "zte-", "longcos",
                "pantech", "gionee", "portalmmm", "jig browser", "hiptop", "benq", "haier", "^lct", "320x320",
                "240x320", "176x220", "w3c ", "acs-", "alav", "alca", "amoi", "audi", "avan", "benq", "bird", "blac",
                "blaz", "brew", "cell", "cldc", "cmd-", "dang", "doco", "eric", "hipt", "inno", "ipaq", "java", "jigs",
                "kddi", "keji", "leno", "lg-c", "lg-d", "lg-g", "lge-", "maui", "maxo", "midp", "mits", "mmef", "mobi",
                "mot-", "moto", "mwbp", "nec-", "newt", "noki", "oper", "palm", "pana", "pant", "phil", "play", "port",
                "prox", "qwap", "sage", "sams", "sany", "sch-", "sec-", "send", "seri", "sgh-", "shar", "sie-", "siem",
                "smal", "smar", "sony", "sph-", "symb", "t-mo", "teli", "tim-", "tosh", "tsm-", "upg1", "upsi", "vk-v",
                "voda", "wap-", "wapa", "wapi", "wapp", "wapr", "webc", "winw", "winw", "xda", "xda-",
                "Googlebot-Mobile"};
        boolean isMobile = false;//MOBILE_AGENTS
        if (request.getHeader("User-Agent") != null) {
            for (String mobileAgent : MOBILE_AGENTS) {
                if (request.getHeader("User-Agent").toLowerCase().indexOf(mobileAgent) >= 0 && (request.getHeader("User-Agent").toLowerCase().indexOf("iphone") > 0 || request.getHeader("User-Agent").toLowerCase().indexOf("ipad") > 0 || request.getHeader("User-Agent").toLowerCase().indexOf("mac") < 0)) {
                    isMobile = true;
                    break;
                }
            }
        }
        return isMobile;
    }

    /**
     * 从多级反向代理中获得第一个非unknown IP地址
     * @param ip 获得的IP地址
     * @return 第一个非unknown IP地址
     */
    public static String getMultistageReverseProxyIp(String ip) {
        // 多级反向代理检测
        if (ip != null && ip.indexOf(",") > 0) {
            final String[] ips = ip.trim().split(",");
            for (String subIp : ips) {
                if (false == isUnknow(subIp)) {
                    ip = subIp;
                    break;
                }
            }
        }
        return ip;
    }

    /**
     * 检测给定字符串是否为未知，多用于检测HTTP请求相关
     * @param checkString 被检测的字符串
     * @return 是否未知
     */
    public static boolean isUnknow(String checkString) {
        return isBlank(checkString) || Header.UNKNOW.toString().equalsIgnoreCase(checkString);
    }

    public static boolean isBlank(String str) {
        int length;
        if (str == null || (length = str.length()) == 0) {
            return true;
        }

        for (int i = 0; i < length; i++) {
            if (!Character.isWhitespace(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }

}
