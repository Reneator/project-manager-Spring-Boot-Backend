package com.example.demo;

import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/technology")
public class TechnologyController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    TechnologyRepository repository;

    @ApiOperation("Get a  Technology By Name")
    @GetMapping("find")
    public ResponseEntity<Technology> getByName(@RequestParam String name) {
        Technology technology = new Technology();
        technology.setName(name);
        Example<Technology> example = Example.of(technology);
        Technology technologyReturn = repository.findOne(example).get();
        return ResponseEntity.ok(technologyReturn);
    }

    @ApiOperation("Get all Technologies")
    @GetMapping("getAll")
    public ResponseEntity<List<Technology>> getAll() {
        return ResponseEntity.ok(repository.findAll());
    }

    @ApiOperation("Get a Technology By Id")
    @GetMapping
    public ResponseEntity<Technology> getById(@RequestParam Long id) {
        Technology technology = repository.findById(id).get();
        return ResponseEntity.ok(technology);
    }

    @ApiOperation("Create a new Technology")
    @PostMapping
    public ResponseEntity<Technology> create(@RequestBody Technology technology) {
        return ResponseEntity.ok( repository.save(technology));
    }

    @ApiOperation("Update a Technology")
    @PutMapping()
    public ResponseEntity<Technology> update(@RequestBody Technology technology) {
        if (!repository.existsById(technology.getId())) {
            return ResponseEntity.notFound().build();
        }
        repository.save(technology);
        return ResponseEntity.ok(technology);
    }

    @ApiOperation("Delete a Technology")
    @DeleteMapping()
    public ResponseEntity<Technology> delete(@RequestParam Long id) {
        repository.deleteById(id);
        return ResponseEntity.ok().build();

    }

}
