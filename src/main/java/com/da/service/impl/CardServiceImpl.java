package com.da.service.impl;

import com.da.dao.CardDAO;
import com.da.dto.CardDTO;
import com.da.dto.CardSearchDTO;
import com.da.exception.ErrorCode;
import com.da.exception.ResultException;
import com.da.model.The;
import com.da.service.CardService;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Service
@Transactional
public class CardServiceImpl implements CardService {
    private final Logger log = LoggerFactory.getLogger(CardServiceImpl.class);

    private final ModelMapper modelMap;

    private final CardDAO cardDao;

    public CardServiceImpl(ModelMapper modelMap, CardDAO cardDao) {
        super();
        this.modelMap = modelMap;
        this.cardDao = cardDao;
    }

    @Override
    public void searchCard(CardSearchDTO dto) {
        log.info(" start service to searchCard with :{}",dto);
        cardDao.searchCard(dto);
    }

    @Override
    public void add(CardDTO dto) throws ResultException {
        log.info(" start service to addCardwith :{}",dto);
        The card = modelMap.map(dto, The.class);
        card.setNgaycap(new Date());
        cardDao.save(card);
    }

    @Override
    public void update(CardDTO dto) throws ResultException {
        log.info(" start service to update with :{}",dto);
        The card = cardDao.findById(dto.getId(), The.class).get();
        if (card.getId() == null) {
            throw new ResultException(ErrorCode.RECORD_NOT_EXISTED);
        }
        card = modelMap.map(dto, The.class);
        cardDao.update(card);
    }

    @Override
    public void delete(Integer id) throws ResultException {
        log.info(" start service to delete with :{}",id);
        The card = cardDao.findById(id, The.class).get();
        if (card.getId() == null) {
            throw new ResultException(ErrorCode.RECORD_NOT_EXISTED);
        }
        cardDao.delete(card);
    }

    @Override
    public CardDTO findById(Integer id) {
        The card = cardDao.findById(id, The.class).get();
        CardDTO dto = modelMap.map(card, CardDTO.class);
        return dto;
    }
}
