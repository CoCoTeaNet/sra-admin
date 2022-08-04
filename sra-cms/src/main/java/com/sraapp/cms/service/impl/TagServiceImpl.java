package com.sraapp.cms.service.impl;

import com.sraapp.cms.param.tag.TagAddParam;
import com.sraapp.cms.param.tag.TagPageParam;
import com.sraapp.cms.param.tag.TagUpdateParam;
import com.sraapp.cms.service.ITagService;
import com.sraapp.cms.vo.TagVo;
import com.sraapp.common.model.BusinessException;
import org.sagacity.sqltoy.model.Page;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TagServiceImpl implements ITagService {
    @Override
    public boolean add(TagAddParam param) throws BusinessException {
        return false;
    }

    @Override
    public boolean deleteBatch(List<String> idList) throws BusinessException {
        return false;
    }

    @Override
    public boolean update(TagUpdateParam param) throws BusinessException {
        return false;
    }

    @Override
    public Page<TagVo> listByPage(TagPageParam param) throws BusinessException {
        return null;
    }

    @Override
    public boolean delete(String id) throws BusinessException {
        return false;
    }
}
