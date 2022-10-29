<template>
  <div>
    <el-card shadow="never">
      <h3>SRA后台管理系统</h3>
      <p>基于springboot，整合satoken、sqltoy的权限管理系统，由此命名为：sss-rbac-admin</p>
      <p>
        🍬基于SpringBoot，后端核心技术采用Sqltoy操作数据库以及Sa-Token鉴权，前端使用Vue3+TS+Element-plus。
        是一款前后端分离、开箱即用的后台权限管理系统。
      </p>
      <p>当前版本：V1.1.3</p>
    </el-card>

    <el-row :gutter="10" style="margin-top: 1em">
      <el-col :span="12">
        <el-card shadow="never" title="联系信息">
          <template #header>
            <div><span>联系信息</span></div>
          </template>
          <p>QQ技术交流群：543112505</p>
          <p>作者博客：<a href="https://live1024.cn">https://live1024.cn</a></p>
          <p>Gitee：<a href="https://gitee.com/momoljw">https://gitee.com/momoljw</a></p>
          <p>GitHub：<a href="https://github.com/momofoolish">https://github.com/momofoolish</a></p>
        </el-card>
      </el-col>
      <el-col :span="12">
        <el-card shadow="never">


          <el-collapse accordion :model-value="'6'">
            <!-- v1.1.2 -->
            <el-collapse-item title="v1.1.2" name="6">
              <p>版本v1.1.2</p>
              <div>
                <ul>
                  <li>1. 修复文件上传XSS安全漏洞.</li>
                  <li>2. 增加图片上传格式限制.</li>
                  <li>3. 升级springboot到2.7.4版本</li>
                  <li>4. 升级mysql连接器到8.0.30版本</li>
                </ul>
              </div>
            </el-collapse-item>

            <!-- v1.1.1 -->
            <el-collapse-item title="v1.1.1" name="5">
              <p>版本v1.1.1</p>
              <div>
                <ul>
                  <li>1. 修复已知BUG.</li>
                  <li>2. 优化UI界面.</li>
                  <li>3. 更改是否枚举标识.</li>
                  <li>4. 优化任务调度代码.</li>
                </ul>
              </div>
            </el-collapse-item>
            <!-- v1.1.0 -->
            <el-collapse-item title="v1.1.0" name="4">
              <p>版本v1.1.0</p>
              <div>
                <ul>
                  <li>1. 修复已知BUG.</li>
                  <li>2. 新增CMS模块.</li>
                  <li>3. 新增任务调度模块.</li>
                  <li>4. 更改GAV,优化UI界面.</li>
                  <li>5. 移除swagger.</li>
                </ul>
              </div>
            </el-collapse-item>
            <!-- v1.0.3 -->
            <el-collapse-item title="v1.0.3" name="3">
              <p>版本v1.0.3</p>
              <div>
                <ul>
                  <li>1. 修复已知BUG.</li>
                  <li>2. 新增CMS模块.</li>
                </ul>
              </div>
            </el-collapse-item>
            <!-- v1.0.2 -->
            <el-collapse-item title="v1.0.2" name="2">
              <p>版本v1.0.2</p>
              <div>
                <ul>
                  <li>1. 修复已知BUG & 优化UI.</li>
                  <li>2. 新增字典表维护.</li>
                  <li>3. 补充权限缓存以及角色鉴权.</li>
                  <li>4. 后台系统新增实体类代码生成器.</li>
                  <li>5. 增加操作日志功能.</li>
                </ul>
              </div>
            </el-collapse-item>
            <!-- v1.0.1 -->
            <el-collapse-item title="v1.0.1" name="1">
              <div>
                <p>版本v1.0.1正式完成</p>
                <p>
                  🍬基于SpringBoot，后端核心技术采用Sqltoy操作数据库以及Sa-Token鉴权，前端使用Vue3+TS+Element-plus。
                  是一款前后端分离、开箱即用的后台权限管理系统。
                </p>
              </div>
            </el-collapse-item>
          </el-collapse>


        </el-card>
      </el-col>
    </el-row>
  </div>
</template>

<style scoped src="./css/Home.css"></style>