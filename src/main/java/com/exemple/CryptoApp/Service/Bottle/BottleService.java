package com.exemple.CryptoApp.Service.Bottle;


import com.exemple.CryptoApp.Model.Bottle;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BottleService {

    List<Bottle> findAll();

    Bottle findOne(Integer id);

    void deleteOne(Integer id);

    void deleteAll();

    void addOne(Bottle b);

    void modifyOne(Integer id, Bottle b);

}
