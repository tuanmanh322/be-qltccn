package com.datn.qltccn.common;

import org.springframework.data.domain.Sort;

public class Orders {
    // hight to low
    public static Sort DESC(String col1 ){
        return Sort.by(Sort.Direction.DESC,col1);
    }

    // low to hight
    public static Sort ASC(String col1 ){
        return Sort.by(Sort.Direction.ASC,col1);
    }
}
