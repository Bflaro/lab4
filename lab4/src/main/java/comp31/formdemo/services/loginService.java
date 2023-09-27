package comp31.formdemo.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import comp31.formdemo.model.Accounts;
import comp31.formdemo.model.Person;

@Service
public class loginService {
    
    Logger logger = LoggerFactory.getLogger(loginService.class);

    Accounts accounts;

    public loginService(Accounts accounts) {
        this.accounts = accounts;
    

        String[] userIds = { "admin","sales", "orders" };

        for(String userId : userIds)
        {
            Person person = new Person();
            person.setUserId(userId);
            accounts.add(person);
        }

        }

    public Person findByUserId(String userId) {
        return accounts.findByUserId(userId);
    }
}
