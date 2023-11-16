package com.java.hodipg.service;

import com.java.hodipg.dto.MemberDto;
import org.springframework.stereotype.Service;

@Service
public interface MemberService {

    MemberDto selectLogin(MemberDto memberDto);
}
