package com.datn.qltccn.dao;


import com.datn.qltccn.dto.AutoCompleteContentSet;
import com.datn.qltccn.dto.AutoCompleteTitleSet;
import com.datn.qltccn.dto.AutocompleteSearchDTO;

import java.io.Serializable;
import java.util.List;

public interface AutoCompleteDAO extends Serializable,BaseDAO {
    List<AutoCompleteTitleSet> searchTitleProduct(AutocompleteSearchDTO autocompleteSearchDTO);

    List<AutoCompleteTitleSet> searchTitleCD(AutocompleteSearchDTO autocompleteSearchDTO);

    List<AutoCompleteContentSet> searchContentBV(AutocompleteSearchDTO autocompleteSearchDTO);

    List<AutoCompleteContentSet> searchsearchContentCD(AutocompleteSearchDTO autocompleteSearchDTO);
}
