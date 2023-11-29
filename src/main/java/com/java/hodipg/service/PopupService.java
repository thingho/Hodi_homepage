package com.java.hodipg.service;

import com.java.hodipg.dto.PopupDto;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public interface PopupService {
    HashMap<String, Object> selectAll(int page, String category, String word);

    HashMap<String, Object> selectOne(int pno);

    void insertOne(PopupDto pdto);

    void deleteOne(int pno);

    void updateOne(PopupDto pdto);

    //index에 나타나는 팝업창
    HashMap<String, Object> selectPopup();
}
