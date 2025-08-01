package com.golfclub.controller;

import com.golfclub.model.Member;
import com.golfclub.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/members")
public class MemberController {

    private final MemberService memberService;

    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping
    public List<Member> getAllMembers() {
        return memberService.getAllMembers();
    }

    @GetMapping("/{id}")
    public Optional<Member> getMemberById(@PathVariable Long id) {
        return memberService.getMemberById(id);
    }

    @PostMapping
    public Member addMember(@RequestBody Member member) {
        return memberService.addMember(member);
    }

    @DeleteMapping("/{id}")
    public void deleteMember(@PathVariable Long id) {
        memberService.deleteMember(id);
    }

    // Search endpoints

    // members search name or phone or duration or membershipType
    @GetMapping("/search")
    public List<Member> searchMembers(@RequestParam(required = false) String name,
                                      @RequestParam(required = false) String phone,
                                      @RequestParam(required = false) Integer duration,
                                      @RequestParam(required = false) String membershipType) {
        if (name != null) {
            return memberService.searchByName(name);
        }
        if (phone != null) {
            return memberService.searchByPhone(phone);
        }
        if (duration != null) {
            return memberService.searchByDuration(duration);
        }
        if (membershipType != null) {
            return memberService.searchByMembershipType(membershipType);
        }
        return memberService.getAllMembers();
    }

    @GetMapping("/by-tournament")
    public List<Member> searchMembersByTournamentStartDate(@RequestParam String startDate) {
        return memberService.searchByTournamentStartDate(startDate);
    }
}



