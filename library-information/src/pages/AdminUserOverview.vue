<template>
  <div>
    <navigation/>
    <user-list :userList="userList"/>
  </div>
</template>

<script>
  const userList = () => import('../components/UserList.vue')
  const navigation = () => import('../components/Navigation')

  export default {
    name: "user-overview",
    components:{userList, navigation},
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
