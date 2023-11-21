package com.java.hodipg.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NewsDto {
    private int nno;
    private String name;
    private String ntitle;
    private String ncontent;
    private Date ndate;
    private String nfile;
    private String nlink;
}
