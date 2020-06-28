package com.survey.demoSurvey;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

@Controller
public class SurveyController {

    @Autowired
    private SurveyService surveyService;

    @RequestMapping("/")
    public String viewHomePage(Model model, HttpServletRequest request) {
        Boolean isCookiePresent = surveyService.getCookie(request, "is-logged-in");
        List<QuestionsAnswersDTO> dtoList = surveyService.listAllQuestionsWithAnswers();
        model.addAttribute("myDTOList", dtoList);
        model.addAttribute("isLoginCookiePresent", isCookiePresent);
        return "index";
    }

    //============================================================================================


    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(Model model, HttpServletRequest request) {
        Boolean isCookiePresent = surveyService.getCookie(request, "is-logged-in");
        model.addAttribute("isLoginCookiePresent", isCookiePresent);
        return "login";

    }



    // to check login credentials
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(
            @RequestParam(value = "email")
                    String username,
            @RequestParam(value = "password")
                    String password,
            HttpServletResponse response
    ) {

        if ("admin".equals(username) && "admin".equals(password)) {
            surveyService.setCookie(response);
            return "index";

        }
        return "logout";
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout() {
        return "index";
    }

    @RequestMapping(value = "/add-survey", method = RequestMethod.GET)
    public String addSurvey() {
        return "add-survey";
    }

    @RequestMapping(value = "/add-survey", method = RequestMethod.POST)
    public String addSurvey(
            @RequestParam(value = "question")
                    String question,
            @RequestParam(value = "option")
                    ArrayList<String> option
    ) {
        return "add-survey";
    }
    //=========================================================================

}
