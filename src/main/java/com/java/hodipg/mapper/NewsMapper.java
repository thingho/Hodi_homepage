package com.java.hodipg.mapper;

import com.java.hodipg.dto.NewsDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.ArrayList;

@Mapper
public interface NewsMapper {
    ArrayList<NewsDto> selectAll();

    NewsDto selectOne(int nno);
}
