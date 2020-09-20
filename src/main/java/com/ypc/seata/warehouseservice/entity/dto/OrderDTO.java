package com.ypc.seata.warehouseservice.entity.dto;

import lombok.Data;

import java.util.Date;

@Data
public class OrderDTO {

    private Long id;

    private String orderNum;

    private String address;

    private Double totalPrice;

    private Date createTime;

    private Date updateTime;

    private Long nums;

    private String warehouseCode;

}
