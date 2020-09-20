package com.ypc.seata.warehouseservice.service.impl;

import com.ypc.seata.warehouseservice.entity.WarehouseEntity;
import com.ypc.seata.warehouseservice.repository.WarehouseRepository;
import com.ypc.seata.warehouseservice.service.WarehouseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Slf4j
@Service
public class WarehouseServiceImpl implements WarehouseService {

    private WarehouseRepository warehouseRepository;

    public WarehouseServiceImpl(WarehouseRepository warehouseRepository) {
        this.warehouseRepository = warehouseRepository;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Map<String, Object> reduceStock(String code, Long num) {
        Map<String,Object> resultMap = new HashMap<>();
        resultMap.put("success",false);
        WarehouseEntity warehouseEntity = warehouseRepository.findByCode(code);
        // 仓库减少库存
        Long remain = warehouseEntity.getStock() - num;
        warehouseEntity.setStock(remain);
        warehouseEntity.setUpdateTime(new Date());
        WarehouseEntity result = warehouseRepository.save(warehouseEntity);
        // 模拟异常
        if (result.getStock() % 2 == 0) {
            log.error(">>>> 仓库分支事务抛出异常 <<<<");
            throw new RuntimeException("仓库分支事务抛出异常");
        }

        resultMap.put("success",true);
        resultMap.put("message","更新库存成功");
        return resultMap;
    }
}
