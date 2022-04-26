<template>
  <div>
    <el-card>
      <h3>SRA后台管理系统</h3>
      <p>基于springboot，整合satoken、sqltoy的权限管理系统，由此命名为：sss-rbac-admin</p>
      <p>
        🍬基于SpringBoot，后端核心技术采用Sqltoy操作数据库以及Sa-Token鉴权，前端使用Vue3+TS+Element-plus。
        是一款前后端分离、开箱即用的后台权限管理系统。
      </p>
      <p>当前版本：V1.0.2</p>
    </el-card>

    <el-row :gutter="10" style="margin-top: 1em">
      <el-col :span="12">
        <el-card title="联系信息">
          <template #header>
            <div><span>联系信息</span></div>
          </template>
          <p>QQ群：xxxxxx</p>
          <p>博客：<a href="https://live1024.cn">https://live1024.cn</a></p>
          <p>Gitee：<a href="https://gitee.com/momoljw">https://gitee.com/momoljw</a></p>
          <p>GitHub：<a href="https://github.com/momofoolish">https://github.com/momofoolish</a></p>
        </el-card>
      </el-col>
      <el-col :span="12">
        <el-card>
          <el-collapse accordion :model-value="'2'">
            <!-- v1.0.2 -->
            <el-collapse-item title="v1.0.2" name="2">
              <p>版本v1.0.2</p>
              <div>
                <ul>
                  <li>1. 修复已知BUG & 优化UI.</li>
                  <li>2. 新增字典表维护.</li>
                  <li>3. 补充权限缓存以及角色鉴权.</li>
                  <li>4. 后台系统新增实体类代码生成器.</li>
                  <li>快马加鞭建设中...</li>
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

<script setup lang="ts"></script>

<style scoped src="./css/Home.css"></style>