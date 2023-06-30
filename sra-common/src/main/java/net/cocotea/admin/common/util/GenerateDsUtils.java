package net.cocotea.admin.common.util;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * 数据结构生成工具
 *
 * @author jwss
 * @date 2022-3-23 11:50:54
 */
public class GenerateDsUtils<T> {

    /**
     * 生成树结构
     * 属性名称默认（父级parentId、主键id、子节点children）
     * @param ls 列表集合
     * @return 树形map结构
     */
    public Map<String, T> buildTreeDefault(List<T> ls) {
        return buildTreeCore(ls, "getParentId", "getId", "Children");
    }

    /**
     * 生成树结构
     * 属性名称必须大写
     * @param ls 列表集合
     * @param parentIdName 父节点属性名称
     * @param mainIdName 主节点属性名称
     * @param childrenName 子节点属性名称
     * @return 树形map结构
     */
    public Map<String, T> buildTree(List<T> ls, String parentIdName, String mainIdName, String childrenName) {
        return buildTreeCore(ls, "get" + parentIdName, "get" + mainIdName, childrenName);
    }

    /**
     * 生成树结构
     * 属性名称必须大写
     * @param tList 列表集合
     * @param parentIdName 获取父节点方法名称
     * @param mainIdName 获取主节点方法名称
     * @param childrenName 子节点属性名称
     * @return 树形map结构
     */
    private Map<String, T> buildTreeCore(List<T> tList, String parentIdName, String mainIdName, String childrenName) {
        Map<String, T> menuRootMap = new LinkedHashMap<>(tList.size());
        Map<String, T> menuChildMap = new LinkedHashMap<>(tList.size());
        String root = String.valueOf(0);
        // 1.将根节点元素和子节点元素通过id映射分离
        tList.forEach(item -> {
            Class<?> itemClass = item.getClass();
            Method getParentIdMethod;
            Method getIdMethod;
            try {
                getParentIdMethod = itemClass.getMethod(parentIdName);
                getIdMethod = itemClass.getMethod(mainIdName);
                if (root.equals(getParentIdMethod.invoke(item))) {
                    menuRootMap.put(String.valueOf(getIdMethod.invoke(item)), item);
                } else {
                    menuChildMap.put(String.valueOf(getIdMethod.invoke(item)), item);
                }
            } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
                e.printStackTrace();
            }
        });
        // 遍历子节点，通过映射id去给子节点分配父元素
        for (Map.Entry<String, T> item : menuChildMap.entrySet()) {
            T value = item.getValue();
            Class<?> valueClass = value.getClass();
            try {
                String parentId = String.valueOf(valueClass.getMethod(parentIdName).invoke(value));
                if (menuRootMap.get(parentId) != null) {
                    addToSet(childrenName, value, menuRootMap.get(parentId));
                } else if (menuChildMap.get(parentId) != null) {
                    addToSet(childrenName, value, menuChildMap.get(parentId));
                }
            } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return menuRootMap;
    }

    /**
     * 将子元素添加到集合
     * @param childrenName 子节点属性名称
     * @param v1 子节点
     * @param v2 父节点
     * @throws NoSuchMethodException 抛出异常
     */
    private void addToSet(String childrenName, T v1, T v2) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Object object = v2.getClass().getMethod("get" + childrenName).invoke(v2);
        if (object != null) {
            if (object instanceof List) {
                List<T> ls = (List<T>) object;
                ls.add(v1);
            }
        } else {
            ArrayList<T> list = new ArrayList<>();
            list.add(v1);
            v2.getClass().getMethod("set" + childrenName, List.class).invoke(v2, list);
        }
    }
}
