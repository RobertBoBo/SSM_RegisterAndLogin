package com.yyb.utils;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class MyDateConverter implements Converter<String,Date> {

    @Override
    public Date convert(String s) {
// HH:mm:ss
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        Date date = null ;

        try {
            date = sdf.parse(s);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return date;
    }
}
