package br.koakovski.project_manager_api.services.task;

import org.springframework.stereotype.Service;

import br.koakovski.project_manager_api.entities.TaskEntity;
import br.koakovski.project_manager_api.exceptions.task.TaskNotFoundException;
import br.koakovski.project_manager_api.repositories.TaskRepository;

@Service
public class TaskFindOneService {
    private final TaskRepository taskRepository;

    public TaskFindOneService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public TaskEntity execute(Integer userId) {
        return taskRepository.findById(userId).orElseThrow(() -> new TaskNotFoundException());
    }
}
