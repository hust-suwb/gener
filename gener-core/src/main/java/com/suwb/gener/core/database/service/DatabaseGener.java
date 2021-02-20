package com.suwb.gener.core.database.service;

import com.suwb.gener.core.database.enums.ColumnType;
import com.suwb.gener.core.database.params.Column;

import java.util.ArrayList;
import java.util.List;

/**
 * mybatis 代码生成
 * @author suwenbo
 * @date 2021/2/20 3:40 PM
 */
public interface DatabaseGener {

    /** 
     * 根据建表语句生成代码
     * @version 1.0
     * @author suwenbo
     * @date 2021/2/20 3:44 PM
     * @param createTableSql
     * @return java.lang.String
     * @see java.lang.String
     * @throws        
     */
    String gen(String createTableSql);

    /** 
     * 解析建表语句
     * @version 1.0
     * @author suwenbo
     * @date 2021/2/20 4:22 PM
     * @param createTableSql
     * @return java.util.List<com.suwb.gener.core.database.params.Column>
     * @see java.util.List<com.suwb.gener.core.database.params.Column>
     * @throws        
     */
    default List<Column> parseCreateTableSql(String createTableSql) {
        List<Column> columns = new ArrayList<>();

        String[] lines = createTableSql.split("\n");
        for(String line : lines) {
            // 跳过第一行
            if(line.toUpperCase().contains("CREATE TABLE")) {
                continue;
            }

            // 到这里就可以退出了
            if(line.toUpperCase().contains("PRIMARY KEY")) {
                break;
            }

            // 解析字段定义行
            String columnName = line.substring(line.indexOf("`") + 1, line.lastIndexOf("`"));
            String dataType = line.trim().split(" ")[1];
            if(dataType.trim().endsWith(")")) {
                dataType = dataType.substring(0, dataType.indexOf("("));
            }
            ColumnType columnType = ColumnType.of(dataType);
            String comment = line.substring(line.indexOf("'") + 1, line.lastIndexOf("'"));

            columns.add(new Column(columnName, columnType, comment));
        }

        return columns;
    }
}