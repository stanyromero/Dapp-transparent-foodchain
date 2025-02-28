package com.supplychain.dapp.transparent.foodchain.Service;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tx.gas.DefaultGasProvider;

import com.supplychain.dapp.transparent.foodchain.Contract.SupplyChainPoS;

import java.math.BigInteger;
import java.util.List;

@Service
public class FarmerService {

    private final SupplyChainPoS contract;
    @SuppressWarnings("unused")
    private final Web3j web3j;
    @SuppressWarnings("unused")
    private final Credentials credentials;

    public FarmerService(
            @Qualifier("web3jFarmer") Web3j web3j,
            @Qualifier("farmerCredentials") Credentials credentials,
            @Value("${blockchain.contractAddress}") String contractAddress) {
        this.web3j = web3j;
        this.credentials = credentials;
        this.contract = SupplyChainPoS.load(contractAddress, web3j, credentials, new DefaultGasProvider());
    }

    /**
     * Registers goods in the supply chain.
     *
     * @param itemName The name of the item.
     * @param quantity The quantity of the item.
     * @return The UUID of the registered goods.
     * @throws Exception If the registration fails or no event is emitted.
     */
    public String registerGoods(String itemName, BigInteger quantity) throws Exception {
        // Send the transaction to register goods
        TransactionReceipt receipt = contract.registerGoods(itemName, quantity).send();

        // Extract the GoodsRegistered event from the transaction receipt
        @SuppressWarnings("static-access")
        List<SupplyChainPoS.GoodsRegisteredEventResponse> events = contract.getGoodsRegisteredEvents(receipt);
        if (events.isEmpty()) {
            throw new Exception("No GoodsRegistered event found in the transaction receipt.");
        }

        // Convert the UUID to a hexadecimal string and return it
        return "0x" + new BigInteger(1, events.get(0).uuid).toString(16);
    }

    /**
     * Fetches all registered goods from the supply chain.
     *
     * @return A list of maps containing goods details.
     * @throws Exception If fetching goods fails.
     */
}