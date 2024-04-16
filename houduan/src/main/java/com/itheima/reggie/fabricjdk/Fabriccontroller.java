//package com.itheima.reggie.fabricjdk;
//
//
//import com.itheima.reggie.entity.Qukuailian;
//import lombok.AllArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import org.hyperledger.fabric.client.*;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//
//@Slf4j
//@RestController
//@AllArgsConstructor
//@RequestMapping("/qukuailian")
//public class Fabriccontroller {
//
//    @javax.annotation.Resource
//    FabricGatewayUtil fabricGatewayUtil;
//
//    @GetMapping("/zengjia")
//    public void zengjia(Qukuailian qukuailian) throws EndorseException, SubmitException, CommitException, CommitStatusException {
//        Contract contract = fabricGatewayUtil.getContract();
//        String id = qukuailian.getId();
//        String drugName = qukuailian.getDrugName();
//        String inboundTime = qukuailian.getInboundTime();
//        String shippingWarehouse = qukuailian.getShippingWarehouse();
//        String genericName = qukuailian.getGenericName();
//        String specification = qukuailian.getSpecification();
//        String dosageForm = qukuailian.getDosageForm();
//        String manufacturer = qukuailian.getManufacturer();
//        String approvalNumber = qukuailian.getApprovalNumber();
//        String unit = qukuailian.getUnit();
//        String quantity = qukuailian.getQuantity();
//        String unitPrice = qukuailian.getUnitPrice();
//        String amount = qukuailian.getAmount();
//        String lotNumber = qukuailian.getLotNumber();
//        String expirationDate = qukuailian.getExpirationDate();
//        String remark = qukuailian.getRemark();
//
//        //增加数据
//        contract.submitTransaction("CreateAsset",""+id+"",""+drugName+"",""+inboundTime+"",""+shippingWarehouse+"",""+genericName+"",""+specification+"",""+dosageForm+"",""+manufacturer+"",""+approvalNumber+"",""+unit+"",""+quantity+"",""+unitPrice+"",""+amount+"",""+lotNumber+"",""+expirationDate+"",""+remark+"");
//
//
//    }
//
//    @GetMapping("/shanchu")
//    public void shanchu() throws EndorseException, SubmitException, CommitException, CommitStatusException {
//        Contract contract = fabricGatewayUtil.getContract();
//        System.out.println(contract+"jjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjj");
//
//        //删除数据
//        contract.submitTransaction("DeleteAsset","asset3");
//
//    }
//
//    @GetMapping("/chaxun")
//    public void chaxun() throws EndorseException, SubmitException, CommitException, CommitStatusException {
//        Contract contract = fabricGatewayUtil.getContract();
//        System.out.println(contract+"jjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjj");
//
//        //根据id查询数据
//        contract.submitTransaction("QueryAssetsByOwner","1");
//
//    }
//}
//
//
//
////获取一段数据
////contract.submitTransaction("GetAssetsByRange","wei U dianqielv drug","sidashu case");
////获取ID asset所历史查询
////contract.submitTransaction("GetAssetHistory","asset3");
////验证数据是否存在
////contract.submitTransaction("AssetExists","asset3");
////
//
//
////更新药品asset里仓库
////contract.submitTransaction("TransferAsset","asset3","China case");
////更新所有以xiu zheng drug里的case
////contract.submitTransaction("TransferAssetByColor","xiu zheng drug","CHINA CASE");
