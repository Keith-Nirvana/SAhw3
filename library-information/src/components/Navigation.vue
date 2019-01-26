<template>
  <el-menu default-active="1" class="el-menu-demo" mode="horizontal" background-color="#545c64"
           text-color="#fff" active-text-color="#ffd04b" router>
    <img style="width: 45px; height: 45px; float: left; margin-top: 10px; margin-left: 10px; margin-right: 10px" src="../assets/logo.png">
    <el-menu-item index="/book">首页</el-menu-item>
    <el-menu-item index="/user">用户管理</el-menu-item>
    <el-menu-item index="/book">图书管理</el-menu-item>
  </el-menu>
</template>

<script>
  export default {
    name: "navigation",
  }
</script>

<style scoped>

</style>
