<template>
  <v-list>
    <v-list-item link>
      <v-list-item-content>
        <v-list-item-title class="text-h6">
          {{$store.state.user.userInfo.userDetail.username}}
        </v-list-item-title>
        <v-list-item-subtitle>{{$store.state.user.userInfo.userDetail.nickname}}</v-list-item-subtitle>
      </v-list-item-content>
    </v-list-item>
  </v-list>
</template>

<script>
export default {
  data: () => ({
    fav: true,
    message: false,
    hints: true,
  }),
  methods: {}
}
</script>