package com.datn.qltccn.service;

import com.datn.qltccn.dto.AutoCompleteContentSet;
import com.datn.qltccn.dto.AutoCompleteTitleSet;
import com.datn.qltccn.dto.AutocompleteSearchDTO;

import java.util.List;

public interface AutoCompleteService {
    List<AutoCompleteTitleSet> autoCompleteTitleBV(AutocompleteSearchDTO autocompleteSearchDTO);

    List<AutoCompleteTitleSet> autoCompleteTitleCD(AutocompleteSearchDTO autocompleteSearchDTO);

    List<AutoCompleteContentSet> autoCompleteContentBV(AutocompleteSearchDTO autocompleteSearchDTO);


    List<AutoCompleteContentSet> autoCompleteContentCD(AutocompleteSearchDTO autocompleteSearchDTO);

    List<String> fetchTitleBV();
}
