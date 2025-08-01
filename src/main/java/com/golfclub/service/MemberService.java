package com.golfclub.service;

import com.golfclub.model.Member;
import com.golfclub.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MemberService {
    private final MemberRepository memberRepository;

    @Autowired
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public List<Member> getAllMembers() {
        return memberRepository.findAll();
    }

    public Optional<Member> getMemberById(Long id) {
        return memberRepository.findById(id);
    }

    public Member addMember(Member member) {
        return memberRepository.save(member);
    }

    public void deleteMember(Long id) {
        memberRepository.deleteById(id);
    }

    public List<Member> searchByName(String name) {
        return memberRepository.findByMemberNameContainingIgnoreCase(name);
    }

    public List<Member> searchByPhone(String phone) {
        return memberRepository.findByMemberPhoneNumber(phone);
    }

    public List<Member> searchByDuration(int duration) {
        return memberRepository.findByDurationOfMembership(duration);
    }

    public List<Member> searchByTournamentStartDate(String startDate) {
        return memberRepository.findByTournaments_StartDate(startDate);
    }

    // search by membershipType
    public List<Member> searchByMembershipType(String membershipType) {
        return memberRepository.findByMembershipTypeContainingIgnoreCase(membershipType);
    }
}



