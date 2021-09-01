package com.exemple.CryptoApp.Repository.Crypto;

import com.exemple.CryptoApp.DTO.CryptoDTO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CryptoRepository {

    List<CryptoDTO> findAll();

    CryptoDTO findById(Integer id);

    void addNew(CryptoDTO bottle);

    void modify(Integer id, CryptoDTO bottle);

    void deleteById(Integer id);

    void deleteAll();

}
