package services;

import models.GrantAccess;
import repositories.GrantAccessRepository;

import java.util.List;

public class ServicesGrantAccess {
    private final GrantAccessRepository repository = new GrantAccessRepository();

    public List<GrantAccess> getAll(){
        return repository.getAll();
    }

    public boolean insert(GrantAccess grantAccess){
        return repository.insert(grantAccess);
    }

    public void update(GrantAccess grantAccess){
        repository.update(grantAccess);
    }

    public void delete(Long grantID){
        repository.delete(grantID);
    }

    public GrantAccess findById(String id){
        return repository.findById(id);
    }
}
