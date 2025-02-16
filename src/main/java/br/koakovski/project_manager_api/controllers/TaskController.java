package br.koakovski.project_manager_api.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.koakovski.project_manager_api.controllers.dtos.task.TaskCreateDTO;
import br.koakovski.project_manager_api.entities.TaskEntity;
import br.koakovski.project_manager_api.services.task.TaskCreateService;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    private final TaskCreateService taskCreateService;

    public TaskController(TaskCreateService taskCreateService) {
        this.taskCreateService = taskCreateService;
    }

    @PostMapping()
    public ResponseEntity<TaskEntity> create(
            @RequestBody TaskCreateDTO body) {

        TaskEntity task = taskCreateService.execute(body);

        return ResponseEntity.status(HttpStatus.CREATED).body(task);
    }
}
