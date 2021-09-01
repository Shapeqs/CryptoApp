package com.exemple.CryptoApp.Service.Crypto;

import com.exemple.CryptoApp.DTO.CryptoDTO;
import com.exemple.CryptoApp.Model.Crypto;
import com.exemple.CryptoApp.Repository.Crypto.CryptoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CryptoServiceImpl implements CryptoService {

    private Logger LOGGER = LoggerFactory.getLogger(CryptoServiceImpl.class);

    @Autowired
    private CryptoRepository cryptoRepository;

    @Override
    public List<Crypto> findAll() {
        ArrayList<Crypto> cryptos = new ArrayList<>();
        for (CryptoDTO b : cryptoRepository.findAll()) {
            cryptos.add(transformDTOtoEntity(b));
        }
        return cryptos;
    }

    @Override
    public Crypto findOne(Integer id) {
        return transformDTOtoEntity(cryptoRepository.findById(id));
    }

    @Override
    public void deleteOne(Integer id) {
        cryptoRepository.deleteById(id);
    }

    @Override
    public void deleteAll() {
        cryptoRepository.deleteAll();
    }


    @Override
    public void addOne(Crypto b) {
        cryptoRepository.addNew(transformEntitytoDTO(b));
    }

    @Override
    public void modifyOne(Integer id, Crypto b) {
        cryptoRepository.modify(id, transformEntitytoDTO(b));
    }

    private Crypto transformDTOtoEntity(CryptoDTO cryptoDTO) {
        Crypto crypto = new Crypto();
        crypto.setId(cryptoDTO.getId());
        crypto.setName(cryptoDTO.getName());
        crypto.setPriceUSD(cryptoDTO.getPriceUSD());
        crypto.setPriceEUR(cryptoDTO.getPriceEUR());
        return crypto;
    }

    private CryptoDTO transformEntitytoDTO(Crypto crypto) {
        return new CryptoDTO(crypto.getId(),
                crypto.getName(), crypto.getPriceUSD(),
                crypto.getPriceEUR());
    }

}
