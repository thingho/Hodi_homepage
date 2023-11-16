package com.java.hodipg.mapper;

import com.java.hodipg.dto.MemberDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberMapper {

    MemberDto selectLogin(MemberDto memberDto);
}
