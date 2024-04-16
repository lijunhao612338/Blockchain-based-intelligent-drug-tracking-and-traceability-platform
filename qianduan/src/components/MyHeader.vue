<template>
    <div class="header">
        <span class="title">基于区块链的药品智能追踪与溯源平台</span>
        <div class="tx" style="float: right;">
          <img src="../img/logo.png" alt="头像" >
          <span>{{name}}</span>
        </div>
    </div>
</template>

<script>
import  axios  from  "axios"
 export default {
  data() {
    return {
      name:"",
      id:""
    };
  },
  methods:{
    loadName(){
    console.log("11")
      this.id=this.$userMsg.userId
      axios(
          {
            url:'/api/information/page/'+this.$userMsg.userId,
            method: "get",
          }
         ).then((response) => {
          console.log(response)
          this.name=response.data.data.businessName
        })
        .catch(function (error) {
          console.log(error);
        });
    }
  },
  created() {
  this.loadName();
  },
}
</script>

<style>

.title{
  width: 193px;
height: 34px;
border-radius: 0px;
font-size: 24px;
font-family: Microsoft YaHei, Microsoft YaHei-Bold;
font-weight:bolder;
text-align: LEFT;
margin-left: 20px;
line-height: 80px;
color: #333333;
}
.tx img{
  margin-top: 30px;
  margin-right: 130px;
  height: 30px;
  width: 30px;
}
.tx span{
  position: absolute;
  left: 1800px;
  top: 35px;
}
</style>