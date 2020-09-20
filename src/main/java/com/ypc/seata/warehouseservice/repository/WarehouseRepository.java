package com.ypc.seata.warehouseservice.repository;

import com.ypc.seata.warehouseservice.entity.WarehouseEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WarehouseRepository extends JpaRepository<WarehouseEntity,Long> {
    WarehouseEntity findByCode(String code);

}
