package net.cocotea.admin.common.service;

import net.cocotea.admin.common.model.BusinessException;

import java.util.List;

/**
 * 删改基础服务 接口
 * @param <A> 新增参数
 * @param <U> 更新参数
 * @author CoCoTea
 * @date 2022-9-30 17:19:06
 */
public interface IBaseUpdateService<A, U> {

    /**
     * 新增字典
     * @param param 新增参数
     * @return 成功返回true
     * @throws BusinessException 业务异常
     */
    boolean save(A param) throws BusinessException;

    /**
     * 批量删除
     * @param idList id集合
     * @return 成功返回true
     * @throws BusinessException 业务异常
     */
    default boolean deleteBatch(List<String> idList) throws BusinessException {
        return false;
    }

    /**
     * 更新信息
     * @param param 更新参数
     * @return 成功返回true
     * @throws BusinessException 业务异常
     */
    boolean update(U param) throws BusinessException;

    /**
     * 移除单个
     * @param id 主键id
     * @return 成功返回true
     * @throws BusinessException 业务异常
     */
    default boolean delete(String id) throws BusinessException {
        return false;
    }
}
