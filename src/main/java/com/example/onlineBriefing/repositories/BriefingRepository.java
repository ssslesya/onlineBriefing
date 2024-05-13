package com.example.onlineBriefing.repositories;

import com.example.onlineBriefing.models.Briefing;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BriefingRepository extends JpaRepository<Briefing,Long> {
}
