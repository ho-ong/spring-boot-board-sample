package com.sample.board.service;

import com.sample.board.dto.MemberDTO;
import com.sample.board.entity.MemberEntity;
import com.sample.board.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
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

    // 회원목록
    public List<MemberDTO> findAll() {
        List<MemberEntity> memberEntityList = memberRepository.findAll();
        List<MemberDTO> memberDTOList = new ArrayList<>();

        for(MemberEntity memberEntity : memberEntityList) {
            memberDTOList.add(MemberDTO.toMemberDTO(memberEntity));
        }

        return memberDTOList;
    }

    // 회원정보 조회
    public MemberDTO findById(Long id) {
        Optional<MemberEntity> optionalMemberEntity = memberRepository.findById(id);

        if(optionalMemberEntity.isPresent()) {
            return MemberDTO.toMemberDTO(optionalMemberEntity.get());
        } else {
            return null;
        }
    }

    // 회원정보 수정
    public MemberDTO updateForm(String myEmail) {
        Optional<MemberEntity> optionalMemberEntity = memberRepository.findByMemberEmail(myEmail);

        if(optionalMemberEntity.isPresent()) {
            return MemberDTO.toMemberDTO(optionalMemberEntity.get());
        } else {
            return null;
        }
    }

    public void update(MemberDTO memberDTO) {
        memberRepository.save(MemberEntity.toUpdateMemberEntity(memberDTO));
    }

    // 회원정보 삭제
    public void deleteById(Long id) {
        memberRepository.deleteById(id);
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

    // 이메일 중복체크
    public String emailCheck(String memberEmail) {
        Optional<MemberEntity> byMemberEmail = memberRepository.findByMemberEmail(memberEmail);

        if(byMemberEmail.isPresent()) {
            // 조회결과가 있으면 사용불가
            return null;
        } else {
            // 조회결과가 없으면 사용가능
            return "ok";
        }
    }

}
