package com.github.macylion.bugtracker.repo;

import com.github.macylion.bugtracker.model.Bug;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.UUID;

public interface BugRepo extends MongoRepository<Bug, UUID> {

}
