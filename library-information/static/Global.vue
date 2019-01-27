<script type="text/javascript">
  let isUserManagement = false
  let isUserAdded = false
  let isBookEdit = false
  let isAdmin = true
  let userId = ''

  function setUserId(userId){
    this.userId = userId
  }

  function changeAdmin(is) {
    this.isAdmin = is
    if (is) {
      this.isUserManagement = true
      this.isUserAdded = true
      this.isBookEdit = true
    }
  }

  function changePermission(permission) {
    this.isUserManagement = permission.search("2") != -1
    this.isUserAdded = permission.search("3") != -1
    this.isBookEdit = permission.search("4") != -1

    console.log(this.isUserManagement + "2")
    console.log(this.isUserAdded + '3')
    console.log(this.isBookEdit + '4')
  }

  export default {
    isUserManagement, isUserAdded, isBookEdit, isAdmin, changeAdmin, changePermission, userId, setUserId
  }
</script>
