package pl.coderslab.controller;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.coderslab.entity.User;
import pl.coderslab.repository.UserRepository;

import javax.validation.Valid;

@Controller
public class RegisterController {
    @Autowired
    private UserRepository userRepository;


    @RequestMapping(value = "register", method = RequestMethod.GET)
    public String showRegisterForm (Model model){
        model.addAttribute("user", new User());
        return "register";
    }
    @RequestMapping(value = "register", method = RequestMethod.POST)
    public String getRegisterForm (@ModelAttribute @Valid User user, BindingResult result, Model model){
        String hashed = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());
        if(result.hasErrors()){
            System.out.println("binding error");
            return "register";
        }else if(userRepository.findByUserNameIgnoreCase(user.getUserName()) != null){
            model.addAttribute("duplicatedUserName", "true");// duplicated login
           return "register";
        }else if(userRepository.findByEmailIgnoreCase(user.getEmail()) != null ){
            model.addAttribute("duplicatedEmail", "true");// duplicated email
            return "register";
        }
        user.setPassword(hashed);
        userRepository.save(user);
        return "redirect:home";
    }

}
