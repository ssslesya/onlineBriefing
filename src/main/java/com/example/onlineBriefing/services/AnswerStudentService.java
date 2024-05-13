package com.example.onlineBriefing.services;

import com.example.onlineBriefing.models.AnswerStudent;
import com.example.onlineBriefing.models.Question;
import com.example.onlineBriefing.repositories.AnswerStudentRepository;
import com.example.onlineBriefing.repositories.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class AnswerStudentService {

    @Autowired
    private AnswerStudentRepository answerStudentRepository;
    @Autowired
    private QuestionRepository questionRepository;

    public List<AnswerStudent> addAnswer(List<AnswerStudent> answerStudents) {
        return answerStudentRepository.saveAll(answerStudents);
    }

    public List<AnswerStudent> checkAnswer(List<AnswerStudent> answerStudents) {
        Optional<Question> question;
        List<AnswerStudent> checkedAnswer = new ArrayList<>();
        for (AnswerStudent answerStudent : answerStudents) {
            question = questionRepository.findById(answerStudent.getQuestion());
            if (question.isPresent()) {
                if (Objects.equals(question.get().getTypeVerification(), "автоматически")) {
                    if(Objects.equals(question.get().getAnswer(), answerStudent.getText())){
                        answerStudent.setAccuracy_percent(new BigDecimal(100));
                       checkedAnswer.add(answerStudent);
                    }
                    else {
                        answerStudent.setAccuracy_percent(new BigDecimal(0));
                        checkedAnswer.add(answerStudent);
                    }
                }
            }
        }
        return answerStudentRepository.saveAll(checkedAnswer);
    }
}
