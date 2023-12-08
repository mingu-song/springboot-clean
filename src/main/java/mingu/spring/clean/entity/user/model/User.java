package mingu.spring.clean.entity.user.model;

import lombok.Getter;
import lombok.Setter;
import mingu.spring.clean.entity.AbstractEntity;

@Getter
@Setter
public abstract class User extends AbstractEntity<Long> {

    private String username;
    private String email;
    private String password;
    private String name;
    protected String role;
    private boolean enabled;

    public User(String username, String password, String name, String email) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.email = email;
        this.enabled = true;
    }

    public User() {
        this.enabled = true;
    }
}
