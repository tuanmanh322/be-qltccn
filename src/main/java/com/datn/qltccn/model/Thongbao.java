package com.datn.qltccn.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@Table(name = "thongbao")
public class Thongbao implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", insertable = false, nullable = false)
    private Integer id;

    @Column(name = "idloaithongbao")
    private Integer idloaithongbao;

    @Column(name = "mota")
    private String mota;

    @Column(name = "ngaytao")
    private String ngaytao;

    @Column(name = "noidung")
    private String noidung;

    @Column(name = "trangthai")
    private String trangthai;

    
}