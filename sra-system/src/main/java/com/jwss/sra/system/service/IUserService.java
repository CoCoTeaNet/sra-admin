package com.jwss.sra.system.service;

import com.jwss.sra.common.model.BusinessException;
import com.jwss.sra.system.param.user.UserAddParam;
import com.jwss.sra.system.param.user.UserLoginParam;
import com.jwss.sra.system.param.user.UserPageParam;
import com.jwss.sra.system.param.user.UserUpdateParam;
import com.jwss.sra.system.vo.LoginUserVO;
import com.jwss.sra.system.vo.UserVO;
import org.sagacity.sqltoy.model.Page;

import javax.servlet.http.HttpServletRequest;

/**
 * @author jwss
 * @date 2022-1-12 15:32:55
 */
public interface IUserService {
    /**
     * 新增用户
     *
     * @param param 用户表单
     * @return 成功返回TRUE
     */
    boolean add(UserAddParam param);

    /**
     * 更新用户
     *
     * @param param 更新用户参数
     * @return 成功返回true
     */
    boolean update(UserUpdateParam param);

    /**
     * 删除用户
     *
     * @param id 主键id
     * @return 成功返回true
     */
    boolean delete(String id);

    /**
     * 用户分页参数
     *
     * @param param 分页参数
     * @return 用户分页集合
     */
    Page<UserVO> listByPage(UserPageParam param);

    /**
     * 用户登录
     *
     * @param request request
     * @param param 登录参数
     * @return token
     * @throws BusinessException 业务异常
     */
    LoginUserVO login(UserLoginParam param, HttpServletRequest request) throws BusinessException;
}
