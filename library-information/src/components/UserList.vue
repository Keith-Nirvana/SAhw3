<template>
  <div>
    <el-col :span="16" :offset="4">
      <el-card shadow="never" style="margin-top: 10px" v-for="user in userList">
        <el-row style="text-align: left; color: #3e86ff; font-weight: bold; font-size: 25px">{{user.userName}}</el-row>
        <el-row style="text-align: left; font-size: 18px; margin-top: 5px">{{user.userId}}</el-row>
        <el-row style="text-align: left; font-size: 18px; margin-top: 5px">{{user.type}}</el-row>
        <el-row style="text-align: left; font-size: 18px; margin-top: 5px">{{user.department}}</el-row>
        <el-row style="text-align: left; font-size: 18px; margin-top: 5px">
          <el-col :span="12">{{user.email}}</el-col>
          <el-col :span="12" style="text-align: right">
            <el-button type="primary" icon="el-icon-edit" size="mini" @click="modifyUserInfo(user)">编辑</el-button>
          </el-col>
        </el-row>
      </el-card>
    </el-col>

    <el-dialog title="修改用户信息" :visible.sync="dialogFormVisible">
      <el-form :model="form" label-position="left">
        <el-form-item label="用户名" label-width="90px">
          <el-input v-model="form.userName" autocomplete="off"/>
        </el-form-item>
        <el-form-item label="用户账号" label-width="90px">
          <el-input v-model="form.userId" autocomplete="off"/>
        </el-form-item>
        <el-form-item label="邮箱" label-width="90px">
          <el-input v-model="form.email" autocomplete="off"/>
        </el-form-item>
        <el-form-item label="身份" label-width="90px">
          <el-select v-model="form.type" placeholder="请选择身份" style="width: 100%">
            <el-option label="教师" value="TEACHER"/>
            <el-option label="在校生" value="UNDERGRADUATE"/>
            <el-option label="毕业生" value="GRADUATE"/>
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
        <el-button @click="dialogFormVisible = false">取 消</el-button>
        <el-button type="primary" @click="confirmModify">确 定</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>

  export default {
    name: "book-list",
    data() {
      return {
        dialogFormVisible: false,
        form: {}
      }
    },
    props: {
      userList: Array
    },
    mounted() {

    },
    methods: {
      modifyUserInfo: function(user){
        console.log(user)
        this.form = user
        this.dialogFormVisible = true
        // this.$router.push('/home')
      },
      confirmModify: function(){
        this.dialogFormVisible = false
        console.log(this.form)
        // TODO 修改信息
      }
    }

  }
</script>

<style scoped>

</style>
