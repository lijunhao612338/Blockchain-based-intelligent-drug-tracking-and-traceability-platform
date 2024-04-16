<template>
  <div class="msp">
    <div class="M-search">
      <div class="search">
        <ul>
          <li>
            <span>企业名称:</span>

            <input type="text" placeholder=" 请输入" v-model="form3.businessName">
          </li>
          <li>
            <span>企业类型:</span>

            <input type="text" placeholder=" 请输入" v-model="form3.businessType">
          </li>
          <li>
            <span>工商注册号:</span>

            <input type="text" placeholder=" 请输入" v-model="form3.businessRegistrationNumber">
          </li>
          <li>
            <span>统一社会信用代码</span>

            <input type="text" placeholder=" 请输入" v-model="form3.unifiedSocialCreditCode">
          </li>
          <li>
            <span>登记状态</span>

            <input type="text" placeholder=" 请输入" v-model="form3.registrationStatus">
          </li>
          <li>
            <span>登记机关</span>

            <input type="text" placeholder=" 请输入" v-model="form3.registrationAuthorities">
          </li>
          <li>
            <span>所属地区</span>

            <input type="text" placeholder=" 请输入" v-model="form3.region">
          </li>
          <li>
            <span>注册地址</span>

            <input type="text" placeholder=" 请输入" v-model="form3.registeredAddress">
          </li>
          <li>
            <span>公司核准日期</span>

            <input type="text" placeholder=" 请输入" v-model="form3.companyApprovalDate">
          </li>
          <li>
            <span>注册资本</span>

            <input type="text" placeholder=" 请输入" v-model="form3.registeredCapital">
          </li>
          <li>
            <span>法定代表人</span>

            <input type="text" placeholder=" 请输入" v-model="form3.legalRepresentative">
          </li>
          <li>
            <span>联系电话</span>

            <input type="text" placeholder=" 请输入" v-model="form3.contactNumber">
          </li>
          <li>
            <span>创建人</span>

            <input type="text" placeholder=" 请输入" v-model="form3.createUser">
          </li>
          <li>
            <span>创建时间</span>

            <input type="text" placeholder=" 请输入" v-model="form3.createTime">
          </li>
          <li>
            <span>修改人</span>

            <input type="text" placeholder=" 请输入" v-model="form3.updateUser">
          </li>
          <li>
            <span>修改时间</span>

            <input type="text" placeholder=" 请输入" v-model="form3.updateTime">
          </li>
        </ul>
        <div class="btn">
          <button class="pa" @click="CLEAR()">清空</button>
          <button class="pb" @click="search()">查阅</button>
        </div>
      </div>
    </div>
    <div class="tab">
      <div class="control">
        <div class="add">
          <button @click="goTo()">新增</button>
          <button @click='opendata1()' style='width:100px;'>上传入库信息</button>
          <button @click='opendata1()' style='width:100px;'>上传出库信息</button>
        </div>
        <div class="cz">
          <button>导出</button>
          <button v-print="'#printArea'">打印</button>
          <button @click="copy()">分享</button>
        </div>
      </div>
      <el-table :data="tableData" :height="780 + 'px'" style="width: 100%"
      id="printArea">
        <el-table-column fixed="left" label="企业名称" width="180">
          <template slot-scope="scope">
            <i class="el-icon-user"></i>
            <span style="margin-left: 10px">{{ scope.row.businessName }}</span>
          </template>
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
        <el-table-column label="出库信息" width="180">
          <template slot-scope="scope">
            <el-popover trigger="focus" placement="top">
              <div slot="reference" class="name-wrapper">
                <el-tag size="medium">
                  <el-button type="text" @click="open1(scope.row)">
                    <i class="el-icon-edit"></i>
                  </el-button>
                </el-tag>
              </div>
            </el-popover>
          </template>
        </el-table-column>
        <el-table-column label="企业类型" width="180">
          <template slot-scope="scope">
            <span style="margin-left: 10px">{{ scope.row.businessType }}</span>
          </template>
        </el-table-column>
        <el-table-column label="工商注册号" width="180">
          <template slot-scope="scope">
            <span style="margin-left: 10px">{{ scope.row.businessRegistrationNumber }}</span>
          </template>
        </el-table-column>
        <el-table-column label="统一社会信用代码" width="180">
          <template slot-scope="scope">
            <span style="margin-left: 10px">{{ scope.row.unifiedSocialCreditCode }}</span>
          </template>
        </el-table-column>
        <el-table-column label="登记状态" width="180">
          <template slot-scope="scope">
            <span style="margin-left: 10px">{{ scope.row.registrationStatus }}</span>
          </template>
        </el-table-column>
        <el-table-column label="登记机关" width="180">
          <template slot-scope="scope">
            <span style="margin-left: 10px">{{ scope.row.registrationAuthorities }}</span>
          </template>
        </el-table-column>
        <el-table-column label="所属地区" width="180">
          <template slot-scope="scope">
            <span style="margin-left: 10px">{{ scope.row.region }}</span>
          </template>
        </el-table-column>
        <el-table-column label="注册地址" width="180">
          <template slot-scope="scope">
            <span style="margin-left: 10px">{{ scope.row.registeredAddress }}</span>
          </template>
        </el-table-column>
        <el-table-column label="公司核准日期" width="180">
          <template slot-scope="scope">
            <span style="margin-left: 10px">{{ scope.row.companyApprovalDate }}</span>
          </template>
        </el-table-column>
        <el-table-column label="注册资本" width="180">
          <template slot-scope="scope">
            <span style="margin-left: 10px">{{ scope.row.registeredCapital }}</span>
          </template>
        </el-table-column>
        <el-table-column label="法定代表人" width="180">
          <template slot-scope="scope">
            <span style="margin-left: 10px">{{ scope.row.legalRepresentative }}</span>
          </template>
        </el-table-column>
        <el-table-column label="联系电话" width="180">
          <template slot-scope="scope">
            <span style="margin-left: 10px">{{ scope.row.contactNumber }}</span>
          </template>
        </el-table-column>
        <el-table-column label="创建人" width="180">
          <template slot-scope="scope">
            <span style="margin-left: 10px">{{ scope.row.createUser }}</span>
          </template>
        </el-table-column>
        <el-table-column label="创建时间" width="180">
          <template slot-scope="scope">
            <span style="margin-left: 10px">{{ scope.row.createTime }}</span>
          </template>
        </el-table-column>
        <el-table-column label="修改人" width="180">
          <template slot-scope="scope">
            <span style="margin-left: 10px">{{ scope.row.updateUser }}</span>
          </template>
        </el-table-column>
        <el-table-column label="修改时间" width="180">
          <template slot-scope="scope">
            <span style="margin-left: 10px">{{ scope.row.updateTime }}</span>
          </template>
        </el-table-column>
        <el-table-column label="操作" fixed="right" width="180px">
          <template slot-scope="scope">
            <el-button size="mini" @click="goToEdit(scope.row)">编辑</el-button>
            <el-button size="mini" type="danger" @click="delSup(scope.row)">删除</el-button>
          </template>
        </el-table-column>

      </el-table>

      <div class="fenye">
        <el-pagination background layout="prev, pager, next" :total="1000">
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

  <el-dialog title="上传出库信息" :visible.sync="form2.dialogTableVisible">
  <div class="el-dialog">
  <el-table
        :data="tableData3"
        border
        style="width: 100%" 
        :height="480+'px'">
        <el-table-column prop="name" label="产品名称"  width="180px">
                <template>
                    <input type="text" style="border: 1px white solid; height: 30px;" v-model='qkl.drugName'>
                </template>
            </el-table-column>
            <el-table-column prop="name" label="出库时间" show-overflow-tooltip width="180px">
                <template>
                    <input type="text" style="border: 1px white solid; height: 30px;" v-model='qkl.inboundTime'>
                </template>
            </el-table-column>
            <el-table-column prop="name" label="发货仓库" show-overflow-tooltip width="180px" >
                <template>
                    <input type="text" style="border: 1px white solid; height: 30px;" v-model='qkl.shippingWarehouse'>
                </template>
            </el-table-column>
            <el-table-column prop="name" label="产品通用名" show-overflow-tooltip width="180px">
                <template>
                    <input type="text" style="border: 1px white solid; height: 30px;" v-model='qkl.genericName'>
                </template>
            </el-table-column>
            <el-table-column prop="name" label="品种" show-overflow-tooltip width="180px">
                <template>
                    <input type="text" style="border: 1px white solid; height: 30px;" v-model='qkl.specification'>
                </template>
            </el-table-column>
            <el-table-column prop="name" label="类型" show-overflow-tooltip width="180px">
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
      <el-dialog title="出库信息详情" :visible.sync="form1.dialogTableVisible">
        <el-table :data="gridData" :height="500 + 'px'" style="width: 100%">
         <el-table-column property="drugInformation" label="产品信息" width="280"></el-table-column>
          <el-table-column property="inboundTime" label="出库时间" width="280"></el-table-column>
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
      <el-dialog title="上传出库信息" :visible.sync="form2.dialogTableVisible">
  <div class="el-dialog">
  <el-table
        :data="tableData3"
        border
        style="width: 100%" 
        :height="480+'px'">
        <el-table-column prop="name" label="产品名称"  width="180px">
                <template>
                    <input type="text" style="border: 1px white solid; height: 30px;" v-model='qkl.drugName'>
                </template>
            </el-table-column>
            <el-table-column prop="name" label="出库时间" show-overflow-tooltip width="180px">
                <template>
                    <input type="text" style="border: 1px white solid; height: 30px;" v-model='qkl.inboundTime'>
                </template>
            </el-table-column>
            <el-table-column prop="name" label="发货仓库" show-overflow-tooltip width="180px" >
                <template>
                    <input type="text" style="border: 1px white solid; height: 30px;" v-model='qkl.shippingWarehouse'>
                </template>
            </el-table-column>
            <el-table-column prop="name" label="产品通用名" show-overflow-tooltip width="180px">
                <template>
                    <input type="text" style="border: 1px white solid; height: 30px;" v-model='qkl.genericName'>
                </template>
            </el-table-column>
            <el-table-column prop="name" label="品种" show-overflow-tooltip width="180px">
                <template>
                    <input type="text" style="border: 1px white solid; height: 30px;" v-model='qkl.specification'>
                </template>
            </el-table-column>
            <el-table-column prop="name" label="类型" show-overflow-tooltip width="180px">
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
      tableData3:[
      {
      name:'',
      }],
      dialogTableVisible: false,
      dialogFormVisible: false,
      
      form: {
        dialogTableVisible: false,
        dialogFormVisible: false,
      },
      form1: {
        dialogTableVisible: false,
        dialogFormVisible: false,
      },
      form2: {
        dialogTableVisible: false,
        dialogFormVisible: false,
      },
      form3: {
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
      form4: {
        dialogTableVisible: false,
        dialogFormVisible: false,
      },
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
    }
  },
  components: {
  },
  mounted() {
   // this.shenfen();
    this.loadData();
  },
  methods: {
    //shenfen(){
     // if(this.$userMsg.userName!==''){
      //  let userstate=document.getElementsByClassName('xinzeng');
       // userstate.style.display='none';
      //}
    //},
    
    search() {
      axios({
        url: "/api/Management/selectby",
        method: "get",
        params: {
          'businessName': this.form3.businessName,
          'registrationStatus': this.form3.registrationStatus,
          'businessType': this.form3.businessType,
          'businessRegistrationNumber': this.form3.businessRegistrationNumber,
          'registrationAuthorities': this.form3.registrationAuthorities,
          'region': this.form3.region,
          'unifiedSocialCreditCode': this.form3.unifiedSocialCreditCode,
          'registeredAddress': this.form3.registeredAddress,
          'companyApprovalDate': this.form3.companyApprovalDate,
          'contactNumber': this.form3.contactNumber,
          'registeredCapital': this.form3.registeredCapital,
          'createUser': this.form3.createUser,
          'legalRepresentative': this.form3.legalRepresentative,
          'createTime': this.form3.createTime,
          'updateUser': this.form3.updateUser,
          'updateTime': this.form3.updateTime
        }
      }).then((response) => {
        console.log(this.form1)
        console.log(response)
        this.tableData = response.data.data;

      })
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
    CLEAR() {
      this.form3.businessName = null
      this.form3.registrationStatus = null
      this.form3.businessType = null
      this.form3.businessRegistrationNumber = null
      this.form3.registrationAuthorities = null
      this.form3.region = null
      this.form3.unifiedSocialCreditCode = null
      this.form3.registeredAddress = null
      this.form3.companyApprovalDate = null
      this.form3.contactNumber = null
      this.form3.registeredCapital = null
      this.form3.createUser = null
      this.form3.legalRepresentative = null
      this.form3.createTime = null
      this.form3.updateUser = null
      this.form3.updateTime = null
      this.search()
    },
    loadData() {
      axios({
        url: "/api/Management/page",
        method: "get"
      }).then((response) => {
        console.log(response)
        this.tableData = response.data.data;
      })
    },
    goToEdit(row) {
      console.log(row);
      this.$router.push({
        path: '/editSup/index',
        query: {
          id: row.id
        }
      })
    },
    goTo() {
      this.$router.push('/addSup')
    },
    delSup(row) {
      console.log(row);
      axios({
        url: "/api/Management/delete1/" + row.id,
        method: "delete",
      }).then((response) => {
        console.log(response.data.data);
        this.loadData();
      })

    },
    open(row) {
      axios({
        url: "/api/VendorInformation/select1/" + row.id,
        method: "get",
      }).then((response) => {
        this.gridData = response.data.data;
        console.log(response.data.data)
      })
      this.dialogFormVisible = true;
      this.dialogTableVisible = true;
    },

    open1(row) {
      axios({
        url: "/api/VendorInformation/select2/" + row.id,
        method: "get",
      }).then((response) => {
        this.gridData = response.data.data;
        console.log(this.gridData)
      })
      this.form1.dialogFormVisible = true;
      this.form1.dialogTableVisible = true;
    },
    opendata() {
      this.form.dialogFormVisible = true;
      this.form.dialogTableVisible = true;
    },
    opendata1() {
      this.form2.dialogFormVisible = true;
      this.form2.dialogTableVisible = true;
    },
  },
}
</script>

<style scoped>
::v-deep .el-pager li.active{
  color: #eeeeee !important;
  background-color: rgb(132, 13, 132) !important;
}
.msp {
  height: 880px;
  width: 1680px;
  background-color: #f0f1f6;
  position: relative;
}

.tab {
  position: absolute;
  left: 220px;
  top: 10px;
  width: 1450px;
}

.M-search {
  width: 210px;
  height: 880px;
  padding: 0%;
  position: absolute;
  left: 0px;
}

.control {
  height: 40px;
  background-color: white;
  margin-bottom: 10px;
  width: 1450px;

}

.control button {
  background-color: rgb(255, 255, 255);
  color: rgb(0, 0, 0);
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
}

.add button {
  margin-left: 5px;
  background-color: rgb(132, 13, 132);
  color: #fff;
  border: rgb(132, 13, 132) 1px solid;
}

.fenye {
  padding-left: 1020px;
  margin-top: 5px;
  background-color: #fff;
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

::-webkit-scrollbar {
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

.btn {
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