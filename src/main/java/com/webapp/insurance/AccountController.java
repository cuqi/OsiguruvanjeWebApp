// package com.webapp.insurance;

// import org.springframework.beans.factory.annotation.Autowired;
// //import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
// import org.springframework.stereotype.Controller;
// import org.springframework.ui.Model;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.RequestBody;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.ResponseBody;
// import org.springframework.web.bind.annotation.RestController;
// import org.springframework.web.servlet.ModelAndView;

// import ch.qos.logback.core.encoder.EncoderBase;

// @Controller
// public class AccountController {

//     @Autowired // This means to get the bean called userRepository
//     private UserRepository userRepository;

//     AccountController(UserRepository userRepository) {
//         this.userRepository = userRepository;
//     }
    
//   // GET ALL USERS
//   @GetMapping(path = "/getAllUsers")
//   public @ResponseBody Iterable<User> getAllUsers() {
//       // This returns a JSON or XML with the users
//       return userRepository.findAll();
//     }

//     // POST NEW USER
//     @PostMapping(path = "/newUser")
//     public User newAccount(@RequestBody User newAccount) {
//         return userRepository.save(newAccount);
//     }
// }