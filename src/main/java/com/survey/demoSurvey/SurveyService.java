package com.survey.demoSurvey;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class SurveyService {
    @Autowired
    private QuestionsRepository repoQuestions;

    @Autowired
    private AnswersRepository repoAnswers;


    //=====================================================================
    // All questions methods
    public List<Questions> listAllQuestions() {
        return repoQuestions.findAll();
    }

    public void saveQuestion(Questions question) {
        repoQuestions.save(question);
    }

    public Questions getQuestion(Long id) {
        Optional<Questions> optional = repoQuestions.findById(id);
        Questions question = optional.get();
        return question;
    }

    public void deleteQuestion(Long id) {
        repoQuestions.deleteById(id);
    }

    //=====================================================================
    // All Answers method
    public List<Answers> listAllAnswers() {
        return repoAnswers.findAll();
    }

    public void saveAnswer(Answers answer) {
        repoAnswers.save(answer);
    }

    public Answers getAnswer(Long id) {
        Optional<Answers> optional = repoAnswers.findById(id);
        Answers answer = optional.get();
        return answer;
    }

    public List<Answers> getAllAnswersForQuestionId(Long questionId) {
        return repoAnswers.findByQuestionsId(questionId);
    }

    public void deleteAnswer(Long id) {
        repoAnswers.deleteById(id);
    }


    //===================================================================
    // Helper methods

    public List<QuestionsAnswersDTO> listAllQuestionsWithAnswers() {
        // Return this
        List<QuestionsAnswersDTO> questionsAnswersDTOList = new ArrayList<>();

        // Get all questions from database
        List<Questions> questions = listAllQuestions();

        for (Questions questionObject : questions) {

            QuestionsAnswersDTO questionsAnswersDTO = new QuestionsAnswersDTO();
            List<Answers> allAnswersForQuestionId = getAllAnswersForQuestionId(questionObject.getId());
            questionsAnswersDTO.setListOfAnswers(allAnswersForQuestionId);
            questionsAnswersDTO.setQuestion(questionObject);

            questionsAnswersDTOList.add(questionsAnswersDTO);
        }
        return questionsAnswersDTOList;

    }

    //==========================================================
    // cookie
    public void setCookie(HttpServletResponse response) {
        response.addCookie(new Cookie("is-logged-in", "1"));

    }

    public Boolean getCookie(HttpServletRequest request, String cookieName) {
        Cookie[] allCookies = request.getCookies();
        for(int i=0; i<allCookies.length; i++){
            Cookie singleCookie = allCookies[i];
            String singleCookieName = singleCookie.getName();

            if(cookieName.equals(singleCookieName)) {
                return true;
            }
        }
        return false;

    }
}
