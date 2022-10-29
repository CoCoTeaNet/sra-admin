package com.sraapp.system.service;

import com.sraapp.common.service.IBaseService;
import com.sraapp.system.param.version.VersionAddParam;
import com.sraapp.system.param.version.VersionPageParam;
import com.sraapp.system.param.version.VersionUpdateParam;
import com.sraapp.system.vo.VersionVO;
import org.sagacity.sqltoy.model.Page;

public interface IVersionService extends IBaseService<Page<VersionVO>, VersionPageParam, VersionAddParam, VersionUpdateParam> {
}
