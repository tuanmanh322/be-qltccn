package com.datn.qltccn.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "vi")
@Data
public class Vi implements Serializable {
    private static final long serialVersionUID = 1L;

    @Column(name = "description")
    private String description;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", insertable = false, nullable = false)
    private Integer id;

    @Column(name = "id_loai_vi")
    private Integer idLoaiVi;

    @Column(name = "id_user")
    private Integer idUser;

    @Column(name = "modified date")
    private LocalDateTime modifiedDate;

    @Column(name = "money")
    private String money;

    
}