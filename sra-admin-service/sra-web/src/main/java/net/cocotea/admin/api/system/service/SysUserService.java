package net.cocotea.admin.api.system.service;

import net.cocotea.admin.api.system.model.dto.*;
import net.cocotea.admin.api.system.model.po.SysUser;
import net.cocotea.admin.api.system.model.vo.SysLoginUserVO;
import net.cocotea.admin.api.system.model.vo.SysUserVO;
import net.cocotea.admin.common.model.ApiPage;
import net.cocotea.admin.common.model.BusinessException;
import net.cocotea.admin.common.service.DetailService;

import jakarta.servlet.http.HttpServletRequest;
import java.math.BigInteger;
import java.util.List;
import java.util.Map;

/**
 * @author CoCoTea
 * @date 2022-1-12 15:32:55
 */
public interface SysUserService extends DetailService<ApiPage<SysUserVO>, SysUserPageDTO, SysUserAddDTO, SysUserUpdateDTO, SysUserVO> {
    /**
     * 用户登录
     *
     * @param request request
     * @param param   登录参数
     * @return token
     * @throws BusinessException 业务异常
     */
    void login(SysLoginDTO param, HttpServletRequest request) throws BusinessException;

    /**
     * 用户获取个人详细信息
     *
     * @return 个人详细信息
     */
    SysUserVO getDetail();

    /**
     * 获取登录用户信息
     *
     * @return {@link SysLoginUserVO}
     */
    SysLoginUserVO loginUser();

    /**
     * 登录用户修改个人信息
     *
     * @param param {@link SysLoginUserUpdateDTO}
     * @return 成功返回TRUE
     */
    boolean updateByUser(SysLoginUserUpdateDTO param);

    /**
     * 修改个人账号密码
     *
     * @param oldPassword 旧密码
     * @param newPassword 新密码
     * @return 成功TRUE
     */
    boolean doModifyPassword(String oldPassword, String newPassword) throws BusinessException;

    /**
     * 获取系统用户map
     *
     * @param ids 用户ID列表
     * @return 用户map
     */
    Map<BigInteger, SysUser> getMap(List<BigInteger> ids);

    /**
     * 修改头像
     *
     * @param avatarName 头像名称
     */
    void doModifyAvatar(String avatarName);
}
