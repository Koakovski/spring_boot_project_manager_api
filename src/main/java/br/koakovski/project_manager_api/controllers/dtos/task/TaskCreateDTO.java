package br.koakovski.project_manager_api.controllers.dtos.task;

import java.util.Date;

import lombok.Data;

@Data
public class TaskCreateDTO {
    private String title;
    private Date startDate;
    private Date endDate;
    private Integer hours;
    private Integer userId;
    private Integer projectId;
}
