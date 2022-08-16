<!doctype html>
<html lang="zh">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <#-- boostrap框架 -->
    <link rel="stylesheet" href="/bootstrap-5.1.3/css/bootstrap.min.css">
    <script src="/bootstrap-5.1.3/jquery-3.6.0.min.js"></script>
    <script src="/bootstrap-5.1.3/js/bootstrap.min.js"></script>
    <#-- 本地css和js -->
    <link rel="stylesheet" href="/css/index.css">
    <script src="/js/index.js"></script>
    <title>首页</title>
</head>
<body>

<#--导航-->
<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <div class="container-fluid">
        <a class="navbar-brand" href="#">LOGO</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
                aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                <li class="nav-item">
                    <a class="nav-link active" aria-current="page" href="#">首页</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">归档</a>
                </li>
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button"
                       data-bs-toggle="dropdown" aria-expanded="false">
                        更多
                    </a>
                    <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
                        <li><a class="dropdown-item" href="#">关于</a></li>
                        <li><a class="dropdown-item" href="#">Gitee</a></li>
                        <li>
                            <hr class="dropdown-divider">
                        </li>
                        <li><a class="dropdown-item" href="#">后台管理</a></li>
                    </ul>
                </li>
            </ul>
            <form class="d-flex" role="search">
                <input class="form-control me-2" type="search" placeholder="搜索" aria-label="Search">
                <button class="btn btn-outline-success" type="submit">Search</button>
            </form>
        </div>
    </div>
</nav>

<#--内容-->
<div class="container">
    <div class="row">
        <#-- 左侧 -->
        <div class="col-8">
            <#-- 文章列表 -->
            <div style="padding-top: 1.33em;">
                <#list articleServiceByTimeDesc as article>
                    <div class="card mb-3">
                        <div class="row g-0">
                            <div class="col-md-4">
                                <img src="${article.cover}" class="img-fluid rounded-start" alt="${article.title}">
                            </div>
                            <div class="col-md-8">
                                <div class="card-body">
                                    <h5 class="card-title">${article.title}</h5>
                                    <p class="card-text">${article.summary}</p>
                                    <p class="card-text"><small class="text-muted">${article.createTime}</small></p>
                                </div>
                            </div>
                        </div>
                    </div>
                </#list>
            </div>
        </div>
        <#-- 右侧 -->
        <div class="col-4">
            <#-- 文章列表 -->
            <ul class="list-group list-group-flush" style="padding-top: 1.33em;">
                <li class="list-group-item">An item</li>
                <li class="list-group-item">A second item</li>
                <li class="list-group-item">A third item</li>
                <li class="list-group-item">A fourth item</li>
                <li class="list-group-item">And a fifth one</li>
            </ul>
            <#-- 归档 -->
            <div style="padding-top: 1.33em;">
                <ul class="list-group">
                    <li class="list-group-item d-flex justify-content-between align-items-center">
                        A list item
                        <span class="badge bg-primary rounded-pill">14</span>
                    </li>
                    <li class="list-group-item d-flex justify-content-between align-items-center">
                        A second list item
                        <span class="badge bg-primary rounded-pill">2</span>
                    </li>
                    <li class="list-group-item d-flex justify-content-between align-items-center">
                        A third list item
                        <span class="badge bg-primary rounded-pill">1</span>
                    </li>
                </ul>
            </div>
            <#-- 标签 -->
            <div style="padding-top: 1.33em;">
                <span class="badge rounded-pill bg-primary">Primary</span>
                <span class="badge rounded-pill bg-secondary">Secondary</span>
                <span class="badge rounded-pill bg-success">Success</span>
                <span class="badge rounded-pill bg-danger">Danger</span>
                <span class="badge rounded-pill bg-warning text-dark">Warning</span>
                <span class="badge rounded-pill bg-info text-dark">Info</span>
                <span class="badge rounded-pill bg-light text-dark">Light</span>
                <span class="badge rounded-pill bg-dark">Dark</span>
            </div>
            <#-- 脚注 -->
            <div class="card" style="margin-top: 1.33em">
                <div class="card-body">
                    <p>联系我们（工作时间：8:30-22:00）</p>
                    <p>京ICP备XXXXXXXX号 经营性网站备案信息</p>
                    <p>公安备案号XXXXXXXXXXXXX</p>
                </div>
            </div>
        </div>
    </div>
</div>

</body>
</html>