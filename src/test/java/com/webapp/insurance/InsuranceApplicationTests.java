package com.webapp.insurance;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.LocalTime;

import com.webapp.insurance.database.Session;
import com.webapp.insurance.database.SessionRepository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class InsuranceApplicationTests {

	@Autowired
    private SessionRepository sessionRepository;

	@Test
	void contextLoads() {
		LocalDateTime ldt = LocalDateTime.now();
		Timestamp timestamp = Timestamp.valueOf(ldt);

		Session session = new Session();
        //session.setId(1);
        session.setSessionID("1234567");
        session.setUsername("cuqi12");
        session.setFromDate(timestamp);
        
        sessionRepository.save(session);
	}

}
