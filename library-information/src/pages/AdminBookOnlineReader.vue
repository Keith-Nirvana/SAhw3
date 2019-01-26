<template>
  <div>
    <navigation/>
    <div style="text-align: center; margin-top: 20px; font-size: 30px; font-weight: bold">{{this.$route.params.bookName}}</div>
    <div v-html="html"></div>
  </div>
</template>

<script>
  const navigation = () => import('../components/Navigation')

  export default {
    components: {navigation},
    name: "book-online-reader",
    data(){
      return{
        html: `<body><div>
    <img src="./../static/bookImages/assignment0.png" style="width:100%;height:auto" />
 </div><div>
    <img src="./../static/bookImages/assignment1.png" style="width:100%;height:auto" />
 </div></body>`,
        bookName: '寒假作业'
      }
    }
  }
</script>

<style scoped>

</style>
