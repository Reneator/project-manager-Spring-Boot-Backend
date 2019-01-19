package com.example.demo;

import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin
@RestController
@RequestMapping("/project")
public class ProjectController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    ProjectRepository repository;
    @Autowired
    TechnologyRepository technologyRepository;

    @ApiOperation("Get a Project By Name")
    @GetMapping("find")
    public ResponseEntity<Project> getByName(@RequestParam String name) {
        Project project = new Project();
        project.setName(name);
        Example<Project> example = Example.of(project);
        Project projectReturn = repository.findOne(example).get();
        return ResponseEntity.ok(projectReturn);
    }

    @ApiOperation("Get Projects By Name contains With Streams")
    @GetMapping("find/contains")
    public ResponseEntity<List<Project>> getByNameStream(@RequestParam @NotNull String name) {
        List<Project> projects = repository.findAll();
        List<Project> filteredProjects = projects.stream()
                .filter(project -> project.getName().toLowerCase().contains(name.toLowerCase()))
                .sorted()
                .collect(Collectors.toList());
        return ResponseEntity.ok(filteredProjects);
    }

    @ApiOperation("Get all Projects")
    @GetMapping("getAll")
    public ResponseEntity<List<Project>> getAll() {
        return ResponseEntity.ok(repository.findAll());
    }

    @ApiOperation("Get a Project By Id")
    @GetMapping
    public ResponseEntity<Project> getById(@RequestParam Long id) {
        Project project = repository.findById(id).get();
        return ResponseEntity.ok(project);
    }

    @ApiOperation("Create a new Project")
    @PostMapping
    public ResponseEntity<Project> create(@RequestBody Project project) {
        return ResponseEntity.ok(repository.save(project));
    }

    @ApiOperation("Add Technology to Project")
    @PutMapping("addtechnology")
    public ResponseEntity<Project> addTechnologyToProject(@RequestParam Long projectId, @RequestParam Long technologyId) {
        Project project = repository.findById(projectId).get();
        Technology technology = technologyRepository.findById(technologyId).get();

        project.getTechnologies().add(technology);
        return ResponseEntity.ok(repository.save(project));
    }


    @ApiOperation("Update a Project")
    @PutMapping()
    public ResponseEntity<Project> update(@RequestBody Project project) {
        if (!repository.existsById(project.getId())) {
            return ResponseEntity.notFound().build();
        }
        repository.save(project);
        return ResponseEntity.ok(project);
    }

    @ApiOperation("Delete a Project")
    @DeleteMapping()
    public ResponseEntity<Project> delete(@RequestParam Long id) {
        repository.deleteById(id);
        return ResponseEntity.ok().build();

    }


}
