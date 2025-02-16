package br.koakovski.project_manager_api.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.koakovski.project_manager_api.controllers.dtos.task.TaskCreateDTO;
import br.koakovski.project_manager_api.controllers.dtos.task.TaskUpdateDTO;

import br.koakovski.project_manager_api.services.task.TaskCreateService;
import br.koakovski.project_manager_api.services.task.TaskDeleteService;
import br.koakovski.project_manager_api.services.task.TaskFindAllService;
import br.koakovski.project_manager_api.services.task.TaskFindOneService;
import br.koakovski.project_manager_api.services.task.TaskUpdateService;

import br.koakovski.project_manager_api.entities.TaskEntity;

@RestController
@RequestMapping("/tasks")
public class TaskController {
    private final TaskFindOneService taskFindOneService;
    private final TaskFindAllService taskFindAllService;
    private final TaskCreateService taskCreateService;
    private final TaskUpdateService taskUpdateService;
    private final TaskDeleteService taskDeleteService;

    public TaskController(
            TaskFindOneService taskFindOneService,
            TaskFindAllService taskFindAllService,
            TaskCreateService taskCreateService,
            TaskUpdateService taskUpdateService,
            TaskDeleteService taskDeleteService) {
        this.taskFindOneService = taskFindOneService;
        this.taskFindAllService = taskFindAllService;
        this.taskCreateService = taskCreateService;
        this.taskUpdateService = taskUpdateService;
        this.taskDeleteService = taskDeleteService;
    }

    @GetMapping("/{taskId}")
    public ResponseEntity<TaskEntity> findOne(
            @PathVariable Integer taskId) {
        TaskEntity task = taskFindOneService.execute(taskId);

        return ResponseEntity.status(HttpStatus.OK).body(task);
    }

    @GetMapping()
    public ResponseEntity<List<TaskEntity>> findAll() {
        List<TaskEntity> tasks = taskFindAllService.execute();

        return ResponseEntity.status(HttpStatus.OK).body(tasks);
    }

    @PostMapping()
    public ResponseEntity<TaskEntity> create(
            @RequestBody TaskCreateDTO body) {

        TaskEntity task = taskCreateService.execute(body);

        return ResponseEntity.status(HttpStatus.CREATED).body(task);
    }

    @PutMapping("/{taskId}")
    public ResponseEntity<TaskEntity> update(
            @PathVariable Integer taskId,
            @RequestBody TaskUpdateDTO body) {
        TaskEntity task = taskUpdateService.execute(taskId, body);

        return ResponseEntity.status(HttpStatus.OK).body(task);
    }

    @DeleteMapping("/{taskId}")
    public ResponseEntity<Void> delete(
            @PathVariable Integer taskId) {
        taskDeleteService.execute(taskId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
