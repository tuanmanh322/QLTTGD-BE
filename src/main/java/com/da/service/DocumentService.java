package com.da.service;

import com.da.dto.DocumentDTO;
import com.da.dto.DocumentSearchDTO;
import com.da.model.Document;

import java.util.List;

public interface DocumentService {
    List<Document> getAll();

    void Add(DocumentDTO documentDTO);

    void edit(DocumentDTO documentDTO,  Integer idCD);

    void delete(Integer docID);

    void searchGetDocument(DocumentSearchDTO documentSearchDTO);
}
