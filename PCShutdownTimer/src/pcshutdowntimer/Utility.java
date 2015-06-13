/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pcshutdowntimer;

import java.util.*;
import java.time.*;

/**
 * @date: Jun 13, 2015
 * @author PhongVu
 */
public final class Utility {

    public static Long getInterval(int hour, int minute) {
        Date cDate = new Date();
        int cHour = cDate.getHours();
        int cMinute = cDate.getMinutes();
        long interval = 0;
        if(hour < cHour || (hour == cHour && minute < cMinute)){
            LocalDate.now().plusDays(1); //Java 8
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(cDate);
            calendar.add(Calendar.DATE, 1);
            Date fDate = calendar.getTime();
            fDate.setHours(hour);
            fDate.setMinutes(minute);
            fDate.setSeconds(0);
            interval = (fDate.getTime() - cDate.getTime())/1000;
        }else{
            int diffHour = hour - cHour;
            int diffMinute = minute - cMinute;
            interval = diffHour * 3600 + diffMinute * 60;
        }
        return interval;
    }
}
