package com.github.macylion.bugtracker.controller;

import com.github.macylion.bugtracker.model.Bug;
import com.github.macylion.bugtracker.repo.BugRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
public class BugController {

    @Autowired
    private BugRepo repo;

    @PostMapping("/add")
    public String addBug(@RequestBody Bug bug){
        repo.save(bug);
        return "Succesfully added new bug. Bug Id: " + bug.getId();
    }

    @GetMapping("/all")
    public List<Bug> getAllBugs(){
        return  repo.findAll();
    }

    @GetMapping("/get/{id}")
    public Optional<Bug> getBugById(@PathVariable UUID id){
        return repo.findById(id);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteById(@PathVariable UUID id){
        repo.deleteById(id);
        return id + " is no more";
    }

    @PutMapping("/update/{id}")
    public String updateById(@PathVariable UUID id, @RequestBody Bug newBug){
        if(!id.equals(newBug.getId()))
            return "ID's are not same";
        if(repo.findById(id).isPresent()) {
            repo.save(newBug);
            return "Updated: " + id;
        }
        else return id + " doesn't exist.";
    }

}
