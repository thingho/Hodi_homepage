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
    public HashMap<String, Object> selectAll(int page, String category, String word) {

        HashMap<String, Object> map = new HashMap<>();

        //게시글 전체개수
        int listCount = newsMapper.selectListCount(category,word);
        //최대페이지
        int maxPage = (int)Math.ceil((double)listCount/10);
        int startPage = (int)((page-1)/10)*10; // 시작페이지 1
        int endPage = startPage+10-1; // 마지막페이지

        int startRow = (page-1)*10+1; //1page : 1-20, 2page : 21-40
        int endRow = startRow+10-1;

        //endPage가 maxPage보다 더 크면 maxPage만 노출
        if(endPage>maxPage) endPage=maxPage;

        ArrayList<NewsDto> news = newsMapper.selectAll(startPage,endRow,category,word);

        map.put("news",news);

        map.put("listCount", listCount);
        map.put("maxPage", maxPage);
        map.put("startPage", startPage);
        map.put("endPage", endPage);
        map.put("page", page);

        map.put("category",category);
        map.put("word",word);
        return map;
    }


    @Override
    public HashMap<String, Object> selectOne(int nno) {

        HashMap<String, Object> map = new HashMap<>();
        NewsDto newsDto = newsMapper.selectOne(nno);

        map.put("newsDto",newsDto);
        return map;
    }

    @Override
    public void insertOne(NewsDto ndto) {
        newsMapper.insertOne(ndto);
    }

    @Override
    public void deleteOne(int nno) {
        newsMapper.deleteOne(nno);
    }

    @Override
    public void updateOne(NewsDto ndto) {
        newsMapper.updateOne(ndto);
    }
}
