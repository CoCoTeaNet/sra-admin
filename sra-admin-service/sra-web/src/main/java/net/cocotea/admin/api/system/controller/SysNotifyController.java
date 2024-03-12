package net.cocotea.admin.api.system.controller;

import net.cocotea.admin.api.system.model.vo.SysNotifyVO;
import net.cocotea.admin.api.system.service.SysNotifyService;
import net.cocotea.admin.common.model.ApiResult;
import org.springframework.web.bind.annotation.*;

import jakarta.annotation.Resource;
import java.math.BigInteger;
import java.util.List;

@RequestMapping("/anime/notify")
@RestController
public class SysNotifyController {

    @Resource
    private SysNotifyService sysNotifyService;

    @GetMapping("/listByType")
    public ApiResult<?> listByType(@RequestParam("type") String type) {
        List<SysNotifyVO> vos = sysNotifyService.listByType(type);
        return ApiResult.ok(vos);
    }

    @PostMapping("/read/{id}")
    public ApiResult<?> read(@PathVariable("id") BigInteger id) {
        sysNotifyService.read(id);
        return ApiResult.ok();
    }

}
