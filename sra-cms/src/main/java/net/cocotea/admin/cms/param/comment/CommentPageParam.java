package net.cocotea.admin.cms.param.comment;

import net.cocotea.admin.cms.vo.CommentVO;
import org.sagacity.sqltoy.model.Page;

public class CommentPageParam extends Page<CommentVO> {
    private static final long serialVersionUID = -1346427578243868811L;

    private CommentVO commentVo;

    public CommentVO getCommentVo() {
        return commentVo;
    }

    public CommentPageParam setCommentVo(CommentVO commentVo) {
        this.commentVo = commentVo;
        return this;
    }
}
