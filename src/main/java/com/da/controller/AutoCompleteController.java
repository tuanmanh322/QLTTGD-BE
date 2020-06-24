package com.da.controller;

import com.da.dto.AutoCompleteTitleSet;
import com.da.dto.AutocompleteSearchDTO;
import com.da.service.AutoCompleteService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/auto-complete")
public class AutoCompleteController {
    private final Logger log = LoggerFactory.getLogger(AutoCompleteController.class);

    private final AutoCompleteService autoCompleteService;

    public AutoCompleteController(AutoCompleteService autoCompleteService) {
        this.autoCompleteService = autoCompleteService;
    }

    @PostMapping("/bv")
    public ResponseEntity<List<AutoCompleteTitleSet>> autoCompleteBV(@RequestBody AutocompleteSearchDTO autocompleteSearchDTO) {
        log.info(" start rest  to autoCompleteBV with :{}", autocompleteSearchDTO);
        return new ResponseEntity<>(autoCompleteService.autoCompleteTitleBV(autocompleteSearchDTO), HttpStatus.OK);
    }

    @PostMapping("/cd")
    public ResponseEntity<List<AutoCompleteTitleSet>> autoCompleteCD(@RequestBody AutocompleteSearchDTO autocompleteSearchDTO) {
        log.info(" start rest  to autoCompleteCD with :{}", autocompleteSearchDTO);
        return new ResponseEntity<>(autoCompleteService.autoCompleteTitleBV(autocompleteSearchDTO), HttpStatus.OK);
    }
}
