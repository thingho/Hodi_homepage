package com.java.hodipg.service;

import com.java.hodipg.dto.MemberDto;
import com.java.hodipg.mapper.MemberMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberServiceImpl implements MemberService{

    @Autowired
    MemberMapper memberMapper;

    @Override
    public MemberDto selectLogin(MemberDto memberDto) {
        //mapper 호출
        MemberDto mdto = memberMapper.selectLogin(memberDto);
        return mdto;
    }
}
