package net.cocotea.admin.common.service;

import net.cocotea.admin.common.model.BusinessException;

/**
 * 查基础服务 接口
 * @param <T> 分页返回对象
 * @param <S> 分页对象
 * @author CoCoTea
 * @date 2022-9-30 17:19:06
 */
public interface IBaseQueryService<T, S> {
    /**
     * 分页获取
     * @param param 分页参数
     * @return 列表
     * @throws BusinessException 业务异常
     */
    T listByPage(S param) throws BusinessException;

    /**
     * 查询详细信息
     * @param id 主键id
     * @return 信息详细
     * @throws BusinessException 业务异常
     */
    T detail(String id) throws BusinessException;
}
