<template>
  <div>
    <user-navigation/>
    <el-col :span="16" :offset="4">
      <el-card shadow="never" style="margin-top: 10px" v-for="book in bookList">
        <el-row style="text-align: left; color: #3e86ff; font-weight: bold; font-size: 25px">{{book.bookName}}</el-row>
        <el-row style="text-align: left; font-size: 18px; margin-top: 5px">{{getCategory(book.category)}}</el-row>
        <el-row style="text-align: left; font-size: 18px; margin-top: 5px">
          <el-col :span="12">索书号：{{book.bookId}}</el-col>
          <el-col :span="12" style="text-align: right">
            <el-button type="success" icon="el-icon-zoom-in" size="mini" @click="read(book.bookId, book.bookName)">
              在线阅读
            </el-button>
            <el-button type="primary" icon="el-icon-document" size="mini" @click="returnBook(book.bookId)">还书
            </el-button>
          </el-col>
        </el-row>
      </el-card>
    </el-col>
  </div>
</template>

<script>
  import global from '../../static/Global'

  const userNavigation = () => import('../components/UserNavigation')

  export default {
    name: "borrow-record",
    components: {userNavigation},
    data() {
      return {
        bookList: []
      }
    },
    methods: {
      returnBook: function (bookId) {
        this.$axios({
          method: 'post',
          url: '/book/returnBook',
          data: {
            userId: global.userId,
            bookId: bookId
          }
        }).then(response => {
          let _data = response.data

          this.$notify({
            title: '成功',
            message: '还书成功',
            type: 'success'
          });

          this.getMyBorrowedBooks()
        }).catch(function (err) {
          console.log(err)
        })
      },
      read: function (bookId, bookName) {
        this.$router.push({name: 'UserOnlineReaderPage', params: {bookName: bookName, bookId: bookId}})
      },
      getCategory: function (category) {
        if (category === 1)
          return "一级"
        if (category === 2)
          return "二级"
        if (category === 3)
          return "三级"
      },
      getMyBorrowedBooks: function(){
        this.$axios({
          method: 'post',
          url: '/book/borrowedBooks',
          data: {
            userId: global.userId
          }
        }).then(response => {
          let _data = response.data

          this.bookList = _data.bookList
        }).catch(function (err) {
          console.log(err)
        })
      }
    },
    mounted() {
      this.getMyBorrowedBooks()
    }
  }
</script>

<style scoped>

</style>
