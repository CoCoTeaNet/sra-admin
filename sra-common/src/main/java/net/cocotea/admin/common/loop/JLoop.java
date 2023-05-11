package net.cocotea.admin.common.loop;

import java.util.function.Consumer;

/**
 * 通用循环
 * @author CoCoTea
 */
public class JLoop {

    /**
     * 通用循环n次，从 1~n
     * @param count 循环次数
     * @param consumer 回调函数，接收每次循环的次数
     */
    public static void loop(int count, Consumer<? super Integer> consumer) {
        if (count <= 0) {
            throw new RuntimeException("count值不能小于或等于0，因为这使得循环永远不成立");
        }
        int i = 1;
        while (i <= count) {
            consumer.accept(i);
            i++;
        }
    }

    /**
     * 循环n次，从min~max，从小到大输出
     * @param min 最小值
     * @param max 最大值
     * @param consumer 回调函数，接收每次循环的次数
     */
    public static void loop(int min, int max, Consumer<? super Integer> consumer) {
        if (min > max) {
            throw new RuntimeException("最小值不能大于最大值，因为这使得循环永远不成立");
        }
        int i = min;
        while (i <= max) {
            consumer.accept(i);
            i++;
        }
    }

    /**
     * 循环n次，从max~min，从大到小输出
     * @param max 最大值
     * @param min 最小值
     * @param consumer 回调函数，接收每次循环的次数
     */
    public static void loopPour(int max, int min, Consumer<? super Integer> consumer) {
        if (min > max) {
            throw new RuntimeException("最小值不能大于最大值，因为这使得循环永远不成立");
        }
        int i = max;
        while (i >= min) {
            consumer.accept(i);
            i--;
        }
    }

}
