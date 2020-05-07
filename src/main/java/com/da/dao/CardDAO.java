package com.da.dao;

import com.da.dto.CardSearchDTO;

import java.io.Serializable;

public interface CardDAO extends Serializable,BaseDAO{
    void searchCard(CardSearchDTO cardSearchDTO);
}
