package net.cocotea.system.controller;

import cn.dev33.satoken.annotation.SaCheckLogin;
import cn.dev33.satoken.annotation.SaCheckPermission;
import cn.dev33.satoken.stp.StpUtil;
import net.cocotea.common.model.ApiResult;
import net.cocotea.common.model.BusinessException;
import net.cocotea.system.service.IUserService;
import net.cocotea.system.vo.LoginUserVO;
import net.cocotea.system.vo.UserVO;
import net.cocotea.system.param.user.UserAddParam;
import net.cocotea.system.param.user.UserLoginParam;
import net.cocotea.system.param.user.UserPageParam;
import net.cocotea.system.param.user.UserUpdateParam;
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
@RequestMapping("/user")
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

    @PostMapping("/login")
    public ApiResult<LoginUserVO> login(@Valid @RequestBody UserLoginParam param, HttpServletRequest request) throws BusinessException {
        LoginUserVO s = userService.login(param, request);
        return ApiResult.ok(s);
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
