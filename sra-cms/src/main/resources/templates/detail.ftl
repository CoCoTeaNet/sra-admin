<#include "./common/layout.ftl">

<@layout>
    <h2>${article.title}</h2>

    <p class="card-text"><small class="text-muted">${article.createTime}</small></p>

    <div style="overflow: auto;white-space: pre-wrap;word-wrap: break-word">${article.content}</div>

    <#list article.tagList as tag>
        <span class="badge rounded-pill bg-primary">${tag}</span>
    </#list>

    <hr class="divider">

    <div class="mb-3">
        <label for="exampleFormControlTextarea1" class="form-label">发表评论</label>
        <textarea class="form-control" id="commentForm" rows="3"></textarea>
        <div style="margin-top: 1em;display: flex;justify-content: space-between">
            <input id="emailForm" type="email" style="width: 90%" class="form-control" placeholder="name@email.com">
            <button id="sendBtn" type="button" style="width: 80px" class="btn btn-primary">发送</button>
        </div>
        <div id="formAlert" class="alert alert-warning mt-1" role="alert"></div>
    </div>

    <#if (articleCommentVoList?size>0)><p>评论列表</p></#if>
    <div style="background-color: aliceblue;">
        <#list articleCommentVoList as item>
            <div style="margin-bottom: 1em">
                <h5 class="card-title">${item.createBy}</h5>
                <p class="card-text text-muted">${item.content}</p>
            </div>
        </#list>
    </div>


    <script>
        window.onload = function () {
            let formAlert = $('#formAlert');
            formAlert.hide();
            $("#sendBtn").click(() => {
                let content = $("#commentForm").val();
                let email = $("#emailForm").val();
                if (!content) {
                    formAlert.show();
                    formAlert.text('回复内容为空');
                    return;
                }
                if (!email) {
                    formAlert.show();
                    formAlert.text('邮箱为空');
                    return;
                }
                $.ajax({
                    method: 'post',
                    url: '/cms/comment/add',
                    data: JSON.stringify({articleId: '${article.id}',replyType: 0, content: content, email: email}),
                    dataType: 'json',
                    contentType: 'application/json',
                    success: (resp) => {
                        if (resp.code === 200) {
                            window.location.reload();
                        } else {
                            formAlert.show();
                            formAlert.text(resp.message);
                        }
                    }
                });
            });
        }
    </script>
</@layout>