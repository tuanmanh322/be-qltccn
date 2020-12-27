package com.datn.qltccn.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
public class NganSachDTO {
    private Integer id;

    private String username;

    private String vonglap;

    private LocalDateTime ngaytao;

    private String tenloaingansach;

    private String loaitien;

    private String tenkhachhang;

    private Integer idLoaiNganSach;

    private String sotien;


}
