package firstweb.web.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WebController {
    @RequestMapping("/login")
    public String login() {
        return "login";
    }

    @RequestMapping("/")
    public String homepage() {
        return "home";
    }
}
