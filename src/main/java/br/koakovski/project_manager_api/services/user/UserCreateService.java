package br.koakovski.project_manager_api.services.user;

import org.springframework.stereotype.Service;

import br.koakovski.project_manager_api.controllers.dtos.user.UserCreateDTO;
import br.koakovski.project_manager_api.entities.UserEntity;
import br.koakovski.project_manager_api.repositories.UserRepository;

@Service
public class UserCreateService {
    private final UserRepository userRepository;

    public UserCreateService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserEntity execute(UserCreateDTO params) {
        UserEntity user = new UserEntity();
        user.setName(params.getName());
        user.setResponsability(params.getResponsability());
        user.setFirm(params.getFirm());

        return userRepository.save(user);
    }

}
