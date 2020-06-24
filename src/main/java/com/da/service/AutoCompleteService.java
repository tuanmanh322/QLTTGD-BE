package com.da.service;

import com.da.dto.AutoCompleteTitleSet;
import com.da.dto.AutocompleteSearchDTO;

import java.util.List;

public interface AutoCompleteService {
    List<AutoCompleteTitleSet> autoCompleteTitleBV(AutocompleteSearchDTO autocompleteSearchDTO);
}
