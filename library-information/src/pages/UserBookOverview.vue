<template>
  <div>
    <user-navigation/>
    <book-list :bookList="bookList" :isEdit="isEdit" />

  </div>

</template>

<script>
  import global from '../../static/Global'

  const userNavigation = () => import('../components/UserNavigation')
  const bookList = () => import('../components/BookList.vue')
  export default {
    name: "user-book-overview",
    components:{bookList, userNavigation},
    data() {
      return {
        isEdit: false,
        bookList: [],
      }
    },
    mounted(){
      this.$axios({
        method: 'post',
        url: '/book/allBooks',
        data:{
          userId: global.userId,
        }
      }).then(response=>{
        let _data=response.data;

        this.bookList = _data.bookList
      }).catch(function(err){
        console.log(err)
      })
    }
  }
</script>

<style scoped>

</style>
