package com.sraapp.system.service;

import com.sraapp.common.model.BusinessException;
import com.sraapp.common.service.IBaseService;
import com.sraapp.system.param.user.UserAddParam;
import com.sraapp.system.param.user.UserLoginParam;
import com.sraapp.system.param.user.UserPageParam;
import com.sraapp.system.param.user.UserUpdateParam;
import com.sraapp.system.vo.LoginUserVO;
import com.sraapp.system.vo.UserVO;
import org.sagacity.sqltoy.model.Page;

import javax.servlet.http.HttpServletRequest;

/**
 * @author jwss
 * @date 2022-1-12 15:32:55
 */
public interface IUserService extends IBaseService<Page<UserVO>, UserPageParam, UserAddParam, UserUpdateParam> {
    /**
     * 用户登录
     *
     * @param request request
     * @param param 登录参数
     * @return token
     * @throws BusinessException 业务异常
     */
    LoginUserVO login(UserLoginParam param, HttpServletRequest request) throws BusinessException;

    /**
     * 用户获取个人详细信息
     * @return 个人详细信息
     */
    UserVO getDetail();
}
