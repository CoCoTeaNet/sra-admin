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
                <#list 1..10 as n>
                    <div class="card mb-3">
                        <div class="row g-0">
                            <div class="col-md-4">
                                <img src="..." class="img-fluid rounded-start" alt="...">
                            </div>
                            <div class="col-md-8">
                                <div class="card-body">
                                    <h5 class="card-title">Card title</h5>
                                    <p class="card-text">This is a wider card with supporting text below as a natural lead-in to additional content. This content is a little bit longer.</p>
                                    <p class="card-text"><small class="text-muted">2022-12-12</small></p>
                                </div>
                            </div>
                        </div>
                    </div>
                </#list>
            </div>
        </div>
        <#-- 右侧 -->
        <div class="col-4">
            <#-- 文章列表-时间倒叙 -->
            <div style="padding-top: 1.33em;">
                <div style="background-color: whitesmoke;">最新文章</div>
                <div class="main-left-card">玛娃是大傻逼</div>
                <div class="main-left-card">玛娃是大傻逼</div>
                <div class="main-left-card">玛娃是大傻逼</div>
                <div class="main-left-card">玛娃是大傻逼</div>
                <div class="main-left-card">玛娃是大傻逼</div>
            </div>
            <ul class="list-group list-group-flush" style="padding-top: 1.33em;">
                <li class="list-group-item">An item</li>
                <li class="list-group-item">A second item</li>
                <li class="list-group-item">A third item</li>
                <li class="list-group-item">A fourth item</li>
                <li class="list-group-item">And a fifth one</li>
            </ul>
            <#-- 归档 -->
            <div style="padding-top: 1.33em;">
                <div style="background-color: whitesmoke;">归档</div>
                <div class="main-left-card">玛娃是大傻逼</div>
                <div class="main-left-card">玛娃是大傻逼</div>
                <div class="main-left-card">玛娃是大傻逼</div>
                <div class="main-left-card">玛娃是大傻逼</div>
                <div class="main-left-card">玛娃是大傻逼</div>
            </div>
            <#-- 标签 -->
            <div style="padding-top: 1.33em;">
                <div style="background-color: whitesmoke;">标签</div>
                <div class="main-left-card">玛娃是大傻逼</div>
                <div class="main-left-card">玛娃是大傻逼</div>
                <div class="main-left-card">玛娃是大傻逼</div>
                <div class="main-left-card">玛娃是大傻逼</div>
                <div class="main-left-card">玛娃是大傻逼</div>
            </div>
            <#-- 评论 -->
            <div style="padding-top: 1.33em;">
                <div style="background-color: whitesmoke;">评论</div>
                <div class="main-left-card">玛娃是大傻逼</div>
                <div class="main-left-card">玛娃是大傻逼</div>
                <div class="main-left-card">玛娃是大傻逼</div>
                <div class="main-left-card">玛娃是大傻逼</div>
                <div class="main-left-card">玛娃是大傻逼</div>
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