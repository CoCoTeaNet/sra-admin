package net.cocotea.admin.common.util.rank;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;

/**
 * 排名工具类
 */
public class RankUtils {
    private RankUtils() {
    }

    /**
     * 常用排名工具类，实体类需要继承 {@link RankModel}
     *
     * @param rankModelList 排名列表
     */
    public static void commonRank(List<? extends RankModel> rankModelList) {
        rankAction(rankModelList, null);
    }

    /**
     * 根据字段名进行排名，实体类需要继承 {@link RankModel}，数量字段必须是Long型
     * <p>字段名quantityName和rankingName必须大写字母开头</p>
     * <p>例：orderNum、rank ==> BusinessUtil.rank(list, "OrderNum", "Rank")</p>
     * <p>用到反射，性能有所降低，不推荐</p>
     *
     * @param list 排名列表
     * @param quantityName 数量字段名称
     * @param rankingName 名次字段名称
     */
    public static void rank(List<? extends RankModel> list, String quantityName, String rankingName) {
        if (quantityName == null || rankingName == null || "".equals(quantityName) || "".equals(rankingName)) {
            throw new RuntimeException("quantityName is empty or rankingName is empty");
        }
        commonRank(list);
        list.forEach(item -> {
            try {
                for (Method method : item.getClass().getMethods()) {
                    String methodNameQ = "set" + quantityName;
                    String methodNameR = "set" + rankingName;
                    if (method.getName().equals(methodNameQ)) {
                        method.invoke(item, item.getQuantity());
                    }else if (method.getName().equals(methodNameR)) {
                        method.invoke(item, item.getRanking());
                    }
                }
            } catch (InvocationTargetException | IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        });
    }

    public static void rankAction(List<? extends RankModel> rankModelList, Consumer<? super RankModel> action) {
        if (rankModelList == null || rankModelList.size() == 0) return;
        int count = 1;
        rankModelList.sort(Comparator.comparing(RankModel::getQuantity, Comparator.reverseOrder()));
        for (RankModel item : rankModelList) {
            boolean flag = true;
            for (RankModel innerItem : rankModelList) {
                if (innerItem.getRanking() != null && Objects.equals(innerItem.getQuantity(), item.getQuantity())) {
                    item.setRanking(innerItem.getRanking());
                    flag = false;
                    break;
                }
            }
            if (flag) item.setRanking(count++);
            if (action != null) action.accept(item);
        }
    }

    public static void commonRankD(List<? extends RankDModel> rankModelList) {
        rankActionD(rankModelList, null);
    }

    public static void rankD(List<? extends RankDModel> list, String quantityName, String rankingName) {
        if (quantityName == null || rankingName == null || "".equals(quantityName) || "".equals(rankingName)) {
            throw new RuntimeException("quantityName is empty or rankingName is empty");
        }
        commonRankD(list);
        list.forEach(item -> {
            try {
                for (Method method : item.getClass().getMethods()) {
                    String methodNameQ = "set" + quantityName;
                    String methodNameR = "set" + rankingName;
                    if (method.getName().equals(methodNameQ)) {
                        method.invoke(item, item.getQuantity());
                    }else if (method.getName().equals(methodNameR)) {
                        method.invoke(item, item.getRanking());
                    }
                }
            } catch (InvocationTargetException | IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        });
    }

    public static void rankActionD(List<? extends RankDModel> rankModelList, Consumer<? super RankDModel> action) {
        if (rankModelList == null || rankModelList.size() == 0) return;
        int count = 1;
        rankModelList.sort(Comparator.comparing(RankDModel::getQuantity, Comparator.reverseOrder()));
        for (RankDModel item : rankModelList) {
            boolean flag = true;
            for (RankDModel innerItem : rankModelList) {
                if (innerItem.getRanking() != null && Objects.equals(innerItem.getQuantity(), item.getQuantity())) {
                    item.setRanking(innerItem.getRanking());
                    flag = false;
                    break;
                }
            }
            if (flag) item.setRanking(count++);
            if (action != null) action.accept(item);
        }
    }

    public static void commonRankF(List<? extends RankFModel> rankModelList) {
        rankActionF(rankModelList, null);
    }

    public static void rankF(List<? extends RankFModel> list, String quantityName, String rankingName) {
        if (quantityName == null || rankingName == null || "".equals(quantityName) || "".equals(rankingName)) {
            throw new RuntimeException("quantityName is empty or rankingName is empty");
        }
        commonRankF(list);
        list.forEach(item -> {
            try {
                for (Method method : item.getClass().getMethods()) {
                    String methodNameQ = "set" + quantityName;
                    String methodNameR = "set" + rankingName;
                    if (method.getName().equals(methodNameQ)) {
                        method.invoke(item, item.getQuantity());
                    }else if (method.getName().equals(methodNameR)) {
                        method.invoke(item, item.getRanking());
                    }
                }
            } catch (InvocationTargetException | IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        });
    }

    public static void rankActionF(List<? extends RankFModel> rankModelList, Consumer<? super RankFModel> action) {
        if (rankModelList == null || rankModelList.size() == 0) return;
        int count = 1;
        rankModelList.sort(Comparator.comparing(RankFModel::getQuantity, Comparator.reverseOrder()));
        for (RankFModel item : rankModelList) {
            boolean flag = true;
            for (RankFModel innerItem : rankModelList) {
                if (innerItem.getRanking() != null && Objects.equals(innerItem.getQuantity(), item.getQuantity())) {
                    item.setRanking(innerItem.getRanking());
                    flag = false;
                    break;
                }
            }
            if (flag) item.setRanking(count++);
            if (action != null) action.accept(item);
        }
    }
}
