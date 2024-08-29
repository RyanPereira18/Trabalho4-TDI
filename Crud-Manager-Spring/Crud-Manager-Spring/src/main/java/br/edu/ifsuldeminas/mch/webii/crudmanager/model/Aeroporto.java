package br.edu.ifsuldeminas.mch.webii.crudmanager.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "aeroportos")
public class Aeroporto {

    public Aeroporto() {
    }

    public Aeroporto(Integer id) {
        this.id = id;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @NotBlank(message = "O nome do aeroporto é obrigatório!")
    private String name;

    @NotBlank(message = "O código do aeroporto é obrigatório!")
    private String code;  // Pode ser um código IATA ou ICAO

    @NotBlank(message = "A localização é obrigatória!")
    private String location;

    @NotNull(message = "O número de terminais é obrigatório!")
    @Min(value = 1, message = "O número de terminais deve ser no mínimo 1")
    private Integer terminalCount;

    // Getters and Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Integer getTerminalCount() {
        return terminalCount;
    }

    public void setTerminalCount(Integer terminalCount) {
        this.terminalCount = terminalCount;
    }

    // Override equals, hashCode, and toString methods
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Aeroporto aeroporto = (Aeroporto) o;

        return id != null ? id.equals(aeroporto.id) : aeroporto.id == null;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Aeroporto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", code='" + code + '\'' +
                ", location='" + location + '\'' +
                ", terminalCount=" + terminalCount +
                '}';
    }
}