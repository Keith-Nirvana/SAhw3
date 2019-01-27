<template>
  <div>
    <user-navigation/>
    <div style="text-align: center; margin-top: 20px; font-size: 30px; font-weight: bold">{{this.$route.params.bookName}}</div>
    <div v-html="html"></div>
  </div>
</template>

<script>
  const userNavigation = () => import('../components/UserNavigation')

  export default {
    components: {userNavigation},
    name: "user-book-online-reader",
    data(){
      return{
        html: ``,
      }
    },
    mounted(){
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
      }).catch(function (err) {
        console.log(err)
      })
    }
  }
</script>

<style scoped>

</style>
