package com.example.demo.base;

import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.util.Objects;
import java.util.UUID;

@MappedSuperclass //Não cria a tabela no banco
public abstract class BaseEntity {
    @Id
    private UUID id;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BaseEntity that = (BaseEntity) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public BaseEntity() {
        this.id = UUID.randomUUID();
    }

    public UUID getId() {
        return id;
    }
}
