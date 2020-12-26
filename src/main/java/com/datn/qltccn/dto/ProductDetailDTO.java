package com.datn.qltccn.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.sql.Date;

@Getter
@Setter
public class ProductDetailDTO {
    private Date createdDate;

    private String description;

    private Long id;

    private Long idCategory;

    private Long idSale;

    private Long idMark;

    private String imageProduct;

    private String maSp;

    private String name;

    private BigDecimal price;

    private Integer sellCount;

    private Integer totalItem;

    private Long idColor;

    private String colorName;

    private String markName;

    private String categoryName;

    private String descriptionMark;

    private Double codeSale;

    private String nameSale;


}
