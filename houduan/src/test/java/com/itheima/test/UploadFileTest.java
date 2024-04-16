//package com.itheima.test;
//
//import com.itheima.reggie.fabricjdk.FabricGatewayUtil;
//import org.hyperledger.fabric.client.Contract;
//import org.hyperledger.fabric.client.EndorseException;
//import org.hyperledger.fabric.client.SubmitException;
//import org.junit.jupiter.api.Test;
//
//public class UploadFileTest {
//    FabricGatewayUtil fabricGatewayUtil;
//
//    @Test
//    public void test1() throws EndorseException, SubmitException {
//        Contract contract = fabricGatewayUtil.getContract();
//        System.out.println(contract);
//        contract.newProposal("CreateAsset")
//                .addArguments("asset4", "wei U dianqielv", "876", "drug", "xiu zheng drug", "guoyaozhunzi H22026232", "box", "20", "sidashu case", "electronically supervised drug")
//                .build()
//                .endorse()
//                .submitAsync();
//    }
//}
