package org.kazi.toufique.projectmgr.resource;

import org.kazi.toufique.projectmgr.model.Project;
import org.kazi.toufique.projectmgr.model.ProjectDTO;
import org.kazi.toufique.projectmgr.model.User;
import org.kazi.toufique.projectmgr.service.ProjectManagerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ProjectController {
    private static final Logger LOGGER = LoggerFactory.getLogger("ProjectController");

    private ProjectManagerService service;

    @Autowired
    public void setService(ProjectManagerService service) {
        this.service = service;
    }

    @GetMapping(value = "/getAllProject")
    public List<ProjectDTO> getAllProject() {
        return service.getAllProject();
    }

    @PostMapping(value = "/saveProject")
    public ProjectDTO saveProject(@RequestBody ProjectDTO projectdto) {

        User user = new User();
        user.setUserId(projectdto.getUserId());

        Project project = new Project();
        project.setProjectId(projectdto.getProjectId());
        project.setProjectName(projectdto.getProjectName());
        project.setPriority(projectdto.getPriority());
        project.setStartDate(projectdto.getStartDate());
        project.setEndDate(projectdto.getEndDate());

        service.saveProject(project, user);
        return projectdto;
    }
}
