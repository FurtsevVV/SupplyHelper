package com.zakat.myapp.entity;


import javax.persistence.*;
import javax.validation.constraints.NotBlank;


@Entity
@Table(name = "baseofsupply")
public class BaseOfSupply {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @NotBlank(message = "Not empty field!")
    @Column(name = "name_of_object")
    private String nameOfObject;
    @NotBlank(message = "Not empty field!")
    @Column(name = "customer")
    private String customer;

    public BaseOfSupply() {
    }

    public BaseOfSupply(String nameOfObject, String customer) {
        this.nameOfObject = nameOfObject;
        this.customer = customer;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameOfObject() {
        return nameOfObject;
    }

    public void setNameOfObject(String nameOfObject) {
        this.nameOfObject = nameOfObject;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }
}
