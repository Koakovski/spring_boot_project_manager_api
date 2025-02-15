package br.koakovski.project_manager_api.controllers.dtos.user;

import lombok.Data;

@Data
public class UserCreateDTO {
    private String name;

    private String responsability;

    private String firm;
}
