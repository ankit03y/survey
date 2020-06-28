package com.survey.demoSurvey;

import java.util.List;

public class QuestionsAnswersDTO {
    private Questions question;
    private List<Answers> listOfAnswers;

    public Questions getQuestion() {
        return question;
    }

    public void setQuestion(Questions question) {
        this.question = question;
    }

    public List<Answers> getListOfAnswers() {
        return listOfAnswers;
    }

    public void setListOfAnswers(List<Answers> listOfAnswers) {
        this.listOfAnswers = listOfAnswers;
    }
}
