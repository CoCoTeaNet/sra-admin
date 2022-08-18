<#macro layout>
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
        <title>${title}</title>
    </head>
    <body>

    <nav class="navbar navbar-expand-lg navbar-light shadow-sm p-3 mb-5 bg-body rounded">
        <div class="container-fluid">
            <a class="navbar-brand" href="#">LOGO</a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse"
                    data-bs-target="#navbarSupportedContent"
                    aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                    <li class="nav-item">
                        <a class="nav-link active" aria-current="page" href="/cmsPage/index">首页</a>
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
                </form>
            </div>
        </div>
    </nav>

    <#--内容-->
    <div class="container">
        <#--导航-->
        <div class="row">
            <div class="col-8"> <#nested > </div>
            <div class="col-4">
                <#-- 文章列表 -->
                <ul class="list-group list-group-flush">
                    <li class="list-group-item">An item</li>
                    <li class="list-group-item">A second item</li>
                    <li class="list-group-item">A third item</li>
                    <li class="list-group-item">A fourth item</li>
                    <li class="list-group-item">And a fifth one</li>
                </ul>
                <#-- 归档 -->
                <div style="padding-top: 1.33em;">
                    <ul class="list-group">

                        <#list archiveVoList as item>
                            <li class="list-group-item d-flex justify-content-between align-items-center">
                                <a class="nav-link" style="padding: 0" href="#">${item.day}</a>
                                <span class="badge bg-primary rounded-pill">${item.total}</span>
                            </li>
                        </#list>

                    </ul>
                </div>
                <#-- 标签 -->
                <div style="padding-top: 1.33em;">

                    <#list tags as tag>
                        <span class="badge rounded-pill ${tag.color}">${tag.tagName}</span>
                    </#list>

                </div>
                <#-- 脚注 -->
                <div class="card" style="margin-top: 1.33em;font-size: 14px;">
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
</#macro>