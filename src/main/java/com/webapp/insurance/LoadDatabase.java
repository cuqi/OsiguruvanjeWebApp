// package com.webapp.insurance;


// import com.webapp.insurance.database.Session;
// import com.webapp.insurance.database.SessionRepository;

// import org.slf4j.Logger;
// import org.slf4j.LoggerFactory;
// import org.springframework.boot.CommandLineRunner;
// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;

// @Configuration
// class LoadDatabase {

//   private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

//   @Bean
//   CommandLineRunner initDatabase(SessionRepository repository) {

//     return args -> {
        
//       log.info("Preloading " + repository.save(new Session("123456789", "cuqi12", java.sql.Timestamp.valueOf("2021-11-28 00:00:00.000"))));
//       log.info("Preloading " + repository.save(new Session("1234567891", "cuqi13", java.sql.Timestamp.valueOf("2021-11-29 00:00:00.000"))));
//     };
//   }
// }