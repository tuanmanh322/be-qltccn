package com.datn.qltccn.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
public class ProductListDetailDTO {
    private Date createdDate;

    private String description;


    private Long id;

    private Long idCategory;

    private Long idSale;

    private Long idMark;

    private MultipartFile imageFile;

    private String imageProduct;

    private String maSp;

    private String name;

    private BigDecimal price;

    private Integer sellCount;

    private Integer totalItem;

    private Long idColor;

    private String colorName;

    private String saleName;

}
