package com.da.service;

import com.da.dto.CardDTO;
import com.da.dto.CardSearchDTO;
import com.da.exception.ResultException;

public interface CardService {
    void searchCard(CardSearchDTO dto);
    void add(CardDTO dto) throws ResultException;
    void update(CardDTO dto)throws ResultException;
    void delete(Integer id)throws ResultException;
    CardDTO findById(Integer id);
}
