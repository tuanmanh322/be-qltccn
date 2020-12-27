package com.datn.qltccn.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "thunhap")
public class Thunhap implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", insertable = false, nullable = false)
    private Integer id;

    @Column(name = "id_thunhap")
    private Integer idThunhap;

    @Column(name = "id_user")
    private Integer idUser;

    @Column(name = "kihan")
    private String kihan;

    @Column(name = "loaitien")
    private String loaitien;

    @Column(name = "mota")
    private String mota;

    @Column(name = "ngaytao")
    private LocalDateTime ngaytao;

    @Column(name = "sotien")
    private String sotien;

    
}