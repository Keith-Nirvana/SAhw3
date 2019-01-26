<template>
  <div>
    <navigation/>
    <el-tabs v-model="activeName" style="margin-right: 10px; margin-left: 10px">
      <el-tab-pane label="图书借阅记录" name="first">
        <el-table :data="gridData">
          <el-table-column property="userName" label="借书编号"/>
          <el-table-column property="userId" label="图书编号"/>
          <el-table-column property="type" label="用户编号"/>
          <el-table-column property="userId" label="借书日期"/>
          <el-table-column property="userId" label="还书日期"/>
        </el-table>
      </el-tab-pane>
      <el-tab-pane label="超期归还记录" name="second">
        <el-table :data="gridData">
          <el-table-column property="userName" label="借书编号"/>
          <el-table-column property="userId" label="图书编号"/>
          <el-table-column property="type" label="用户编号"/>
          <el-table-column property="userId" label="还书日期"/>
          <el-table-column property="userId" label="违约金"/>
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
        gridData: [{
          userName: 'kiki',
          userId: '161250031',
          type: 'UNDERGRADUATE',
          email: '161250031@smail.nju.edu.cn',
          department: '软件学院'
        },
          {
            userName: 'keith',
            userId: '161250033',
            type: 'UNDERGRADUATE',
            email: '161250031@smail.nju.edu.cn',
            department: '软件学院'
          },
          {
            userName: 'max',
            userId: '161250035',
            type: 'UNDERGRADUATE',
            email: '161250031@smail.nju.edu.cn',
            department: '软件学院'
          }],
      }
    },
  }
</script>

<style scoped>

</style>
