package com.suwb.gener.core.database.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Optional;
import java.util.stream.Stream;

/**
 * mysql 的字段类型定义。
 * 只写了目前用的上的。
 * @author suwenbo
 * @date 2021/2/20 3:54 PM
 */
@Getter
@AllArgsConstructor
public enum ColumnType {

    BIGINT("BIGINT", "Long"),
    INT("INT", "Integer"),
    TINYINT("TINYINT", "Integer"),
    VARCHAR("VARCHAR", "String"),
    TEXT("TEXT", "String"),
    LONGTEXT("LONGTEXT", "String"),
    DATETIME("DATETIME", "Date"),
    UNKNOWN("未知类型", "未知类型"),
    ;

    /**
     * 字段类型
     * @date 2021/2/20 4:14 PM
     */
    private String columnType;

    /**
     * Java的代码类型
     * @date 2021/2/20 4:14 PM
     */
    private String javaType;

    public static ColumnType of(String columnType) {
        Optional<ColumnType> optionalColumnType = Stream.of(ColumnType.values()).filter(e->columnType.equalsIgnoreCase(e.getColumnType())).findFirst();
        if(optionalColumnType.isPresent()) {
            return optionalColumnType.get();
        } else {
            return UNKNOWN;
        }
    }
}