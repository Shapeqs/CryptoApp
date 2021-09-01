package com.exemple.CryptoApp.Service.Crypto;


import com.exemple.CryptoApp.Model.Crypto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CryptoService {

    List<Crypto> findAll();

    Crypto findOne(Integer id);

    void deleteOne(Integer id);

    void deleteAll();

    void addOne(Crypto b);

    void modifyOne(Integer id, Crypto b);

}
