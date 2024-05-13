package com.example.onlineBriefing.repositories;

import com.example.onlineBriefing.models.News;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NewsRepository extends JpaRepository<News,Long> {

    List<News> findAllByIdProfile(Integer idProfile);

}
