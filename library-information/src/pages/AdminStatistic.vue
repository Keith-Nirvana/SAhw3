<template>
  <div>
    <navigation/>
    <el-tabs v-model="activeName" style="margin-right: 10px; margin-left: 10px">
      <el-tab-pane label="图书借阅记录" name="first">
        <el-table :data="borrowRecord">
          <el-table-column property="recordId" label="借书编号"/>
          <el-table-column property="bookId" label="图书编号"/>
          <el-table-column property="userId" label="用户编号"/>
          <el-table-column property="borrowDate" label="借书日期"/>
          <el-table-column property="returnDate" label="还书日期"/>
        </el-table>
      </el-tab-pane>
      <el-tab-pane label="超期归还记录" name="second">
        <el-table :data="paymentRecord">
          <el-table-column property="recordId" label="借书编号"/>
          <el-table-column property="bookId" label="图书编号"/>
          <el-table-column property="userId" label="用户编号"/>
          <el-table-column property="returnDate" label="还书日期"/>
          <el-table-column property="payment" label="违约金"/>
        </el-table>
      </el-tab-pane>
    </el-tabs>

  </div>
</template>

<script>
  const navigation = () => import('../components/Navigation')
  export default {
    name: "admin-statistic",
    components: {navigation},
    data() {
      return {
        activeName: 'first',
        borrowRecord: [],
        paymentRecord: [],
      }
    },
    methods: {
      getBorrowRecords: function(){
        this.$axios({
          method: 'get',
          url: '/statistic/borrow',
        }).then(response => {
          console.log(response)
          let _data = response.data
          console.log(_data)

          this.borrowRecord = _data.borrowRecord
        }).catch(function (err) {
          console.log(err)
        })
      },
      getPaymentRecords: function(){
        this.$axios({
          method: 'get',
          url: '/statistic/payment',
        }).then(response => {
          console.log(response)
          let _data = response.data
          console.log(_data)

          this.paymentRecord = _data.paymentRecord
        }).catch(function (err) {
          console.log(err)
        })
      }
    },
    mounted(){
      this.getBorrowRecords()
      this.getPaymentRecords()
    }
  }
</script>

<style scoped>

</style>
