package com.supplychain.dapp.transparent.foodchain.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tx.gas.DefaultGasProvider;

import com.supplychain.dapp.transparent.foodchain.Contract.SupplyChainPoS;
@Service
public class OFAService {

    private final SupplyChainPoS contract;
    @SuppressWarnings("unused")
    private final Web3j web3j;
    @SuppressWarnings("unused")
    private final Credentials credentials;

    public OFAService(
            @Qualifier("web3jOFA") Web3j web3j,
            @Qualifier("ofaCredentials") Credentials credentials,
            @Value("${blockchain.contractAddress}") String contractAddress) {
        this.web3j = web3j;
        this.credentials = credentials;
        this.contract = SupplyChainPoS.load(contractAddress, web3j, credentials, new DefaultGasProvider());
    }

    public String verifyGoods(String uuid) throws Exception {
        // Remove the "0x" prefix if present
        if (uuid.startsWith("0x")) {
            uuid = uuid.substring(2);
        }

        // Ensure the UUID is 64 characters long (32 bytes in hex)
        if (uuid.length() != 64) {
            throw new IllegalArgumentException("UUID must be 64 characters long (32 bytes in hex)");
        }

        // Convert the UUID from hex string to byte array
        byte[] uuidBytes = hexStringToByteArray(uuid);

        // Send the transaction to verify goods
        TransactionReceipt receipt = contract.OFAValidateGoods(uuidBytes).send();

        // Extract the GoodsVerified event from the transaction receipt
        @SuppressWarnings("static-access")
        List<SupplyChainPoS.GoodsVerifiedEventResponse> events = contract.getGoodsVerifiedEvents(receipt);
        if (events.isEmpty()) {
            throw new Exception("No GoodsVerified event found in the transaction receipt.");
        }

        return "Goods verified successfully";
    }

    private byte[] hexStringToByteArray(String s) {
        int len = s.length();
        byte[] data = new byte[len / 2];
        for (int i = 0; i < len; i += 2) {
            data[i / 2] = (byte) ((Character.digit(s.charAt(i), 16) << 4)
                    + Character.digit(s.charAt(i + 1), 16));
        }
        return data;
    }
}