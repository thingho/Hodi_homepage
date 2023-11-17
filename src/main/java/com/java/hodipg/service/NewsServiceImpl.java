package com.java.hodipg.service;

import com.java.hodipg.dto.NewsDto;
import com.java.hodipg.mapper.NewsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;

@Service
public class NewsServiceImpl implements NewsSerivce{

    @Autowired
    NewsMapper newsMapper;
    @Override
    public HashMap<String, Object> selectAll() {

        HashMap<String, Object> map = new HashMap<>();
        ArrayList<NewsDto> news = newsMapper.selectAll();

        map.put("news",news);
        return map;
    }

    @Override
    public HashMap<String, Object> selectOne(int nno) {

        HashMap<String, Object> map = new HashMap<>();
        NewsDto newsDto = newsMapper.selectOne(nno);

        map.put("newsDto",newsDto);
        return map;
    }
}
