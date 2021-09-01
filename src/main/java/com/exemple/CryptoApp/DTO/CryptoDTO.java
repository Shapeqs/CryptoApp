package com.exemple.CryptoApp.DTO;

import java.io.Serializable;

public class CryptoDTO implements Serializable {

    private Integer id;
    private String name;
    private double priceUSD;
    private double priceEUR;

    public CryptoDTO() {
    }

    public CryptoDTO(Integer id, String name, double priceUSD, double priceEUR) {
        this.id = id;
        this.name = name;
        this.priceUSD = priceUSD;
        this.priceEUR = priceEUR;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPriceUSD() {
        return priceUSD;
    }

    public void setPriceUSD(double priceUSD) {
        this.priceUSD = priceUSD;
    }

    public double getPriceEUR() {
        return priceEUR;
    }

    public void setPriceEUR(double priceEUR) {
        this.priceEUR = priceEUR;
    }

    @Override
    public String toString() {
        return "CryptoDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", priceUSD=" + priceUSD +
                ", priceEUR=" + priceEUR +
                '}';
    }
}
