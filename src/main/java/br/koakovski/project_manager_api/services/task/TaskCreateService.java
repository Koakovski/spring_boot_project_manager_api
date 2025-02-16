package br.koakovski.project_manager_api.services.task;

import org.springframework.stereotype.Service;

import br.koakovski.project_manager_api.controllers.dtos.task.TaskCreateDTO;
import br.koakovski.project_manager_api.entities.ProjectEntity;
import br.koakovski.project_manager_api.entities.TaskEntity;
import br.koakovski.project_manager_api.entities.UserEntity;
import br.koakovski.project_manager_api.exceptions.project.ProjectNotFoundException;
import br.koakovski.project_manager_api.exceptions.user.UserNotFoundException;
import br.koakovski.project_manager_api.repositories.ProjectRepository;
import br.koakovski.project_manager_api.repositories.TaskRepository;
import br.koakovski.project_manager_api.repositories.UserRepository;

@Service
public class TaskCreateService {
    private final TaskRepository taskRepository;
    private final UserRepository userRepository;
    private final ProjectRepository projectRepository;

    public TaskCreateService(
            TaskRepository taskRepository,
            UserRepository userRepository,
            ProjectRepository projectRepository) {
        this.taskRepository = taskRepository;
        this.userRepository = userRepository;
        this.projectRepository = projectRepository;
    }

    public TaskEntity execute(TaskCreateDTO params) {
        fetchUser(params);
        fetchProject(params);

        TaskEntity task = generateEntity(params);
        return taskRepository.save(task);
    }

    private UserEntity fetchUser(TaskCreateDTO params) {
        return userRepository.findById(params.getUserId())
                .orElseThrow(() -> new UserNotFoundException());
    }

    private ProjectEntity fetchProject(TaskCreateDTO params) {
        return projectRepository.findById(params.getProjectId())
                .orElseThrow(() -> new ProjectNotFoundException());
    }

    private TaskEntity generateEntity(TaskCreateDTO params) {
        TaskEntity task = new TaskEntity();
        task.setTitle(params.getTitle());
        task.setStartDate(params.getStartDate());
        task.setEndDate(params.getEndDate());
        task.setHours(params.getHours());
        task.setUserId(params.getUserId());
        task.setProjectId(params.getProjectId());
        return task;
    }
}
