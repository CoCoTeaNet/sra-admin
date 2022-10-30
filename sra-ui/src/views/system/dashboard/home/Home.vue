<template>
  <div>
    <el-card shadow="never">
      <h3>SRA后台管理系统</h3>
      <p>基于springboot，整合satoken、sqltoy的权限管理系统，由此命名为：sss-rbac-admin</p>
      <p>
        基于SpringBoot，后端核心技术采用Sqltoy操作数据库以及Sa-Token鉴权，前端使用Vue3+TS+Element-plus。
        是一款前后端分离、开箱即用的后台权限管理系统。
      </p>
      <p>当前版本：{{pageVo.records.length>0 ? pageVo.records[0].updateNo : ''}}</p>
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

          <el-collapse accordion :model-value="0">
            <el-collapse-item v-for="(item,index) in pageVo.records" :title="item.updateNo" :name="index">
              <el-input class="p-view" v-model="item.updateDesc" type="textarea" rows="8"></el-input>
            </el-collapse-item>
          </el-collapse>

        </el-card>
      </el-col>
    </el-row>
  </div>
</template>

<script setup lang="ts">
import {reqCommonFeedback} from "@/api/ApiFeedback";
import {listByPage} from "@/api/system/version-api";
import {onMounted, ref} from "vue";

const pageVo = ref<PageVO>({pageNo: 1, pageSize: 50, total: 0, records: []});

onMounted(() => {
  loadTableData();
})

const loadTableData = (): void => {
  let param = {
    pageNo: 1,
    pageSize: 50,
    version: {}
  };
  reqCommonFeedback(listByPage(param), (data: any) => {
    pageVo.value.records = data.rows;
    pageVo.value.total = data.recordCount;
    pageVo.value.pageSize = data.pageSize;
  });
}
</script>

<style scoped src="./css/Home.css"></style>