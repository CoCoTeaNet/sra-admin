package net.cocotea.cms.param.comment;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class CommentAddParam {
    @NotBlank(message = "文章id为空")
    private String articleId;
    @NotBlank(message = "回复内容为空")
    private String content;
    /**
     * 回复类型;0文章 1用户
     */
    @NotNull(message = "回复类型为空")
    private Integer replyType;
    @Email(message = "邮箱格式有误")
    private String email;

    public String getArticleId() {
        return articleId;
    }

    public CommentAddParam setArticleId(String articleId) {
        this.articleId = articleId;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public CommentAddParam setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getContent() {
        return content;
    }

    public CommentAddParam setContent(String content) {
        this.content = content;
        return this;
    }

    public Integer getReplyType() {
        return replyType;
    }

    public CommentAddParam setReplyType(Integer replyType) {
        this.replyType = replyType;
        return this;
    }
}
