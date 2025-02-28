package com.supplychain.dapp.transparent.foodchain.Configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.http.HttpService;

@Configuration
public class OFAConfig {

    @Value("${blockchain.nodeUrl}")
    private String nodeUrl;

    @Value("${blockchain.ofa.privateKey}")
    private String ofaPrivateKey;

    @Bean(name = "web3jOFA")
    public Web3j web3jOFA() {
        return Web3j.build(new HttpService(nodeUrl));
    }

    @Bean(name = "ofaCredentials")
    public Credentials ofaCredentials() {
        return Credentials.create(ofaPrivateKey);
    }
}