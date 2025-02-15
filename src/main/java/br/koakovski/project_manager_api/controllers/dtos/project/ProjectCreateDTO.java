package br.koakovski.project_manager_api.controllers.dtos.project;

import java.util.Date;

import lombok.Data;

@Data
public class ProjectCreateDTO {
    private Date startDate;
    private Date endDate;
    private Integer hours;
    private String artifact;
}
