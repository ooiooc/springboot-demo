package com.springbootdemo.service;

import com.springbootdemo.domain.Member;
import com.springbootdemo.repository.MemberRepository;
import com.springbootdemo.repository.MemoryMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

//@Service // 스프링 컨테이너에 서비스 등록
public class MemberService {

    private final MemberRepository memberRepository;

    // 의존성 주입
    @Autowired
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    // 회원가입
    public Long join(Member member){
        validateDuplicateMember(member); // 중복 회원 검증
        memberRepository.save(member);
        return member.getId();
    }
    // 유효성 검사
    private void validateDuplicateMember(Member member) {
        memberRepository.findByName(member.getName())
                .ifPresent(member1 -> {
                    throw new IllegalStateException("이미 존재하는 회원입니다.");
        });
    }

    // 전체 회원 조회
    public List<Member> findMembers(){
        return memberRepository.findAll();
    }

    // 회원 정보 조회
    public Optional<Member> findOne(long memberId){
        return memberRepository.findById(memberId);
    }



}
