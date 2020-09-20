package com.ypc.seata.warehouseservice.controller;

import com.ypc.seata.warehouseservice.service.WarehouseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/warehouse")
public class WarehouseController {

    private WarehouseService warehouseService;

    public WarehouseController(WarehouseService warehouseService) {
        this.warehouseService = warehouseService;
    }

    @PostMapping("/reduce")
    public ResponseEntity reduceStock(@RequestParam("code")String code,@RequestParam("num") Long num) {
        log.info(">>>> request params: code={}, nums={} <<<<",code,num);
        Map<String,Object> result = warehouseService.reduceStock(code,num);
        return ResponseEntity.ok(result);
    }

}
