package com.datn.qltccn.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class ProductFinalDTO {
    private Date createDate;

    private String description;

    private Long id;

    private Long idCategory;

    private Long idSale;

    private Long idMark;

    private String imageProduct;

    private String maSP;

    private String nameSP;

    private Double price;

    private Integer sellCount;

    private Integer totalItem;

    private Long idColor;

    private String codeSale;
}
