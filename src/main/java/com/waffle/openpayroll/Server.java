package com.waffle.openpayroll;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@EnableAutoConfiguration
public class Server {

    @RequestMapping("/")
    @ResponseBody
    public ModelAndView index() {
        return new ModelAndView("index");
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(Server.class, args);
    }

}