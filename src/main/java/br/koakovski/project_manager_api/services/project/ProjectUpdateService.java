package br.koakovski.project_manager_api.services.project;

import org.springframework.stereotype.Service;

import br.koakovski.project_manager_api.controllers.dtos.project.ProjectUpdateDTO;
import br.koakovski.project_manager_api.entities.ProjectEntity;
import br.koakovski.project_manager_api.exceptions.project.ProjectNotFoundException;
import br.koakovski.project_manager_api.repositories.ProjectRepository;

@Service
public class ProjectUpdateService {
    private final ProjectRepository projectRepository;

    public ProjectUpdateService(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    public ProjectEntity execute(Integer projectId, ProjectUpdateDTO params) {
        ProjectEntity project = fetchProject(projectId);

        params.getStartDate().ifPresent(project::setStartDate);
        params.getEndDate().ifPresent(project::setEndDate);
        params.getHours().ifPresent(project::setHours);
        params.getArtifact().ifPresent(project::setArtifact);

        return projectRepository.save(project);
    }

    private ProjectEntity fetchProject(Integer projectId) {
        return projectRepository.findById(projectId)
                .orElseThrow(() -> new ProjectNotFoundException());
    }
}
