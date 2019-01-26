<script type="text/javascript">
  let isUserManagement = false
  let isUserAdded = false
  let isBookEdit = false
  let isAdmin = false

  function changeAdmin(is){
    this.isAdmin = is
  }

  function changePermission(permission){
    isUserManagement = permission.search("2") != -1
    isUserAdded = permission.search("3") != -1
    isBookEdit  = permission.search("4") != -1
  }

  export default{
    isUserManagement, isUserAdded, isBookEdit, isAdmin, changeAdmin, changePermission
  }
</script>
