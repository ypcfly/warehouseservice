package com.ypc.seata.warehouseservice.entity;

import lombok.Data;
import javax.persistence.*;
import java.util.Date;


@Data
@Entity
@Table(name = "t_warehouse")
public class WarehouseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "stock")
    private Long stock;

    @Column(name = "unit")
    private String unit;

    @Column(name = "code")
    private String code;

    @Column(name = "createTime")
    private Date createTime;

    @Column(name = "updateTime")
    private Date updateTime;
}
