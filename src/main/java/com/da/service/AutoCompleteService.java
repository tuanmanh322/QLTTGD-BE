package com.da.service;

import com.da.dto.AutoCompleteContentSet;
import com.da.dto.AutoCompleteTitleSet;
import com.da.dto.AutocompleteSearchDTO;

import java.util.List;

public interface AutoCompleteService {
    List<AutoCompleteTitleSet> autoCompleteTitleBV(AutocompleteSearchDTO autocompleteSearchDTO);

    List<AutoCompleteTitleSet> autoCompleteTitleCD(AutocompleteSearchDTO autocompleteSearchDTO);

    List<AutoCompleteContentSet> autoCompleteContentBV(AutocompleteSearchDTO autocompleteSearchDTO);


    List<AutoCompleteContentSet> autoCompleteContentCD(AutocompleteSearchDTO autocompleteSearchDTO);

}
