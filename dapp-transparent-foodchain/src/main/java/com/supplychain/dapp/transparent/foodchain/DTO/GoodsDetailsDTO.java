package com.supplychain.dapp.transparent.foodchain.DTO;

import java.math.BigInteger;

public class GoodsDetailsDTO {
    private String uuid;
    private String itemName;
    private BigInteger quantity;
    private String arrivalDateToDistributor;
    private BigInteger arrivalTimestampToRetailer;
    private String farmer;
    private String distributor;
    private String retailer;
    private boolean distributorArrival;
    private boolean retailerArrival;
    private boolean isVerified;

    // Getters and Setters
    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public BigInteger getQuantity() {
        return quantity;
    }

    public void setQuantity(BigInteger quantity) {
        this.quantity = quantity;
    }

    public String getArrivalDateToDistributor() {
        return arrivalDateToDistributor;
    }

    public void setArrivalDateToDistributor(String arrivalDateToDistributor) {
        this.arrivalDateToDistributor = arrivalDateToDistributor;
    }

    public BigInteger getArrivalTimestampToRetailer() {
        return arrivalTimestampToRetailer;
    }

    public void setArrivalTimestampToRetailer(BigInteger arrivalTimestampToRetailer) {
        this.arrivalTimestampToRetailer = arrivalTimestampToRetailer;
    }

    public String getFarmer() {
        return farmer;
    }

    public void setFarmer(String farmer) {
        this.farmer = farmer;
    }

    public String getDistributor() {
        return distributor;
    }

    public void setDistributor(String distributor) {
        this.distributor = distributor;
    }

    public String getRetailer() {
        return retailer;
    }

    public void setRetailer(String retailer) {
        this.retailer = retailer;
    }

    public boolean isDistributorArrival() {
        return distributorArrival;
    }

    public void setDistributorArrival(boolean distributorArrival) {
        this.distributorArrival = distributorArrival;
    }

    public boolean isRetailerArrival() {
        return retailerArrival;
    }

    public void setRetailerArrival(boolean retailerArrival) {
        this.retailerArrival = retailerArrival;
    }

    public boolean isVerified() {
        return isVerified;
    }

    public void setVerified(boolean verified) {
        isVerified = verified;
    }
}