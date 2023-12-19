package mingu.spring.clean.infrastructure.config.db.schema;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(discriminatorType = DiscriminatorType.STRING)
@Table(name = "Userz")
public abstract class UserSchema extends AbstractEntitySchema<Long> {
    @NotBlank
    @Column(length = 20, unique = true)
    private String username;

    @NotBlank
    @Column(nullable = false, length = 40, unique = true)
    private String email;

    @NotBlank
    @Column(nullable = false, length = 64)
    private String password;

    @NotBlank
    @Column(nullable = false, length = 60)
    private String name;

    @NotBlank
    @Column(nullable = false, length = 20)
    protected String role;

    @Column(nullable = false)
    private boolean enabled;

    public UserSchema(String username, String password, String name, String email) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.email = email;
        this.enabled = true;
    }

    public UserSchema() {
        this.enabled = true;
    }

    public UserSchema(Long id, String username, String name, String email, String password) {
        this.setId(id);
        this.name = name;
        this.email = email;
        this.password = password;
        this.username = username;

    }
}
