<template>
  <div>
    <el-col :span="16" :offset="4">
      <el-card shadow="never" style="margin-top: 10px" v-for="book in bookList">
        <el-row style="text-align: left; color: #3e86ff; font-weight: bold; font-size: 25px">{{book.bookName}}</el-row>
        <el-row style="text-align: left; font-size: 18px; margin-top: 5px">{{book.category}}</el-row>
        <el-row style="text-align: left; font-size: 18px; margin-top: 5px">
          <el-col :span="12">索书号：{{book.bookId}}</el-col>
          <el-col :span="12" style="text-align: right">
            <el-button type="success" icon="el-icon-zoom-in" size="mini" @click="read(book.bookId)">在线阅读</el-button>
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
        <el-form-item label="编号" label-width="90px">
          <el-input v-model="form.bookId" autocomplete="off"/>
        </el-form-item>
        <el-form-item label="类型" label-width="90px">
          <el-select v-model="form.category" placeholder="请选择图书类型" style="width: 100%">
            <el-option label="文学" value="文学"/>
            <el-option label="历史" value="历史"/>
            <el-option label="商学" value="商学"/>
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
        icon: "el-icon-document",
        text: "借阅",
        dialogFormVisible: false,
        form: {}
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
      confirmModify: function(){
        this.dialogFormVisible = false
        console.log(this.form)
      },
      modifyOrBorrow: function(book){
        console.log(book)
        if(!this.isEdit){
          this.borrow(book.bookId)
        }
        else{
          this.dialogFormVisible = true
          this.form = book
        }
      },
      borrow: function(bookId){
        console.log(bookId)
      },
      read: function(bookId){
        console.log(bookId)
      }
    }

  }
</script>

<style scoped>

</style>
