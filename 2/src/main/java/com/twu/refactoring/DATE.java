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

    public void setIndexAndRange(int[] index, int[] range, String sign){
        switch (sign){
            case "Year":
                System.arraycopy(DATE_INDEX.YEAR, 0, index, 0, 2);
                System.arraycopy(DATE_RANGE.YEAR, 0, range, 0, 2);
                break;
            case "Date":
                System.arraycopy(DATE_INDEX.DATE, 0, index, 0, 2);
                System.arraycopy(DATE_RANGE.DATE, 0, range, 0, 2);
                break;
            case "Minute":
                System.arraycopy(DATE_INDEX.MINUTE, 0, index, 0, 2);
                System.arraycopy(DATE_RANGE.MINUTE, 0, range, 0, 2);
                break;
            case "Month":
                System.arraycopy(DATE_INDEX.MONTH, 0, index, 0, 2);
                System.arraycopy(DATE_RANGE.MONTH, 0, range, 0, 2);
                break;
            case "Hour" :
                System.arraycopy(DATE_INDEX.HOUR, 0, index, 0, 2);
                System.arraycopy(DATE_RANGE.HOUR, 0, range, 0, 2);
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + sign);
        }
    }


}
