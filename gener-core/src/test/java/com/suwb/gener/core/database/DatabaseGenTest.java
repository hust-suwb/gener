package com.suwb.gener.core.database;

import com.suwb.gener.core.database.service.impl.DatabaseEntityGenerImpl;
import com.suwb.gener.core.database.service.impl.DatabaseMapperXmlGenerImpl;
import com.suwb.gener.core.database.service.impl.DatabaseVoGenerImpl;
import org.junit.Test;

/**
 * @author suwenbo
 * @date 2021/2/20 4:04 PM
 */
public class DatabaseGenTest {

    private final String createTableSql = "CREATE TABLE `test` (\n" +
            "  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键id',\n" +
            "  `name` varchar(256) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '名称',\n" +
            "  `is_valid` tinyint(1) NOT NULL DEFAULT '1' COMMENT '是否有效',\n" +
            "  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',\n" +
            "  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',\n" +
            "  PRIMARY KEY (`id`),\n" +
            "  KEY `idx_name` (`name`)\n" +
            ") ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='测试格式'";

    @Test
    public void test1() {
        DatabaseEntityGenerImpl gener = new DatabaseEntityGenerImpl();
        String result = gener.gen(createTableSql);
        System.out.println(result);
    }

    @Test
    public void test2() {
        DatabaseVoGenerImpl gener = new DatabaseVoGenerImpl();
        String result = gener.gen(createTableSql);
        System.out.println(result);
    }

    @Test
    public void test3() {
        DatabaseMapperXmlGenerImpl gener = new DatabaseMapperXmlGenerImpl();
        String result = gener.gen(createTableSql);
        System.out.println(result);
    }
}