package com.j4mt.app.web.ui.tests.util.date;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author j4mt
 */
public class DateHelper {

    private static String formatDate = "dd/MM/yyyy";
    private static DateFormat dateFormat = new SimpleDateFormat(formatDate );

    public static String getTodayDate(){


        Calendar cal = Calendar.getInstance();
        Date date = new Date();
        return dateFormat.format(date);
    }

    public static String getYesterdaysDate() {


        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, -1);
        return dateFormat.format(cal.getTime());

    }
}
