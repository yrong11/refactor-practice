package com.twu.refactoring;

import java.util.*;

public class DateParser {
    private final String dateAndTimeString;
    private static final HashMap<String, TimeZone> KNOWN_TIME_ZONES = new HashMap<String, TimeZone>();
    private static String RANGE_ERROR_MSG = "%s cannot be less than %d or more than %d";
    private static String INDEX_OUT_ERR_MSG = "%s string is less than %d characters";
    private static String NOT_INT_ERR_MSG = "%s is not an integer";
    private DATE date_Obj = new DATE();


    static {
        KNOWN_TIME_ZONES.put("UTC", TimeZone.getTimeZone("UTC"));
    }

    public DateParser(String dateAndTimeString) {
        this.dateAndTimeString = dateAndTimeString;
    }

    public Date parse() {
        int year, month, date, hour, minute;

        year = checkDateAndGetValue(dateAndTimeString, DATE.YEAR);
        month = checkDateAndGetValue(dateAndTimeString, DATE.MONTH);
        date = checkDateAndGetValue(dateAndTimeString, DATE.DATE);

        if (dateAndTimeString.startsWith("Z", 11)) {
            hour = 0;
            minute = 0;
        } else {
            hour = checkDateAndGetValue(dateAndTimeString, DATE.HOUR);
            minute = checkDateAndGetValue(dateAndTimeString, DATE.MINUTE);
        }

        Calendar calendar = Calendar.getInstance();
        calendar.setTimeZone(TimeZone.getTimeZone("UTC"));
        calendar.set(year, month - 1, date, hour, minute, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTime();
    }


    public int checkDateAndGetValue(String dateAndTimeString, String sign){
        int[] index = new int[2];
        int[] range = new int[2];
        int date_value = 0;

        date_Obj.setIndexAndRange(index, range, sign);
        try {
            String dateString = dateAndTimeString.substring(index[0], index[1]);
            date_value = Integer.parseInt(dateString);
        } catch (StringIndexOutOfBoundsException e) {
            throw new IllegalArgumentException(String.format(INDEX_OUT_ERR_MSG, sign, index[1]-index[0]));
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(String.format(NOT_INT_ERR_MSG, sign));
        }
        if (date_value < range[0] || date_value > range[1])
            throw new IllegalArgumentException(String.format(RANGE_ERROR_MSG, sign, range[0], range[1]));

        return date_value;
    }


}
