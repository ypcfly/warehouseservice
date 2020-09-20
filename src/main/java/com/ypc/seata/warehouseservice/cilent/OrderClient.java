package com.ypc.seata.warehouseservice.cilent;

import com.ypc.seata.warehouseservice.entity.dto.OrderDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "order-service",url = "http://localhost:8080")
public interface OrderClient {

    @PostMapping("/order/purchase")
    ResponseEntity purchase(@RequestBody OrderDTO orderDTO);
}
