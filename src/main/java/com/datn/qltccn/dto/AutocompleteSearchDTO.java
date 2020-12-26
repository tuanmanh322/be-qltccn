package com.datn.qltccn.dto;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Setter
@Getter
@ToString
public class AutocompleteSearchDTO {
    private String keyword;
    private List<String> excludeKeywords;
    private Integer idCD;
}
