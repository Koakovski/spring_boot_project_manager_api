package br.koakovski.project_manager_api.services.user;

import java.util.List;

import org.springframework.stereotype.Service;

import br.koakovski.project_manager_api.entities.UserEntity;
import br.koakovski.project_manager_api.repositories.UserRepository;

@Service
public class UserFindAllService {
    private final UserRepository userRepository;

    public UserFindAllService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<UserEntity> execute() {
        return userRepository.findAll();
    }
}
