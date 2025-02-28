package com.supplychain.dapp.transparent.foodchain.Controller;

import com.supplychain.dapp.transparent.foodchain.DTO.GoodsRequest;
import com.supplychain.dapp.transparent.foodchain.Service.FarmerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

import java.util.Map;

@RestController
@RequestMapping("/api/farmer")
public class FarmerController {

    @Autowired
    private FarmerService farmerService;

    @PostMapping("/registerGoods")
    public ResponseEntity<?> registerGoods(@RequestBody GoodsRequest goodsRequest) {
        try {
            String uuid = farmerService.registerGoods(goodsRequest.getItemName(), goodsRequest.getQuantity());
            Map<String, String> response = new HashMap<>();
            response.put("uuid", uuid);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error registering goods: " + e.getMessage());
        }
    }
}
