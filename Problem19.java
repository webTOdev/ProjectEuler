/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projectuler.net;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 *
 * @author nut 2 extra sundays !!!
 */
public class Problem19 {

    private static String days[] = {"Sun", "Mon", "Tues", "Wed", "Thurs", "Fri", "Sat"};

    public static void main(String args[]) {

                Calendar startDateCal = Calendar.getInstance();
                startDateCal.set(Calendar.YEAR, 1901);
                startDateCal.set(Calendar.MONTH, 0);
                startDateCal.set(Calendar.DATE, 1);
 
                Calendar endDateCal = Calendar.getInstance();
                endDateCal.set(Calendar.YEAR, 2000);
                endDateCal.set(Calendar.MONTH, 11);
                endDateCal.set(Calendar.DATE, 31);
                checkSundays(startDateCal.getTime(), endDateCal.getTime());
    }

    private static void checkSundays(Date start, Date end) {
        int dayNum;

        Calendar startDate = Calendar.getInstance();
        startDate.setTime(start);
        System.out.println(startDate.getTime());

        Calendar endDate = Calendar.getInstance();
        endDate.setTime(end);
        System.out.println(endDate.getTime());
        int count = 0;

        while (startDate.before(endDate)) {
            for (int i = 1; i < 13; i++) {
                dayNum = startDate.get(Calendar.DAY_OF_WEEK);
                if (dayNum == 1) {
                    count++;
                }

                System.out.println(startDate.getTime());
                startDate.add(Calendar.MONTH, 1);
              //  System.out.println("Count " + count);
            }

        }
         System.out.println("Count " + count);
    }
}
