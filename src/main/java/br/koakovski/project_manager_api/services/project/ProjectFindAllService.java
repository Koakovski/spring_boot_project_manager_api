package br.koakovski.project_manager_api.services.project;

import java.util.List;

import org.springframework.stereotype.Service;

import br.koakovski.project_manager_api.entities.ProjectEntity;
import br.koakovski.project_manager_api.repositories.ProjectRepository;

@Service
public class ProjectFindAllService {
    private final ProjectRepository projectRepository;

    public ProjectFindAllService(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    public List<ProjectEntity> execute() {
        return projectRepository.findAll();
    }
}
