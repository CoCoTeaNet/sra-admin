<template>
  <v-breadcrumbs :items="items">
    <template v-slot:item="{ item }">
      <v-breadcrumbs-item
          :href="item.href"
          :disabled="item.disabled"
      >
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
        items.push({text: item.name, disabled: index === list.length - 1, href: item.path});
      });
      this.items = items;
    }
  }
}
</script>