package com.golfclub.model;

import jakarta.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Tournament {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String startDate;
    private String endDate;
    private String location;
    private double entryFee;
    private double cashPrizeAmount;

    @ManyToMany
    @JoinTable(
            name = "tournament_member",
            joinColumns = @JoinColumn(name = "tournament_id"),
            inverseJoinColumns = @JoinColumn(name = "member_id")
    )
    private Set<Member> members = new HashSet<>();

    // Constructors
    public Tournament() {}

    // Getters and Setters
    public Long getId() { return id; }
    public String getStartDate() { return startDate; }
    public void setStartDate(String startDate) { this.startDate = startDate; }
    public String getEndDate() { return endDate; }
    public void setEndDate(String endDate) { this.endDate = endDate; }
    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }
    public double getEntryFee() { return entryFee; }
    public void setEntryFee(double entryFee) { this.entryFee = entryFee; }
    public double getCashPrizeAmount() { return cashPrizeAmount; }
    public void setCashPrizeAmount(double cashPrizeAmount) { this.cashPrizeAmount = cashPrizeAmount; }
    public Set<Member> getMembers() { return members; }
    public void setMembers(Set<Member> members) { this.members = members; }
}





