package com.supplychain.dapp.transparent.foodchain.Configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.http.HttpService;

@Configuration
public class FarmerConfig {

    @Value("${blockchain.nodeUrl}")
    private String nodeUrl;

    @Value("${blockchain.farmer.privateKey}")
    private String farmerPrivateKey;

    @Bean(name = "web3jFarmer")
    public Web3j web3jFarmer() {
        return Web3j.build(new HttpService(nodeUrl));
    }

    @Bean(name = "farmerCredentials")
    public Credentials farmerCredentials() {
        return Credentials.create(farmerPrivateKey);
    }
}