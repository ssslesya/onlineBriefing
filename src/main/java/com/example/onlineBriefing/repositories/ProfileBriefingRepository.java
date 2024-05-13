package com.example.onlineBriefing.repositories;

import com.example.onlineBriefing.models.ProfileBriefing;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfileBriefingRepository extends JpaRepository<ProfileBriefing,Long> {
}
