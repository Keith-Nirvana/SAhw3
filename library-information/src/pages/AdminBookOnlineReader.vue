<template>
  <div>
    <navigation/>
    <el-row>
      <el-col :span="2">
        <el-button type="primary" plain icon="el-icon-arrow-left" style="margin-top: 20px; margin-left: 20px" @click="returnTo">返回</el-button>
      </el-col>
      <el-col :span="20">
        <div style="text-align: center; margin-top: 20px; font-size: 30px; font-weight: bold">{{this.$route.params.bookName}}</div>
      </el-col>
    </el-row>
    <div v-loading="loading" v-html="html" style="margin-left: 5%; width: 90%"></div>
  </div>
</template>

<script>
  import ElRow from "element-ui/packages/row/src/row"

  const navigation = () => import('../components/Navigation')

  export default {
    components: {
      ElRow,
      navigation},
    name: "book-online-reader",
    data(){
      return{
        html: ``,
        loading: true
      }
    },
    methods: {
      returnTo: function(){
        this.$router.push('/admin/book')
      }
    },
    mounted(){
      this.loading = true,
        this.$axios({
          method: 'post',
          url: '/book/readBook',
          data: {
            bookId: this.$route.params.bookId,
            bookName: this.$route.params.bookName
          }
        }).then(response => {
          let _data = response.data
          this.html = _data.html
          this.loading = false
        }).catch(function (err) {
          console.log(err)
          this.loading = false
        })
    }
  }
</script>

<style scoped>

</style>
