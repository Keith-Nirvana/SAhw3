<template>
  <user-list :userList="userList"/>

</template>

<script>
  const userList = () => import('../components/UserList.vue')
  export default {
    name: "user-overview",
    components:{userList},
    data() {
      return {
        userList: [{userName: 'kiki', userId: '161250031', type: 'UNDERGRADUATE', email: '161250031@smail.nju.edu.cn', department: '软件学院'},
          {userName: 'keith', userId: '161250033', type: 'UNDERGRADUATE', email: '161250031@smail.nju.edu.cn', department: '软件学院'},
          {userName: 'max', userId: '161250035', type: 'UNDERGRADUATE', email: '161250031@smail.nju.edu.cn', department: '软件学院'}],
      }
    },
  }
</script>

<style scoped>

</style>
