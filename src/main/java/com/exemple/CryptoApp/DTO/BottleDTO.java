package com.exemple.CryptoApp.DTO;

import com.exemple.CryptoApp.EnumUtils.Color;

import java.io.Serializable;

public class BottleDTO implements Serializable {

    private Integer id;
    private String vintage;
    private double price;
    private String infos;
    private Color color;
    private int year;
    private int quantity;
    private double alcool;

    public BottleDTO() {
    }

    public BottleDTO(Integer id,
                     String vintage,
                     double price,
                     String infos,
                     Color color,
                     int year,
                     int quantity,
                     double alcool) {
        this.id = id;
        this.vintage = vintage;
        this.price = price;
        this.infos = infos;
        this.color = color;
        this.year = year;
        this.quantity = quantity;
        this.alcool = alcool;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getVintage() {
        return vintage;
    }

    public void setVintage(String vintage) {
        this.vintage = vintage;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getInfos() {
        return infos;
    }

    public void setInfos(String infos) {
        this.infos = infos;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getAlcool() {
        return alcool;
    }

    public void setAlcool(double alcool) {
        this.alcool = alcool;
    }

    @Override
    public String toString() {
        return "BottleDTO{" +
                "id=" + id +
                ", name='" + vintage + '\'' +
                ", price=" + price +
                ", infos='" + infos + '\'' +
                ", color=" + color +
                ", year=" + year +
                ", quantity=" + quantity +
                ", alcool=" + alcool +
                '}';
    }
}
