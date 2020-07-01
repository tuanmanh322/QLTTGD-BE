package com.da.service;

import com.da.dto.ContactDTO;
import com.da.dto.ContactSearchDTO;

public interface ContactService {
    void AddContact(ContactDTO dto);

    void searchContact(ContactSearchDTO contactSearchDTO);

    void delete(Integer id);
}
