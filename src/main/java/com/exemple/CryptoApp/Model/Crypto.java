package com.exemple.CryptoApp.Model;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class Crypto implements Serializable {
    @Id
    private Integer id;

    private String name;
    private double priceUSD;
    private double priceEUR;

    public Crypto() {}

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
        return "Crypto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", priceUSD=" + priceUSD +
                ", priceEUR=" + priceEUR +
                '}';
    }
}
