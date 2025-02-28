package com.supplychain.dapp.transparent.foodchain.DTO;

public class VerifyGoodsRequest {
    private String uuid;

    // Getters and Setters
    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        // Validate UUID format
        if (uuid == null || !uuid.matches("0x[0-9a-fA-F]{64}")) {
            throw new IllegalArgumentException("UUID must be a 64-character hexadecimal string prefixed with '0x'");
        }
        this.uuid = uuid;
    }
}