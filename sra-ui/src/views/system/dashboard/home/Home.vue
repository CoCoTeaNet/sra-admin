<template>
  <div class="bg">
    <el-card>
      <h3>SRA后台管理系统</h3>
      <p>基于springboot，整合satoken、sqltoy的权限管理系统，由此命名为：sss-rbac-admin</p>
      <p>当前版本：V1.0.0</p>
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
          <el-collapse accordion>
            <el-collapse-item title="Consistency" name="1">
              <div>
                Consistent with real life: in line with the process and logic of real
                life, and comply with languages and habits that the users are used to;
              </div>
              <div>
                Consistent within interface: all elements should be consistent, such
                as: design style, icons and texts, position of elements, etc.
              </div>
            </el-collapse-item>
            <el-collapse-item title="Feedback" name="2">
              <div>
                Operation feedback: enable the users to clearly perceive their
                operations by style updates and interactive effects;
              </div>
              <div>
                Visual feedback: reflect current state by updating or rearranging
                elements of the page.
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