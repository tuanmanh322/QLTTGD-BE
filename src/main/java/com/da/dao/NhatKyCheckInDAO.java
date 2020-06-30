package com.da.dao;

import com.da.dto.NhatKySearchDTO;

import java.io.Serializable;

public interface NhatKyCheckInDAO extends Serializable, BaseDAO {
    void searchNk(NhatKySearchDTO nhatKySearchDTO);
}
