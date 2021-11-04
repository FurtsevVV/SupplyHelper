package com.zakat.myapp.entity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Entity
@Table(name = "producer")
public class Producer {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotBlank(message = "Field must be filled")
    @Column(name = "name")
    private String name;
    @Column(name = "contact")
    private String contact;
    @Pattern(regexp = "\\d{1}-\\d{3}-\\d{3}-\\d{4}", message = "Use pattern X-XXX-XXX-XXXX")
    @Column(name = "phone")
    private String phone;

    public Producer() {
    }

    public Producer(String name, String contact, String phone) {
        this.name = name;
        this.contact = contact;
        this.phone = phone;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
