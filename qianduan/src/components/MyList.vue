<template>
  <div class="nav-ul">
    <el-menu default-active="2" class="el-menu-vertical-demo" :router="true">
      <el-menu-item index="/home">
        <i class="el-icon-location"></i>
        <span slot="title">信息速览</span>
      </el-menu-item>
      <el-menu-item index="/msg">
        <i class="el-icon-menu"></i>
        <span slot="title">我的信息</span>
      </el-menu-item>
      <el-menu-item index="/dealer">
        <i class="el-icon-menu"></i>
        <span slot="title">经销商管理</span>
      </el-menu-item>
      <el-menu-item index="/sup">
        <i class="el-icon-document"></i>
        <span slot="title">供应商管理</span>
      </el-menu-item>
      <el-menu-item index="/manu">
        <i class="el-icon-setting"></i>
        <span slot="title">生产商管理</span>
      </el-menu-item>
      <el-menu-item index="/find">
        <i class="el-icon-s-home"></i>
        <span slot="title">溯源查询</span>
      </el-menu-item>
    </el-menu>
    <div class="tuichu">
      <button class="btn" @click="tuichu()"><i class="el-icon-setting"></i>安全退出</button>
    </div>
  </div>
</template>

<script>
 export default {
  data() {
  return {

  }
  },
  created() {
  },
  methods: {
      tuichu(){
        this.$message({
          message: '退出成功',
          type: 'success'
        });
        this.$router.push({path:'/'})
        
      }
  },
  }
</script>
<style scoped>
.el-menu {
  width: 240px;
height: 880px;
  border-radius: 0px;
  font-size: 14px;
  font-family: Microsoft YaHei, Microsoft YaHei-Normal;
  font-weight: normal;
  text-align: LEFT;
  opacity: 0.8;
  background: #ffffff;
  line-height: 34px;
}
.el-menu-item.is-active {
        background-color: rgb(132, 13, 132) !important;
        color: #ffffff;
        font-size: 16px;
    }
.nav-ul{
  border-top: 1px solid #f0f1f6;
}
.tuichu{
  position: relative;
}
.btn{
  position: absolute;
  height: 50px;
 bottom: 20px;
 left: 15px;
 background-color: #ffffff;
 border: 1px #ffffff solid;
}
</style>