package com.webapp.insurance;

import com.webapp.insurance.database.Session;
import com.webapp.insurance.database.SessionRepository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

@DataJpaTest
@AutoConfigureTestDatabase
@Rollback(false)
public class SessionRepositoryTests {
    @Autowired
    private SessionRepository sessionRepository;

    @Autowired
    private TestEntityManager entityManager;

    @Test
    public void testCreateUser() {
        Session session = new Session();
        session.setId(1);
        session.setSessionID("1234567");
        session.setUsername("cuqi12");
        //session.setFromDate(fromDate);
        
        sessionRepository.save(session);
    }
}

// package com.webapp.insurance;

// import static org.assertj.core.api.Assertions.assertThat;

// import com.webapp.insurance.database.User;

// import org.junit.jupiter.api.Test;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
// import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
// import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
// import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
// import org.springframework.test.annotation.Rollback;

// @DataJpaTest
// @AutoConfigureTestDatabase(replace = Replace.NONE)
// @Rollback(false)
// public class UserRepositoryTests {
    
//     @Autowired
//     private UserRepository repo;

//     @Autowired
//     private TestEntityManager entityManager;

//     @Test
//     public void testCreateUser() {
//         User user = new User();
//         user.setEmail("lora@gmail.com");
//         user.setPassword("pass123");
//         user.setName("lora");

//         User savedUser = repo.save(user);

//         User existsUser = entityManager.find(User.class, savedUser.getId());
        
//         assertThat(existsUser.getEmail()).isEqualTo(user.getEmail());
//     }
// }