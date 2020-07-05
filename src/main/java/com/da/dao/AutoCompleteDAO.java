package com.da.dao;

import com.da.dto.AutoCompleteContentSet;
import com.da.dto.AutoCompleteTitleSet;
import com.da.dto.AutocompleteSearchDTO;

import java.io.Serializable;
import java.util.List;

public interface AutoCompleteDAO extends Serializable,BaseDAO {
    List<AutoCompleteTitleSet> searchTitleBV(AutocompleteSearchDTO autocompleteSearchDTO);

    List<AutoCompleteTitleSet> searchTitleCD(AutocompleteSearchDTO autocompleteSearchDTO);

    List<AutoCompleteContentSet> searchContentBV(AutocompleteSearchDTO autocompleteSearchDTO);

    List<AutoCompleteContentSet> searchsearchContentCD(AutocompleteSearchDTO autocompleteSearchDTO);
}
