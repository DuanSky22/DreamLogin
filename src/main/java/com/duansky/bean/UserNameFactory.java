package com.duansky.bean;

import java.text.NumberFormat;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by SkyDream on 2016/7/14.
 */
public class UserNameFactory {

    private String year;
    private String institude;
    private String id;

    private static String[] YEARS = {"2014","2013","2015","2016","2012","2011","2010","2017"};
    private static String[] INSTITUDES = {"28015029"};

    private static int counter = 0;
    private static final int MAX_COUNTER = 999;

    private static int yearFlag = 0;
    private static int institudeFlag = 0;

    private static NumberFormat nf = NumberFormat.getInstance();
    static {
        nf.setMaximumIntegerDigits(3);
        nf.setMinimumIntegerDigits(3);
    }

    public static String getNextUserName(){
        counter++;
        if(counter > MAX_COUNTER) {
            counter = 0;
            institudeFlag++;
        }
        if(institudeFlag >= INSTITUDES.length){
            institudeFlag = 0;
            yearFlag++;
        }
        if(yearFlag >= YEARS.length)
            return "";
        return YEARS[yearFlag]+INSTITUDES[institudeFlag]+nf.format(counter);
    }

}
