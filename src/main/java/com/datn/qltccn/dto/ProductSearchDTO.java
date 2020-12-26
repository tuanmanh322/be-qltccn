package com.datn.qltccn.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class ProductSearchDTO extends BaseSearch{
    private List<Integer> idColor;

    private List<Integer> idMark;

    private List<Integer> idSale;

    private List<Integer> idCategory;

    private Double priceFirst;

    private Double priceSecond;

    private String name;

}
