package com.overflow.hellospringboot.service;

import com.overflow.hellospringboot.domain.Member;
import com.overflow.hellospringboot.repository.MemoryMemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MemberServiceTest {

    MemberService memberService;
    MemoryMemberRepository memberRepository = new MemoryMemberRepository();

    @BeforeEach
    public void beforeEach() {
        memberRepository = new MemoryMemberRepository();
        memberService = new MemberService(memberRepository);
    }
    
    @AfterEach
    public void afterEach() {
        memberRepository.clearStore();
    }
    
    @Test
    public void join() {
        Member member = new Member();
        member.setName("Spring");

        long id = memberService.join(member);

        Member findMember = memberService.findOne(id).get();
        Assertions.assertThat(member.getName()).isEqualTo(findMember.getName());
    }

    @Test
    public void isAlready() {
        Member member1 = new Member();
        member1.setName("Spring T");

        Member member2 = new Member();
        member2.setName("Spring T");

        memberService.join(member1);
        IllegalStateException ex = assertThrows(IllegalStateException.class, () -> memberService.join(member2));
        
        Assertions.assertThat(ex.getMessage()).isEqualTo("이미 존재하는 회원 입니다.");
    }

    @Test
    public void findMembers() {

    }
}