package com.zakat.myapp.entity;

import com.zakat.myapp.entity.validation.CheckBaseOfSupply;
import com.zakat.myapp.entity.validation.CheckProducer;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

public class TempSupply {

    private int id;
    @NotBlank(message = "Field must be filled")
    private String material;
    private double quantity;
    private double price;
    private double sum;
    private String status;
    @Pattern(regexp = "\\d{4}-\\d{2}-\\d{2}", message = "Use pattern YYYY-DD-MM")
    private String date;
    private String commentary;
    @CheckProducer
    private String producerString;
    @CheckBaseOfSupply
    private String baseString;


    public TempSupply() {
    }

    public TempSupply(String material, double quantity, double price, double sum, String status, @Pattern(regexp = "\\d{4}-\\d{2}-\\d{2}", message = "Use pattern YYYY-DD-MM") String date, String commentary, String producerString, String baseString) {
        this.material = material;
        this.quantity = quantity;
        this.price = price;
        this.sum = sum;
        this.status = status;
        this.date = date;
        this.commentary = commentary;
        this.producerString = producerString;
        this.baseString = baseString;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getSum() {
        return sum;
    }

    public void setSum(double sum) {
        this.sum = sum;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getCommentary() {
        return commentary;
    }

    public void setCommentary(String commentary) {
        this.commentary = commentary;
    }

    public String getProducerString() {
        return producerString;
    }

    public void setProducerString(String producerString) {
        this.producerString = producerString;
    }

    public String getBaseString() {
        return baseString;
    }

    public void setBaseString(String baseString) {
        this.baseString = baseString;
    }
}
