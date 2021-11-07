package com.zakat.myapp.entity;


import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.util.Map;

@Entity
@Table (name = "supply")
public class Supply {

    @Id
    @Column(name= "id")
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;
    @NotBlank(message = "Field must be filled")
    @Column(name = "material")
    private String material;
    @Column(name="quantity")
    private double quantity;
    @Column(name = "price")
    private double price;
    @Column(name = "sum")
    private double sum;
    @Column(name = "statussup")
    private String status;
    @Pattern(regexp = "\\d{4}-\\d{2}-\\d{2}", message = "Use pattern YYYY-MM-DD")
    @Column(name = "date_of_supply")
    private String date;
    @Column(name = "commentary")
    private String commentary;



    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.DETACH, CascadeType.MERGE})
     private Producer producer;


     @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.DETACH, CascadeType.MERGE})
    private BaseOfSupply baseOfSupply;


    public Supply() {
    }

    public Supply(String material, double quantity, double price, double sum, String status, String date, String commentary) {
        this.material = material;
        this.quantity = quantity;
        this.price = price;
        this.sum = sum;
        this.status = status;
        this.date = date;
        this.commentary = commentary;
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

    public Producer getProducer() {
        return producer;
    }

        public void setProducer(Producer producer) {
        this.producer = producer;
    }

    public BaseOfSupply getBaseOfSupply() {
        return baseOfSupply;
    }

    public void setBaseOfSupply(BaseOfSupply baseOfSupply) {
        this.baseOfSupply = baseOfSupply;
    }
}
