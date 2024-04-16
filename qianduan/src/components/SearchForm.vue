<template>
    <div class="search">
        <ul>
            <li>
                <span>企业名称:</span>

                <input type="text" placeholder=" 请输入" v-model="businessName">
            </li>
            <li>
                <span>企业类型:</span>

                <input type="text" placeholder=" 请输入" v-model="businessType">
            </li>
            <li>
                <span>工商注册号:</span>

                <input type="text" placeholder=" 请输入" v-model="businessRegistrationNumber">
            </li>
            <li>
                <span>统一社会信用代码</span>

                <input type="text" placeholder=" 请输入" v-model="unifiedSocialCreditCode">
            </li>
            <li>
                <span>登记状态</span>

                <input type="text" placeholder=" 请输入" v-model="registrationStatus">
            </li>
            <li>
                <span>登记机关</span>

                <input type="text" placeholder=" 请输入" v-model="registrationAuthorities">
            </li>
            <li>
                <span>所属地区</span>

                <input type="text" placeholder=" 请输入" v-model="region">
            </li>
            <li>
                <span>注册地址</span>

                <input type="text" placeholder=" 请输入" v-model="registeredAddress">
            </li>
            <li>
                <span>公司核准日期</span>

                <input type="text" placeholder=" 请输入" v-model="companyApprovalDate">
            </li>
            <li>
                <span>注册资本</span>

                <input type="text" placeholder=" 请输入" v-model="registeredCapital">
            </li>
            <li>
                <span>法定代表人</span>

                <input type="text" placeholder=" 请输入" v-model="legalRepresentative">
            </li>
            <li>
                <span>联系电话</span>

                <input type="text" placeholder=" 请输入" v-model="contactNumber">
            </li>
            <li>
                <span>创建人</span>

                <input type="text" placeholder=" 请输入" v-model="createUser">
            </li>
            <li>
                <span>创建时间</span>

                <input type="text" placeholder=" 请输入" v-model="createTime">
            </li>
            <li>
                <span>修改人</span>

                <input type="text" placeholder=" 请输入" v-model="updateUser">
            </li>
            <li>
                <span>修改时间</span>

                <input type="text" placeholder=" 请输入" v-model="updateTime">
            </li>
        </ul>
        <div class="btn">
        <button class="pa">清空</button>
        <button class="pb" @click="search()">查阅</button>
    </div>
    </div>
</template>

<script>
import axios from 'axios'
export default {
    data() {
        return {
                 businessName: '',
                registrationStatus: '',
                businessType: '',
                businessRegistrationNumber: '',
                registrationAuthorities: '',
                region: '',
                unifiedSocialCreditCode: '',
                registeredAddress: '',
                companyApprovalDate: '',
                contactNumber: '',
                registeredCapital: '',
                createUser: '',
                legalRepresentative: "",
                createTime: '',
                updateUser: '',
                updateTime: ''
        }
    },
    methods: {
        search(){
        console.log('1')
        axios({
        url:"/api/vendorManagement/selectby",
        method:"post",
        data: {
                   'businessName': this.form1.businessName,
                    'registrationStatus': this.form1.registrationStatus,
                    'businessType': this.form1.businessType,
                    'businessRegistrationNumber': this.form1.businessRegistrationNumber,
                    'registrationAuthorities': this.form1.registrationAuthorities,
                    'region':this.form1.region,
                    'unifiedSocialCreditCode': this.form1.unifiedSocialCreditCode,
                    'registeredAddress': this.form1.registeredAddress,
                    'companyApprovalDate': this.form1.companyApprovalDate,
                    'contactNumber': this.form1.contactNumber,
                    'registeredCapital': this.form1.registeredCapital,
                    'createUser': this.form1.createUser,
                    'legalRepresentative': this.form1.legalRepresentative,
                    'createTime': this.form1.createTime,
                    'updateUser': this.form1.updateUser,
                    'updateTime': this.form1.updateTime
                }
      }).then((response) => {
                  console.log(response)
                  this.tableData=response.data.data;
              })
        }
    },
}
</script>
<style scoped>
.search {
    background-color: white;
    margin-left: 10px;
    margin-top: 10px;
    border-radius: 6px;
    height: 870px;
    overflow-y: scroll;
}
::-webkit-scrollbar{
    color: blueviolet;
}
li input :placeholder {
    width: 155px;
    height: 20px;
    background: #ffffff;
    border-radius: 0px;
    font-size: 14px;
    font-family: Microsoft YaHei, Microsoft YaHei-Normal;
    font-weight: normal;
    text-align: LEFT;
    color: #a7a7a7;
    line-height: 20px;

}
input::placeholder {
  color: #a7a7a7;
}

li input {
    width: 168px;
    height: 26px;
    background: #ffffff;
    border: 1px solid #797979;
    border-radius: 6px;
}

li span {
    display: block;
    width: 145px;
    height: 34px;
    line-height: 34px;
    font-size: 14px;
    font-family: Microsoft YaHei, Microsoft YaHei-Normal;
    font-weight: normal;
    text-align: LEFT;
    color: #71747b;

}

ul li {
    margin-left: 6px;
    list-style-type: none;
    height: 60px;
}

ul {
    width: 210px;
    margin: 0%;
    padding: 0%;

}

.pa {
    margin-left: 15px;
    margin-top: 15px;
    margin-right: 5px;
    border-radius: 6px;
    width: 67px;
height: 26px;
background: #ffffff;
border: 1px solid #5c5050;
border-radius: 6px;
font-size: 12px;
font-family: Microsoft YaHei, Microsoft YaHei-Normal;
font-weight: normal;
text-align: CENTER;
color: #71747b;
line-height: 20px;

}

.pb {
    margin-left: 10px;
    border-radius: 6px;
    width: 67px;
height: 26px;
background: #ffffff;
border: 1px solid #5c5050;
border-radius: 6px;
font-size: 12px;
font-family: Microsoft YaHei, Microsoft YaHei-Normal;
font-weight: normal;
text-align: CENTER;
color: #71747b;
line-height: 20px;
  
}
.btn{
    background-color: #fff;
    position: sticky;
    bottom: 0%;
}
</style>