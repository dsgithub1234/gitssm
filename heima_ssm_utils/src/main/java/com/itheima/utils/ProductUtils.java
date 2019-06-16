package com.itheima.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ProductUtils {
     //日期转换为字符串
    public  static String getParse(Date date,String str){
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat(str);
        String format = simpleDateFormat.format(date);
        return format;
    }
    //字符串转换为日期
    public static Date getDate(String str,String sr) throws ParseException {
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat(str);
        Date parse = simpleDateFormat.parse(sr);
        return parse;
    }


}
