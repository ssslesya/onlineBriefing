package com.example.onlineBriefing.services;

import com.example.onlineBriefing.models.*;
import com.example.onlineBriefing.repositories.*;
import org.apache.catalina.Group;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.relational.core.sql.In;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class BriefingService {

    @Autowired
    private BriefingRepository briefingRepository;
    @Autowired
    private AnswerStudentRepository answerStudentRepository;
    @Autowired
    private QuestionRepository questionRepository;
    @Autowired
    private UniversityGroupRepository universityGroupRepository;
    @Autowired
    private StudentRepository studentRepository;

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
    public List<Double>  getAllScores(Integer idStudent, Integer subject){
        List<Briefing> briefings = getAllBriefingsByIdSubject(subject);
        List<Double> scores = new ArrayList<>();
        for (Briefing briefing :
                briefings) {
            scores.add(getEstimationBriefingStudent(briefing.getId(), idStudent));
        }
        return scores;
    }
    //Получить место в топе и лучший балл
    public String getTop(Integer idStudent, Integer subject){
        Student student = studentRepository.findById(idStudent).get();
        Integer profileId = universityGroupRepository.findById(student.getIdGroup()).get().getIdProfile();
        List<UniversityGroup> groups = universityGroupRepository.findAllByIdProfile(profileId);
        List<Student> students = new ArrayList<>();
        for (UniversityGroup group:
             groups) {
            students.addAll(studentRepository.findAllByIdGroup(group.getId()));
        }
        Map<Integer, Double> studentsMap = new HashMap<>();
        for(Student s: students){
            studentsMap.put(s.getId(), calculateAverageGradeBySubject(s.getId(), subject));
        }
        Map<Integer, Double> sortedByScores = studentsMap.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())) // Сортировка по убыванию
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (e1, e2) -> e1,
                        LinkedHashMap::new
                ));
        int position = getStudentPositionInTop(sortedByScores, idStudent);
        Double max = sortedByScores.values().iterator().next();
        return "Ваше место в рейтинге "+position+"Лучший балл в топе: "+max;
    }
    private static int getStudentPositionInTop(Map<Integer, Double> sortedScores, Integer idStudent) {
        int position = 1;
        for (Map.Entry<Integer, Double> entry : sortedScores.entrySet()) {
            if (entry.getKey().equals(idStudent)) {
                return position;
            }
            position++;
        }
        return -1; // Если студент не найден
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
