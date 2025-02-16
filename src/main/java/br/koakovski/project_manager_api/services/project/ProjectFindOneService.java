package br.koakovski.project_manager_api.services.project;

import org.springframework.stereotype.Service;

import br.koakovski.project_manager_api.entities.ProjectEntity;
import br.koakovski.project_manager_api.exceptions.project.ProjectNotFoundException;
import br.koakovski.project_manager_api.repositories.ProjectRepository;

@Service
public class ProjectFindOneService {
    private final ProjectRepository projectRepository;

    public ProjectFindOneService(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    public ProjectEntity execute(Integer projectId) {
        return projectRepository.findById(projectId).orElseThrow(() -> new ProjectNotFoundException());
    }
}
