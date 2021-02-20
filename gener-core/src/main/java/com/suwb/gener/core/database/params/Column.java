package com.suwb.gener.core.database.params;

import com.suwb.gener.core.database.enums.ColumnType;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * sql中列的定义
 * @author suwenbo
 * @date 2021/2/20 3:48 PM
 */
@Data
@AllArgsConstructor
public class Column {

    /** 
     * 字段名
     * @date 2021/2/20 3:53 PM
     */
    private String name;

    /** 
     * 字段类型
     * @date 2021/2/20 3:53 PM
     */
    private ColumnType type;

    /** 
     * 字段注释
     * @date 2021/2/20 3:53 PM
     */
    private String comment;
}