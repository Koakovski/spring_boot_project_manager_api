package br.koakovski.project_manager_api.services.user;

import org.springframework.stereotype.Service;

import br.koakovski.project_manager_api.entities.UserEntity;
import br.koakovski.project_manager_api.exceptions.user.UserNotFoundException;
import br.koakovski.project_manager_api.repositories.UserRepository;

@Service
public class UserFindOneService {
    private final UserRepository userRepository;

    public UserFindOneService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserEntity execute(Integer userId) {
        return userRepository.findById(userId).orElseThrow(() -> new UserNotFoundException());
    }
}
