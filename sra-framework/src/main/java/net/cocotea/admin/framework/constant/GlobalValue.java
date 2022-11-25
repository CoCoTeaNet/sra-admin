package net.cocotea.admin.framework.constant;

/**
 * 全局常量
 * @date 2022-2-9 14:27:00
 * @author jwss
 */
public class GlobalValue {
    /**
     * 系统启动时间
     */
    public static Long START_TIME;

    /**
     * 服务器IP
     */
    public static String SERVER_IP;

    /**
     * 服务器端口
     */
    public static Integer PORT;

    /**
     * 访问协议
     */
    public static String AGREEMENT;

    /**
     * 获取服务器地址
     * @return 服务器地址
     */
    public static String getServerUrl() {
        return AGREEMENT + "://" + SERVER_IP + ":" + PORT;
    }
}
