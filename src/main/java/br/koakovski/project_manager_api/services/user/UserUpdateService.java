package br.koakovski.project_manager_api.services.user;

import org.springframework.stereotype.Service;

import br.koakovski.project_manager_api.controllers.dtos.user.UserUpdateDTO;
import br.koakovski.project_manager_api.entities.UserEntity;
import br.koakovski.project_manager_api.exceptions.user.UserNotFoundException;
import br.koakovski.project_manager_api.repositories.UserRepository;

@Service
public class UserUpdateService {
    private final UserRepository userRepository;

    public UserUpdateService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserEntity execute(Integer userId, UserUpdateDTO params) {
        UserEntity user = fetchUser(userId);

        params.getName().ifPresent(user::setName);
        params.getResponsability().ifPresent(user::setResponsability);
        params.getFirm().ifPresent(user::setFirm);

        return userRepository.save(user);
    }

    private UserEntity fetchUser(Integer userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> new UserNotFoundException());
    }
}
