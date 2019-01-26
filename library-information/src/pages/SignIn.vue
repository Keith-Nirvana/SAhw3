<template>
  <div class="sign-in">
    <el-row>
      <img src="../assets/logo.png">
    </el-row>
    <el-row>
      <el-input
        placeholder="账号"
        v-model="id"
        clearable
        class="text-input">
      </el-input>
    </el-row>
    <el-row>
      <el-input
        placeholder="密码"
        v-model="password"
        clearable
        class="text-input">
      </el-input>
    </el-row>
    <el-row style="margin-top: 40px; margin-bottom: 10px">
      <el-button type="primary" style="width: 300px" @click="signIn">登陆</el-button>
    </el-row>
  </div>
</template>

<script>
  export default {
    data() {
      return {
        id: '',
        password: ''
      }
    },
    methods:{
      signIn: function(){
        // TODO,验证登陆
        this.$router.push('/user/book')
      }
    }
  }
</script>

<style scoped>
  .sign-in {
    font-family: 'Avenir', Helvetica, Arial, sans-serif;
    -webkit-font-smoothing: antialiased;
    -moz-osx-font-smoothing: grayscale;
    text-align: center;
    color: #2c3e50;
    margin-top: 100px;
  }

  .text-input {
    width: 300px;
    margin-top: 15px;
  }
</style>
