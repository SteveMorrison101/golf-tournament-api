package com.golfclub.controller;

import com.golfclub.model.Tournament;
import com.golfclub.model.Member;
import com.golfclub.service.TournamentService;
import com.golfclub.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/tournaments")
public class TournamentController {

    private final TournamentService tournamentService;
    private final MemberService memberService;

    @Autowired
    public TournamentController(TournamentService tournamentService, MemberService memberService) {
        this.tournamentService = tournamentService;
        this.memberService = memberService;
    }

    @GetMapping
    public List<Tournament> getAllTournaments() {
        return tournamentService.getAllTournaments();
    }

    @GetMapping("/{id}")
    public Optional<Tournament> getTournamentById(@PathVariable Long id) {
        return tournamentService.getTournamentById(id);
    }

    @PostMapping
    public Tournament addTournament(@RequestBody Tournament tournament) {
        return tournamentService.addTournament(tournament);
    }

    @DeleteMapping("/{id}")
    public void deleteTournament(@PathVariable Long id) {
        tournamentService.deleteTournament(id);
    }

    @PostMapping("/{tournamentId}/members/{memberId}")
    public Tournament addMemberToTournament(
            @PathVariable Long tournamentId,
            @PathVariable Long memberId) {
        Tournament tournament = tournamentService.getTournamentById(tournamentId)
                .orElseThrow(() -> new RuntimeException("Tournament not found"));
        Member member = memberService.getMemberById(memberId)
                .orElseThrow(() -> new RuntimeException("Member not found"));

        // Bi-directional association
        tournament.getMembers().add(member);
        member.getTournaments().add(tournament);

        // Save both sides of the relationship
        tournamentService.addTournament(tournament);
        memberService.addMember(member);

        return tournament;
    }

    @PostMapping("/debug")
    public String debug(@RequestBody String body) {
        return "Raw: " + body;
    }
}




