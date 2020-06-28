package com.survey.demoSurvey;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnswersRepository extends JpaRepository<Answers, Long> {
    public List<Answers> findByQuestionsId(Long questionId);
}
