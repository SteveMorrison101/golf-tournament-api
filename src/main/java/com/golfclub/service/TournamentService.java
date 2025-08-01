package com.golfclub.service;

import com.golfclub.model.Tournament;
import com.golfclub.repository.TournamentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TournamentService {
    private final TournamentRepository tournamentRepository;

    @Autowired
    public TournamentService(TournamentRepository tournamentRepository) {
        this.tournamentRepository = tournamentRepository;
    }

    public List<Tournament> getAllTournaments() {
        return tournamentRepository.findAll();
    }

    public Optional<Tournament> getTournamentById(Long id) {
        return tournamentRepository.findById(id);
    }

    public Tournament addTournament(Tournament tournament) {
        return tournamentRepository.save(tournament);
    }

    public void deleteTournament(Long id) {
        tournamentRepository.deleteById(id);
    }

    // Search methods
    public List<Tournament> searchByStartDate(String startDate) {
        return tournamentRepository.findByStartDate(startDate);
    }

    public List<Tournament> searchByLocation(String location) {
        return tournamentRepository.findByLocationContainingIgnoreCase(location);
    }
}



