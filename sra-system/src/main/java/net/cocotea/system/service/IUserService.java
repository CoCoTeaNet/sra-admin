package net.cocotea.system.service;

import net.cocotea.common.model.BusinessException;
import net.cocotea.common.service.IBaseService;
import net.cocotea.system.param.user.UserAddParam;
import net.cocotea.system.param.user.UserLoginParam;
import net.cocotea.system.param.user.UserPageParam;
import net.cocotea.system.param.user.UserUpdateParam;
import net.cocotea.system.vo.LoginUserVO;
import net.cocotea.system.vo.UserVO;
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
