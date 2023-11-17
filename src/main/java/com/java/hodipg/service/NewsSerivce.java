package com.java.hodipg.service;

import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public interface NewsSerivce {
    HashMap<String, Object> selectAll();

    HashMap<String, Object> selectOne(int nno);
}
