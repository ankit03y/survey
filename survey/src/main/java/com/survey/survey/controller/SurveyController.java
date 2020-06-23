package com.survey.survey.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.ArrayList;

@Controller
public class SurveyController {
    //to get home form page
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home() {
        //to return html page name
        return "home";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login() {
        return "login";

    }

    private void setCookie() {}
    private String getCookie() {
        return "1";
    }

    // to check login credentials
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(
            @RequestParam(value = "email")
                    String username,
            @RequestParam(value = "password")
                    String password
    ) {

        if ("admin".equals(username) && "admin".equals(password)) {
            setCookie();
            return "home";

        }
        return "login";
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout() {
        return "home";
    }

    @RequestMapping(value = "/add-survey", method = RequestMethod.GET)
    public String addSurvey() {
        return "add_survey";
    }

    @RequestMapping(value = "/add-survey", method = RequestMethod.POST)
    public String addSurvey(
            @RequestParam(value = "question")
                    String question,
            @RequestParam(value = "option")
                    ArrayList<String> option
    ){
        return "add-survey";
    }



}