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
        bookList: [{bookName: '寒假作业', bookId: 'Nj20394', isBorrowed: true, category: 2},
          {bookName: '暑假作业', bookId: 'N990394', isBorrowed: false, category: 1},
          {bookName: '课时作业', bookId: 'Nj20394', isBorrowed: false, category: 3}],
      }
    },
    mounted(){
      // TODO 获得所有图书
      this.$axios({
        method: 'post',
        url: '/book/allBooks',
        data:{
          userId: global.userId,
        }
      }).then(response=>{
        console.log(response)
        let _data=response.data;
        console.log(_data)

        this.bookList = _data.bookList
      }).catch(function(err){
        console.log(err)
      })
    }
  }
</script>

<style scoped>

</style>
