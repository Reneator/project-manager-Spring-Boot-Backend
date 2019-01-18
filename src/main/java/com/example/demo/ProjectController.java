package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProjectController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    ProjectRepository repository;

    @RequestMapping("/initialize")
    public String index() {
        logger.info("Resetting the Tables");
        repository.deleteAll();

        Project project = new Project();
        project.setName("First Project");
        project.setDescription("The first Project to have been created!");
        repository.save(project);

        return "Greetings from Spring Boot!";
    }


}
