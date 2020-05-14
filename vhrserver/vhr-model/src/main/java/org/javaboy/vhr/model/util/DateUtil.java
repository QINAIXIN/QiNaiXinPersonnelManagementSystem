package org.javaboy.vhr.model.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

    /**
     * 日期转换为字符串格式
     * @param date
     * @param patter
     * @return
     */
    public static String formatDate(Date date, String patter){
        SimpleDateFormat sdf = new SimpleDateFormat(patter);
        String format = sdf.format(date);
        return format;
    }
}
