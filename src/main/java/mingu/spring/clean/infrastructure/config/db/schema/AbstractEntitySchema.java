package mingu.spring.clean.infrastructure.config.db.schema;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@EqualsAndHashCode
@MappedSuperclass
public abstract class AbstractEntitySchema<ID extends Serializable> implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private ID id;

    @Override
    public String toString() {
        return "id=" + id;
    }
}
