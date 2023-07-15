package com.overflow.hellospringboot;

import com.overflow.hellospringboot.repository.MemberRepository;
import com.overflow.hellospringboot.repository.MemoryMemberRepository;
import com.overflow.hellospringboot.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {
    
    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }
    
    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }
}
