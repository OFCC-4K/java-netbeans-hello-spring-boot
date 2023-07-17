package com.overflow.hellospringboot.repository;

import com.overflow.hellospringboot.domain.Member;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

public class MemoryMemberRepositoryTest {

    MemoryMemberRepository repository = new MemoryMemberRepository();

    @AfterEach // 함수 실행이 끝날 때 마다 자동 실행되는 콜백 어노테이션
    public void afterEach() {
        repository.clearStore();
    }

    @Test
    public void save() {
        Member member = new Member();
        member.setName("Spring");

        repository.save(member);

        Member result = repository.findById(member.getId()).get();

        Assertions.assertThat(member).isEqualTo(result);
    }

    @Test
    public void findByName() {
        Member member1 = new Member();
        member1.setName("Spring 1");

        repository.save(member1);

        Member member2 = new Member();
        member2.setName("Spring 2");

        repository.save(member2);

        Member result = repository.findByName("Spring 1").get();

        Assertions.assertThat(member1).isEqualTo(result);
    }

    @Test
    public void findAll() {
        Member member1 = new Member();
        member1.setName("Spring 1");

        repository.save(member1);

        Member member2 = new Member();
        member2.setName("Spring 2");

        repository.save(member2);

        List<Member> result = repository.findAll();

        Assertions.assertThat(result.size()).isEqualTo(2);
    }
}
