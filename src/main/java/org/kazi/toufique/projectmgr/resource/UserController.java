package org.kazi.toufique.projectmgr.resource;

import org.kazi.toufique.projectmgr.model.User;
import org.kazi.toufique.projectmgr.service.ProjectManagerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UserController {
    private static final Logger LOGGER = LoggerFactory.getLogger("UserController");

    private ProjectManagerService service;

    @Autowired
    public void setService(ProjectManagerService service) {
        this.service = service;
    }


    @GetMapping(value = "/getAllUser")
    public List<User> getAllUser() {
        return service.getAllUser();
    }

    @PostMapping(value = "/saveUser")
    public User saveUser(@RequestBody User user) {
        LOGGER.info("User to be persisted : {}", user);
        service.saveUser(user);
        return user;
    }

    @GetMapping(value = "/getUser/{id}")
    public User getUserById(@PathVariable String id) {
        return service.getUserById(Long.parseLong(id));
    }

    @GetMapping(value = "/deleteUser/{id}")
    public void deleteUser(@PathVariable String id) {
        service.removeUser(Long.parseLong(id));
    }

}
