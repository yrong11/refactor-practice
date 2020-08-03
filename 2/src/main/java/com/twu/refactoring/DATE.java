package com.twu.refactoring;

public class DATE {
    public String name;
    public int[] index;
    public int[] range;

    public static String MONTH = "Month";
    public static String YEAR = "Year";
    public static String DATE = "Date";
    public static String HOUR = "Hour";
    public static String MINUTE = "Minute";

    static class DATE_INDEX{
        static int[] MONTH = {5, 7};
        static int[] YEAR = {0, 4};
        static int[] DATE = {8, 10};
        static int[] HOUR = {11, 13};
        static int[] MINUTE = {14, 16};
    }

    static class DATE_RANGE{
        static int[] MONTH = {1, 12};
        static int[] YEAR = {2000, 2012};
        static int[] DATE = {1, 31};
        static int[] HOUR = {0, 23};
        static int[] MINUTE = {0, 59};
    }


    public void setIndexAndRange(String sign) {
        switch (sign) {
            case "Year":
                this.index = DATE_INDEX.YEAR;
                this.range = DATE_RANGE.YEAR;
                break;
            case "Date":
                this.index = DATE_INDEX.DATE;
                this.range = DATE_RANGE.DATE;
                break;
            case "Minute":
                this.index = DATE_INDEX.MINUTE;
                this.range = DATE_RANGE.MINUTE;
                break;
            case "Month":
                this.index = DATE_INDEX.MONTH;
                this.range = DATE_RANGE.MONTH;
                break;
            case "Hour":
                this.index = DATE_INDEX.HOUR;
                this.range = DATE_RANGE.HOUR;
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + sign);
        }
    }


}
