package mingu.spring.clean.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public abstract class AbstractEntity<ID extends Serializable> implements Serializable {

    private ID id;

    @Override
    public String toString() {
        return "id = " + id;
    }
}
