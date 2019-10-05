package org.kazi.toufique.projectmgr.model;

import java.time.LocalDate;

public class ProjectDTO {
    private long projectId;
    private String projectName;
    private int priority;
    private LocalDate startDate;
    private LocalDate endDate;
    private long userId;
    private String userName;
    private int noOfTasks;
    private int noOfTasksCompleted;

    public ProjectDTO() {
    }

    public long getProjectId() {
        return projectId;
    }

    public void setProjectId(long projectId) {
        this.projectId = projectId;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getNoOfTasks() {
        return noOfTasks;
    }

    public void setNoOfTasks(int noOfTasks) {
        this.noOfTasks = noOfTasks;
    }

    public int getNoOfTasksCompleted() {
        return noOfTasksCompleted;
    }

    public void setNoOfTasksCompleted(int noOfTasksCompleted) {
        this.noOfTasksCompleted = noOfTasksCompleted;
    }
}
