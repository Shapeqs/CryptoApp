package com.exemple.CryptoApp.Service.Bottle;

import com.exemple.CryptoApp.DTO.BottleDTO;
import com.exemple.CryptoApp.Model.Bottle;
import com.exemple.CryptoApp.Repository.Bottle.BottleRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BottleServiceImpl implements BottleService {

    private Logger LOGGER = LoggerFactory.getLogger(BottleServiceImpl.class);

    @Autowired
    private BottleRepository bottleRepository;

    @Override
    public List<Bottle> findAll() {
        ArrayList<Bottle> bottles = new ArrayList<>();
        for (BottleDTO b : bottleRepository.findAll()) {
            bottles.add(transformDTOtoEntity(b));
        }
        return bottles;
    }

    @Override
    public Bottle findOne(Integer id) {
        return transformDTOtoEntity(bottleRepository.findById(id));
    }

    @Override
    public void deleteOne(Integer id) {
        bottleRepository.deleteById(id);
    }

    @Override
    public void deleteAll() {
        bottleRepository.deleteAll();
    }


    @Override
    public void addOne(Bottle b) {
        bottleRepository.addNew(transformEntitytoDTO(b));
    }

    @Override
    public void modifyOne(Integer id, Bottle b) {
        bottleRepository.modify(id, transformEntitytoDTO(b));
    }

    private Bottle transformDTOtoEntity(BottleDTO bottleDTO) {
        Bottle b = new Bottle();
        b.setId(bottleDTO.getId());
        b.setVintage(bottleDTO.getVintage());
        b.setPrice(bottleDTO.getPrice());
        b.setInfos(bottleDTO.getInfos());
        b.setColor(bottleDTO.getColor());
        b.setYear(bottleDTO.getYear());
        b.setQuantity(bottleDTO.getQuantity());
        b.setAlcool(bottleDTO.getAlcool());
        return b;
    }

    private BottleDTO transformEntitytoDTO(Bottle bottle) {
        return new BottleDTO(bottle.getId(),
                bottle.getVintage(), bottle.getPrice(),
                bottle.getInfos(), bottle.getColor(),
                bottle.getYear(), bottle.getQuantity(),
                bottle.getAlcool());
    }

}
