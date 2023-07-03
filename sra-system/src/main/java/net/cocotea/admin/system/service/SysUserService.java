package net.cocotea.admin.system.service;

import net.cocotea.admin.system.param.login.SysLoginParam;
import net.cocotea.admin.system.param.user.SysUserAddParam;
import net.cocotea.admin.system.param.user.SysUserPageParam;
import net.cocotea.admin.system.param.user.SysUserUpdateParam;
import net.cocotea.admin.common.model.BusinessException;
import net.cocotea.admin.common.service.IBaseService;
import net.cocotea.admin.system.vo.SysLoginUserVO;
import net.cocotea.admin.system.vo.SysUserVO;
import org.sagacity.sqltoy.model.Page;

import javax.servlet.http.HttpServletRequest;

/**
 * @author jwss
 * @date 2022-1-12 15:32:55
 */
public interface SysUserService extends IBaseService<Page<SysUserVO>, SysUserPageParam, SysUserAddParam, SysUserUpdateParam> {
    /**
     * 用户登录
     *
     * @param request request
     * @param param 登录参数
     * @return token
     * @throws BusinessException 业务异常
     */
    SysLoginUserVO login(SysLoginParam param, HttpServletRequest request) throws BusinessException;

    /**
     * 用户获取个人详细信息
     * @return 个人详细信息
     */
    SysUserVO getDetail();

    SysLoginUserVO loginUser();

    /**
     * 修改个人账号密码
     * @param oldPassword 旧密码
     * @param newPassword 新密码
     * @return 成功TRUE
     */
    boolean doModifyPassword(String oldPassword, String newPassword) throws BusinessException;
}
