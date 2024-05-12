package com.gfg.JBDL70DB.db;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@AllArgsConstructor
@ToString
@Builder
public class Person {
    private String name;
    private int id;
}
