package com.sraapp.system.controller;

import com.sraapp.common.model.ApiResult;
import com.sraapp.common.model.BusinessException;
import com.sraapp.system.param.log.OperationLogPageParam;
import com.sraapp.system.service.IOperationLogService;
import com.sraapp.system.vo.OperationLogVO;
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
@Validated
@RestController
@RequestMapping("/operationLog")
public class OperationLogController {
    @Resource
    private IOperationLogService operationLogService;

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
