package com.supplychain.dapp.transparent.foodchain.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.supplychain.dapp.transparent.foodchain.DTO.GoodsDetailsDTO;
import com.supplychain.dapp.transparent.foodchain.Service.GoodsService;

@RestController
@RequestMapping("/api")
public class GoodsController {

    @Autowired
    private GoodsService goodsService;

    @GetMapping("/goodsDetailsByID/{uuid}")
    public ResponseEntity<?> getGoodsDetailsByID(@PathVariable String uuid) {
        try {
            GoodsDetailsDTO goodsDetails = goodsService.getGoodsDetailsByID(uuid);
            return ResponseEntity.ok(goodsDetails);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error fetching goods details: " + e.getMessage());
        }
    }
}