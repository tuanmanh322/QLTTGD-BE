package com.da.service.impl;

import com.da.dao.DocumentDAO;
import com.da.dto.DocumentDTO;
import com.da.dto.DocumentSearchDTO;
import com.da.model.Document;
import com.da.repository.DocumentRepository;
import com.da.security.SecurityUtils;
import com.da.service.DocumentService;
import com.da.service.FileStorageService;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class DocumentServiceImpl implements DocumentService {
    private final Logger log = LoggerFactory.getLogger(DocumentServiceImpl.class);

    private final DocumentRepository documentRepository;

    private final ModelMapper modelMapper;

    private final FileStorageService fileStorageService;

    private final DocumentDAO documentDAO;

    public DocumentServiceImpl(DocumentRepository documentRepository, ModelMapper modelMapper, FileStorageService fileStorageService, DocumentDAO documentDAO) {
        this.documentRepository = documentRepository;
        this.modelMapper = modelMapper;
        this.fileStorageService = fileStorageService;
        this.documentDAO = documentDAO;
    }

    @Override
    public List<Document> getAll() {
        return documentRepository.findAll();
    }

    @Override
    public void Add(DocumentDTO documentDTO) {
        log.info(" start service to Add document by documentDTO :{}",documentDTO);
        Document document = modelMapper.map(documentDTO,Document.class);
        if (documentDTO.getFileDocument() !=null){
            try {
                document.setLinkDownload(fileStorageService.storeFile(documentDTO.getFileDocument()));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        document.setCreatedDate(LocalDateTime.now());
        documentRepository.save(document);
    }

    @Override
    public void edit(DocumentDTO documentDTO, Integer idCD) {
        log.info(" start service to edit document by documentDTO :{}",documentDTO);
        Optional<Document> document = documentRepository.findById(idCD);
        if (document.isPresent()){
            Document doc = document.get();
            doc = modelMapper.map(documentDTO,Document.class);
            if (documentDTO.getFileDocument() !=null){
                try {
                    doc.setLinkDownload(fileStorageService.storeFile(documentDTO.getFileDocument()));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            documentRepository.save(doc);
        }
    }

    @Override
    public void delete(Integer docID) {
        log.info(" start service to delete document by id :{}",docID);
        Optional<Document> document = documentRepository.findById(docID);
        if (document.isPresent()){
            documentRepository.delete(document.get());
        }
    }

    @Override
    public void searchGetDocument(DocumentSearchDTO documentSearchDTO) {
        log.info(" start service to searchGetDocument document by documentSearchDTO :{}",documentSearchDTO);
        documentDAO.searchDocument(documentSearchDTO, SecurityUtils.getCurrentUserIdLogin());
    }
}
