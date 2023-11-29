package com.java.hodipg.mapper;

import com.java.hodipg.dto.PopupDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.ArrayList;

@Mapper
public interface PopupMapper {

    ArrayList<PopupDto> selectAll(int startRow, int endRow, String category, String word);

    PopupDto selectOne(int pno);

    int selectListCount(String category, String word);

    void insertOne(PopupDto pdto);

    void updateOne(PopupDto pdto);

    void deleteOne(int pno);

    //index에 나타나는 팝업창
    PopupDto selectPopup();
}
