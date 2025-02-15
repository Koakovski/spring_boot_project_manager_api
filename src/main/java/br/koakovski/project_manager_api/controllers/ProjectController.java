package br.koakovski.project_manager_api.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.koakovski.project_manager_api.controllers.dtos.project.ProjectCreateDTO;
import br.koakovski.project_manager_api.entities.ProjectEntity;
import br.koakovski.project_manager_api.services.project.ProjectCreateService;

@RestController
@RequestMapping("/projects")
public class ProjectController {
    private final ProjectCreateService projectCreateService;

    public ProjectController(ProjectCreateService projectCreateService) {
        this.projectCreateService = projectCreateService;
    }

    @PostMapping()
    public ResponseEntity<ProjectEntity> create(
            @RequestBody ProjectCreateDTO body) {

        ProjectEntity project = projectCreateService.execute(body);

        return ResponseEntity.status(HttpStatus.CREATED).body(project);
    }
}
