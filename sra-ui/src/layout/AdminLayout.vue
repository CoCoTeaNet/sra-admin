<template>
  <!-- 采用element-ui常用布局：https://element-plus.gitee.io/zh-CN/component/container.html -->
  <el-container style="height: 100%">
    <!-- 导航 -->
    <el-aside class="el-aside" :width="store.state.isCollapseMenu ? '64px' : '220px'">
      <NavMenu/>
    </el-aside>
    <el-container style="background: #F2F6FC">
      <!-- 头部 -->
      <el-header>
        <admin-header/>
      </el-header>
      <!-- 主体 -->
      <el-main>
        <div style="background: white;padding: 1em;border-radius: 3px;">
          <router-view v-slot="{Component}">
            <keep-alive>
              <transition :name="`slide-fade`" :mode="`out-in`">
                <component :is="Component"/>
              </transition>
            </keep-alive>
          </router-view>
        </div>
      </el-main>
    </el-container>
  </el-container>
</template>

<script setup lang="ts">
import NavMenu from "./modules/NavMenu.vue";
import AdminHeader from "./modules/AdminHeader.vue";
import {useStore} from "@/store";
import {ref} from "vue";

const store = ref<any>(useStore());
</script>

<style>
.el-aside {
  transition: width 200ms;
  background-color: white;
}

/* 可以设置不同的进入和离开动画 */
/* 设置持续时间和动画函数 */
.slide-fade-enter-active {
  transition: all .5s ease;
}

.slide-fade-leave-active {
  transition: all .5s cubic-bezier(1.0, 0.5, 0.8, 1.0);
}

.slide-fade-enter, .slide-fade-leave-to {
  transform: translateX(10px);
  opacity: 0;
}
</style>