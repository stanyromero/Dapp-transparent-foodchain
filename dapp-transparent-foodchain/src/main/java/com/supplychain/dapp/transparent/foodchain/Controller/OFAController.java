package com.supplychain.dapp.transparent.foodchain.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.supplychain.dapp.transparent.foodchain.DTO.VerifyGoodsRequest;
import com.supplychain.dapp.transparent.foodchain.Service.OFAService;

@RestController
@RequestMapping("/api/ofa")
public class OFAController {

    @Autowired
    private OFAService ofaService;

    @PostMapping("/verifyGoods")
    public ResponseEntity<?> verifyGoods(@RequestBody VerifyGoodsRequest verifyGoodsRequest) {
        try {
            String result = ofaService.verifyGoods(verifyGoodsRequest.getUuid());
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error verifying goods: " + e.getMessage());
        }
    }
}