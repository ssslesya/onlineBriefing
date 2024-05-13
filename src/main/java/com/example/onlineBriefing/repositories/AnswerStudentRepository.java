package com.example.onlineBriefing.repositories;

import com.example.onlineBriefing.models.AnswerStudent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnswerStudentRepository extends JpaRepository<AnswerStudent,Long> {
}
