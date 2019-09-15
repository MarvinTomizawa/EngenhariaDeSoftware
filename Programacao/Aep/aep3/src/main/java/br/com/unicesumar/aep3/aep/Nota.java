package br.com.unicesumar.aep3.aep;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

@Entity
@Table(name = "nota")
public class Nota {
    @Id
    private String id = UUID.randomUUID().toString();

    @Column
    private float value;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public float getValue() {
        return value;
    }

    public void setValue(float nota) {
        if(nota < 0 || nota > 10){
            throw new RuntimeException("Nota invalida");
        }

        this.value = nota;
    }
}
