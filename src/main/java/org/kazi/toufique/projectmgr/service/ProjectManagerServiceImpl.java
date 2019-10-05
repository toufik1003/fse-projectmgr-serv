package org.kazi.toufique.projectmgr.service;

import org.kazi.toufique.projectmgr.model.Project;
import org.kazi.toufique.projectmgr.model.ProjectDTO;
import org.kazi.toufique.projectmgr.model.User;
import org.kazi.toufique.projectmgr.repository.ParentTaskRepository;
import org.kazi.toufique.projectmgr.repository.ProjectRepository;
import org.kazi.toufique.projectmgr.repository.TaskRepository;
import org.kazi.toufique.projectmgr.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProjectManagerServiceImpl implements ProjectManagerService {
    private static final Logger LOGGER = LoggerFactory.getLogger("ProjectManagerServiceImpl");

    @Override
    public void saveUser(User user) {
        userRepository.save(user);
    }

    @Override
    public List<User> getAllUser() {
        return ((List<User>) (userRepository.findAll()));
    }

    @Override
    public User getUserById(long id) {
        return userRepository.findById(id).get();
    }

    @Override
    public void removeUser(long id) {
        userRepository.deleteById(id);
    }

    @Override
    public void saveProject(Project project, User user) {
        projectRepository.save(project);
        User tmpUser = userRepository.findById(user.getUserId()).get();
        LOGGER.info("user retrieved from DB : {}", tmpUser);
        tmpUser.setProject(project);
        // flush all existing projectid for users...
        List<User> users = userRepository.findByProjectId(project.getProjectId());
        users.stream().forEach(u -> userRepository.flushProjectIdForOtherUser(u.getUserId()));

        userRepository.save(tmpUser);
    }

    @Override
    public List<ProjectDTO> getAllProject() {
        List<ProjectDTO> list = Collections.emptyList();
        List<Project> projectList = (List<Project>) projectRepository.findAll();

        list = projectList.stream().map(project -> {
            ProjectDTO dto = new ProjectDTO();
            //populate project data
            dto.setProjectId(project.getProjectId());
            dto.setProjectName(project.getProjectName());
            dto.setPriority(project.getPriority());
            dto.setStartDate(project.getStartDate());
            dto.setEndDate(project.getEndDate());
            //populate user data
            dto.setUserId(userRepository.findByProjectId(project.getProjectId()).get(0).getUserId());
            //populate task data

            return dto;
        }).collect(Collectors.toList());

        return list;
    }

    @Override
    public Project getProjectById(long id) {
        return projectRepository.findById(id).get();
    }

    @Override
    public void removeProject(long id) {
        projectRepository.deleteById(id);
    }


    private UserRepository userRepository;
    private ProjectRepository projectRepository;
    private ParentTaskRepository parentTaskRepository;
    private TaskRepository taskRepository;

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Autowired
    public void setProjectRepository(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    @Autowired
    public void setParentTaskRepository(ParentTaskRepository parentTaskRepository) {
        this.parentTaskRepository = parentTaskRepository;
    }

    @Autowired
    public void setTaskRepository(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }
}
