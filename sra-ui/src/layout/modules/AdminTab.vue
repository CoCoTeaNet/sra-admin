<template>
  <el-scrollbar>
    <div class="scrollbar-flex-content">
      <p v-for="item in tabItems" :key="item" :class="`scrollbar-tab-item ${item.isActive?'active':''}`"
         @click="onClick(item)">
        {{ item.name }}
        <el-icon class="tab-icon" @click="onClose(item.id)">
          <close/>
        </el-icon>
      </p>
    </div>
  </el-scrollbar>
</template>

<script lang="ts" setup>
import {Close} from "@element-plus/icons-vue";
import {onMounted, ref, watch} from "vue";
import {router} from "@/router";
import {useRoute} from "vue-router";

const route = useRoute();

interface TabItem {
  id?: string,
  name?: string,
  isActive?: boolean,
  url?: string
}

const items: TabItem[] = [
  {name: '首页', id: '1', isActive: true, url: '/admin/home'},
  {name: '用户管理', id: '2', isActive: false, url: '/admin/user-manager'},
  {name: '文章管理', id: '3', isActive: false, url: '/admin/article-list'},
  {name: '菜单管理', id: '4', isActive: false, url: '/admin/menu-manager'},
  {name: '日志管理', id: '5', isActive: false, url: '/admin/operation-log-manager'},
  {name: '角色管理', id: '6', isActive: false, url: '/admin/role-manager'}
];

const tabItems = ref<TabItem[]>([]);

onMounted(() => {
  tabItems.value = items;
});

watch(() => route.path, (v: any) => {
  console.log(route.matched)
});

const onClick = (obj: any) => {
  router.push({path: obj.url});
  tabItems.value.forEach((item: TabItem) => {
    item.isActive = item.id == obj.id;
  });
}

const onActive = () => {

}

const onClose = (id: string) => {
  let arr: TabItem[] = [];
  tabItems.value.forEach((item: TabItem) => {
    if (item.id != id) arr.push(item);
  });
  tabItems.value = arr;
}

const onCloseAll = () => {

}

const onAdd = () => {

}
</script>

<style scoped>
.scrollbar-flex-content {
  display: flex;
}

.tab-icon {
  margin-left: 1px;
  padding: 1px;
}

.tab-icon:hover {
  border-radius: 16px;
  color: var(--el-color-primary);
  background-color: var(--el-color-white);
}

.scrollbar-tab-item {
  font-size: 12px;
  flex-shrink: 0;
  display: flex;
  align-items: center;
  justify-content: center;
  height: 21px;
  margin: 3px;
  padding: 0 3px;
  text-align: center;
  border-radius: 1px;
  background: var(--el-color-white);
  border: 1px solid var(--el-border-color-dark);
  color: var(--el-text-color-regular);
}

.scrollbar-tab-item:hover {
  cursor: pointer;
  background-color: var(--el-color-primary);
  color: var(--el-color-white);
}

.active {
  background-color: var(--el-color-primary);
  color: var(--el-color-white);
}
</style>