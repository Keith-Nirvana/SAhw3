<template>
  <div>
    <user-navigation/>
    <book-list :bookList="bookList" :isEdit="isEdit" />

  </div>

</template>

<script>
  const userNavigation = () => import('../components/UserNavigation')
  const bookList = () => import('../components/BookList.vue')
  export default {
    name: "user-book-overview",
    components:{bookList, userNavigation},
    data() {
      return {
        isEdit: false,
        bookList: [{bookName: '寒假作业', bookId: 'Nj20394', isBorrowed: true, category: '文学'},
          {bookName: '暑假作业', bookId: 'N990394', isBorrowed: false, category: '文学'},
          {bookName: '课时作业', bookId: 'Nj20394', isBorrowed: false, category: '文学'}],
      }
    },
  }
</script>

<style scoped>

</style>
