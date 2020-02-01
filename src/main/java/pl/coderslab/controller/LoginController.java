package pl.coderslab.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.coderslab.entity.User;

import javax.validation.Valid;

@Controller
public class LoginController {
    @RequestMapping(value = "login", method = RequestMethod.GET)
    public String showLoginForm (){
        return "login";
    }
    @RequestMapping(value = "login", method = RequestMethod.POST)
    public String getLoginForm (@RequestAttribute String login, @RequestAttribute String password){
        if(true){

        }
//        if (BCrypt.checkpw(candidate, hashed))
//            System.out.println("It matches");
//        else
//            System.out.println("It does not match");
        return "redirect:home";
    }

}
