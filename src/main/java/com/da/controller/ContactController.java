package com.da.controller;

import com.da.dto.ContactDTO;
import com.da.dto.ContactSearchDTO;
import com.da.service.ContactService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/contact")
public class ContactController {
    private final ContactService contactService;

    public ContactController(ContactService contactService) {
        this.contactService = contactService;
    }

    @PostMapping("/search")
    public ResponseEntity<ContactSearchDTO> search(@RequestBody ContactSearchDTO contactSearchDTO) {
        contactService.searchContact(contactSearchDTO);
        return new ResponseEntity<>(contactSearchDTO, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Void> add(@RequestBody ContactDTO dto) {
        contactService.AddContact(dto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id")Integer idC) {
        contactService.delete(idC);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
