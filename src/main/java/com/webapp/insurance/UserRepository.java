package com.webapp.insurance;

import org.springframework.data.repository.CrudRepository;
import com.webapp.insurance.User;

public interface UserRepository extends CrudRepository<User, Integer>{
    
}
