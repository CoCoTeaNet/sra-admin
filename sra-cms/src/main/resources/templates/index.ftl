<!doctype html>
<html lang="zh">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="/css/index.css">
    <script src="/js/index.js"></script>
    <title>首页</title>
</head>
<body>

<#--导航-->
<div class="nav">
    <div class="nav-inner-box global-dist">
        <ul>
            <a href="#">首页</a>
            <a href="#">归档</a>
            <a href="#">标签</a>
        </ul>
        <ul>
            <input type="text" placeholder="搜索">
        </ul>
        <ul>
            <a href="#">关于</a>
            <a href="#">后台管理</a>
        </ul>
    </div>
</div>

<#--内容-->
<div class="global-dist main">
    <#-- 左侧 -->
    <#-- 文章列表 -->
    <div style="width: 79%;padding-right: 1em;">
        <#list 1..10 as n>
            <div class="article-list" style="border-bottom: 1px solid #b9b9b961;">
                <a href="/cmsPage/detail/12313"><h3>张三是大傻逼</h3></a>
                <div style="color: slategray">张三是大傻逼张三是大傻逼张三是大傻逼张三是大傻逼张三是大傻逼张三是大傻逼张三是大傻逼张三是大傻逼张三是大傻逼张三是大傻逼</div>
                <p style="color: darkgrey">2022-2-22</p>
            </div>
        </#list>
    </div>
    <#-- 右侧 -->
    <div style="width: 21%">
        <#-- 文章列表-时间倒叙 -->
        <div style="padding-top: 1.33em;">
            <div style="background-color: whitesmoke;">最新文章</div>
            <div class="main-left-card">玛娃是大傻逼</div>
            <div class="main-left-card">玛娃是大傻逼</div>
            <div class="main-left-card">玛娃是大傻逼</div>
            <div class="main-left-card">玛娃是大傻逼</div>
            <div class="main-left-card">玛娃是大傻逼</div>
        </div>
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
        <div class="main-left-card" style="margin-top: 1.33em;font-size: 14px;border: 1px solid #b9b9b961">
            <p>联系我们（工作时间：8:30-22:00）</p>
            <p>京ICP备XXXXXXXX号 经营性网站备案信息</p>
            <p>公安备案号XXXXXXXXXXXXX</p>
        </div>
    </div>
</div>

</body>
</html>