package com.supplychain.dapp.transparent.foodchain.Service;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.tuples.generated.Tuple10;
import org.web3j.tx.gas.DefaultGasProvider;

import com.supplychain.dapp.transparent.foodchain.Contract.SupplyChainPoS;
import com.supplychain.dapp.transparent.foodchain.DTO.GoodsDetailsDTO;

import java.math.BigInteger;

@Service
public class GoodsService {

    private final SupplyChainPoS contract;
    @SuppressWarnings("unused")
    private final Web3j web3j;
    @SuppressWarnings("unused")
    private final Credentials credentials;

    public GoodsService(
            @Qualifier("web3jFarmer") Web3j web3j,
            @Qualifier("farmerCredentials") Credentials credentials,
            @Value("${blockchain.contractAddress}") String contractAddress) {
        this.web3j = web3j;
        this.credentials = credentials;
        this.contract = SupplyChainPoS.load(contractAddress, web3j, credentials, new DefaultGasProvider());
    }

    /**
     * Fetches goods details by UUID.
     *
     * @param uuid The UUID of the goods.
     * @return A GoodsDetailsDTO containing goods details.
     * @throws Exception If fetching goods details fails.
     */
    @SuppressWarnings("deprecation")
    public GoodsDetailsDTO getGoodsDetailsByID(String uuid) throws Exception {
        try {
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

            // Fetch goods details from the smart contract
            Tuple10<String, BigInteger, String, BigInteger, String, String, String, Boolean, Boolean, Boolean> goodsDetails =
                    contract.getGoodsDetails(uuidBytes).send();

            // Map goods details to a GoodsDetailsDTO
            GoodsDetailsDTO goodsDetailsDTO = new GoodsDetailsDTO();
            goodsDetailsDTO.setUuid("0x" + uuid); // Convert UUID back to hex string
            goodsDetailsDTO.setItemName(goodsDetails.getValue1()); // itemName
            goodsDetailsDTO.setQuantity(goodsDetails.getValue2()); // quantity
            goodsDetailsDTO.setArrivalDateToDistributor(goodsDetails.getValue3()); // arrivalDateToDistributor
            goodsDetailsDTO.setArrivalTimestampToRetailer(goodsDetails.getValue4()); // arrivalTimestampToRetailer
            goodsDetailsDTO.setFarmer(goodsDetails.getValue5()); // farmer
            goodsDetailsDTO.setDistributor(goodsDetails.getValue6()); // distributor
            goodsDetailsDTO.setRetailer(goodsDetails.getValue7()); // retailer
            goodsDetailsDTO.setDistributorArrival(goodsDetails.getValue8()); // distributorArrival
            goodsDetailsDTO.setRetailerArrival(goodsDetails.getValue9()); // retailerArrival
            goodsDetailsDTO.setVerified(goodsDetails.getValue10()); // isVerified

            return goodsDetailsDTO;
        } catch (Exception e) {
            throw new Exception("Error fetching goods details: " + e.getMessage(), e);
        }
    }

    private byte[] hexStringToByteArray(String s) {
        if (s.startsWith("0x")) {
            s = s.substring(2); // Remove the "0x" prefix
        }
        if (s.length() != 64) {
            throw new IllegalArgumentException("UUID must be 64 characters long (32 bytes in hex)");
        }
        byte[] data = new byte[32];
        for (int i = 0; i < 64; i += 2) {
            data[i / 2] = (byte) ((Character.digit(s.charAt(i), 16) << 4)
                    + Character.digit(s.charAt(i + 1), 16));
        }
        return data;
    }
}