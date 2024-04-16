<template>
    <div class="addDeal">
      <div class="t1">
            <span>编辑经销商</span>
        </div>
      <div class="msg">
            <br>
            <span class="form-left-name">企业名称:</span>
            <input type="text" v-model="form.businessName" class="inputborder">
            <span class="form-right-name">登记状态:</span>
            <span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;在营</span><input type="radio" value="在营" v-model="form.registrationStatus">
            <span>&nbsp;&nbsp;&nbsp;开业</span><input type="radio" value="开业" v-model="form.registrationStatus">
            <span>&nbsp;&nbsp;&nbsp;注册</span><input type="radio" value="注册" v-model="form.registrationStatus">
            <br>
            <span class="form-left-name">企业类型:</span>
            <input type="text" v-model="form.businessType" class="inputborder">
            <span class="form-right-name">工商注册号: &nbsp;&nbsp;</span>
            <input type="text" v-model="form.businessRegistrationNumber" class="inputborder">
            <span class="form-right-right-name">登记机关 : &nbsp;&nbsp;</span>
            <input type="text" v-model="form.registrationAuthorities" class="inputborder">
            <br>
            <span class="form-left-name">所属地区:</span>
            <input type="text" v-model="form.region" class="inputborder">
            <span class="form-right-name">社会信用代码:</span>
            <input type="text" class="inputborder" v-model="form.unifiedSocialCreditCode">
            <span class="form-right-right-name">法定代表人:</span>
            <input type="text" v-model="form.legalRepresentative" class="inputborder">
            <br>
            <span class="form-left-name">注册地址:</span>
            <input type="text" v-model="form.registeredAddress" class="inputborder">
            <span class="form-right-name">公司核准日期:</span>
            <input type="date" class="inputborder" v-model="form.companyApprovalDate">
            <span class="form-right-right-name">联系电话: &nbsp;&nbsp;</span>
            <input type="text" v-model="form.contactNumber" class="inputborder">
            <br>
            <span class="form-left-name">注册资本:</span>
            <input type="text" v-model="form.registeredCapital" class="inputborder">
            <br>
            <span class="form-left-bt-name">创建人:&nbsp;&nbsp;&nbsp;</span>
            <input type="text" v-model="form.createUser" class="bt-inputborder">
            <span class="form-right-bt-name">修改人:&nbsp;&nbsp;&nbsp;</span>
            <input type="text" v-model="form.updateUser" class="bt-inputborder">
            <br>
            <span class="form-left-name">创建时间:</span>
            <input type="text" v-model="form.createTime" class="inputborder">
            <span class="form-right-name">修改时间:</span>
            <input type="text" v-model="form.updateTime" class="inputborder">
        </div>
  <div class="ctl">
    <button class="bt1" @click="Edit()">保存</button>
    <button class="bt2" @click="ret()">取消</button>
  </div>
