package com.webapp.insurance;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller // This means that this class is a Controller
public class MainController {
  @Autowired // This means to get the bean called userRepository
         // Which is auto-generated by Spring, we will use it to handle the data
  private UserRepository userRepository;

  // GET REGISTER
  @GetMapping("/register")
  public ModelAndView showRegistrationForm(Model model) {
  model.addAttribute("user", new User());
  ModelAndView modelAndView = new ModelAndView();
  modelAndView.setViewName("signup_form");

    return modelAndView;
  }
  // POST PROCESS REGISTER
  @PostMapping("/process_register")
  public String proccessRegister(User user) {
    System.out.println(user.getEmail() + " " + user.getName() + " " + user.getPassword());
    BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    String encodedPassword = passwordEncoder.encode(user.getPassword());
    System.out.println("encodedPassword: " + encodedPassword);
    user.setPassword(encodedPassword);

    userRepository.save(user);

    return "register_success";
  }
      
  @PostMapping(path="/add") // Map ONLY POST Requests
  public @ResponseBody String addNewUser (@RequestParam String name
      , @RequestParam String email) {
    // @ResponseBody means the returned String is the response, not a view name
    // @RequestParam means it is a parameter from the GET or POST request

    User n = new User();
    n.setName(name);
    n.setEmail(email);
    userRepository.save(n);
    return "Saved";
  }

  @GetMapping(path="/users")
  public @ResponseBody Iterable<User> getAllUsers() {
    // This returns a JSON or XML with the users
    return userRepository.findAll();
  }
}