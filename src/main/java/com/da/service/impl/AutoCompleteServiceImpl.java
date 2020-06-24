package com.da.service.impl;

import com.da.dao.AutoCompleteDAO;
import com.da.dto.AutoCompleteTitleSet;
import com.da.dto.AutocompleteSearchDTO;
import com.da.repository.BaivietRepository;
import com.da.service.AutoCompleteService;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class AutoCompleteServiceImpl implements AutoCompleteService {
    private Logger log = LoggerFactory.getLogger(AutoCompleteServiceImpl.class);

    private final AutoCompleteDAO autoCompleteDAO;

    private final BaivietRepository baivietRepository;

    private final ModelMapper modelMapper;

    public AutoCompleteServiceImpl(AutoCompleteDAO autoCompleteDAO, BaivietRepository baivietRepository, ModelMapper modelMapper) {
        this.autoCompleteDAO = autoCompleteDAO;
        this.baivietRepository = baivietRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<AutoCompleteTitleSet> autoCompleteTitleBV(AutocompleteSearchDTO autocompleteSearchDTO) {
        log.info(" start service to autoCompleteTitleBV with {}",autocompleteSearchDTO);
        return autoCompleteDAO.searchTitleBV(autocompleteSearchDTO);
    }
}
