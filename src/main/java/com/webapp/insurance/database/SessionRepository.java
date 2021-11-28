package com.webapp.insurance.database;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface SessionRepository extends CrudRepository<Session, Integer>{
    // @Query("SELECT s from SESSIONS s WHERE s.sessionID = ?1")
    // public Session findBySessionId(String sessionId);
}
/*
package com.webapp.insurance;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer>{
    
    // @Query("SELECT u FROM User u WHERE u.email = ?1")
    // public User findByEmail(String email);

    @Query("SELECT u FROM User u WHERE u.name = ?1")
    public User findByEmail(String name);
}

*/