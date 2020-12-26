package com.datn.qltccn.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
public class ProductListSaleDTO {
    private Long id;

    private String imageProduct;

    private String maSp;

    private String name;

    private BigDecimal price;

    private Integer sellCount;

    private String saleName;

    private Double codeSale;

    private Long idSale;

    private Long idColor;

    private Long idCategory;

    private Long idMark;

    public ProductListSaleDTO(Long id, String imageProduct, String maSp, String name, BigDecimal price, Integer sellCount, String saleName, Double codeSale) {
        this.id = id;
        this.imageProduct = imageProduct;
        this.maSp = maSp;
        this.name = name;
        this.price = price;
        this.sellCount = sellCount;
        this.saleName = saleName;
        this.codeSale = codeSale;
    }
}
