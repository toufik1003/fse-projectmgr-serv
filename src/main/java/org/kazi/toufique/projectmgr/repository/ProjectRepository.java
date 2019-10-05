package org.kazi.toufique.projectmgr.repository;

import org.kazi.toufique.projectmgr.model.Project;
import org.springframework.data.repository.CrudRepository;

public interface ProjectRepository extends CrudRepository<Project, Long> {
}

