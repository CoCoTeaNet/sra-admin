<template>
  <v-breadcrumbs :items="items" class="pl-1">
    <template v-slot:item="{ item }">
      <v-breadcrumbs-item :disabled="item.disabled" href="#" @click="$router.push({path: item.href})">
        {{ item.text.toUpperCase() }}
      </v-breadcrumbs-item>
    </template>
  </v-breadcrumbs>
</template>

<script>
export default {
  data: () => ({
    items: [],
  }),
  watch:{   //监听路由变化
    $route(){
      this.getRouterMatch();
    }
  },
  methods: {
    /**
     * 获取路由导航地址
     */
    getRouterMatch() {
      let list = this.$route.matched;
      let items = []
      list.forEach((item, index) => {
        items.push({text: item.meta.title, disabled: index === list.length - 1, href: item.path});
      });
      this.items = items;
    }
  }
}
</script>