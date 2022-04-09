package dao;


import entity.EmplProj;

import java.util.List;

public interface EmplProjDAO {
    //create
    void add(EmplProj emplProj);

    //read
    List<EmplProj> getAll();

    //get
    EmplProj getByEmplIdProjId(long emplId, long projId);

    //update
    void update(EmplProj emplProj);

    //delete
    void remove(EmplProj emplProj);
}
