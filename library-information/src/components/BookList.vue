<template>
  <div>
    <el-col :span="16" :offset="4">
      <el-card shadow="never" style="margin-top: 10px" v-for="book in bookList">
        <el-row style="text-align: left; color: #3e86ff; font-weight: bold; font-size: 25px">{{book.bookName}}</el-row>
        <el-row style="text-align: left; font-size: 18px; margin-top: 5px">{{getCategory(book.category)}}</el-row>
        <el-row style="text-align: left; font-size: 18px; margin-top: 5px">
          <el-col :span="12">索书号：{{book.bookId}}</el-col>
          <el-col :span="12" style="text-align: right">
            <el-button type="success" icon="el-icon-zoom-in" size="mini" @click="read(book.bookId, book.bookName)">在线阅读</el-button>
            <el-button type="primary" :icon="icon" size="mini" :disabled=book.isBorrowed&&isEdit @click="modifyOrBorrow(book)">{{text}}</el-button>
          </el-col>
        </el-row>
      </el-card>
    </el-col>

    <el-dialog title="修改图书信息" :visible.sync="dialogFormVisible">
      <el-form :model="form" label-position="left">
        <el-form-item label="名称" label-width="90px">
          <el-input v-model="form.bookName" autocomplete="off"/>
        </el-form-item>
        <el-form-item label="级别" label-width="90px">
          <el-select v-model="form.category" placeholder="请选择图书级别" style="width: 100%">
            <el-option label="一级" value="一级"/>
            <el-option label="二级" value="二级"/>
            <el-option label="三级" value="三级"/>
          </el-select>
        </el-form-item>
        <!--<el-form-item label="是否借出" label-width="90px">-->
          <!--<el-radio-group v-model="form.isBorrowed">-->
            <!--<el-radio label="是" value="true"/>-->
            <!--<el-radio label="否" value="false"/>-->
          <!--</el-radio-group>-->
        <!--</el-form-item>-->
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button @click="cancelModify">取 消</el-button>
        <el-button type="primary" @click="confirmModify">确 定</el-button>
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
        icon: "el-icon-document",
        text: "借阅",
        dialogFormVisible: false,
        form: {},
        tempForm: {}
      }
    },
    props: {
      bookList: Array,
      isEdit: Boolean
    },
    mounted() {
      this.icon = this.isEdit ? "el-icon-edit" : "el-icon-document"
      this.text = this.isEdit ? "编辑" : "借阅"
    },
    methods: {
      getCategory: function(category){
        if(category === 1)
          return "一级"
        if(category === 2)
          return "二级"
        if(category === 3)
          return "三级"
      },
      confirmModify: function(){
        this.dialogFormVisible = false

        if(this.form.category === '一级')
          this.form.category = 1
        if(this.form.category === '二级')
          this.form.category = 2
        if(this.form.category === '三级')
          this.form.category = 2

        console.log(this.form)

        this.$axios({
          method: 'post',
          url: '/book/modifyBook',
          data: {
            bookId: this.form.bookId,
            bookName: this.form.bookName,
            category: this.form.category
          }
        }).then(response => {
          console.log(response)
          let _data = response.data
          console.log(_data)

          this.$notify({
            title: '成功',
            message: '修改信息成功',
            type: 'success'
          });
        }).catch(function (err) {
          console.log(err)
        })
        // TODO 修改信息
      },
      modifyOrBorrow: function(book){
        if(!this.isEdit){
          this.borrow(book.bookId)
        }
        else{
          this.dialogFormVisible = true
          this.form = book
          this.tempForm = book
        }
      },
      cancelModify: function(){
        this.dialogFormVisible = false
        this.form = this.tempForm
      },
      borrow: function(bookId){
        console.log(bookId)
        // TODO 借书
        this.$axios({
          method: 'post',
          data:{
            userId: global.userId,
            bookId: bookId
          },
          url: '/book/borrow',
        }).then(response => {
          console.log(response)
          let _data = response.data
          console.log(_data)

          this.$notify({
            title: '成功',
            message: '借书成功',
            type: 'success'
          });
        }).catch(function (err) {
          console.log(err)
        })

      },
      read: function(bookId, bookName){
        if(this.isEdit)
          this.$router.push({name: 'AdminOnlineReaderPage', params: { bookName: bookName, bookId: bookId}})
        else
          this.$router.push({name: 'UserOnlineReaderPage', params: { bookName: bookName, bookId: bookId}})
      }
    }

  }
</script>

<style scoped>

</style>
