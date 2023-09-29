package services;

import models.Roles;
import repositories.RoleRepository;

import java.util.List;

public class ServicesRoles {
    private final RoleRepository repository = new RoleRepository();

    public List<Roles> getAll(){
        return repository.getAll();
    }

    public boolean insert(Roles roles){
        return repository.insert(roles);
    }

    public void update(Roles roles){
        repository.update(roles);
    }

    public void delete(Long roleId){
        repository.delete(roleId);
    }

    public Roles findById(String id){
        return repository.findById(id);
    }
}
