package com.golfclub.model;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String memberName;
    private String memberAddress;
    private String memberEmailAddress;
    private String memberPhoneNumber;
    private LocalDate startDateOfMembership;
    private int durationOfMembership;

    @ManyToMany(mappedBy = "members")
    private Set<Tournament> tournaments = new HashSet<>();

    // Constructors
    public Member() {}

    // Getters and Setters
    public Long getId() { return id; }
    public String getMemberName() { return memberName; }
    public void setMemberName(String memberName) { this.memberName = memberName; }
    public String getMemberAddress() { return memberAddress; }
    public void setMemberAddress(String memberAddress) { this.memberAddress = memberAddress; }
    public String getMemberEmailAddress() { return memberEmailAddress; }
    public void setMemberEmailAddress(String memberEmailAddress) { this.memberEmailAddress = memberEmailAddress; }
    public String getMemberPhoneNumber() { return memberPhoneNumber; }
    public void setMemberPhoneNumber(String memberPhoneNumber) { this.memberPhoneNumber = memberPhoneNumber; }
    public LocalDate getStartDateOfMembership() { return startDateOfMembership; }
    public void setStartDateOfMembership(LocalDate startDateOfMembership) { this.startDateOfMembership = startDateOfMembership; }
    public int getDurationOfMembership() { return durationOfMembership; }
    public void setDurationOfMembership(int durationOfMembership) { this.durationOfMembership = durationOfMembership; }

    public Set<Tournament> getTournaments() { return tournaments; }
    public void setTournaments(Set<Tournament> tournaments) { this.tournaments = tournaments; }
}

