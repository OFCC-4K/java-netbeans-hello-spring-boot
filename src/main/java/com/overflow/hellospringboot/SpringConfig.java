package com.overflow.hellospringboot;

import com.overflow.hellospringboot.aop.TimeTraceAop;
import com.overflow.hellospringboot.repository.MemberRepository;
import com.overflow.hellospringboot.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {
    
    //private DataSource dataSource; // JDBC
    //private EntityManager em; // JPA
    private final MemberRepository memberRepository; // Spring Data JPA
    
    @Autowired
    public SpringConfig(MemberRepository memberRepository) { // DataSource dataSource // JDBC, EntityManager em // JPA
        //this.dataSource = dataSource; // JDBC
        // this.em = em; // JPA
        this.memberRepository = memberRepository; // Spring Data JPA
    }
    
    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository); // memberRepository() // JDBC, JPA
    }
    
    /*
    // Spring Data JPA 는 해당 메서드 필요 없음.
    @Bean
    public MemberRepository memberRepository() {
        //return new JdbcTemplateMemberRepository(dataSource); // JDBC
        //return new JpaMemberRepository(em); // JPA
    }*/
}
