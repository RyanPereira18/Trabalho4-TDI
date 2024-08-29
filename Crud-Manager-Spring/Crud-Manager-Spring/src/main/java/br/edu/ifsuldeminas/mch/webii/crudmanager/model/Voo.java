package br.edu.ifsuldeminas.mch.webii.crudmanager.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "voos")
public class Voo {

    public Voo() {
    }

    public Voo(Integer id) {
        this.id = id;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @NotBlank(message = "O número do voo é obrigatório!")
    private String numero;

    @ManyToOne(optional = false)
    @NotNull(message = "O aeroporto de origem é obrigatório!")
    private Aeroporto origem;

    @ManyToOne(optional = false)
    @NotNull(message = "O aeroporto de destino é obrigatório!")
    private Aeroporto destino;

    @NotBlank(message = "A data de partida é obrigatória!")
    private String dataPartida;

    @NotBlank(message = "A data de chegada é obrigatória!")
    private String dataChegada;

    // Getters and Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public Aeroporto getOrigem() {
        return origem;
    }

    public void setOrigem(Aeroporto origem) {
        this.origem = origem;
    }

    public Aeroporto getDestino() {
        return destino;
    }

    public void setDestino(Aeroporto destino) {
        this.destino = destino;
    }

    public String getDataPartida() {
        return dataPartida;
    }

    public void setDataPartida(String dataPartida) {
        this.dataPartida = dataPartida;
    }

    public String getDataChegada() {
        return dataChegada;
    }

    public void setDataChegada(String dataChegada) {
        this.dataChegada = dataChegada;
    }

    // Override equals, hashCode, and toString methods
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Voo voo = (Voo) o;

        return id != null ? id.equals(voo.id) : voo.id == null;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Voo{" +
                "id=" + id +
                ", numero='" + numero + '\'' +
                ", origem=" + origem +
                ", destino=" + destino +
                ", dataPartida='" + dataPartida + '\'' +
                ", dataChegada='" + dataChegada + '\'' +
                '}';
    }
}