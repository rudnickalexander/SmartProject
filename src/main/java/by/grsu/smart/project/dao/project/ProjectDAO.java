package by.grsu.smart.project.dao.project;

import by.grsu.smart.project.entity.Project;

import java.util.List;

public interface ProjectDAO {

    void save(Project project);

    void update(Project project);

    List<Project> getLatest();
}
