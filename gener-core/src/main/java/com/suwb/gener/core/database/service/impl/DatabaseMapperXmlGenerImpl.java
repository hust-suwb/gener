package com.suwb.gener.core.database.service.impl;

import com.suwb.gener.core.database.params.Column;
import com.suwb.gener.core.database.service.DatabaseGener;
import com.suwb.gener.core.database.utils.CaseFormatUtil;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author suwenbo
 * @date 2021/2/20 3:43 PM
 */
public class DatabaseMapperXmlGenerImpl implements DatabaseGener {

    private static final String TEMPLATE = "<result column=\"%s\" jdbcType=\"%s\" property=\"%s\" />";

    @Override
    public String gen(String createTableSql) {
        List<Column> columns = parseCreateTableSql(createTableSql);
        return columns.stream().map(e->String.format(TEMPLATE, e.getName(), e.getType().getColumnType(), CaseFormatUtil.formatFromUnderScoreToCamel(e.getName()))).collect(Collectors.joining("\n"));
    }
}