package com.da.dao;

import com.da.dto.AutoCompleteTitleSet;
import com.da.dto.AutocompleteSearchDTO;

import java.io.Serializable;
import java.util.List;

public interface AutoCompleteDAO extends Serializable,BaseDAO {
    List<AutoCompleteTitleSet> searchTitleBV(AutocompleteSearchDTO autocompleteSearchDTO);

    List<AutoCompleteTitleSet> searchTitleCD(AutocompleteSearchDTO autocompleteSearchDTO);

}
