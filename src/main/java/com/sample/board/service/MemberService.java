package com.sample.board.service;

import com.sample.board.dto.MemberDTO;
import com.sample.board.entity.MemberEntity;
import com.sample.board.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    // 회원가입
    public void join(MemberDTO memberDTO) {
        MemberEntity memberEntity = MemberEntity.toMemberEntity(memberDTO);
        memberRepository.save(memberEntity);
    }

    // 로그인
    public MemberDTO login(MemberDTO memberDTO) {
        // 이메일로 회원정보 조회
        Optional<MemberEntity> byMemberEmail = memberRepository.findByMemberEmail(memberDTO.getMemberEmail());

        if(byMemberEmail.isPresent()) {
            // 이메일 일치
            MemberEntity memberEntity = byMemberEmail.get();

            if(memberEntity.getMemberPassword().equals(memberDTO.getMemberPassword())) {
                // 비밀번호 일치
                MemberDTO dto = MemberDTO.toMemberDTO(memberEntity);
                return dto;
            } else {
                // 비밀번호 불일치
                return null;
            }
        } else {
            // 이메일 불일치
            return null;
        }
    }

}
