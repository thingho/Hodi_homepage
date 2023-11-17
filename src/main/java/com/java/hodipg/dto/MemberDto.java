package com.java.hodipg.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MemberDto {

    private int no;
    private String name;
    private String id;
    private String pw;
    private int level;
}
