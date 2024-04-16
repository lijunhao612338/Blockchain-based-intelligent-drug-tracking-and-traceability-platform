<template>
  <!-- 经销商界面 -->
  <div class="mdl">
    <div class="M-search">
          <div class="search">
        <ul>
            <li>
                <span>企业名称:</span>

                <input type="text" placeholder=" 请输入" v-model="form1.businessName">
            </li>
            <li>
                <span>企业类型:</span>

                <input type="text" placeholder=" 请输入" v-model="form1.businessType">
            </li>
            <li>
                <span>工商注册号:</span>

                <input type="text" placeholder=" 请输入" v-model="form1.businessRegistrationNumber">
            </li>
            <li>
                <span>统一社会信用代码</span>

                <input type="text" placeholder=" 请输入" v-model="form1.unifiedSocialCreditCode">
            </li>
            <li>
                <span>登记状态</span>

                <input type="text" placeholder=" 请输入" v-model="form1.registrationStatus">
            </li>
            <li>
                <span>登记机关</span>

                <input type="text" placeholder=" 请输入" v-model="form1.registrationAuthorities">
            </li>
            <li>
                <span>所属地区</span>

                <input type="text" placeholder=" 请输入" v-model="form1.region">
            </li>
            <li>
                <span>注册地址</span>

                <input type="text" placeholder=" 请输入" v-model="form1.registeredAddress">
            </li>
            <li>
                <span>公司核准日期</span>

                <input type="text" placeholder=" 请输入" v-model="form1.companyApprovalDate">
            </li>
            <li>
                <span>注册资本</span>

                <input type="text" placeholder=" 请输入" v-model="form1.registeredCapital">
            </li>
            <li>
                <span>法定代表人</span>

                <input type="text" placeholder=" 请输入" v-model="form1.legalRepresentative">
            </li>
            <li>
                <span>联系电话</span>

                <input type="text" placeholder=" 请输入" v-model="form1.contactNumber">
            </li>
            <li>
                <span>创建人</span>

                <input type="text" placeholder=" 请输入" v-model="form1.createUser">
            </li>
            <li>
                <span>创建时间</span>

                <input type="text" placeholder=" 请输入" v-model="form1.createTime">
            </li>
            <li>
                <span>修改人</span>

                <input type="text" placeholder=" 请输入" v-model="form1.updateUser">
            </li>
            <li>
                <span>修改时间</span>

                <input type="text" placeholder=" 请输入" v-model="form1.updateTime">
            </li>
        </ul>
        <div class="btn">
        <button class="pa" @click="CLEAR">清空</button>
        <button class="pb" @click="search()">查阅</button>
    </div>
    </div>
    </div>
    <div class="tab">
      <div class="control">
        <div class="add">
          <button @click="goTo()">新增</button>
          <button @click='opendata3()' style='width:100px;' v-show="zhanshi">上传入库信息</button>
        </div>
        <div class="cz">
          <button >导出</button>
          <button v-print="'#printArea'">打印</button>
          <button @click="copy()">分享</button>
        </div>
      </div>
      <el-table :data="tableData" :height="780 + 'px'" style="width: 100%" id="printArea">
        <el-table-column fixed="left" label="企业名称" width="180" prop="businessName">
        </el-table-column>
        <el-table-column label="入库信息" width="180">
          <template slot-scope="scope">
            <el-popover trigger="focus" placement="top">
              <div slot="reference" class="name-wrapper">
                <el-tag size="medium">
                  <el-button type="text" @click="open(scope.row)">
                    <i class="el-icon-edit"></i>
                  </el-button>
                </el-tag>
              </div>
            </el-popover>
          </template>
        </el-table-column>
        <el-table-column label="企业类型" width="180" prop="businessType">
        </el-table-column>
        <el-table-column label="工商注册号" width="180" prop="businessRegistrationNumber">
        </el-table-column>
        <el-table-column label="统一社会信用代码" width="180" prop="unifiedSocialCreditCode">
        </el-table-column>
        <el-table-column label="登记状态" width="180" prop="registrationStatus">
        </el-table-column>
        <el-table-column label="登记机关" width="180" prop="registrationAuthorities">
        </el-table-column>
        <el-table-column label="所属地区" width="180" prop="region">
        </el-table-column>
        <el-table-column label="注册地址" width="180" prop="registeredAddress">
        </el-table-column>
        <el-table-column label="公司核准日期" width="180" prop="companyApprovalDate">
        </el-table-column>
        <el-table-column label="注册资本" width="180" prop="registeredCapital">
        </el-table-column>
        <el-table-column label="法定代表人" width="180" prop="legalRepresentative">
        </el-table-column>
        <el-table-column label="联系电话" width="180" prop="contactNumber">
        </el-table-column>
        <el-table-column label="创建人" width="180" prop="createUser">
        </el-table-column>
        <el-table-column label="创建时间" width="180" prop="createTime">
        </el-table-column>
        <el-table-column label="修改人" width="180" prop="updateUser">
        </el-table-column>
        <el-table-column label="修改时间" width="180" prop="updateTime">
        </el-table-column>
        <el-table-column label="操作" fixed="right" width="180px">
          <template slot-scope="scope">
            <el-button size="mini" @click="goToEdit(scope.row)" class="bianji">编辑</el-button>
            <el-button size="mini" type="danger" @click="delDealer(scope.row)" class="bianji">删除</el-button>
          </template>
        </el-table-column>

      </el-table>
      <div class="fenye">
        <el-pagination :background="true" layout="prev, pager, next" :total="1000" style="">
        </el-pagination>
      </div>
      
      <el-dialog title="入库信息详情" :visible.sync="dialogTableVisible">
        <el-table :data="gridData" :height="500 + 'px'" style="width: 100%">
          <el-table-column property="drugInformation" label="产品信息" width="280"></el-table-column>
          <el-table-column property="inboundTime" label="入库时间" width="280"></el-table-column>
          <el-table-column property="shippingWarehouse" label="发货仓库" width="280"></el-table-column>
          <el-table-column prop="genericName" label="产品通用名" show-overflow-tooltip width="280px"></el-table-column>
          <el-table-column prop="dosageForm" label="品种" show-overflow-tooltip width="180px"></el-table-column>
            <el-table-column prop="manufacturer" label="生产厂商" show-overflow-tooltip width="180px"></el-table-column>
            <el-table-column prop="approvalNumber" label="所在产地" show-overflow-tooltip width="180px"></el-table-column>
            <el-table-column prop="unit" label="单位" show-overflow-tooltip width="180px"></el-table-column>
            <el-table-column prop="quantity" label="数量" show-overflow-tooltip width="180px"></el-table-column>
            <el-table-column prop="unitPrice" label="单价" show-overflow-tooltip width="180px"></el-table-column>
            <el-table-column prop="amount" label="金额" show-overflow-tooltip width="180px"></el-table-column>
            <el-table-column prop="lotNumber" label="批号" show-overflow-tooltip width="180px" ></el-table-column>
            <el-table-column prop="expirationDate" label="有效期" show-overflow-tooltip width="180px"></el-table-column>
            <el-table-column prop="remark" label="备注" show-overflow-tooltip width="180px"></el-table-column>
          <el-table-column property="xiangqing" label="详情" width="100">
           <template >
              <el-tag size="medium">
                    <el-button type="text">
                    <a href="https://a120ajv1fg3cizy3.vapp.cloudhost.link" target="_blank"> <i class="el-icon-edit"></i></a> 

                    </el-button>
              </el-tag>
            </template>
          </el-table-column>
        </el-table>
      </el-dialog>

       <el-dialog title="上传入库信息" :visible.sync="form.dialogTableVisible">
        <el-table :data="[gridData]" :height="500 + 'px'" style="width: 100%">
           <el-table-column property="qkl.drugInformation" label="产品信息" width="280"></el-table-column>
          <el-table-column property="inboundTime" label="入库时间" width="280"></el-table-column>
          <el-table-column property="shippingWarehouse" label="发货仓库" width="280"></el-table-column>
          <el-table-column prop="genericName" label="产品通用名" show-overflow-tooltip width="280px"></el-table-column>
          <el-table-column prop="dosageForm" label="品种" show-overflow-tooltip width="180px"></el-table-column>
            <el-table-column prop="manufacturer" label="生产厂商" show-overflow-tooltip width="180px"></el-table-column>
            <el-table-column prop="approvalNumber" label="所在产地" show-overflow-tooltip width="180px"></el-table-column>
            <el-table-column prop="unit" label="单位" show-overflow-tooltip width="180px"></el-table-column>
            <el-table-column prop="quantity" label="数量" show-overflow-tooltip width="180px"></el-table-column>
            <el-table-column prop="unitPrice" label="单价" show-overflow-tooltip width="180px"></el-table-column>
            <el-table-column prop="amount" label="金额" show-overflow-tooltip width="180px"></el-table-column>
            <el-table-column prop="lotNumber" label="批号" show-overflow-tooltip width="180px" ></el-table-column>
            <el-table-column prop="expirationDate" label="有效期" show-overflow-tooltip width="180px"></el-table-column>
            <el-table-column prop="remark" label="备注" show-overflow-tooltip width="180px"></el-table-column>
        </el-table>
      </el-dialog>
