package com.datn.qltccn.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NganSachSearchDTO extends BaseSearch {
    private String tenloaingansach;

    private String year;

    private String thang;
}
