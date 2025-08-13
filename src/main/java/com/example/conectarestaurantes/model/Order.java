package com.example.conectarestaurantes.model;


import jakarta.persistence.*;

@Entity
@Table(name="orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String comida;
    @Column
    private String pedinde;


    public String getPedinde() {
        return pedinde;
    }

    public void setPedinde(String pedinde) {
        this.pedinde = pedinde;
    }

    public String getComida() {
        return comida;
    }

    public void setComida(String comida) {
        this.comida = comida;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
