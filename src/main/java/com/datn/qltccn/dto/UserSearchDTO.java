package com.datn.qltccn.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class UserSearchDTO extends BaseSearch {
    private String username;

    private String tenkhachhang;
}
