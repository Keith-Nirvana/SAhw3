<template>
  <div>
    <navigation/>
    <book-list :bookList="bookList" :isEdit="isEdit" />

  </div>

</template>

<script>
  const navigation = () => import('../components/Navigation')
  const bookList = () => import('../components/BookList.vue')
  export default {
    name: "office-book-overview",
    components:{bookList, navigation},
    data() {
      return {
        isEdit: false,
        bookList: [{bookName: '寒假作业', bookId: 'Nj20394', isBorrowed: true, category: 2},
          {bookName: '暑假作业', bookId: 'N990394', isBorrowed: false, category: 1},
          {bookName: '课时作业', bookId: 'Nj20394', isBorrowed: false, category: 3}],
      }
    },
  }
</script>

<style scoped>

</style>
