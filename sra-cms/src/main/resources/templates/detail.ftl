<#include "./common/layout.ftl">

<@layout>
    <h2>${article.title}</h2>

    <p class="card-text"><small class="text-muted">${article.createTime}</small></p>

    <div style="overflow: auto;white-space: pre-wrap;word-wrap: break-word">${article.content}</div>

    <#list article.tagList as tag>
        <span class="badge rounded-pill bg-primary">${tag}</span>
    </#list>
</@layout>