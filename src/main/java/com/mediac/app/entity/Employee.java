package com.mediac.app.entity;


//javax.persistence 가 jpa의 핵심 interface라는데? 내가 spring . data. annotation과 둘중에 무엇을 import 해야할까
import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Version;

public class Employee {

    private @Id
    @GeneratedValue Long id;
    private String firstname;
    private String lastname;
    private String description;

    private @Version @JsonIgnore Long version;

    private @ManyToOne Manager manager;

    private Employee() {}

    public Employee(String firstname, String lastname, String description, Manager manager) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.description = description;
        this.manager = manager;
    }
}
