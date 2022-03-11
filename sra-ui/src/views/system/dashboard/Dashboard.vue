<template>
  <div class="bg">
    <!-- 综合统计 -->
    <el-row :gutter="12">
      <el-col :span="6">
        <el-card shadow="hover">
          <div style="display: flex;flex-direction: column;align-items: center">
            <span>用户数量</span>
            <span>12313</span>
          </div>
        </el-card>
      </el-col>
      <el-col :span="6">
        <el-card shadow="hover">
          <div style="display: flex;flex-direction: column;align-items: center">
            <span>菜单数量</span>
            <span>12313</span>
          </div>
        </el-card>
      </el-col>
      <el-col :span="6">
        <el-card shadow="hover">
          <div style="display: flex;flex-direction: column;align-items: center">
            <span>角色数量</span>
            <span>12313</span>
          </div>
        </el-card>
      </el-col>
      <el-col :span="6">
        <el-card shadow="hover">
          <div style="display: flex;flex-direction: column;align-items: center">
            <span>在线用户</span>
            <span>12313</span>
          </div>
        </el-card>
      </el-col>
    </el-row>

    <!-- cpu使用情况 -->
    <el-row style="margin-top: 1em">
      <el-col>
        <sra-pie-chart spc-id="spc3" :height="300" name="PeiName" :data="da" left="left" orient="vertical"
                       :title="title"/>
      </el-col>
    </el-row>

    <!-- 系统信息 -->
    <el-row>
      <el-col>
        <el-descriptions title="系统信息" direction="vertical" :column="4" border>
          <el-descriptions-item label="操作系统">kooriookami</el-descriptions-item>
          <el-descriptions-item label="服务器名">18100000000</el-descriptions-item>
          <el-descriptions-item label="服务器IP">Suzhou</el-descriptions-item>
          <el-descriptions-item label="系统架构">Suzhou</el-descriptions-item>

          <el-descriptions-item label="Java名称">Suzhou</el-descriptions-item>
          <el-descriptions-item label="Java版本">Suzhou</el-descriptions-item>
          <el-descriptions-item label="安装路径">Suzhou</el-descriptions-item>
          <el-descriptions-item label="项目路径">Suzhou</el-descriptions-item>
          <el-descriptions-item label="服务器运行时长">Suzhou</el-descriptions-item>

          <el-descriptions-item label="总内存">Suzhou</el-descriptions-item>
          <el-descriptions-item label="可用内存">Suzhou</el-descriptions-item>
          <el-descriptions-item label="已用内存">Suzhou</el-descriptions-item>

          <el-descriptions-item label="磁盘总大小">Suzhou</el-descriptions-item>
          <el-descriptions-item label="可用空间">Suzhou</el-descriptions-item>
          <el-descriptions-item label="已用空间">Suzhou</el-descriptions-item>
          <el-descriptions-item label="盘符路径">Suzhou</el-descriptions-item>
          <el-descriptions-item label="磁盘分隔符">Suzhou</el-descriptions-item>
        </el-descriptions>
      </el-col>
    </el-row>
  </div>
</template>

<script setup lang="ts">
import SraPieChart from "@/components/chart/pie-chart/SraPieChart.vue";
import {useStore} from "@/store";
import {ref} from "vue";

const title = {
  text: 'TitleText',
  subtext: 'title subtext',
  left: 'center'
}

const da = [
  {value: 1048, name: 'Search Engine'},
  {value: 735, name: 'Direct'},
  {value: 580, name: 'Email'},
  {value: 484, name: 'Union Ads'},
  {value: 300, name: 'Video Ads'}
]

const store = ref(useStore());

</script>
