package br.koakovski.project_manager_api.controllers.dtos.user;

import java.util.Optional;

public class UserUpdateDTO {
    private Optional<String> name = Optional.empty();
    private Optional<String> responsability = Optional.empty();
    private Optional<String> firm = Optional.empty();

    public Optional<String> getName() {
        return name;
    }

    public void setName(String name) {
        this.name = Optional.ofNullable(name);
    }

    public Optional<String> getResponsability() {
        return responsability;
    }

    public void setResponsability(String responsability) {
        this.responsability = Optional.ofNullable(responsability);
    }

    public Optional<String> getFirm() {
        return firm;
    }

    public void setFirm(String firm) {
        this.firm = Optional.ofNullable(firm);
    }
}
