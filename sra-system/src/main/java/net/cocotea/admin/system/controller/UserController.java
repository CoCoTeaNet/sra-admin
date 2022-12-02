package net.cocotea.admin.system.controller;

import cn.dev33.satoken.annotation.SaCheckLogin;
import cn.dev33.satoken.annotation.SaCheckPermission;
import cn.dev33.satoken.stp.StpUtil;
import net.cocotea.admin.common.model.ApiResult;
import net.cocotea.admin.common.model.BusinessException;
import net.cocotea.admin.system.service.IUserService;
import net.cocotea.admin.system.vo.LoginUserVO;
import net.cocotea.admin.system.vo.UserVO;
import net.cocotea.admin.system.param.user.UserAddParam;
import net.cocotea.admin.system.param.login.LoginParam;
import net.cocotea.admin.system.param.user.UserPageParam;
import net.cocotea.admin.system.param.user.UserUpdateParam;
import org.sagacity.sqltoy.model.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;

/**
 * @author jwss
 */
@Validated
@RequestMapping("/system/user")
@RestController
public class UserController {
    @Resource
    private IUserService userService;

    @SaCheckPermission("system:user:add")
    @PostMapping("/add")
    public ApiResult<String> add(@Valid @RequestBody UserAddParam param) throws BusinessException {
        boolean b = userService.add(param);
        return ApiResult.flag(b);
    }

    @SaCheckPermission("system:user:update")
    @PostMapping("/update")
    public ApiResult<String> update(@Valid @RequestBody UserUpdateParam param) throws BusinessException {
        boolean b = userService.update(param);
        return ApiResult.flag(b);
    }

    @SaCheckPermission("system:user:delete")
    @PostMapping("/delete/{id}")
    public ApiResult<String> delete(@PathVariable String id) throws BusinessException {
        boolean b = userService.delete(id);
        return ApiResult.flag(b);
    }

    @SaCheckPermission("system:user:delete")
    @PostMapping("/deleteBatch")
    public ApiResult<String> deleteBatch(@RequestBody List<String> idList) throws BusinessException {
        boolean b = userService.deleteBatch(idList);
        return ApiResult.flag(b);
    }

    @SaCheckPermission("system:user:listByPage")
    @PostMapping("/listByPage")
    public ApiResult<Page<UserVO>> listByPage(@Valid @RequestBody UserPageParam param) throws BusinessException {
        Page<UserVO> list = userService.listByPage(param);
        return ApiResult.ok(list);
    }

    @PostMapping("/logout")
    public ApiResult<String> logout() {
        StpUtil.logout();
        return ApiResult.ok();
    }

    @SaCheckLogin
    @GetMapping("/getDetail")
    public ApiResult<UserVO> getDetail() {
        UserVO vo = userService.getDetail();
        return ApiResult.ok(vo);
    }
}
