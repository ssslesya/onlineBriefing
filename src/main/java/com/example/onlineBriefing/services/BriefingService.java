package com.example.onlineBriefing.services;

import com.example.onlineBriefing.models.*;
import com.example.onlineBriefing.repositories.AnswerStudentRepository;
import com.example.onlineBriefing.repositories.BriefingRepository;
import com.example.onlineBriefing.repositories.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.Optional;

@Service
public class BriefingService {

    @Autowired
    private BriefingRepository briefingRepository;
    @Autowired
    private AnswerStudentRepository answerStudentRepository;
    @Autowired
    private QuestionRepository questionRepository;

    public List<Briefing> getAllBriefingsByIdSubject(Integer idSubject) {
        return briefingRepository.findAllByIdSubject(idSubject);
    }

    //РЕЗУЛЬТАТЫ ЛЕТУЧКИ
    public Double getEstimationBriefingStudent(Integer idBriefing, Integer idStudent) {
        List<Question> questions = questionRepository.findAllByBriefing(idBriefing);
        BigDecimal sum = BigDecimal.ZERO; // Используем константу BigDecimal.ZERO для инициализации суммы
        int count = 0;
        for (Question question : questions) {
            AnswerStudent answerStudent = answerStudentRepository.findByQuestion(question.getId());
            if (answerStudent != null && answerStudent.getAccuracy_percent() != null) {
                sum = sum.add(answerStudent.getAccuracy_percent()); // Используем метод add() для добавления BigDecimal к сумме
            }
            count++;
        }
        BigDecimal average = BigDecimal.ZERO;
        if (count != 0) {
            average = sum.divide(BigDecimal.valueOf(count), 2, RoundingMode.HALF_UP); // Вычисляем среднее значение с точностью до двух знаков после запятой
        }
        return average.doubleValue();
    }
    //Средний балл по предмету
    public double calculateAverageGradeBySubject(Integer idStudent, Integer subject) {
        List<Briefing> briefings = getAllBriefingsByIdSubject(subject);
        double sum = 0;
        int count = 0;
        double estimate;
        for (Briefing briefing :
                briefings) {
            estimate = getEstimationBriefingStudent(briefing.getId(), idStudent);
            sum += estimate;
            count += 1;
        }
        return sum/count;
    }

    public Optional<Briefing> findBriefingById(Integer id) {
        return briefingRepository.findById(id);
    }

    public Briefing addBriefing(Briefing briefing) {
        return briefingRepository.save(briefing);
    }

    public List<Briefing> findAllBriefings() {
        return briefingRepository.findAll();
    }

}
