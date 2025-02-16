package br.koakovski.project_manager_api.services.user;

import org.springframework.stereotype.Service;

import br.koakovski.project_manager_api.entities.UserEntity;
import br.koakovski.project_manager_api.exceptions.user.UserNotFoundException;
import br.koakovski.project_manager_api.repositories.UserRepository;

@Service
public class UserDeleteService {
    private final UserRepository userRepository;

    public UserDeleteService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void execute(Integer userId) {
        fetchUser(userId);
        userRepository.deleteById(userId);
    }

    private UserEntity fetchUser(Integer userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> new UserNotFoundException());
    }
}
