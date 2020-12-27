package com.datn.qltccn.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
public class ChiPhiDTO {
    private Integer id;

    private String username;

    private String loaitien;

    private LocalDateTime ngaytao;

    private String mota;

    private String sotien;

    private String tenloaingansach;

    private String tenkhachhang;

    private Integer idLoaiNganSach;
}
