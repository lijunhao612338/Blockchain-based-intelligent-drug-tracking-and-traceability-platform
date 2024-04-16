package com.itheima.reggie.fabricjdk;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "fabric.config.properties")
@Data
public class HyperLedgerFabricProperties {


    String networkConnectionConfigPath;
    String certificatePath;
    String privateKeyPath;


}