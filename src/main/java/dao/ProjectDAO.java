package dao;



import entity.Project;

import java.util.List;

public interface ProjectDAO {
    //create
    void add(Project project);

    //read
    List<Project> getAll();

    //get
    Project getById(long id);

    //update
    void update(Project project);

    //delete
    void remove(Project project);
}
