    <template>
        <div class="msg">
          <div class="title">
            <span>基本信息</span>
            
          </div>
            <br>
            <span class="form-left-name">企业名称:</span>
            <input type="text" v-model="form.businessName" class="inputborder">
            <span class="form-right-name">登记状态:</span>
            <span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;在营</span><input type="radio" value="1" v-model="form.registrationStatus">
            <span>&nbsp;&nbsp;&nbsp;开业</span><input type="radio" value="2" v-model="form.registrationStatus">
            <span>&nbsp;&nbsp;&nbsp;注册</span><input type="radio" value="3" v-model="form.registrationStatus">
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
            <input type="text" v-model:="form.updateTime" class="inputborder">
        </div>
</template>

<script>
import  axios  from  "axios"
export default {
  data() {
    return {
        form:{
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
     updateTime:'',
        }
      }
  },
  created() {
    this.loadData();
  },
  methods: {
    loadData(){
       axios(
          {
            url:'/api/information/page/'+this.$userMsg.userId,
            method: "get",
          }
         ).then((response) => {
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
        .catch(function (error) {
          console.log(error);
        });
    }
  },
}
</script>

<style>
@import '../assets/MyMesage.css'
</style>