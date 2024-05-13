package com.example.onlineBriefing.repositories;

import com.example.onlineBriefing.models.Briefing;
import com.example.onlineBriefing.models.News;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BriefingRepository extends JpaRepository<Briefing,Integer> {

    List<Briefing> findAllByIdSubject(Integer idSubject);

}
