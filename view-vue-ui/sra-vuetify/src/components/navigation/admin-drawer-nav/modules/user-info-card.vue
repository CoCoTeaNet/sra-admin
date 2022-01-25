<template>
  <v-list>
    <v-list-item class="px-2">
      <v-list-item-avatar>
        <v-img src="https://randomuser.me/api/portraits/women/75.jpg"></v-img>
      </v-list-item-avatar>
    </v-list-item>
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