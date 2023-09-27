package comp31.formdemo.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import comp31.formdemo.model.Person;
import comp31.formdemo.services.loginService;

@Controller
public class MainController {

    Logger logger = LoggerFactory.getLogger(MainController.class);

    loginService loginService;

    public MainController(loginService loginService)
    {
        this.loginService = loginService;
    }


    @GetMapping("/")
    String getRoot(Model model) {

        logger.info("--------- Request '/'");
        Person person = new Person();
        person.setUserId("joe");
        model.addAttribute("person", person);
        return "login";
    }

    @GetMapping("/login")
    public String getForm(Person person, Model model) {

        logger.info("--------- Request '/login'");

        if(loginService.findByUserId(person.getUserId()) != null){
        model.addAttribute("person", person);
        return "welcome";
        }
        else
        {
        return "login";
        }
    }

}
