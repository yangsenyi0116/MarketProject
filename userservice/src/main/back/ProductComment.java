package com.kermi.market.userservice.dao;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;


@Data
@AllArgsConstructor
public class ProductComment implements Serializable {
    private Integer commentId;

    private Integer productId;

    private Long orderId;

    private Integer customerId;

    private String title;

    private String content;

    private Byte auditStatus;

    private Date auditTime;

    private Date modifiedTime;

    private static final long serialVersionUID = 1L;

    public ProductComment() {
        super();
    }

}