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
  import global from '../../static/Global'

  export default {
    data() {
      return {
        id: '',
        password: ''
      }
    },
    methods:{
      signIn: function(){
        this.$axios({
          method: 'post',
          // url:'../static/test/getInfo.json', //<---本地地址
          url: '/user/login',
          data:{
            userId: this.id,
            password: this.password
          }
        }).then(response=>{
          console.log(response)
          let _data=response.data;
          console.log(_data)

          if(_data.isValid){
            global.setUserId(this.id)
            if(_data.type == 'OFFICE'){
              global.changePermission(_data.permission)
              global.changeAdmin(false)

              this.$router.push('/office/info')
            }
            else if(_data.type == 'ADMINISTRATOR'){
              global.changeAdmin(true)
              this.$router.push('/admin/user')
            }
            else{
              this.$router.push('/user/book')
            }
          }
          else{
            alert("抱歉，账号密码出错！")
          }

        }).catch(function(err){
          console.log(err)
        })
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
