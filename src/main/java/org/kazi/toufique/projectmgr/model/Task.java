package org.kazi.toufique.projectmgr.model;

import org.kazi.toufique.projectmgr.util.LocalDateConverter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "task")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "task_id")
    private long taskId;

    @Column(name = "task_name")
    private String taskName;

    @Column(name = "priority")
    private int priority;

    @Column(name = "start_date")
    @Convert(converter = LocalDateConverter.class)
    private LocalDate startDate;

    @Column(name = "end_date")
    @Convert(converter = LocalDateConverter.class)
    private LocalDate endDate;

    @Column(name = "status")
    private String status;

    @ManyToOne
    @JoinColumn(name = "parent_task_id")
    private ParentTask parentTask;

    @ManyToOne
    @JoinColumn(name = "project_id")
    private Project project;

    @Transient
    private Long parentTaskId;
    @Transient
    private String parentTaskName;

    public Task() {
    }

    public long getTaskId() {
        return taskId;
    }

    public void setTaskId(long taskId) {
        this.taskId = taskId;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public Long getParentTaskId() {
        return parentTaskId;
    }

    public void setParentTaskId(Long parentTaskId) {
        this.parentTaskId = parentTaskId;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Task task = (Task) o;
        return taskId == task.taskId && taskName.equals(task.taskName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(taskId, taskName);
    }

    @Override
    public String toString() {
        return "Task{" +
                "taskId=" + taskId +
                ", taskName='" + taskName + '\'' +
                ", priority=" + priority +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", status='" + status + '\'' +
                ", parentTask=" + parentTask +
                ", project=" + project +
                '}';
    }

    public ParentTask getParentTask() {
        return parentTask;
    }

    public void setParentTask(ParentTask parentTask) {
        this.parentTask = parentTask;
    }

    public String getParentTaskName() {
        return parentTaskName;
    }

    public void setParentTaskName(String parentTaskName) {
        this.parentTaskName = parentTaskName;
    }

}
