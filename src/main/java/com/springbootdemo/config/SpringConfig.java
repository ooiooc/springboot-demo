package com.springbootdemo.config;

import com.springbootdemo.repository.MemberRepository;
import com.springbootdemo.repository.MemoryMemberRepository;
import com.springbootdemo.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository(){
        return new MemoryMemberRepository();
    }

}
