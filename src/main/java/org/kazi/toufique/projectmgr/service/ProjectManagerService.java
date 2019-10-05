package org.kazi.toufique.projectmgr.service;

import org.kazi.toufique.projectmgr.model.Project;
import org.kazi.toufique.projectmgr.model.ProjectDTO;
import org.kazi.toufique.projectmgr.model.User;

import java.util.List;

public interface ProjectManagerService {

    /*User mgmt*/
    public void saveUser(User user);

    public List<User> getAllUser();

    public User getUserById(long id);

    public void removeUser(long id);

    /*Project mgmt*/
    public void saveProject(Project project, User user);

    public List<ProjectDTO> getAllProject();

    public Project getProjectById(long id);

    public void removeProject(long id);


}
