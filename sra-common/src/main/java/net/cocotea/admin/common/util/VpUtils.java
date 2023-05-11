package net.cocotea.admin.common.util;

import java.util.Collection;

/**
 * 业务参数校验工具类
 *
 * @author CoCoTea
 * @since 2022-12-30 09:47:04
 */
public class VpUtils {
    /**
     * 校验集合为空
     *
     * @param list 待校验集合
     * @return 为空返回TRUE
     */
    public static boolean isEmptyList(Collection<?> list) {
        return list == null || list.size() == 0;
    }

    /**
     * 校验集合不为空
     *
     * @param list 待校验集合
     * @return 不为空返回TRUE
     */
    public static boolean isNotEmptyList(Collection<?> list) {
        return !isEmptyList(list);
    }
}
