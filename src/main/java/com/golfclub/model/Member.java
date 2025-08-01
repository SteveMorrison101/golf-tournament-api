package com.golfclub.model;

import jakarta.persistence.*;
import java.util.HashSet;
import java.util.Set;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String memberName;
    private String memberAddress;
    private String memberEmailAddress;
    private String memberPhoneNumber;
    private String startDateOfMembership;
    private int durationOfMembership;
    private String membershipType; // <-- NEW FIELD

    @ManyToMany(mappedBy = "members")
    @JsonIgnore  // Prevent infinite recursion
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
    public String getStartDateOfMembership() { return startDateOfMembership; }
    public void setStartDateOfMembership(String startDateOfMembership) { this.startDateOfMembership = startDateOfMembership; }
    public int getDurationOfMembership() { return durationOfMembership; }
    public void setDurationOfMembership(int durationOfMembership) { this.durationOfMembership = durationOfMembership; }
    public String getMembershipType() { return membershipType; }
    public void setMembershipType(String membershipType) { this.membershipType = membershipType; }
    public Set<Tournament> getTournaments() { return tournaments; }
    public void setTournaments(Set<Tournament> tournaments) { this.tournaments = tournaments; }
}






