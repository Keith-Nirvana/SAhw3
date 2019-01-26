<template>
  <el-menu default-active="1" mode="horizontal" background-color="#545c64"
           text-color="#fff" active-text-color="#ffd04b" router>
    <img style="width: 45px; height: 45px; float: left; margin-top: 10px; margin-left: 10px; margin-right: 10px"
         src="../assets/logo.png">
    <el-menu-item index="/admin/user" :disabled="!isUserManagement">用户管理</el-menu-item>
    <el-menu-item index="/admin/book" :disabled="!isBookEdit">图书管理</el-menu-item>
    <el-menu-item index="/admin/statistic" :disabled="!isAdmin">图书统计</el-menu-item>
  </el-menu>
</template>

<script>
  import global from '../../static/Global'
  export default {
    name: "navigation",
    components: {global},
    data() {
      return {
        isUserManagement: global.isUserManagement,
        isBookEdit: global.isBookEdit,
        isAdmin: global.isAdmin
      }
    },
    mounted() {
      console.log(global.isBookEdit)
    },
  }
</script>

<style scoped>

</style>
