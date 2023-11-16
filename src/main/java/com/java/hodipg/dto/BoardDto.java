package com.java.hodipg.dto;

import lombok.Data;

import java.sql.Date;

@Data
public class BoardDto {

    private int bno;
    private String name;
    private String btitle;
    private String bcontent;
    private Date bdate;
    private String bfile;
}
