package net.cocotea.admin.cms.param.comment;

import net.cocotea.admin.cms.vo.CmsCommentVO;
import org.sagacity.sqltoy.model.Page;

public class CmsCommentPageParam extends Page<CmsCommentVO> {
    private static final long serialVersionUID = -1346427578243868811L;

    private CmsCommentVO comment;

    public CmsCommentVO getComment() {
        return comment;
    }

    public CmsCommentPageParam setComment(CmsCommentVO comment) {
        this.comment = comment;
        return this;
    }
}
