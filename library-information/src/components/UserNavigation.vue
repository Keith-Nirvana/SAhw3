<template>
  <el-menu default-active="1" mode="horizontal" background-color="#545c64"
           text-color="#fff" active-text-color="#ffd04b" router>
    <img style="width: 45px; height: 45px; float: left; margin-top: 10px; margin-left: 10px; margin-right: 10px" src="../assets/logo.png">
    <el-menu-item index="/user/book">首页</el-menu-item>
    <el-menu-item index="/user/record">借书记录</el-menu-item>
    <el-menu-item index="/user/info">个人中心</el-menu-item>
  </el-menu>
</template>

<script>
  export default {
    name: "user-navigation",
  }
</script>

<style scoped>

</style>
