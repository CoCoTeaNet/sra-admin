package net.cocotea.admin.cms.param.comment;

import net.cocotea.admin.cms.vo.CommentVo;
import org.sagacity.sqltoy.model.Page;

public class CommentPageParam extends Page<CommentVo> {
    private static final long serialVersionUID = -1346427578243868811L;

    private CommentVo commentVo;

    public CommentVo getCommentVo() {
        return commentVo;
    }

    public CommentPageParam setCommentVo(CommentVo commentVo) {
        this.commentVo = commentVo;
        return this;
    }
}
