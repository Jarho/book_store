package cn.vaf714.shop.util;


import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;

/**
 * Web 层工具类
 *
 * @author Shengzhao Li
 */
public abstract class WebUtils {

    /**
     * ThreadLocal翻译成中文比较准确的叫法应该是：线程局部变量。
     * 这个玩意有什么用处，或者说为什么要有这么一个东东？
     * 先解释一下，在并发编程的时候，成员变量如果不做任何处理其实是线程不安全的，各个线程都在操作同一个变量，显然是不行的，
     * 并且我们也知道volatile这个关键字也是不能保证线程安全的。那么在有一种情况之下，我们需要满足这样一个条件：变量是同一个，
     * 但是每个线程都使用同一个初始值，也就是使用同一个变量的一个新的副本。这种情况之下ThreadLocal就非常使用，比如说DAO的数据库连接，
     * 我们知道DAO是单例的，那么他的属性Connection就不是一个线程安全的变量。而我们每个线程都需要使用他，并且各自使用各自的。
     * 这种情况，ThreadLocal就比较好的解决了这个问题。
     * 详见笔记
     */
    private static ThreadLocal<String> ipThreadLocal = new ThreadLocal<>();

    //private
    private WebUtils() {
    }


    /**
     * 添加线程局部变量
     * @param ip
     */
    public static void setIp(String ip) {
        ipThreadLocal.set(ip);
    }

    /**
     * 获取ip
     * @return
     */
    public static String getIp() {
        return ipThreadLocal.get();
    }


    /**
     * 获得客户端地址
     *
     * @param request HttpServletRequest
     * @return IP
     */
    public static String retrieveClientIp(HttpServletRequest request) {
        String ip = request.getHeader("x-forwarded-for");
        //TODO 三个if？
        if (isUnAvailableIp(ip)) {
            //地址不可用：代理地址
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (isUnAvailableIp(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (isUnAvailableIp(ip)) {
            ip = request.getRemoteAddr();
        }
        return ip;
    }

    /**
     * 判断ip地址是否可用
     *
     * @param ip
     * @return
     */
    private static boolean isUnAvailableIp(String ip) {
        return StringUtils.isEmpty(ip) || "unknown".equalsIgnoreCase(ip);
    }

}