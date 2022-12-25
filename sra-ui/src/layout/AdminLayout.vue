<template>
  <el-container style="height: 100vh;">
    <el-aside width="300" style="border-right: solid 1px var(--el-menu-border-color);"><NavMenu/></el-aside>

    <el-container>
      <el-header><admin-header/></el-header>

      <el-main>
        <router-view v-slot="{Component}">
          <keep-alive>
            <transition :name="`slide-fade`" :mode="`out-in`">
              <component :is="Component"/>
            </transition>
          </keep-alive>
        </router-view>
      </el-main>

      <el-footer>
        <span style="color: #606266">SRA-ADMIN copyright @ CoCoTea 2022</span>
      </el-footer>
    </el-container>
  </el-container>
</template>

<script setup lang="ts">
import NavMenu from "./modules/NavMenu.vue";
import AdminHeader from "./modules/AdminHeader.vue";
import {useStore} from "@/store";

const store = useStore();
</script>

<!--私有样式-->
<style scoped>
.el-aside {
  overflow-x: hidden;
  transition: width 200ms;
}

/* 可以设置不同的进入和离开动画 */
/* 设置持续时间和动画函数 */
.slide-fade-enter-active {
  transition: all .5s ease;
}

.slide-fade-leave-active {
  transition: all .1s cubic-bezier(1.0, 0.5, 0.8, 1.0);
}

.slide-fade-enter, .slide-fade-leave-to {
  transform: translateX(10px);
  opacity: 0;
}
</style>