package br.koakovski.project_manager_api.controllers.dtos.task;

import java.util.Date;
import java.util.Optional;

public class TaskUpdateDTO {
    private Optional<String> title = Optional.empty();
    private Optional<Date> startDate = Optional.empty();
    private Optional<Date> endDate = Optional.empty();
    private Optional<Integer> hours = Optional.empty();
    private Optional<Integer> userId = Optional.empty();
    private Optional<Integer> projectId = Optional.empty();

    public Optional<String> getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = Optional.ofNullable(title);
    }

    public Optional<Date> getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = Optional.ofNullable(startDate);
    }

    public Optional<Date> getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = Optional.ofNullable(endDate);
    }

    public Optional<Integer> getHours() {
        return hours;
    }

    public void setHours(Integer hours) {
        this.hours = Optional.ofNullable(hours);
    }

    public Optional<Integer> getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = Optional.ofNullable(userId);
    }

    public Optional<Integer> getProjectId() {
        return projectId;
    }

    public void setProjectId(Integer projectId) {
        this.projectId = Optional.ofNullable(projectId);
    }
}