</div>
  </template>
  
  <script>
  import  axios  from  "axios"
  export default {
  data() {
  return {
   form: {
    id:'',
     businessName: '',
     registrationStatus:'',
     businessType: '',
     businessRegistrationNumber:'',
     registrationAuthorities:'',
     region:'',
     unifiedSocialCreditCode:'',
     registeredAddress:'',
     companyApprovalDate:'',
     contactNumber:'',
     registeredCapital:'',
     createUser:'',
     legalRepresentative:"",
     createTime:'',
     updateUser:'',
     updateTime:''
   }
  }
  },
  created() {
  this.loadData();

  },
  methods: {
  loadData(){
     axios({
        url:"/api/vendorManagement/select/"+this.$route.query.id,
        method:"get",
        data: {
                'id':this.$route.query.id
                }
      }).then((response) => {
            console.log(response)
            this.form.id=response.data.data.id
            this.form.businessName=response.data.data.businessName
            this.form.registrationStatus=response.data.data.registrationStatus
            this.form.businessType=response.data.data.businessType
            this.form.businessRegistrationNumber=response.data.data.businessRegistrationNumber
            this.form.registrationAuthorities=response.data.data.registrationAuthorities
            this.form.region=response.data.data.region
            this.form.unifiedSocialCreditCode=response.data.data.unifiedSocialCreditCode
            this.form.registeredAddress=response.data.data.registeredAddress
            this.form.companyApprovalDate=response.data.data.companyApprovalDate
            this.form.contactNumber=response.data.data.contactNumber
            this.form.registeredCapital=response.data.data.registeredCapital
            this.form.createUser=response.data.data.createUser
            this.form.legalRepresentative=response.data.data.legalRepresentative
            this.form.createTime=response.data.data.createTime
            this.form.updateUser=response.data.data.updateUser
            this.form.updateTime=response.data.data.updateTime
        })
  },
     Edit(){
     console.log(this.form.registrationStatus);
      axios({
        url:"/api/vendorManagement/editSSave1",
        method:"post",
        data: {
                    'id':this.form.id,
                    'businessName': this.form.businessName,
                    'registrationStatus': this.form.registrationStatus,
                    'businessType': this.form.businessType,
                    'businessRegistrationNumber': this.form.businessRegistrationNumber,
                    'registrationAuthorities': this.form.registrationAuthorities,
                    'region':this.region,
                    'unifiedSocialCreditCode': this.form.unifiedSocialCreditCode,
                    'registeredAddress': this.form.registeredAddress,
                    'companyApprovalDate': this.form.companyApprovalDate,
                    'contactNumber': this.form.contactNumber,
                    'registeredCapital': this.form.registeredCapital,
                    'createUser': this.form.createUser,
                    'legalRepresentative': this.form.legalRepresentative,
                    'createTime': this.form.createTime,
                    'updateUser': this.form.updateUser,
                    'updateTime': this.form.updateTime
                }
      }).then((response) => {
                  console.log(response)
                  // this.tableData=response.data.data;
              })
              this.$message({
            message: '修改成功',
            type: 'success'
          });
              this.$router.push('/dealer')
     },
     ret(){
      this.$router.push('/dealer')
    },
  },
  }
  </script>
  
  <style scoped>
  .t1{
    width: 1680px;
    height: 60px;
    background-color: #fff;
    line-height: 60px;
    opacity: 0.8;
    font-weight: bolder;
    font-size: 20px;
    padding-left: 15px;
    position: relative;
    left: 1px;
    top: 1px;
}
  .addDeal{
    width: 1680px;
    height: 880px;
  }
  .msg{
    height: 740px;
    width: 1640px;
  }
  .form-left-name {
      margin-top: 20px;
      margin-left: 22px;
  }
  
  .form-right-name {
      margin-top: 20px;
      margin-left: 159px;
  }
  .form-right-right-name{
      margin-top: 20px;
      margin-left: 134px;
  }
  .inputborder {
      margin-top: 20px;
      width: 300px;
      height: 32px;
      background: #ffffff;
      border: 1px solid #f0f1f3;
      border-radius: 6px;
      font-size: 14px;
      font-family: Microsoft YaHei, Microsoft YaHei-Normal;
      font-weight: normal;
      text-align: LEFT;
      color: #333333;
      line-height: 20px;
  }
  .msg span{
    color: #71747B;
    margin-right: 10px;
  }
  .form-left-bt-name{
      margin-top: 100px;
      margin-left: 22px;
  }
  .bt-inputborder{
      margin-top: 100px;
      width: 300px;
      height: 32px;
      background: #ffffff;
      border: 1px solid #f0f1f3;
      border-radius: 6px;
      font-size: 14px;
      font-family: Microsoft YaHei, Microsoft YaHei-Normal;
      font-weight: normal;
      text-align: LEFT;
      color: #333333;
      line-height: 20px;
  }
  .form-right-bt-name{
      margin-top: 100px;
      margin-left: 175px;
  }
  .ctl{
  position: absolute;
  top: 820px;
  width: 1680px;
  bottom: 10px;
  height: 50px;
  background-color: #ffffff;
}
.bt1{
  height: 40px;
  width: 80px;
  margin-top: 5px;
  margin-left: 20px;
  border-radius: 6px;
  background-color:rgb(132, 13, 132);
  color: #fff;
  border: rgb(132, 13, 132) 1px solid;
}
.bt2{
    height: 40px;
  width: 80px;
  margin-top: 5px;
  margin-left: 10px;
  border-radius: 6px;
  background-color: #fff;
  border: 1px solid #e1e1e1;

}
  </style>