<el-dialog title="上传入库信息" :visible.sync="form3.dialogTableVisible" >
  <div class="el-dialog">
  <el-table
        :data="tableData3"
        border
        style="width: 100%" 
        :height="480+'px'">
        <el-table-column prop="name" label="药品名称"  width="180px">
                <template>
                    <input type="text" style="border: 1px white solid; height: 30px;" v-model='qkl.drugName'>
                </template>
            </el-table-column>
            <el-table-column prop="name" label="入库时间" show-overflow-tooltip width="180px">
                <template>
                    <input type="text" style="border: 1px white solid; height: 30px;" v-model='qkl.inboundTime'>
                </template>
            </el-table-column>
            <el-table-column prop="name" label="发货仓库" show-overflow-tooltip width="180px" >
                <template>
                    <input type="text" style="border: 1px white solid; height: 30px;" v-model='qkl.shippingWarehouse'>
                </template>
            </el-table-column>
            <el-table-column prop="name" label="药品通用名" show-overflow-tooltip width="180px">
                <template>
                    <input type="text" style="border: 1px white solid; height: 30px;" v-model='qkl.genericName'>
                </template>
            </el-table-column>
            <el-table-column prop="name" label="规格" show-overflow-tooltip width="180px">
                <template>
                    <input type="text" style="border: 1px white solid; height: 30px;" v-model='qkl.specification'>
                </template>
            </el-table-column>
            <el-table-column prop="name" label="剂型" show-overflow-tooltip width="180px">
                <template>
                    <input type="text" style="border: 1px white solid; height: 30px;" v-model='qkl.dosageForm'>
                </template>
            </el-table-column>
            <el-table-column prop="name" label="生产厂商" show-overflow-tooltip width="180px"> 
                <template>
                    <input type="text" style="border: 1px white solid; height: 30px;" v-model='qkl.manufacturer'>
                </template>
            </el-table-column>
            <el-table-column prop="name" label="批准文号" show-overflow-tooltip width="180px">
                <template>
                    <input type="text" style="border: 1px white solid; height: 30px;" v-model='qkl.approvalNumber'>
                </template>
            </el-table-column>
            <el-table-column prop="name" label="单位" show-overflow-tooltip width="180px"> 
                <template>
                    <input type="text" style="border: 1px white solid; height: 30px;" v-model='qkl.unit'>
                </template>
            </el-table-column>
            <el-table-column prop="name" label="数量" show-overflow-tooltip width="180px">
                <template>
                    <input type="text" style="border: 1px white solid; height: 30px;" v-model='qkl.quantity'>
                </template>
            </el-table-column>
            <el-table-column prop="name" label="单价" show-overflow-tooltip width="180px">
                <template>
                    <input type="text" style="border: 1px white solid; height: 30px;" v-model='qkl.unitPrice'>
                </template>
            </el-table-column>
            <el-table-column prop="name" label="金额" show-overflow-tooltip width="180px">
                <template>
                    <input type="text" style="border: 1px white solid; height: 30px;" v-model='qkl.amount'>
                </template>
            </el-table-column>
            <el-table-column prop="name" label="批号" show-overflow-tooltip width="180px" >
                <template>
                    <input type="text" style="border: 1px white solid; height: 30px;" v-model='qkl.lotNumber'>
                </template>
            </el-table-column>
            <el-table-column prop="name" label="有效期" show-overflow-tooltip width="180px">
                <template>
                    <input type="text" style="border: 1px white solid; height: 30px;" v-model='qkl.expirationDate'>
                </template>
            </el-table-column>
            <el-table-column prop="name" label="备注" show-overflow-tooltip width="180px">
                <template>
                    <input type="text" style="border: 1px white solid; height: 30px;" v-model='qkl.remark'>
                </template>
            </el-table-column>
        </el-table>
        <button  style="float: right; background-color: #fdfdfd; height: 30px; width: 60px; border-radius: 6px; margin-top: 5px;margin-right: 5px; border: 1px #d1d1d1 solid;" @click='qkltj()'>提交</button>
      </div>
      </el-dialog>
    </div>
  </div>
