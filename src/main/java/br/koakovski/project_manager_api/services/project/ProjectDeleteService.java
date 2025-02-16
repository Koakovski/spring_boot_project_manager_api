package br.koakovski.project_manager_api.services.project;

import org.springframework.stereotype.Service;

import br.koakovski.project_manager_api.entities.ProjectEntity;
import br.koakovski.project_manager_api.exceptions.project.ProjectNotFoundException;
import br.koakovski.project_manager_api.repositories.ProjectRepository;

@Service
public class ProjectDeleteService {
    private final ProjectRepository projectRepository;

    public ProjectDeleteService(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    public void execute(Integer projectId) {
        fetchProject(projectId);
        projectRepository.deleteById(projectId);
    }

    private ProjectEntity fetchProject(Integer projectId) {
        return projectRepository.findById(projectId)
                .orElseThrow(() -> new ProjectNotFoundException());
    }
}
