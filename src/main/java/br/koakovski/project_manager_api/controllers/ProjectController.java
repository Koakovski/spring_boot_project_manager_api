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

import br.koakovski.project_manager_api.services.project.ProjectCreateService;
import br.koakovski.project_manager_api.services.project.ProjectDeleteService;
import br.koakovski.project_manager_api.services.project.ProjectFindAllService;
import br.koakovski.project_manager_api.services.project.ProjectFindOneService;
import br.koakovski.project_manager_api.services.project.ProjectUpdateService;

import br.koakovski.project_manager_api.controllers.dtos.project.ProjectCreateDTO;
import br.koakovski.project_manager_api.controllers.dtos.project.ProjectUpdateDTO;

import br.koakovski.project_manager_api.entities.ProjectEntity;

@RestController
@RequestMapping("/projects")
public class ProjectController {
    private final ProjectFindOneService projectFindOneService;
    private final ProjectFindAllService projectFindAllService;
    private final ProjectCreateService projectCreateService;
    private final ProjectUpdateService projectUpdateService;
    private final ProjectDeleteService projectDeleteService;

    public ProjectController(
            ProjectFindOneService projectFindOneService,
            ProjectFindAllService projectFindAllService,
            ProjectCreateService projectCreateService,
            ProjectUpdateService projectUpdateService,
            ProjectDeleteService projectDeleteService) {
        this.projectFindOneService = projectFindOneService;
        this.projectFindAllService = projectFindAllService;
        this.projectCreateService = projectCreateService;
        this.projectUpdateService = projectUpdateService;
        this.projectDeleteService = projectDeleteService;
    }

    @GetMapping("/{projectId}")
    public ResponseEntity<ProjectEntity> findOne(
            @PathVariable Integer projectId) {
        ProjectEntity project = projectFindOneService.execute(projectId);

        return ResponseEntity.status(HttpStatus.OK).body(project);
    }

    @GetMapping()
    public ResponseEntity<List<ProjectEntity>> findAll() {
        List<ProjectEntity> tasks = projectFindAllService.execute();

        return ResponseEntity.status(HttpStatus.OK).body(tasks);
    }

    @PostMapping()
    public ResponseEntity<ProjectEntity> create(
            @RequestBody ProjectCreateDTO body) {

        ProjectEntity project = projectCreateService.execute(body);

        return ResponseEntity.status(HttpStatus.CREATED).body(project);
    }

    @PutMapping("/{projectId}")
    public ResponseEntity<ProjectEntity> update(
            @PathVariable Integer projectId,
            @RequestBody ProjectUpdateDTO body) {
        ProjectEntity project = projectUpdateService.execute(projectId, body);

        return ResponseEntity.status(HttpStatus.OK).body(project);
    }

    @DeleteMapping("/{projectId}")
    public ResponseEntity<Void> delete(
            @PathVariable Integer projectId) {
        projectDeleteService.execute(projectId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
