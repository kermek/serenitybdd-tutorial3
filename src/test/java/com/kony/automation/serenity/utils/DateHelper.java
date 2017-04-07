package com.kony.automation.serenity.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateHelper {
    public static final String  TEST_DATA_DATE_FORMAT = "yyyy-MM-dd";

    public static Date getDateFromString(String text) {
        Date dt;
        try {
            dt = new SimpleDateFormat(TEST_DATA_DATE_FORMAT).parse(text);
        } catch (ParseException e) {
            throw new Error(e);
        }
        return dt;
    }
}
