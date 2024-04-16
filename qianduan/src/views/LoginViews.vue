<template>
  <div class="Login">
    <div class="cover">
      <img src="../img/封面图.png" alt="封面图" class="coverimg">
    </div>
    <div class="Login-R">
      <div class="L-Top">
        <img src="../img/logo.png" alt="logo" class="logo">
      </div>
      <div class="L-bottom">
        <div class="title">基于区块链的药品智能追踪与溯源平台</div>
        <form id="login-form" action="" onsubmit="return false;">
          <select name="user" id="user" class="user">
            <option value="null" selected> 请选择</option>
            <option value="user0">个人</option>
            <option value="user1">经销商管理</option>
            <option value="user2">供应商管理</option>
            <option value="user3">生产商管理</option>
            <option value="user4">管理员</option>
          </select>
          <input type="username" name="username" class="login-from-item1" v-model='username' placeholder=" 请输入账号">
          <br>
          <input type="password" name="userpassword" class="login-from-item2" v-model='password' placeholder=" 请输入密码">
          <br>
          <button id="login-sbn" @click="login()">登录</button>
        </form>
      </div>
    </div>
  </div>
</template>
<script>
import axios from 'axios';
import Vue from 'vue';
export default {
  data() {
    return {
      username: '',
      password: '',
      usertype: ''
    }
  },
  methods: {
    login() {
      axios({
        url: '/api/information/login',
        method: 'post',
        data: {
          'username': this.username,
          'password': this.password,
          'usertype': this.usertype
        }
      }).then((response) => {
        console.log(response);
        if (response.data.code == 1) {
          const userMsg = {
            userId: response.data.data.id,
            userName: response.data.data.userName,
            userType: response.data.data.identificationCode
          }
          Vue.prototype.$userMsg = userMsg
          console.log(this.$userMsg.userType)
          this.$message({
            message: '登录成功',
            type: 'success'
          });
          this.$router.push({ path: '/home' })

        }
        if (response.data.code == 0) {
          alert("登录失败")
        }
      })
    }
  },
}
</script>
<style scoped>
/*清除默认边距*/
* {
  margin: 0;
  padding: 0;
}

/*设置html标签高度为100%，body高度为100%*/
html,
body {
  height: 100%;
}

.Login {
  position: fixed;
  left: 0px;
  top: 0px;
  width: 100%;
  height: 100%;
  background-color: #fff;
}

/* logo样式 start */
.logo {
  height: 70px;
  width: 70px;
  position: absolute;
  top: 200px;
  left: 1470px;
}

.Login-R {
  position: absolute;
  left: 0px;
  top: 0px;
  width: 50%;
  height: 100%;
}

/* logp样式end */
/* 封面图样式 start */
.coverimg {
  position: absolute;
  left: 0px;
  width: 50%;
  height: 100%;
}

/* 封面图 end */
/* 用户选择 start*/
.user {
  position: absolute;
  width: 150px;
  height: 40px;
  background: #ffffff;
  border: 1px solid #d2c2c2;
  border-radius: 6px;
  font-size: 14px;
  font-family: Microsoft YaHei, Microsoft YaHei-Normal;
  font-weight: normal;
  text-align: LEFT;
  line-height: 20px;
  border: 1px solid #b6b7b8;
}

/* 用户选择 end */
/* 登录端口样式 start */
#login-form {
  position: absolute;
  left: 1302.5px;
  top: 441px;
  bottom: 349px;
}

/* 登录端口样式 end */
/* 登录入口样式start */
.login-from-item1 {
  width: 440px;
  height: 60px;
  background: #ffffff;
  border-radius: 6px;
  margin-top: 52px;
  /* border-top: 0cm;
  border-left: 0px;
  border-right: 0px; */
  border: 1px solid #b6b7b8;
}

.login-from-item2 {
  margin-top: 20px;
  width: 440px;
  height: 60px;
  background: #ffffff;
  /* border-top: 0cm;
  border-left: 0px;
  border-right: 0px; */
  border: 1px solid #b6b7b8;
}

/* 登录入口样式 end */
/* 登陆提交按钮样式 start*/
#login-sbn {
  margin: auto;
  position: absolute;
  bottom: 340px;
  top: 269px;
  width: 440px;
  height: 60px;
  background: #6266eb;
  border-radius: 6px;
  font-size: 18px;
  font-family: PingFang SC, PingFang SC-Bold;
  font-weight: normal;
  text-align: CENTER;
  color: #ffffff;
  line-height: 24px;
  border: #6266eb 1px solid;
}

/* 登陆提交按钮样式 end */
/* 平台标题样式  start*/
.title {
  position: absolute;
  top: 290px;
  left: 1300.5px;
  right: 300.5px;
  bottom: 676px;
  width: 420px;
  height: 70px;
  border-radius: 0px;
  font-size: 42px;
  font-family: Microsoft YaHei, Microsoft YaHei-Bold;
  font-weight: normal;
  text-align: CENTER;
  color: #333333;
  line-height: 70px;
  font-weight: bold
}

/* 平台标题样式 end */</style>