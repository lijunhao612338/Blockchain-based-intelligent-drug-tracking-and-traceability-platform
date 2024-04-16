<template>
  <div class="mf">
    <div class="sy">
      <span>溯源查询</span>
    </div>
    <div class="suyuan">
      <span>溯源查询码:</span>
      <input type="text" class="suyuanma" v-model='sourceCode'>
      <button @click='chaxun'><i class="el-icon-search"></i></button>
    </div>
    <div class="msg">
      <div class="sc">
        <span class="tit">生产商</span>
        <br>
        <input type="text" v-model="scs">
        <div class="ckxx">
          <span>生产商出库信息</span>
          <br>
          <button @click="opendata()"><i class="el-icon-edit"></i></button>
        </div>
        <!-- <div class="ckfp">
          <span>生产商出厂发票</span>
          <br>
          <button @click="opendata1()"><i class="el-icon-edit"></i></button>
        </div> -->
      </div>
      <div class="gy">
        <span class="tit">供应商</span>
        <br>
        <input type="text" v-model="gys">
        <!-- <div class="jhfp">
          <span>供应商进货发票</span>
          <br>
          <button @click="opendata2()"><i class="el-icon-edit"></i></button>
        </div> -->
        <div class="rkxx">
          <span>供应商入库信息</span>
          <br>
          <button @click="opendata3()"><i class="el-icon-edit"></i></button>
        </div>
        <div class="gyckxx">
          <span>供应商出库信息</span>
          <br>
          <button @click="opendata4()"><i class="el-icon-edit"></i></button>
        </div>
        <!-- <div class="gyckfp">
          <span>供应商出库发票</span>
          <br>
          <button @click="opendata5()"><i class="el-icon-edit"></i></button>
        </div> -->
      </div>
      <div class="jx">
        <span class="tit">经销商</span>
        <br>
        <input type="text" v-model="jxs">
        <div class="jxjhxx">
          <span>经销商进货信息</span>
          <br>
          <button @click="opendata6()"><i class="el-icon-edit"></i></button>
        </div>
        <!-- <div class="jxjhfp">
          <span>
            经销商进货发票
          </span>
          <br>
          <button @click="opendata7()"><i class="el-icon-edit"></i></button>
        </div> -->
      </div>
    </div>
    <!-- 生产商出库信息 -->
    <el-dialog title="生产商出库信息" :visible.sync="form.dialogTableVisible">
      <el-table :data="gridData">
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
      </el-table>
    </el-dialog>
    <!-- 生产商出厂发票 -->
    <el-dialog title="生产商出厂发票" :visible.sync="form1.dialogTableVisible">
      <el-table :data="gridData">
        <el-table-column prop="drug_information" label="药品信息" width="280"></el-table-column>
        <el-table-column prop="inbound_time" label="入库时间" width="280"></el-table-column>
        <el-table-column prop="shipping_warehouse" label="发货仓库" width="280"></el-table-column>
      </el-table>
    </el-dialog>
    <!--供应商进货发票-->
    <el-dialog title="供应商进货发票" :visible.sync="form2.dialogTableVisible">
      <el-table :data="gridData">
        <el-table-column prop="drug_information" label="药品信息" width="280"></el-table-column>
        <el-table-column prop="inbound_time" label="入库时间" width="280"></el-table-column>
        <el-table-column prop="shipping_warehouse" label="发货仓库" width="280"></el-table-column>
      </el-table>
    </el-dialog>
    <!-- 供应商入库信息 -->
    <el-dialog title="供应商入库信息" :visible.sync="form3.dialogTableVisible">
      <el-table :data="gridData">
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
      </el-table>
    </el-dialog>
    <!-- 供应商出库信息 -->
    <el-dialog title="供应商出库信息" :visible.sync="form4.dialogTableVisible">
      <el-table :data="gridData">
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
      </el-table>
    </el-dialog>
    <!-- 供应商出库发票 -->
    <el-dialog title="供应商出库发票" :visible.sync="form5.dialogTableVisible">
      <el-table :data="gridData">
        <el-table-column prop="drug_information" label="药品信息" width="280"></el-table-column>
        <el-table-column prop="inbound_time" label="入库时间" width="280"></el-table-column>
        <el-table-column prop="shipping_warehouse" label="发货仓库" width="280"></el-table-column>
      </el-table>
    </el-dialog>
    <!-- 经销商进货信息 -->
    <el-dialog title="经销商进货信息" :visible.sync="form6.dialogTableVisible">
      <el-table :data="gridData">
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
      </el-table>
    </el-dialog>
    <!-- 经销商进货发票 -->
    <el-dialog title="经销商进货发票" :visible.sync="form7.dialogTableVisible">
      <el-table :data="gridData">
        <el-table-column prop="drug_information" label="药品信息" width="280"></el-table-column>
        <el-table-column prop="inbound_time" label="入库时间" width="280"></el-table-column>
        <el-table-column prop="shipping_warehouse" label="发货仓库" width="280"></el-table-column>
      </el-table>
    </el-dialog>
  </div>
</template>

