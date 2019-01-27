<template>
  <div>
    <navigation/>
    <book-list :bookList="bookList" :isEdit="isEdit" />
  </div>

</template>

<script>
  import global from '../../static/Global'

  const navigation = () => import('../components/Navigation')
  const bookList = () => import('../components/BookList.vue')
  export default {
    name: "admin-book-overview",
    components:{bookList, navigation},
    data() {
      return {
        isEdit: true,
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
