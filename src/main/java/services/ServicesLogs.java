package services;

import models.Logs;
import repositories.LogRepository;

import java.util.List;

public class ServicesLogs {
    private final LogRepository repository = new LogRepository();

    public List<Logs> getAll(){
        return repository.getAll();
    }

    public boolean insert(Logs logs){
        return repository.insert(logs);
    }

    public void update(Logs logs){
        repository.update(logs);
    }

    public void delete(Long logId){
        repository.delete(logId);
    }

    public Logs findById(String id){
        return repository.findById(id);
    }
}
