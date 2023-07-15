package com.overflow.hellospringboot.service;

import com.overflow.hellospringboot.domain.Member;
import com.overflow.hellospringboot.repository.MemberRepository;
import com.overflow.hellospringboot.repository.MemoryMemberRepository;
import java.util.List;
import java.util.Optional;

public class MemberService {

    private MemberRepository memberRepository = new MemoryMemberRepository();

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }
    
    private void validateDuplicateMember(Member member) {
        memberRepository.findByName(member.getName()).ifPresent(m -> {
            throw new IllegalStateException("이미 존재하는 회원 입니다.");
        });

        memberRepository.save(member);
    }

    public long join(Member member) {
        validateDuplicateMember(member);

        memberRepository.save(member);

        return member.getId();
    }

    public List<Member> findMembers() {
        return memberRepository.findAll();
    }

    public Optional<Member> findOne(long id) {
        return memberRepository.findById(id);
    }
}