</template>

<script>
import axios from 'axios';
export default {
  data() {
    return {
      tableData: [],
      gridData:[],
      qkl:{
      id:'',
       drugName: "",
       inboundTime: "",
       shippingWarehouse: "",
       genericName: "",
       specification: "",
       dosageForm: "",
       manufacturer: "",
       approvalNumber: "",
       unit: "",
       quantity: "",
       unitPrice: "",
       amount: "",
       lotNumber: "",
       expirationDate: "",
       remark: ""
      },
      tableData3:[
      {
      name:'',
      }],
      form1:{
                businessName: null,
                registrationStatus: null,
                businessType: null,
                businessRegistrationNumber: null,
                registrationAuthorities: null,
                region: null,
                unifiedSocialCreditCode: null,
                registeredAddress: null,
                companyApprovalDate: null,
                contactNumber: null,
                registeredCapital: null,
                createUser: null,
                legalRepresentative: null,
                createTime: null,
                updateUser: null,
                updateTime: null
      },
      dialogTableVisible: false,
      dialogFormVisible: false,
      form: {
        dialogTableVisible: false,
        dialogFormVisible: false,
      },
      form3:{
      dialogTableVisible: false,
        dialogFormVisible: false,
        },
        zhanshi:false,
      total: 0, //总记录数
      //参数
      queryInfo: {
        query: '',
        // 当前页数
        pagenum: 1,
        // 显示一页多少条数据
        pagesize: 1
      }
    }
  },
  components: {

  },
  mounted() {
    this.shenfen();
    this.loadData();
  },
  methods: {
    shenfen(){
      
      console.log(this.$userMsg.userType)
      if(this.$userMsg.userType=='5'){
      this.zhanshi=true
      }
    },
    copy () {
	// 这里注释的方式是把url里的路径去掉了，也可以自己修改路径以及添加参数
	// let invitelink = location.href.replace(this.$route.path,'') + "/register?invitecode=" 
	let invitelink = location.href;
	this.$copyText(invitelink).then(
		res => {
			console.log(res.text) // 这里可以换成提示信息，比如：已成功复制到剪切板
      this.$message({
          message: '链接已成功复制到粘贴板',
          type: 'success'
        });
		},
		err => {
			console.log(err) 
		}
	)
},
  qkltj(){
  this.qkl.id=Math.random()*100
  console.log(this.qkl.id)
    axios({
        url: "/api/qukuailian/zengjia",
        method: "get",
        data:{
        'id':this.qkl.id,
         'drugName':this.qkl.drugName,
       'inboundTime':this.qkl.inboundTime,
       'shippingWarehouse': this.qkl.shippingWarehouse,
       'genericName': this.qkl.genericName,
       'specification': this.qkl.specification,
       'dosageForm': this.qkl.dosageForm,
       'manufacturer': this.qkl.manufacturer,
       'approvalNumber': this.qkl.approvalNumber,
       'unit': this.qkl.unit,
       'quantity': this.qkl.quantity,
       'unitPrice': this.qkl.unitPrice,
       'amount': this.qkl.amount,
       'lotNumber': this.qkl.lotNumber,
       'expirationDate': this.qkl.expirationDate,
       'remark': this.qkl.remark,
        }
      }).then((response) => {
        console.log(response)
        this.tableData = response.data.data;
      })
  },
  opendata3(){
  this.form3.dialogFormVisible=true;
      this.form3.dialogTableVisible=true;
  },
    loadData() {
      axios({
        url: "/api/vendorManagement/page",
        method: "get"
      }).then((response) => {
        console.log(response)
        this.tableData = response.data.data;
      })
      this.$message({
            message: '加载成功',
            type: 'success'
          });
    },
    goTo() {
      this.$router.push('/addDealer')
    },
    goToEdit(row) {
      console.log(row)
      this.$router.push({
        path: '/editDealer/index',
        query: {
          id: row.id
        }
      })
    },
    delDealer(row) {
      console.log(row);
      axios({
        url: "/api/vendorManagement/delete/" + row.id,
        method: "delete",
      }).then((response) => {
        console.log(response.data.data)
        this.loadData();
      })

    },
    open(row) {
      axios({
        url: "/api/DealerInformation/select2/"+ row.id,
        method: "get",
      }).then((response) => {
        this.gridData=response.data.data;  
        console.log(this.gridData)      
      })
      this.dialogFormVisible = true;
      this.dialogTableVisible = true;
    },
    opendata() {
      console.log('1');
      this.form.dialogFormVisible=true;
      this.form.dialogTableVisible=true;
    },
    handleSizeChange(newsize) {
      //这里conso 选中第几页 最新的值
      console.log(newsize)
      //最新的条数（newsize）赋值给 动态的 pagesie
      this.queryInfo.pagesize = newsize
      //获取到最新一页显示的数据  重新发送axios请求 这里是封装好的请求方法
      this.userlistinfo()
    },
     search(){
            axios({
        url:"/api/vendorManagement/selectby",
        method:"get",
        params: {
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
      console.log(this.form1)
                  console.log(response)
                  this.tableData=response.data.data;
                  
              })
        },
        CLEAR(){
        this.form1.businessName=null
        this.form1.registrationStatus=null
        this.form1.businessType=null
        this.form1.businessRegistrationNumber=null
        this.form1.registrationAuthorities=null
        this.form1.region=null
        this.form1.unifiedSocialCreditCode=null
        this.form1.registeredAddress=null
        this.form1.companyApprovalDate=null
        this.form1.contactNumber=null
        this.form1.registeredCapital=null
        this.form1.createUser=null
        this.form1.legalRepresentative=null
        this.form1.createTime=null
        this.form1.updateUser=null
        this.form1.updateTime=null
        this.search()
        },
    handleCurrentChange(newPage) {
      console.log(newPage)
      //把最新的页码（newPage）赋值给 动态的 pagenum 
      this.queryInfo.pagenum = newPage
      //获取到最新显示的页码值  重新发送axios请求 这里是封装好的请求方法
      this.userlistinfo()
    }
  }
}
</script>

<style scoped>

::v-deep .el-pager li.active{
  color: #eeeeee !important;
  background-color: rgb(132, 13, 132) !important;
}
.mdl {
  height: 880px;
  width: 1680px;
  background-color: #f0f1f6;
  position: relative;
}

.M-search {
  width: 210px;
  height: 880px;
  padding: 0%;
  position: absolute;
  left: 0px;
}

.tab {
  position: absolute;
  left: 220px;
  top: 10px;
  width: 1450px;
}

.control {
  height: 40px;
  background-color: white;
  margin-bottom: 10px;
  width: 1450px;

}

.control button {
  background-color: rgb(255, 255, 255);
  color: rgb(23, 21, 21);
  height: 30px;
  width: 60px;
  margin-top: 5px;
  margin-right: 5px;
  border-radius: 6px;
}


.add {
  float: left;
}

.cz {
  float: right;
  margin-right: 10px;
}

.fenye {
  padding-left: 1020px;
  margin-top: 5px;
  background-color: #fff;
}

.add button {
  margin-left: 5px;
  background-color: rgb(132, 13, 132);
  color: #fff;
  border: rgb(132, 13, 132) 1px solid;
}

.cz button {
  color: #5c5050;
  border: #5c5050 1px solid;
}
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
.el-dialog{
  height: 530px;
  width: 900px;
  border: 0px;
}
</style>