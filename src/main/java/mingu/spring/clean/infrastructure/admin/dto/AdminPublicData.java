package mingu.spring.clean.infrastructure.admin.dto;

import mingu.spring.clean.entity.admin.model.Admin;
import mingu.spring.clean.usecase.admin.dto.IAdminPublicData;

public record AdminPublicData(
        String id, String username, String name, String email
) implements IAdminPublicData {
    public AdminPublicData(Admin admin) {
        this(admin.getId().toString(), admin.getUsername(), admin.getName(), admin.getEmail());
    }
}


