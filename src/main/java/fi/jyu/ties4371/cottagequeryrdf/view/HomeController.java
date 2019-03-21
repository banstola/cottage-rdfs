package fi.jyu.ties4371.cottagequeryrdf.view;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller
public class HomeController {

    @RequestMapping("/")
    public String welcome(Map<String, Object> model) {

        System.out.println("The request arrived here");
        return "index";
    }
}