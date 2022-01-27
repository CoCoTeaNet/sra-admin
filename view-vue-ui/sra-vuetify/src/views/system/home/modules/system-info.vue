<template>
  <v-card class="mx-auto" tile>
    <v-list dense>
      <v-subheader>系统信息</v-subheader>
      <v-list-item-group color="primary">
        <v-list-item
            v-for="(item, i) in items"
            :key="i"
        >
          <v-list-item-icon>
            <v-icon v-text="item.icon"></v-icon>
          </v-list-item-icon>
          <v-list-item-content>
            <v-list-item-title v-text="item.text"></v-list-item-title>
          </v-list-item-content>
        </v-list-item>
      </v-list-item-group>
    </v-list>
  </v-card>
</template>

<script>
/**
 * 展示系统信息
 */
export default {
  name: 'SystemInfo',
  data: () => ({
    items: [
      {text: 'Real-Time', icon: 'mdi-clock'},
      {text: 'Audience', icon: 'mdi-account'},
      {text: 'Conversions', icon: 'mdi-flag'},
    ],
  }),
}
</script>
