package com.teachMeSkills.task.date;

import java.text.SimpleDateFormat;
import java.util.Date;

public class FormatDate {
    public static String dateFormat(Date date) {
        SimpleDateFormat newDate = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
        return newDate.format(date);
    }
}
