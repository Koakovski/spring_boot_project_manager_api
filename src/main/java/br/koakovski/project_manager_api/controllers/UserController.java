package br.koakovski.project_manager_api.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.koakovski.project_manager_api.controllers.dtos.user.UserCreateDTO;
import br.koakovski.project_manager_api.entities.UserEntity;
import br.koakovski.project_manager_api.services.user.UserCreateService;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserCreateService userCreateService;

    public UserController(UserCreateService userCreateService) {
        this.userCreateService = userCreateService;
    }

    @PostMapping()
    public ResponseEntity<UserEntity> create(
            @RequestBody UserCreateDTO body) {

        UserEntity user = userCreateService.execute(body);

        return ResponseEntity.status(HttpStatus.CREATED).body(user);
    }
}
