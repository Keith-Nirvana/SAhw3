<template>
  <div>
    <el-col :span="16" :offset="4">
      <el-card shadow="never" style="margin-top: 10px" v-for="user in userList">
        <el-row style="text-align: left; color: #3e86ff; font-weight: bold; font-size: 25px">{{user.userName}}</el-row>
        <el-row style="text-align: left; font-size: 18px; margin-top: 5px">{{user.userId}}</el-row>
        <el-row style="text-align: left; font-size: 18px; margin-top: 5px">
          <el-col :span="12">{{getType(user.type)}}</el-col>
          <el-col :span="12" style="text-align: right" v-show="user.type == 'OFFICE' && isAdmin">
            <el-button type="primary" icon="el-icon-edit" size="mini" plain @click="grant(user.permission, user.userId)">授权</el-button>
          </el-col>
        </el-row>
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
        <el-button @click="cancelModify">取 消</el-button>
        <el-button type="primary" @click="confirmModify">确 定</el-button>
      </div>
    </el-dialog>

    <el-dialog title="授权" :visible.sync="grantFormVisible">
      <el-form :model="grantForm" label-position="left">
        <el-checkbox-group v-model="grantForm.type">
          <el-checkbox label="编辑用户"/>
          <el-checkbox label="创建用户"/>
          <el-checkbox label="编辑图书"/>
        </el-checkbox-group>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button @click="cancelGrant">取 消</el-button>
        <el-button type="primary" @click="confirmGrant">确 定</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
  import global from '../../static/Global'

  export default {
    name: "book-list",
    data() {
      return {
        dialogFormVisible: false,
        grantFormVisible: false,
        form: {},
        tempForm: {},
        grantForm: {
          type:[]
        },
        isAdmin: global.isAdmin,
        tempUser: ''
      }
    },
    props: {
      userList: Array
    },
    mounted() {
    },
    methods: {
      getType: function(type){
        if(type==='TEACHER')
          return '教师'
        if(type==='UNDERGRADUATE')
          return '在校生'
        if(type==='GRADUATE')
          return '毕业生'
        if(type==='OFFICE')
          return '学工处'
      },
      modifyUserInfo: function(user){
        this.form = user
        this.tempForm = user
        this.dialogFormVisible = true
      },
      confirmModify: function(){
        this.dialogFormVisible = false

        this.$axios({
          method: 'post',
          url: '/user/modifyUser',
          data: {
            userId: this.form.userId,
            userName: this.form.userName,
            department: this.form.department,
            email: this.form.email,
            type: this.form.type
          }
        }).then(response => {
          let _data = response.data

          this.dialogFormVisible = false

          this.$notify({
            title: '成功',
            message: '修改成功',
            type: 'success'
          });
        }).catch(function (err) {
          console.log(err)
        })
      },
      cancelModify: function(){
        this.dialogFormVisible = false
        this.form = this.tempForm

        // this.getUserList()
      },
      grant: function(permission, userId){
        this.grantFormVisible = true

        this.tempUser = userId

        this.grantForm.type = []

        if(permission === undefined)
          return

        if(permission.search("2") != -1)
          this.grantForm.type.push("编辑用户")

        if(permission.search("3") != -1)
          this.grantForm.type.push("创建用户")

        if(permission.search("4") != -1)
          this.grantForm.type.push("编辑图书")
      },
      confirmGrant: function(){
        this.grantFormVisible = false

        let permission = ""

        if(this.grantForm.type.includes("编辑用户"))
          permission = "2"

        if(this.grantForm.type.includes("创建用户"))
          permission = permission + "3"

        if(this.grantForm.type.includes("编辑图书"))
          permission = permission + "4"

        this.$axios({
          method: 'post',
          url: '/user/grant',
          data: {
            userId: this.tempUser,
            permission: permission,
          }
        }).then(response => {
          let _data = response.data
          this.dialogFormVisible = false

          this.$notify({
            title: '成功',
            message: '授权成功',
            type: 'success'
          });
        }).catch(function (err) {
          console.log(err)
        })

        this.getUserList()
      },
      cancelGrant: function(){
        this.grantFormVisible = false
      },
      getUserList: function(){
        this.$axios({
          method: 'get',
          url: '/user/allUser',
        }).then(response => {
          let _data = response.data

          let users = _data.userList

          if(this.isAdmin)
            this.userList = _data.userList
          else{
            let my_list = []

            for ( let i = 0; i <users.length; i++){
              if(users[i].type === 'TEACHER' || users[i].type === 'UNDERGRADUATE' || users[i].type === 'GRADUATE')
                my_list.push(users[i])
            }

            this.userList = my_list
          }
        }).catch(function (err) {
          console.log(err)
        })
      }
    }

  }
</script>

<style scoped>

</style>
