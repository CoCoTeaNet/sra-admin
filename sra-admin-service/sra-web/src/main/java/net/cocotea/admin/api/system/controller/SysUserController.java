package net.cocotea.admin.api.system.controller;

import cn.dev33.satoken.annotation.SaCheckRole;
import cn.dev33.satoken.annotation.SaMode;
import com.alibaba.fastjson.JSONObject;
import net.cocotea.admin.api.system.model.dto.SysLoginUserUpdateDTO;
import net.cocotea.admin.api.system.model.dto.SysUserAddDTO;
import net.cocotea.admin.api.system.model.dto.SysUserPageDTO;
import net.cocotea.admin.api.system.model.dto.SysUserUpdateDTO;
import net.cocotea.admin.api.system.model.vo.SysUserVO;
import net.cocotea.admin.api.system.service.SysUserService;
import net.cocotea.admin.common.model.ApiPage;
import net.cocotea.admin.common.model.ApiResult;
import net.cocotea.admin.common.model.BusinessException;
import org.springframework.web.bind.annotation.*;

import jakarta.annotation.Resource;
import javax.validation.Valid;
import java.math.BigInteger;
import java.util.List;

@RequestMapping("/system/user")
@RestController
public class SysUserController {
    @Resource
    private SysUserService userService;

    @SaCheckRole(value = {"role:super:admin", "role:simple:admin"}, mode = SaMode.OR)
    @PostMapping("/add")
    public ApiResult<?> add(@Valid @RequestBody SysUserAddDTO dto) throws BusinessException {
        boolean b = userService.add(dto);
        return ApiResult.flag(b);
    }

    @SaCheckRole(value = {"role:super:admin", "role:simple:admin"}, mode = SaMode.OR)
    @PostMapping("/update")
    public ApiResult<?> update(@Valid @RequestBody SysUserUpdateDTO param) throws BusinessException {
        boolean b = userService.update(param);
        return ApiResult.flag(b);
    }

    @SaCheckRole(value = {"role:super:admin", "role:simple:admin"}, mode = SaMode.OR)
    @PostMapping("/delete/{id}")
    public ApiResult<?> delete(@PathVariable BigInteger id) throws BusinessException {
        boolean b = userService.delete(id);
        return ApiResult.flag(b);
    }

    @SaCheckRole(value = {"role:super:admin", "role:simple:admin"}, mode = SaMode.OR)
    @PostMapping("/deleteBatch")
    public ApiResult<?> deleteBatch(@RequestBody List<BigInteger> idList) throws BusinessException {
        boolean b = userService.deleteBatch(idList);
        return ApiResult.flag(b);
    }

    @SaCheckRole(value = {"role:super:admin", "role:simple:admin"}, mode = SaMode.OR)
    @PostMapping("/listByPage")
    public ApiResult<?> listByPage(@Valid @RequestBody SysUserPageDTO param) throws BusinessException {
        ApiPage<SysUserVO> list = userService.listByPage(param);
        return ApiResult.ok(list);
    }

    @GetMapping("/getDetail")
    public ApiResult<?> getDetail() {
        SysUserVO vo = userService.getDetail();
        return ApiResult.ok(vo);
    }

    @PostMapping("/updateByUser")
    public ApiResult<?> updateByUser(@Valid @RequestBody SysLoginUserUpdateDTO param) {
        boolean b = userService.updateByUser(param);
        return ApiResult.flag(b);
    }

    @PostMapping("/doModifyPassword")
    public ApiResult<?> doModifyPassword(@RequestBody JSONObject obj) throws BusinessException {
        boolean r = userService.doModifyPassword(obj.getString("oldPassword"), obj.getString("newPassword"));
        return ApiResult.ok(r);
    }
}
