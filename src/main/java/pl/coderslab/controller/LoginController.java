package pl.coderslab.controller;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import pl.coderslab.entity.User;
import pl.coderslab.repository.UserRepository;

import javax.servlet.http.HttpSession;

@Controller
@SessionAttributes("currentUser")
public class LoginController {
    @Autowired
    private UserRepository userRepository;

    @RequestMapping(value = "login", method = RequestMethod.GET)
    public String showLoginForm (){
        return "login";
    }
    @RequestMapping(value = "login", method = RequestMethod.POST)
    public String getLoginForm (@RequestParam String userName,
                                @RequestParam String password, Model model){
        if(userName == null || password == null){
            return "login";
        }
        User user = userRepository.findByUserNameIgnoreCase(userName);
        if (user == null){
            model.addAttribute("loginError", "true");
            System.out.println("wrong user name");
            return "login";
        }
        if (BCrypt.checkpw(password, user.getPassword())) {
            user.setPassword("");
            model.addAttribute("currentUser", user);
            return "redirect:home";
        }else {
            model.addAttribute("loginError", "true");
            System.out.println("error wrong password");
            return "login";
        }
    }

    @RequestMapping("logout")
    public String logout (SessionStatus status){
        status.setComplete();
        System.out.println("logout");
        return "redirect:home";
    }

}
