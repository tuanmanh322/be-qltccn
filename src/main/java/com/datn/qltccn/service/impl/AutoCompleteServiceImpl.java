package com.datn.qltccn.service.impl;//package com.kl.jewelry.service.impl;
//
//import com.da.common.TitleFilter;
//import com.da.dao.AutoCompleteDAO;
//import com.da.dto.AutoCompleteContentSet;
//import com.da.dto.AutoCompleteTitleSet;
//import com.da.dto.AutocompleteSearchDTO;
//import com.da.repository.BaivietRepository;
//import com.da.service.AutoCompleteService;
//import com.kl.jewelry.dao.AutoCompleteDAO;
//import com.kl.jewelry.service.AutoCompleteService;
//import org.modelmapper.ModelMapper;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.util.List;
//
//@Service
//@Transactional
//public class AutoCompleteServiceImpl implements AutoCompleteService {
//    private Logger log = LoggerFactory.getLogger(AutoCompleteServiceImpl.class);
//
//    private final AutoCompleteDAO autoCompleteDAO;
//
//    private final BaivietRepository baivietRepository;
//
//    private final ModelMapper modelMapper;
//
//    public AutoCompleteServiceImpl(AutoCompleteDAO autoCompleteDAO, BaivietRepository baivietRepository, ModelMapper modelMapper) {
//        this.autoCompleteDAO = autoCompleteDAO;
//        this.baivietRepository = baivietRepository;
//        this.modelMapper = modelMapper;
//    }
//
//    @Override
//    public List<AutoCompleteTitleSet> autoCompleteTitleBV(AutocompleteSearchDTO autocompleteSearchDTO) {
//        log.info(" start service to autoCompleteTitleBV with {}",autocompleteSearchDTO);
//        return autoCompleteDAO.searchTitleBV(autocompleteSearchDTO);
//    }
//
//    @Override
//    public List<AutoCompleteTitleSet> autoCompleteTitleCD(AutocompleteSearchDTO autocompleteSearchDTO) {
//        log.info(" start service to autoCompleteTitleCD with {}",autocompleteSearchDTO);
//        return autoCompleteDAO.searchTitleCD(autocompleteSearchDTO);
//    }
//
//    @Override
//    public List<AutoCompleteContentSet> autoCompleteContentBV(AutocompleteSearchDTO autocompleteSearchDTO) {
//        log.info(" start service to autoCompleteContentBV with {}",autocompleteSearchDTO);
//        return autoCompleteDAO.searchContentBV(autocompleteSearchDTO);
//    }
//
//    @Override
//    public List<AutoCompleteContentSet> autoCompleteContentCD(AutocompleteSearchDTO autocompleteSearchDTO) {
//        log.info(" start service to autoCompleteContentCD with {}",autocompleteSearchDTO);
//        return autoCompleteDAO.searchsearchContentCD(autocompleteSearchDTO);
//    }
//
//    @Override
//    public List<String> fetchTitleBV() {
//        List<String> strings = TitleFilter.xauConChung(null,"b");
//        return null;
//    }
//}
