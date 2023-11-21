package com.java.hodipg.mapper;

import com.java.hodipg.dto.NewsDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.ArrayList;

@Mapper
public interface NewsMapper {
    ArrayList<NewsDto> selectAll(int startRow, int endRow,String category,String word);

    NewsDto selectOne(int nno);

    void insertOne(NewsDto ndto);

    void deleteOne(int nno);

    void updateOne(NewsDto ndto);

    int selectListCount(String category, String word);
}
