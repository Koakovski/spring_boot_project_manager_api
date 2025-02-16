package br.koakovski.project_manager_api.services.task;

import org.springframework.stereotype.Service;

import br.koakovski.project_manager_api.entities.TaskEntity;
import br.koakovski.project_manager_api.exceptions.task.TaskNotFoundException;
import br.koakovski.project_manager_api.repositories.TaskRepository;

@Service
public class TaskDeleteService {
    private final TaskRepository taskRepository;

    public TaskDeleteService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public void execute(Integer taskId) {
        fetchTask(taskId);
        taskRepository.deleteById(taskId);
    }

    private TaskEntity fetchTask(Integer taskId) {
        return taskRepository.findById(taskId)
                .orElseThrow(() -> new TaskNotFoundException());
    }
}
