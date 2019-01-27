<template>
  <div>
    <navigation/>
    <el-col :span="16" :offset="4">
      <el-card shadow="never" style="margin-top: 10px" v-for="message in messageList">
        <el-row style="text-align: left; font-size: 18px; margin-top: 5px">
          <el-col :span="12">编号：{{message.messageId}}</el-col>
          <el-col :span="12" style="text-align: right">
            <el-button type="primary" icon="el-icon-document" size="mini" @click="readMessage(message.messageId)">已读</el-button>
          </el-col>
        </el-row>
        <el-row style="text-align: left; color: #3e86ff; font-weight: bold; font-size: 25px">{{message.content}}</el-row>
      </el-card>
    </el-col>
  </div>
</template>

<script>
  import global from '../../static/Global'

  const navigation = () => import('../components/Navigation')
  export default {
    name: "admin-message",
    components:{navigation},
    data(){
      return {
        messageList: []
      }
    },
    methods: {
      readMessage: function(messageId){
        // TODO
        this.$axios({
          method: 'post',
          url: '/message/read',
          data: {
            userId: global.userId,
            messageId: messageId,
          }
        }).then(response => {
          console.log(response)
          let _data = response.data
          console.log(_data)

          this.getAllMessage()
          alert("成功阅读！")
        }).catch(function (err) {
          console.log(err)
        })
      },
      getAllMessage: function(){
        // TODO
        this.$axios({
          method: 'post',
          url: '/message/all',
          data: {
            userId: global.userId
          }
        }).then(response => {
          console.log(response)
          let _data = response.data
          console.log(_data)

          this.messageList = _data.messageList
        }).catch(function (err) {
          console.log(err)
        })
      }
    },
    mounted(){
      this.getAllMessage()
    }
  }
</script>

<style scoped>

</style>
