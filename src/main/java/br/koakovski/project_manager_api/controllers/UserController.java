package br.koakovski.project_manager_api.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.koakovski.project_manager_api.controllers.dtos.user.UserCreateDTO;
import br.koakovski.project_manager_api.controllers.dtos.user.UserUpdateDTO;
import br.koakovski.project_manager_api.entities.UserEntity;
import br.koakovski.project_manager_api.services.user.UserCreateService;
import br.koakovski.project_manager_api.services.user.UserDeleteService;
import br.koakovski.project_manager_api.services.user.UserFindAllService;
import br.koakovski.project_manager_api.services.user.UserFindOneService;
import br.koakovski.project_manager_api.services.user.UserUpdateService;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserFindOneService userFindOneService;
    private final UserFindAllService userFindAllService;
    private final UserCreateService userCreateService;
    private final UserUpdateService userUpdateService;
    private final UserDeleteService userDeleteService;

    public UserController(
            UserFindOneService userFindOneService,
            UserFindAllService userFindAllService,
            UserCreateService userCreateService,
            UserUpdateService userUpdateService,
            UserDeleteService userDeleteService) {
        this.userFindOneService = userFindOneService;
        this.userFindAllService = userFindAllService;
        this.userCreateService = userCreateService;
        this.userUpdateService = userUpdateService;
        this.userDeleteService = userDeleteService;
    }

    @GetMapping("/{userId}")
    public ResponseEntity<UserEntity> findOne(
            @PathVariable Integer userId) {
        UserEntity user = userFindOneService.execute(userId);

        return ResponseEntity.status(HttpStatus.OK).body(user);
    }

    @GetMapping()
    public ResponseEntity<List<UserEntity>> findAll() {
        List<UserEntity> users = userFindAllService.execute();

        return ResponseEntity.status(HttpStatus.OK).body(users);
    }

    @PostMapping()
    public ResponseEntity<UserEntity> create(
            @RequestBody UserCreateDTO body) {

        UserEntity user = userCreateService.execute(body);

        return ResponseEntity.status(HttpStatus.CREATED).body(user);
    }

    @PutMapping("/{userId}")
    public ResponseEntity<UserEntity> update(
            @PathVariable Integer userId,
            @RequestBody UserUpdateDTO body) {
        UserEntity user = userUpdateService.execute(userId, body);

        return ResponseEntity.status(HttpStatus.OK).body(user);
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<Void> delete(
            @PathVariable Integer userId) {
        userDeleteService.execute(userId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
