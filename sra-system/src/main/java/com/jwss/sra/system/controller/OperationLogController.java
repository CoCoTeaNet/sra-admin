package com.jwss.sra.system.controller;

import com.jwss.sra.common.model.ApiResult;
import com.jwss.sra.common.model.BusinessException;
import com.jwss.sra.system.param.log.OperationLogPageParam;
import com.jwss.sra.system.service.IOperationLogService;
import com.jwss.sra.system.vo.OperationLogVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.sagacity.sqltoy.model.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * 系统操作日志 接口控制器
 *
 * @author jwss
 * @date 2022-4-29 16:37:01
 */
@Api(value = "系统操作日志接口")
@Validated
@RestController
@RequestMapping("/operationLog")
public class OperationLogController {
    @Resource
    private IOperationLogService operationLogService;

    @ApiOperation("分页获取系统操作日志")
    @PostMapping("/listByPage")
    public ApiResult<Page<OperationLogVO>> pageApiResult(@RequestBody OperationLogPageParam param) throws BusinessException {
        Page<OperationLogVO> p = operationLogService.listByPage(param);
        return ApiResult.ok(p);
    }

    @PostMapping("/deleteBatch")
    public ApiResult<String> deleteBatch(@RequestBody List<String> ids) throws BusinessException {
        boolean b = operationLogService.deleteBatch(ids);
        return ApiResult.flag(b);
    }
}
