package br.koakovski.project_manager_api.services.project;

import org.springframework.stereotype.Service;

import br.koakovski.project_manager_api.controllers.dtos.project.ProjectCreateDTO;
import br.koakovski.project_manager_api.entities.ProjectEntity;
import br.koakovski.project_manager_api.repositories.ProjectRepository;

@Service
public class ProjectCreateService {
    private final ProjectRepository projectRepository;

    public ProjectCreateService(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    public ProjectEntity execute(ProjectCreateDTO params) {
        ProjectEntity project = new ProjectEntity();
        project.setStartDate(params.getStartDate());
        project.setEndDate(params.getEndDate());
        project.setHours(params.getHours());
        project.setArtifact(params.getArtifact());

        return projectRepository.save(project);
    }
}
