package com.java.hodipg.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class PopupDto {

    private int pno;
    private String name;
    private String ptitle;
    private String pcontent;
    private Date pdate;
    private String pfile;
    private String pshow;
}
