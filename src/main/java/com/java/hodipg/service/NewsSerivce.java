package com.java.hodipg.service;

import com.java.hodipg.dto.NewsDto;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public interface NewsSerivce {
    HashMap<String, Object> selectAll(int page, String category, String word);

    HashMap<String, Object> selectOne(int nno);

    void insertOne(NewsDto ndto);

    void deleteOne(int nno);

    void updateOne(NewsDto ndto);
}
