package com.example.conectarestaurantes.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.Positive;

@Entity
@Table(name="orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String obra;
    @Column(nullable = false)
    private String gestor;
    @Column(nullable = false)
    private int qtd_Marmitas;

    @Column(nullable = true)
    private String status;

    public Order() {}

    public String getGestor() {
        return gestor;
    }

    public void setGestor(String gestor) {
        this.gestor = gestor;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getObra() {
        return obra;
    }

    public void setObra(String obra) {
        this.obra = obra;
    }

    public int getQtd_Marmitas() {
        return qtd_Marmitas;
    }

    public void setQtd_Marmitas(int qtd_Marmitas) {
        this.qtd_Marmitas = qtd_Marmitas;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }


    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", obra='" + obra + '\'' +
                ", gestor='" + gestor + '\'' +
                ", qtd_Marmitas=" + qtd_Marmitas +
                ", status='" + status + '\'' +
                '}';
    }

}
