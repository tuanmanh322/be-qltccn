package com.datn.qltccn.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class ViDTO {
    private String description;

    private Integer id;

    private Integer idLoaiVi;

    private Integer idUser;

    private LocalDateTime modifiedDate;

    private String money;
}
