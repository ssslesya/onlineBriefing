package com.example.onlineBriefing.repositories;

import com.example.onlineBriefing.models.UniversityGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UniversityGroupRepository extends JpaRepository<UniversityGroup,Integer> {
    Optional<UniversityGroup> findByIdProfileAndYearBeginAndNumber(Integer idProfile, Integer yearBegin, String number);
}
