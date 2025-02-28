package com.supplychain.dapp.transparent.foodchain.DTO;

import java.math.BigInteger;

public class GoodsRequest {
    private String itemName;
    private BigInteger quantity;

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
}