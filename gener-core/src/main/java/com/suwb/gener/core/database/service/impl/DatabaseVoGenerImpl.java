package com.suwb.gener.core.database.service.impl;

import com.suwb.gener.core.database.params.Column;
import com.suwb.gener.core.database.service.DatabaseGener;
import com.suwb.gener.core.database.utils.CaseFormatUtil;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author suwenbo
 * @date 2021/2/20 3:42 PM
 */
public class DatabaseVoGenerImpl implements DatabaseGener {

    private static final String TEMPLATE = "    @ApiModelProperty(value = \"%s\")\n" +
            "    private %s %s;\n";

    @Override
    public String gen(String createTableSql) {
        List<Column> columns = parseCreateTableSql(createTableSql);
        return columns.stream().map(e->String.format(TEMPLATE, e.getComment(), e.getType().getJavaType(), CaseFormatUtil.formatFromUnderScoreToCamel(e.getName()))).collect(Collectors.joining("\n"));
    }
}