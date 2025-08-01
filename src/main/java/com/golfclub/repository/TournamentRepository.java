package com.golfclub.repository;

import com.golfclub.model.Tournament;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TournamentRepository extends JpaRepository<Tournament, Long> {
    // Search by start date
    List<Tournament> findByStartDate(String startDate);

    // Search by location
    List<Tournament> findByLocationContainingIgnoreCase(String location);
}


