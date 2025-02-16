package br.koakovski.project_manager_api.services.task;

import org.springframework.stereotype.Service;

import br.koakovski.project_manager_api.controllers.dtos.task.TaskUpdateDTO;
import br.koakovski.project_manager_api.entities.ProjectEntity;
import br.koakovski.project_manager_api.entities.TaskEntity;
import br.koakovski.project_manager_api.entities.UserEntity;
import br.koakovski.project_manager_api.exceptions.project.ProjectNotFoundException;
import br.koakovski.project_manager_api.exceptions.task.TaskNotFoundException;
import br.koakovski.project_manager_api.exceptions.user.UserNotFoundException;
import br.koakovski.project_manager_api.repositories.ProjectRepository;
import br.koakovski.project_manager_api.repositories.TaskRepository;
import br.koakovski.project_manager_api.repositories.UserRepository;

@Service
public class TaskUpdateService {
    private final TaskRepository taskRepository;
    private final UserRepository userRepository;
    private final ProjectRepository projectRepository;

    public TaskUpdateService(
            TaskRepository taskRepository,
            UserRepository userRepository,
            ProjectRepository projectRepository) {
        this.taskRepository = taskRepository;
        this.userRepository = userRepository;
        this.projectRepository = projectRepository;
    }

    public TaskEntity execute(Integer taskId, TaskUpdateDTO params) {
        fetchUser(params);
        fetchProject(params);

        TaskEntity task = taskRepository.findById(taskId)
                .orElseThrow(() -> new TaskNotFoundException());

        params.getTitle().ifPresent(task::setTitle);
        params.getStartDate().ifPresent(task::setStartDate);
        params.getEndDate().ifPresent(task::setEndDate);
        params.getHours().ifPresent(task::setHours);
        params.getUserId().ifPresent(task::setUserId);
        params.getProjectId().ifPresent(task::setProjectId);

        return taskRepository.save(task);
    }

    private UserEntity fetchUser(TaskUpdateDTO params) {
        if (!params.getUserId().isPresent())
            return null;

        return userRepository.findById(params.getUserId().get())
                .orElseThrow(() -> new UserNotFoundException());
    }

    private ProjectEntity fetchProject(TaskUpdateDTO params) {
        if (!params.getProjectId().isPresent())
            return null;

        return projectRepository.findById(params.getProjectId().get())
                .orElseThrow(() -> new ProjectNotFoundException());
    }
}
