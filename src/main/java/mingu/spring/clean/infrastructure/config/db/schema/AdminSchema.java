package mingu.spring.clean.infrastructure.config.db.schema;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import mingu.spring.clean.entity.admin.model.Admin;

@Entity
@Table(name = "Admin")
public class AdminSchema extends UserSchema{

    public AdminSchema() {
        this.role = "ROLE_ADMIN";
    }

    public AdminSchema(Admin admin) {
        super(admin.getId(), admin.getUsername(), admin.getName(), admin.getEmail(), admin.getPassword());
        this.role = "ROLE_ADMIN";
    }

    public Admin toAdmin() {
        Admin admin = new Admin (this.getUsername(), this.getPassword(), this.getName(), this.getEmail());
        admin.setId(this.getId());
        return admin;
    }
}
