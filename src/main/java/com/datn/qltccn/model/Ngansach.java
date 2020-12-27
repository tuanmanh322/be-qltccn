package com.datn.qltccn.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

@Data
@Entity
@Table(name = "ngansach")
public class Ngansach implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", insertable = false, nullable = false)
    private Integer id;

    @Column(name = "id_ngansach")
    private Integer idNgansach;

    @Column(name = "id_user")
    private Integer idUser;

    @Column(name = "id_loaingansach")
    private String idLoaiNganSach;

    @Column(name = "loaitien")
    private String loaitien;

    @Column(name = "ngaytao")
    private LocalDateTime ngaytao;

    @Column(name = "vonglap")
    private String vonglap;

    @Column(name = "sotien")
    private String sotien;

    
}