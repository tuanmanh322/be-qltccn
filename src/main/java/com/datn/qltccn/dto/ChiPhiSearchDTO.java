package com.datn.qltccn.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ChiPhiSearchDTO extends BaseSearch{
    private String tenloaingansach;

    private String thang;

    private String year;
}
