package com.suwb.gener.core.database.utils;

import com.google.common.base.CaseFormat;

/**
 * @author suwenbo
 * @date 2021/2/20 4:26 PM
 */
public class CaseFormatUtil {
    
    /** 
     * 下划线转驼峰
     * @version 1.0
     * @author suwenbo
     * @date 2021/2/20 4:28 PM
     * @param underScore
     * @return java.lang.String
     * @see java.lang.String
     * @throws        
     */
    public static String formatFromUnderScoreToCamel(String underScore) {
        return CaseFormat.LOWER_UNDERSCORE.to(CaseFormat.LOWER_CAMEL, underScore);
    }
}