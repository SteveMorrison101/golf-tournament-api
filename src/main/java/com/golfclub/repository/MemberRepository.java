package com.golfclub.repository;

import com.golfclub.model.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {
    List<Member> findByMemberNameContainingIgnoreCase(String memberName);
    List<Member> findByMemberPhoneNumber(String memberPhoneNumber);
    List<Member> findByDurationOfMembership(int durationOfMembership);
    List<Member> findByTournaments_StartDate(String startDate);

    // Search by membership type
    List<Member> findByMembershipTypeContainingIgnoreCase(String membershipType);
}



