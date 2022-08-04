package com.sraapp.cms.service;

import com.sraapp.cms.param.tag.TagAddParam;
import com.sraapp.cms.param.tag.TagPageParam;
import com.sraapp.cms.param.tag.TagUpdateParam;
import com.sraapp.cms.vo.TagVo;
import com.sraapp.common.service.IBaseService;
import org.sagacity.sqltoy.model.Page;

public interface ITagService extends IBaseService<Page<TagVo>, TagPageParam, TagAddParam, TagUpdateParam> {
}
