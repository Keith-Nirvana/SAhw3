<template>
  <div>
    <user-navigation/>
    <user-list :userList="userList"/>
  </div>
</template>

<script>
  import global from '../../static/Global'

  const userList = () => import('../components/UserList.vue')
  const userNavigation = () => import('../components/UserNavigation')

  export default {
    name: "user-info",
    components:{userList, userNavigation},
    data() {
      return {
        userList: []
      }
    },
    mounted(){
      this.$axios({
        method: 'post',
        url: '/user/id',
        data:{
          userId: global.userId,
        }
      }).then(response=>{
        let _data=response.data;
        console.log(_data)

        this.userList = [{userName: _data.userName, userId: _data.userId, type: _data.type, email: _data.email, department: _data.department}]
      }).catch(function(err){
        console.log(err)
      })
    }
  }
</script>

<style scoped>

</style>
