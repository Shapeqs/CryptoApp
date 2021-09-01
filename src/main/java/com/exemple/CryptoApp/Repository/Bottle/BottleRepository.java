package com.exemple.CryptoApp.Repository.Bottle;

import com.exemple.CryptoApp.DTO.BottleDTO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BottleRepository {

    List<BottleDTO> findAll();

    BottleDTO findById(Integer id);

    void addNew(BottleDTO bottle);

    void modify(Integer id, BottleDTO bottle);

    void deleteById(Integer id);

    void deleteAll();

}
