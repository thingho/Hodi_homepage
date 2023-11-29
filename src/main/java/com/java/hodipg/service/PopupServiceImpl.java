package com.java.hodipg.service;

import com.java.hodipg.dto.PopupDto;
import com.java.hodipg.mapper.PopupMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.HashMap;

@Service
public class PopupServiceImpl implements PopupService{

    @Autowired
    PopupMapper popupMapper;

    @Override
    public HashMap<String, Object> selectAll(@RequestParam(defaultValue ="1")int page,
                                             String category, String word) {

        HashMap<String, Object> map = new HashMap<>();

        //팝업 전체개수
        int listCount = popupMapper.selectListCount(category,word);
        //최대페이지
        int maxPage = (int)Math.ceil((double)listCount/10);
        int startPage = (int)((page-1)/10)*10+1; // 시작페이지 1
        int endPage = startPage+10-1; // 마지막페이지

        int startRow = (page-1)*10; //1page : 1-20, 2page : 21-40
        int endRow = startRow+10;

        //endPage가 maxPage보다 더 크면 maxPage만 노출
        if(endPage>maxPage) {endPage=maxPage;}

        ArrayList<PopupDto> popup = popupMapper.selectAll(startRow,endRow,category,word);

        map.put("popup",popup);

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
    public HashMap<String, Object> selectOne(int pno) {

        HashMap<String, Object> map = new HashMap<>();
        PopupDto popupDto = popupMapper.selectOne(pno);

        map.put("popupDto",popupDto);
        return map;
    }

    @Override
    public void insertOne(PopupDto pdto) {
        popupMapper.insertOne(pdto);
    }

    @Override
    public void updateOne(PopupDto pdto) {
        popupMapper.updateOne(pdto);
    }

    @Override
    public void deleteOne(int pno) {
        popupMapper.deleteOne(pno);
    }

    //index에 나타나는 팝업창
    @Override
    public HashMap<String, Object> selectPopup() {
        HashMap<String, Object> map = new HashMap<>();
        PopupDto popupDto = popupMapper.selectPopup();

        map.put("popupDto",popupDto);
        return map;
    }
}
