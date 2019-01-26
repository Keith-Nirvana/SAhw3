<template>
  <div>
    <navigation/>
    <el-button type="primary" style="width: 66%; margin-top: 10px" @click="dialogFormVisible=true" :disabled="!isUserAdded">增加用户</el-button>
    <user-list :userList="userList"/>

    <el-dialog title="增加用户" :visible.sync="dialogFormVisible">
      <el-form :model="form" label-position="left">
        <el-form-item label="用户账号" label-width="90px">
          <el-input v-model="form.userId" autocomplete="off"/>
        </el-form-item>
        <el-form-item label="用户名" label-width="90px">
          <el-input v-model="form.userName" autocomplete="off"/>
        </el-form-item>
        <el-form-item label="邮箱" label-width="90px">
          <el-input v-model="form.email" autocomplete="off"/>
        </el-form-item>
        <el-form-item label="身份" label-width="90px">
          <el-select v-model="form.type" placeholder="请选择身份" style="width: 100%">
            <el-option label="教师" value="TEACHER"/>
            <el-option label="在校生" value="UNDERGRADUATE"/>
            <el-option label="毕业生" value="GRADUATE"/>
            <el-option label="学工处" value="OFFICE"/>
          </el-select>
        </el-form-item>
        <el-form-item label="学院/部门" label-width="90px">
          <el-select v-model="form.department" placeholder="请选择学院/部门" style="width: 100%">
            <el-option label="软件学院" value="软件学院"/>
            <el-option label="文学院" value="文学院"/>
            <el-option label="电子学院" value="电子学院"/>
            <el-option label="商学院" value="商学院"/>
          </el-select>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button @click="cancelAdd">取 消</el-button>
        <el-button type="primary" @click="addUser">确 定</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
  import global from '../../static/Global'

  const userList = () => import('../components/UserList.vue')
  const navigation = () => import('../components/Navigation')

  export default {
    name: "user-overview",
    components: {userList, navigation, global},
    data() {
      return {
        isUserAdded: global.isUserAdded,
        userList: [{
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
          },
          {
            userName: 'max',
            userId: '161250035',
            type: 'OFFICE',
            email: '161250031@smail.nju.edu.cn',
            department: '软件学院',
            permission: '23'
          }],
        dialogFormVisible: false,
        form: {}
      }
    },
    methods: {
      addUser: function () {
        console.log(this.form)
        // TODO 增加用户
      },
      cancelAdd: function () {
        this.dialogFormVisible = false
        this.form = {}
      }
    },
    mounted: function(){
      console.log('hhh')

      // TODO 获得所有用户
    }
  }
</script>

<style scoped>

</style>
