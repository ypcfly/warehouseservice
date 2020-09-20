package com.ypc.seata.warehouseservice.service;

import java.util.Map;

public interface WarehouseService {
    Map<String, Object> reduceStock(String code, Long num);
}
