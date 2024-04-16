<template>
<el-dialog title="用户信息" :visible.sync="dialogFormVisible">
  <el-form :model="form">
    <el-form-item label="企业名称" :label-width="formLabelWidth">
      <el-input v-model="form.businessName" autocomplete="off"></el-input>
    </el-form-item>
    <el-form-item label="企业类型" :label-width="formLabelWidth">
      <el-select v-model="form.region" placeholder="请选择活动区域">
        <el-option label="区域一" value="shanghai"></el-option>
        <el-option label="区域二" value="beijing"></el-option>
      </el-select>
    </el-form-item>
  </el-form>
  <div slot="footer" class="dialog-footer">
    <el-button @click="dialogFormVisible = false">取 消</el-button>
    <el-button type="primary" @click="dialogFormVisible = false">确 定</el-button>
  </div>
</el-dialog>

</template>

<script>
import axios from 'axios';

  export default {
    data() {
      return {
        dialogTableVisible: false,
        dialogFormVisible: false,
        form: {
          businessName:'',
        businessType: '',
        businessRegistrationNumber:'',
        unifiedSocialCreditCode:'',
        registrationStatus:'',
        registrationAuthorities:'',
        region:'',
        registeredAddress:'',
        companyApprovalDate:'',
        registeredCapital:'',
        legalRepresentative:'',
        contactNumber:'',
        createUser:'',
        createTime:'',
        updateUser:'',
        updateTime:''
        },
        formLabelWidth: '120px'
      };
    },
    methods: {
      open(){
        axios.get(
    '/MyTable',
    {
      params: {
        'businessName':'1'
          }
    }
   ).then(function (response) {
    console.log(response);
  })
  .catch(function (error) {
    console.log(error);
  });
        this.dialogFormVisible=true;
        this.dialogTableVisible=true;
      }
    },
  };
</script>