<template>
  <div>
    <user-navigation/>
    <user-list :userList="userList"/>
  </div>
</template>

<script>
  const userList = () => import('../components/UserList.vue')
  const userNavigation = () => import('../components/UserNavigation')

  export default {
    name: "user-info",
    components:{userList, userNavigation},
    data() {
      return {
        userList: [{userName: 'kiki', userId: '161250031', type: 'UNDERGRADUATE', email: '161250031@smail.nju.edu.cn', department: '软件学院'},],
      }
    },
  }
</script>

<style scoped>

</style>
