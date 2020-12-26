package com.datn.qltccn.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Setter
@Getter
public class ProductDTO implements Serializable {

    private Date createdDate;

    private String description;


    private Long id;

    private Long idCategory;

    private Long idSale;

    private String iSale;

    private Long idMark;

    private MultipartFile imageFile;

    private String imageProduct;

    private String maSp;

    private String name;

    private BigDecimal price;

    private Integer sellCount;

    private Integer totalItem;

    private Long idColor;

    private String codeSale;
}
