package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import pl.coderslab.entity.Tweet;
import pl.coderslab.entity.User;
import pl.coderslab.repository.TweetRepository;

import javax.servlet.http.HttpSession;

@Controller
public class TweetController {
    @Autowired
    private TweetRepository tweetRepository;

    @RequestMapping(value = "newTweet", method = RequestMethod.POST)
    public String newTweet(HttpSession session, @RequestParam String content){
        if(content == null || content.length() > 140 || content.length() < 1){
            return "redirect:home";
        }
        User user = (User) session.getAttribute("currentUser");
        if (user == null){
            return "redirect:home";
        }
        tweetRepository.save(new Tweet(content, user));
        return "redirect:home";
    }
}
