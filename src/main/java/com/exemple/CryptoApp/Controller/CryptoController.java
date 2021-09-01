package com.exemple.CryptoApp.Controller;

import com.exemple.CryptoApp.Model.Crypto;
import com.exemple.CryptoApp.Service.Crypto.CryptoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Cryptos")
public class CryptoController {

    private final Logger LOGGER = LoggerFactory.getLogger(CryptoController.class);

    @Autowired
    private CryptoService cryptoService;

    @GetMapping
    public List<Crypto> getAll() {
        return cryptoService.findAll();
    }

    @GetMapping("/{id}")
    public Crypto getOne(@PathVariable Integer id) {
        return cryptoService.findOne(id);
    }

    @DeleteMapping("/{id}")
    public void deleteBottle(@PathVariable Integer id) {
        cryptoService.deleteOne(id);
    }

    @DeleteMapping()
    public void deleteBottles() {
        cryptoService.deleteAll();
    }

    @PutMapping("/{id}")
    public void modifyBottle(@PathVariable Integer id, @RequestBody Crypto b) {
        cryptoService.modifyOne(id, b);
    }

    @PostMapping
    public void addBottle(@RequestBody Crypto b) {
        cryptoService.addOne(b);
    }

}
