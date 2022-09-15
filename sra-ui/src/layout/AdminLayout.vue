<template>
  <admin-container
      :l-width="store.state.isCollapseMenu ? '8%' : '18%'"
      :r-width="store.state.isCollapseMenu ? '92%' : '82%'" >
    <template #nav>
      <el-scrollbar>
        <el-aside class="aside el-aside" :width="store.state.isCollapseMenu ? '64px' : '90%'">
          <NavMenu/>
        </el-aside>
      </el-scrollbar>
    </template>

    <template #header>
      <admin-header/>
    </template>

    <template #main>
      <div class="main">
        <router-view v-slot="{Component}">
          <keep-alive>
            <transition :name="`slide-fade`" :mode="`out-in`">
              <component :is="Component"/>
            </transition>
          </keep-alive>
        </router-view>
      </div>
    </template>
  </admin-container>
</template>

<script setup lang="ts">
import NavMenu from "./modules/NavMenu.vue";
import AdminHeader from "./modules/AdminHeader.vue";
import {useStore} from "@/store";
import AdminContainer from "@/components/container/AdminContainer.vue";

const store = useStore();
</script>

<!--私有样式-->
<style scoped>
.aside {
  border-radius: 4px;
  margin: 1em;
  box-shadow: var(--el-box-shadow);
}

.main {
  box-shadow: var(--el-box-shadow-lighter);
  padding: 1em;
}

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
  transition: all .5s cubic-bezier(1.0, 0.5, 0.8, 1.0);
}

.slide-fade-enter, .slide-fade-leave-to {
  transform: translateX(10px);
  opacity: 0;
}
</style>