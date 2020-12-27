package com.datn.qltccn.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class ThuNhapDTO {
    private String tenkhachhang;

    private Integer id;

    private String sotien;

    private String loaitien;

    private String kihan;

    private LocalDateTime ngaytao;

    private String mota;

    private String username;
}
