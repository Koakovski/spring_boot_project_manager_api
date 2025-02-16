package br.koakovski.project_manager_api.controllers.dtos.project;

import java.util.Date;
import java.util.Optional;

public class ProjectUpdateDTO {
    private Optional<Date> startDate = Optional.empty();
    private Optional<Date> endDate = Optional.empty();
    private Optional<Integer> hours = Optional.empty();
    private Optional<String> artifact = Optional.empty();

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

    public Optional<String> getArtifact() {
        return artifact;
    }

    public void setArtifact(String artifact) {
        this.artifact = Optional.ofNullable(artifact);
    }
}
