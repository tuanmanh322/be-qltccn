package com.datn.qltccn.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "loaithongbao")
@Data
public class Loaithongbao implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", insertable = false, nullable = false)
    private Integer id;

    @Column(name = "loaithongbao")
    private String loaithongbao;

    @Column(name = "tenloaithongbao")
    private String tenloaithongbao;

    @Column(name = "id_user")
    private int idUser;
}