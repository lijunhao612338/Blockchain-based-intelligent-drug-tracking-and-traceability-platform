package com.itheima.reggie.fabricjdk;

import com.google.common.collect.Maps;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.binary.StringUtils;
import org.hyperledger.fabric.gateway.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.PrivateKey;
import java.security.cert.X509Certificate;
import java.util.Map;
import java.util.concurrent.TimeoutException;


@RestController
@RequestMapping("/car")
@Slf4j
@AllArgsConstructor
public class Fabriccontroller {
    @Resource
    private Gateway gateway;


    @GetMapping("/queryall")
    public Map<String, Object> queryall() throws ContractException {

        Map<String, Object> result = Maps.newConcurrentMap();
        Contract contract = getContract();
        byte[] car = contract.evaluateTransaction("queryAllCars");

        result.put("result", StringUtils.newStringUtf8(car));


        return result;
    }

    private Network getNetwork(){
        return gateway.getNetwork("mychannel");
    }

    private  Contract getContract(){
        return getNetwork().getContract("fabcar");
    }


}