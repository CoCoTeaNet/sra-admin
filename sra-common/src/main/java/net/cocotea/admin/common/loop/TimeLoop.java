package net.cocotea.admin.common.loop;

import java.time.LocalDateTime;
import java.time.YearMonth;
import java.util.Calendar;
import java.util.Date;
import java.util.function.Consumer;

/**
 * 时间循环
 *
 * @author CoCoTea
 */
public class TimeLoop {

    /**
     * 计算某天的周期的所有日期，从周一开始到周日
     *
     * @param date 日期
     * @param consumer 偏移日期回调
     */
    public static void week(Date date, Consumer<? super Date> consumer) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        JLoop.loop(1, 7, count -> {
            // 当前日期
            int day = calendar.get(Calendar.DAY_OF_WEEK);
            // 计算偏移
            int offset = count - (day - 1);
            calendar.add(Calendar.DAY_OF_WEEK, offset);
            // 日期回调
            if (consumer != null) {
                consumer.accept(calendar.getTime());
            }
        });
    }

    /**
     * 计算本周所有日期
     * @param consumer 偏移日期回调
     */
    public static void thisWeek(Consumer<? super Date> consumer) {
        week(new Date(), consumer);
    }

    /**
     * 循环某月份的所有日期，从本月第一天到最后一天
     * @param month 月份
     * @param isNow 是否当前时间：是，month参数无效
     * @param consumer 偏移日期回调
     */
    private static void month(int month, boolean isNow, Consumer<? super Date> consumer) {
        if (month < 1 || month > 12) {
            throw new RuntimeException("参数错误，月份范围：1~12");
        }
        LocalDateTime now = LocalDateTime.now();
        if (!isNow) {
            now = LocalDateTime.of(now.getYear(), month, 1, 0, 0);
        }
        // 获取某个月的月份有多少天
        int monthValue = now.getMonthValue();
        int year = now.getYear();
        YearMonth yearMonth = YearMonth.of(year, monthValue);
        int daysInMonth = yearMonth.lengthOfMonth();
        // 开启循环
        int finalMonth = now.getMonthValue() - 1;
        int finalYear = now.getYear();
        JLoop.loop(1, daysInMonth, count -> {
            Calendar calendar = Calendar.getInstance();
            calendar.set(finalYear, finalMonth, count);
            if (consumer != null) {
                consumer.accept(calendar.getTime());
            }
        });
    }

    /**
     * 循环某月份的所有日期，从本月第一天到最后一天
     * @param month 月份
     * @param consumer 偏移日期回调
     */
    public static void month(int month, Consumer<? super Date> consumer) {
        month(month, false, consumer);
    }

    /**
     * 循环当前月份的所有日期，从本月第一天到最后一天
     * @param consumer 偏移日期回调
     */
    public static void thisMonth(Consumer<? super Date> consumer) {
        month(1, true, consumer);
    }

}
