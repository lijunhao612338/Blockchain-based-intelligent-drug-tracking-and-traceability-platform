<template>
  <div class="add">
    <span class="form-left-name">企业名称:</span>
    <input type="text" v-model="form.user" class="inputborder">
    <span class="form-right-name">登记状态:</span>
    在营<input type="radio" value="1" v-model="form.state">
    开业<input type="radio" value="2" v-model="form.state">
    注册<input type="radio" value="3" v-model="form.state">
    <br>
    <span class="form-left-name">企业类型:</span>
    <input type="text" v-model="form.type" class="inputborder">
    <span class="form-right-name">工商注册号:</span>
    <input type="text" v-model="form.number" class="inputborder">
    <span class="form-right-right-name">登记机关:</span>
    <input type="text" v-model="form.authorities" class="inputborder">
    <br>
    <span class="form-left-name">所属地区:</span>
    <input type="text" v-model="form.places" class="inputborder">
    <span class="form-right-name">社会信用代码:</span>
    <input type="text" class="inputborder" v-model="form.Code">
    <span class="form-right-right-name">法定代表人:</span>
    <input type="text" v-model="form.Head" class="inputborder">
    <br>
    <span class="form-left-name">注册地址:</span>
    <input type="text" v-model="form.place" class="inputborder">
    <span class="form-right-name">公司核准日期:</span>
    <input type="date" class="inputborder" v-model="form.day">
    <span class="form-right-right-name">联系电话:</span>
    <input type="text" v-model="form.phone" class="inputborder">
    <br>
    <span class="form-left-name">注册资本:</span>
    <input type="text" v-model="form.money" class="inputborder">
    <br>
    <span class="form-left-bt-name">创建人</span>
    <input type="text" v-model="form.Create" class="bt-inputborder">
    <span class="form-right-bt-name">修改人</span>
    <input type="text" v-model="form.edit" class="bt-inputborder">
    <br>
    <span class="form-left-name">创建时间</span>
    <input type="text" v-model="form.Createtime" class="inputborder">
    <span class="form-right-name">创建时间</span>
    <input type="text" v-model:="form.edittime" class="inputborder">
    <el-button type="primary" @click="postMes">保存</el-button>

  </div>
</template>

<script>
import  axios  from  "axios"
export default {
  data() {
    return {
      form: {
        user: '',
        state: '',
        type: '',
        number: '',
        authorities: '',
        places: '',
        Code: '',
        Head: '',
        place: '',
        day: '',
        phone: '',
        money: '',
        Create: '',
        Createtime: '',
        edit: '',
        edittime: ''
      }
    }
  },
  methods: {
  postMes(){
   axios.get(
    '/user',
    {
      params: {
        'businessName':this.$route.query.businessName
          },
       
    }
   ).then(function (response) {
    console.log(response);
  })
  .catch(function (error) {
    console.log(error);
  });
  }
   }
  }

</script>
<style scoped>
.add {
  background-color: white;
  height: 988px;
  width: 1640px;
  position: absolute;
  left: 20px;
  top: 12px;
}

.message {
  margin-top: 40px;
}

.a-title {
  padding-left: 10px;
  height: 40px;
  line-height: 40px;
  font-size: 16px;
  font-weight: bold;
}

.el-input {
  margin-bottom: 30px;
  border-radius: 6px;
  margin-right: 50px;
}
</style>