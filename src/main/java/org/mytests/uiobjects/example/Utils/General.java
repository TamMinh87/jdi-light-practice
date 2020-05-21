package org.mytests.uiobjects.example.Utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class General {
    public static String getCurrentDate(String formatDate) {
        SimpleDateFormat format = new SimpleDateFormat(formatDate);
        return format.format(new Date());
    }
}
