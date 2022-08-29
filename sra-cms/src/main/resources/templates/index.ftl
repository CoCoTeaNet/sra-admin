<#include "./common/layout.ftl">

<@layout>
    <link rel="stylesheet" href="/css/index.css">
    <script src="/js/index.js"></script>

<#-- 文章列表 -->
    <div>
        <#list articleServiceByTimeDesc as article>
            <div class="card mb-3">
                <div class="row g-0">
                    <div class="col-md-4">
                        <img src="${article.cover}" class="img-fluid rounded-start" alt="${article.title}">
                    </div>
                    <div class="col-md-8">
                        <div class="card-body">
                            <a class="nav-link" style="padding: 0" href="p/${article.id}"><h5
                                        class="card-title">${article.title}</h5></a>
                            <p class="card-text">${article.summary}</p>
                            <p class="card-text"><small class="text-muted">${article.createTime}</small></p>
                        </div>
                    </div>
                </div>
            </div>
        </#list>
    </div>
</@layout>