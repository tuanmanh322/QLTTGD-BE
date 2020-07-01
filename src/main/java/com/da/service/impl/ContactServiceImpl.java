package com.da.service.impl;

import com.da.dao.ContactDAO;
import com.da.dto.ContactDTO;
import com.da.dto.ContactSearchDTO;
import com.da.model.Contact;
import com.da.repository.ContactRepository;
import com.da.service.ContactService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ContactServiceImpl implements ContactService {
    private final ContactRepository contactRepository;

    private final ModelMapper modelMapper;

    private final ContactDAO contactDAO;

    public ContactServiceImpl(ContactRepository contactRepository, ModelMapper modelMapper, ContactDAO contactDAO) {
        this.contactRepository = contactRepository;
        this.modelMapper = modelMapper;
        this.contactDAO = contactDAO;
    }

    @Override
    public void AddContact(ContactDTO dto) {
        Contact contact = modelMapper.map(dto, Contact.class);
        contactRepository.save(contact);
    }

    @Override
    public void searchContact(ContactSearchDTO contactSearchDTO) {
        contactDAO.searchContact(contactSearchDTO);
    }

    @Override
    public void delete(Integer id) {
        Contact contact = contactRepository.getOne(id);
        contactRepository.delete(contact);
    }
}