<script>
import axios from 'axios';
export default {
  data() {
    return {
    sourceCode:'',
      jxs: '经销商',
      gys: '供应商',
      scs: '生产商',
      gridData: [],
      nameData:[],
      // 生产商出库信息
      form: {
        dialogTableVisible: false,
        dialogFormVisible: false,
      },
      // 生产商出厂发票
      form1: {
        dialogTableVisible: false,
        dialogFormVisible: false,
      },
      form2: {
        dialogTableVisible: false,
        dialogFormVisible: false,
      },
      form3: {
        dialogTableVisible: false,
        dialogFormVisible: false,
      },
      form4: {
        dialogTableVisible: false,
        dialogFormVisible: false,
      },
       form5: {
        dialogTableVisible: false,
        dialogFormVisible: false,
      }, 
      form6: {
        dialogTableVisible: false,
        dialogFormVisible: false,
      },
      form7: {
        dialogTableVisible: false,
        dialogFormVisible: false,
      },
    };
  },
  methods: {
  //生产商出库
    opendata() {
        axios({
        url: "/api/Suyuan/select1/"+this.sourceCode,
        method: "get",
      }).then((response) => {
        this.gridData=response.data.data;  
        console.log(this.gridData)      
      })
      this.form.dialogFormVisible = true;
      this.form.dialogTableVisible = true;
    },
    opendata1() {
            axios({
        url: "/api/DealerInformation/select/",
        method: "get",
      }).then((response) => {
        this.gridData=response.data.data;  
        console.log(this.gridData)      
      })
      this.form1.dialogFormVisible = true;
      this.form1.dialogTableVisible = true;
    },
    opendata2() {
            axios({
        url: "/api/DealerInformation/select/",
        method: "get",
      }).then((response) => {
        this.gridData=response.data.data;  
        console.log(this.gridData)      
      })
      this.form2.dialogFormVisible = true;
      this.form2.dialogTableVisible = true;
    },
    opendata3() {
            axios({
        url: "/api/Suyuan/select1/"+this.sourceCode,
        method: "get",
      }).then((response) => {
        this.gridData=response.data.data;  
        console.log(this.gridData)      
      })
      this.form3.dialogFormVisible = true;
      this.form3.dialogTableVisible = true;
    },
    opendata4() {
            axios({
        url: "/api/Suyuan/select2/"+this.sourceCode,
        method: "get",
      }).then((response) => {
        this.gridData=response.data.data;  
        console.log(this.gridData)      
      })
      this.form4.dialogFormVisible = true;
      this.form4.dialogTableVisible = true;
    },
    opendata5() {
            axios({
        url: "/api/DealerInformation/select/",
        method: "get",
      }).then((response) => {
        this.gridData=response.data.data;  
        console.log(this.gridData)      
      })
      this.form5.dialogFormVisible = true;
      this.form5.dialogTableVisible = true;
    },
    opendata6() {
            axios({
        url: "/api/Suyuan/select2/"+this.sourceCode,
        method: "get",
      }).then((response) => {
        this.gridData=response.data.data;  
        console.log(this.gridData)      
      })
      this.form6.dialogFormVisible = true;
      this.form6.dialogTableVisible = true;
    },
    opendata7() {
            axios({
        url: "/api/DealerInformation/select/",
        method: "get",
      }).then((response) => {
        this.gridData=response.data.data;  
        console.log(this.gridData)      
      })
      this.form7.dialogFormVisible = true;
      this.form7.dialogTableVisible = true;
    },
    chaxun(){
    axios({
        url: "/api/SuYuanChangShang/select3/"+this.sourceCode,
        method: "get",
      }).then((response) => {
        this.nameData=response.data.data;  
        console.log(this.nameData)
        this.jxs=response.data.data.dealerName;
        this.gys=response.data.data.vendorName;
        this.scs=response.data.data.manufacturersName;
      })
    }
  }
}
</script>

<style scoped>
.msg {
  position: absolute;
  top: 200px;
}

.mf {
  height: 880px;
  width: 1680px;
}

.suyuan {
  position: absolute;
  top: 70px;
  left: 15px;
  height: 809px;
  width: 1650px;
  background-color: #ffffff;
  border-radius: 6px;
}

.suyuan span {
  position: absolute;
  top: 20px;
  left: 10px;
}

.sy {
  position: absolute;
  top: 1px;
  left: 1px;
  background-color: rgb(255, 255, 255);
  height: 40px;
  width: 1680px;
  font-size: 16px;
  padding-top: 12px;
  font-weight: bolder;
  padding-left: 20px;
  font-size:20px ;
  font-weight: bolder;
}

.suyuanma {
  position: absolute;
  top: 16px;
  left: 110px;
  border-radius: 6px;
  height: 26px;
  width: 180px;
}

.msg input {
  border: #ffffff 1px solid;
  height: 30px;
  width: 160px;
  margin-bottom: 70px;
  margin-top: 20px;
  margin-left: 20px;
}

.tit {
  margin-left: 20px;
}

.ckxx {
  position: absolute;
  left: 270px;
  top: 0px;
}

.ckfp {
  position: absolute;
  left: 503px;
  top: 0px;
}

.jhfp {
  position: absolute;
  left: 270px;
  top: 140px;
}

.rkxx {
  position: absolute;
  left: 270px;
  top: 140px;
}

.gyckxx {
  position: absolute;
  left: 503px;
  top: 140px;
}

.gyckfp {
  position: absolute;
  left: 969px;
  top: 140px;
}

.jxjhxx {
  position: absolute;
  left: 270px;
  top: 287px;
}

.jxjhfp {
  position: absolute;
  left: 503px;
  top: 287px;
}

.msg button {
  margin-left: 40px;
  margin-top: 25px;
  background-color: #fff;
  border: #fff;
}

.suyuan button {
  position: absolute;
  left: 260px;
  top: 20px;
  height: 20px;
  width: 30px;
  border: none;
  background-color: #fff;
}</style>