package br.koakovski.project_manager_api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.koakovski.project_manager_api.entities.TaskEntity;

@Repository
public interface TaskRepository extends JpaRepository<TaskEntity, Integer> {
}
