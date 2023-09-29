package services;

import models.Account;
import repositories.AccountRepository;

import java.util.List;

public class ServicesAccount {
    private final AccountRepository repository = new AccountRepository();
     public List<Account> getAll(){
         return repository.getAll();
     }

     public boolean insert(Account account){
         return repository.insert(account);
     }

     public void update(Account account){
         repository.update(account);
     }

     public void delete(Long accountID){
        repository.delete(accountID);
     }

    public Account findById(String id){
         return repository.findById(id);
    }
}
