package com.springbootdemo.config;

import com.springbootdemo.repository.JpaMemberRepository;
import com.springbootdemo.repository.MemberRepository;
import com.springbootdemo.repository.MemoryMemberRepository;
import com.springbootdemo.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;

@Configuration
public class SpringConfig {

    private EntityManager em;

    @Autowired
    public SpringConfig(EntityManager em) {
        this.em = em;
    }

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository(){
        //return new MemoryMemberRepository();
        return new JpaMemberRepository(em);
    }

}
