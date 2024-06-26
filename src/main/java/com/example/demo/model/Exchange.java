package com.example.demo.model;

import jakarta.persistence.*;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import java.util.List;

@Entity
public class Exchange {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "t")
    private String table;
    private String currency;
    private String code;
    @OneToMany
    @Cascade(CascadeType.ALL)
    private List<Rate> rates;

    public Exchange(Long id, String table, String currency, String code, List<Rate> rates) {
        this.id = id;
        this.table = table;
        this.currency = currency;
        this.code = code;
        this.rates = rates;
    }

    public Exchange() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTable() {
        return table;
    }

    public void setTable(String table) {
        this.table = table;
    }

    public void setRates(List<Rate> rates) {
        this.rates = rates;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public List<Rate> getRates() {
        return rates;
    }
}
