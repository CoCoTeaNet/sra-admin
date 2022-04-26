package com.jwss.sra.system.service;

import com.jwss.sra.common.service.IBaseService;
import com.jwss.sra.system.param.log.OperationLogAddParam;
import com.jwss.sra.system.param.log.OperationLogPageParam;
import com.jwss.sra.system.param.log.OperationLogUpdateParam;
import com.jwss.sra.system.vo.OperationLogVO;
import org.sagacity.sqltoy.model.Page;

/**
 * @author jwss
 * @date 2022-4-26 22:59:14
 */
public interface IOperationLogService extends IBaseService<Page<OperationLogVO>, OperationLogPageParam, OperationLogAddParam, OperationLogUpdateParam> {

}
