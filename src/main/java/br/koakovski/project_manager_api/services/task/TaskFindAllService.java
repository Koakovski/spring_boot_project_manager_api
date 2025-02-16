package br.koakovski.project_manager_api.services.task;

import java.util.List;

import org.springframework.stereotype.Service;

import br.koakovski.project_manager_api.entities.TaskEntity;
import br.koakovski.project_manager_api.repositories.TaskRepository;

@Service
public class TaskFindAllService {
    private final TaskRepository taskRepository;

    public TaskFindAllService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public List<TaskEntity> execute() {
        return taskRepository.findAll();
    }
}
