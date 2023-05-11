package net.cocotea.admin.common.util;

import java.text.DecimalFormat;

/**
 * 对象结果返回工具类
 *
 * @date 2022-11-3 15:27:41
 * @author CoCoTea
 */
public class RdUtils {
    /**
     * 字符串为null时默认返回XX值
     * @param s 原始字符串
     * @param d 默认字符串
     * @return 指定默认字符串
     */
    public static String strNull(String s, String d) {
        if (s == null || s.length() == 0) {
            return d;
        }
        return s;
    }

    /**
     * Integer为null时默认返回XX值
     * @param s 原始Integer
     * @param d 默认数字
     * @return 指定默认值
     */
    public static int intNull(Integer s, int d) {
        if (s == null) {
            return d;
        }
        return s;
    }

    /**
     * Float对象为null时默认返回XX值
     * @param s 原始Float对象
     * @param d 默认值
     * @return 指定默认值
     */
    public static float floNull(Float s, float d) {
        if (s == null) {
            return d;
        }
        return s;
    }

    /**
     * 对象为null时返回 0.0
     */
    public static float floZero(Float s) {
        return floNull(s, 0.0f);
    }

    /**
     * 对象为null时返回 0.00
     */
    public static double douZero(Double s) {
        return douNull(s, 0.00);
    }

    /**
     * Double对象为null时默认返回XX值
     * @param s 原始Double对象
     * @param d 默认值
     * @return 指定默认值
     */
    public static double douNull(Double s, double d) {
        if (s == null) {
            return d;
        }
        return s;
    }

    /**
     * Long对象为null时默认返回XX值
     * @param s 原始Long对象
     * @param d 默认值
     * @return 指定默认值
     */
    public static long lonNull(Long s, long d) {
        if (s == null) {
            return d;
        }
        return s;
    }

    /**
     * 对象为null时返回 0
     */
    public static long lonZero(Long s, long d) {
        return lonNull(s, 0);
    }

    /**
     * 字符串为null时返回空字符串
     */
    public static String strEmpty(String s) {
        return strNull(s, "");
    }

    /**
     * 字符串为null时返回0.0
     */
    public static String strZeroF(String s) {
        return strNull(s, "0.0");
    }

    /**
     * 字符串为null时返回0
     */
    public static String strZero(String s) {
        return strNull(s, String.valueOf(0));
    }

    /**
     * Integer为null时返回0
     */
    public static int intZero(Integer s) {
        return intNull(s, 0);
    }

    /**
     * 保留1位小数
     */
    public static String retain1f(double d) {
        return String.format("%.1f", d);
    }

    /**
     * 保留2位小数
     */
    public static String retain2f(double d) {
        return String.format("%.2f", d);
    }

    /**
     * 保留3位小数
     */
    public static String retain3f(double d) {
        return String.format("%.3f", d);
    }

    /**
     * 保留1位小数
     */
    public static String retain1f(String s) {
        return retain1f(Double.parseDouble(s));
    }

    /**
     * 保留2位小数
     */
    public static String retain2f(String s) {
        return retain2f(Double.parseDouble(s));
    }

    /**
     * 保留3位小数
     */
    public static String retain3f(String s) {
        return retain3f(Double.parseDouble(s));
    }

    /**
     * 不足两位数自动补零，返回字符串
     * 比如：1 --》 01
     */
    public static String lFillZero(int i) {
        return i < 10 ? "0"+i : String.valueOf(i);
    }

    /**
     * 运算百分比
     *
     * @param a 除数
     * @param b 被除数
     * @return 带百分号
     */
    public static String getPercent(int a, int b) {
        String res = "0.00%";
        if (b < 1) {
            return res;
        }
        DecimalFormat df = new DecimalFormat("0.00");
        res = df.format((float) a * 100 / b).concat("%");
        return res;
    }

    /**
     * 运算百分比
     *
     * @param a 除数
     * @param b 被除数
     * @return 返回number类型，不带百分号
     */
    public static Number getPercentNumber(int a, int b) {
        Number res = 0.00;
        if (b < 1) {
            return res;
        }
        DecimalFormat df = new DecimalFormat("0.00");
        return Float.parseFloat(df.format((float) a * 100 / b));
    }
}
