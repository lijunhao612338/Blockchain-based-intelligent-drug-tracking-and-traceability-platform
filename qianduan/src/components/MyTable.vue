<template>
    <div class="table">
      <div class="btn">
        <el-button type="primary" plain @click="goTo()" >新增</el-button> 
      </div>
        <div class="TableData">
        <el-table
      :data="tableData"
      style="width: 100%">
      <el-table-column fixed="left"
        label="企业名称"
        width="180">
        <template slot-scope="scope">
          <i class="el-icon-user"></i>
          <span style="margin-left: 10px">{{ scope.row.businessName }}</span>
        </template>
      </el-table-column>
      <el-table-column
        label="入库信息"
        width="180">
        <template slot-scope="scope">
          <el-popover trigger="click" placement="top">
            <p>姓名: {{ scope.row }}</p>
            <p>住址: {{ scope.row }}</p>
            <div slot="reference" class="name-wrapper">
              <el-tag size="medium"><i class="el-icon-edit"></i></el-tag>
            </div>
          </el-popover>
        </template>
      </el-table-column>
      <el-table-column
        label="企业类型"
        width="180">
        <template slot-scope="scope">
          <span style="margin-left: 10px">{{ scope.row.businessType }}</span>
        </template>
      </el-table-column>
      <el-table-column
        label="工商注册号"
        width="180">
        <template slot-scope="scope">
          <span style="margin-left: 10px">{{ scope.row.businessRegistrationNumber }}</span>
        </template>
      </el-table-column>
      <el-table-column
        label="统一社会信用代码"
        width="180">
        <template slot-scope="scope">
          <span style="margin-left: 10px">{{ scope.row.unifiedSocialCreditCode }}</span>
        </template>
      </el-table-column>
      <el-table-column
        label="登记状态"
        width="180">
        <template slot-scope="scope">
          <span style="margin-left: 10px">{{ scope.row.registrationStatus }}</span>
        </template>
      </el-table-column>
      <el-table-column
        label="登记机关"
        width="180">
        <template slot-scope="scope">
          <span style="margin-left: 10px">{{ scope.row.registrationAuthorities }}</span>
        </template>
      </el-table-column>
      <el-table-column
        label="所属地区"
        width="180">
        <template slot-scope="scope">
          <span style="margin-left: 10px">{{ scope.row.region }}</span>
        </template>
      </el-table-column>
      <el-table-column
        label="注册地址"
        width="180">
        <template slot-scope="scope">
          <span style="margin-left: 10px">{{ scope.row.registeredAddress }}</span>
        </template>
      </el-table-column>
      <el-table-column
        label="公司核准日期"
        width="180">
        <template slot-scope="scope">
          <span style="margin-left: 10px">{{ scope.row.companyApprovalDate }}</span>
        </template>
      </el-table-column>
      <el-table-column
        label="注册资本"
        width="180">
        <template slot-scope="scope">
          <span style="margin-left: 10px">{{ scope.row.registeredCapital}}</span>
        </template>
      </el-table-column>
      <el-table-column
        label="法定代表人"
        width="180">
        <template slot-scope="scope">
          <span style="margin-left: 10px">{{ scope.row.legalRepresentative }}</span>
        </template>
      </el-table-column>
      <el-table-column
        label="联系电话"
        width="180">
        <template slot-scope="scope">
          <span style="margin-left: 10px">{{ scope.row.contactNumber }}</span>
        </template>
      </el-table-column>
      <el-table-column
        label="创建人"
        width="180">
        <template slot-scope="scope">
          <span style="margin-left: 10px">{{ scope.row.createUser }}</span>
        </template>
      </el-table-column>
      <el-table-column
        label="创建时间"
        width="180">
        <template slot-scope="scope">
          <span style="margin-left: 10px">{{ scope.row.createTime }}</span>
        </template>
      </el-table-column>
      <el-table-column
        label="修改人"
        width="180">
        <template slot-scope="scope">
          <span style="margin-left: 10px">{{ scope.row.updateUser }}</span>
        </template>
      </el-table-column>
      <el-table-column
        label="修改时间"
        width="180">
        <template slot-scope="scope">
          <span style="margin-left: 10px">{{ scope.row.updateTime }}</span>
        </template>
      </el-table-column>
      <el-table-column label="操作" fixed="right" width="180px">
        <template slot-scope="scope">
          <el-button
            size="mini"
            @click="handleEdit()">编辑</el-button>
          <el-button
            size="mini"
            type="danger"
            @click="handleDelete(scope.$index, scope.row)">删除</el-button>
        </template>
      </el-table-column>
      
    </el-table>
    <EditDialog ref="EditDialog"></EditDialog>
  </div>
    </div>
</template>

<script>
import  axios  from  "axios"
import EditDialog from "./EditDialog.vue"
export default {
  data() {
    return {
      tableData: []
    }
  },
  created() {
    this.loadData()
  },
  methods: {
    loadData(){
      
        axios.get(
          
    '/manufacturerSelectById',
    {
      params: {
        'businessRegistrationNumber':'1'
          },
    }
   ).then(function (response) {
    console.log(response)
  })
  .catch(function (error) {
    console.log('错误')
    console.log(error);
  });
    },
    handleEdit() {
      this.$router.push({path:'/add?businessName=1'})
    },
    
    handleDelete(index, row) {
      console.log(index, row);
    },
    goTo(){
      this.$router.push('/add')
    }
  },
  components:{
  EditDialog
  }
}
</script>

<style>
.table{
  position: relative;
  left: 220px;
  top: 10px;
    height: 999px;
    width: 1460px;
}
.btn{
   position: absolute;
   top: 0px;
   height: 50px;
   left: 9px;
   width: 1440px;
   background-color: #FFFFFF;
}
.TableData{
  position: absolute;
  left: 9px;
  top: 60px;
  background-color: #FFFFFF;
  width: 1440px;
  height: 840px;
}
</style>