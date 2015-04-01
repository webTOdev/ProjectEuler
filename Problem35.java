/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projectuler.net;

import java.util.*;

/**
 *
 * @author nut
 */
public class Problem35 {

    private static List<Long> listOfPrimes = new ArrayList< Long>();
    private static Set<Long> checked = new TreeSet<Long>();
    private static Set<Long> allCircularNumbers = new TreeSet<Long>();

    public static void main(String args[]) {

        for (long i = 2; i < 1000000; i++) {
            isPrime(i);
        }

        for (Long num : listOfPrimes) {
            if (!checkIfValid(num)) {
                continue;
            }
            circularNumbers(num.toString());

            boolean flag = true;

            for (Long perm : allCircularNumbers) {
                if (!listOfPrimes.contains(perm)) {
                    flag = false;
                }
            }

            if (flag == true) {
                checked.addAll(allCircularNumbers);
            }

        }

        System.out.println("count " + checked.size());
        System.out.println(checked);


    }

    private static void circularNumbers(String str) {
        allCircularNumbers.clear();
        String s;
        for (int i = 0; i < str.length(); i++) {
            s = "";
            s += str.substring(i, str.length());
            for (int j = 0; j < i; j++) {
                s += str.charAt(j);
            }

            allCircularNumbers.add(Long.parseLong(s));
        }

        System.out.println(allCircularNumbers);
    }

    private static boolean checkIfValid(Long n) {

        if (n < 10) {
            return true;
        }
        Long m;
        while (n > 0) {
            m = n % 10;
            if (m % 2 == 0 || m == 5) {
                return false;
            }
            n = n / 10;
        }

        return true;
    }

    private static boolean isPrime(long n) {

        String strFromN = new Long(n).toString();
        if ((strFromN.length() != 1) && (strFromN.endsWith("2") || strFromN.endsWith("4") || strFromN.endsWith("5") || strFromN.endsWith("6") || strFromN.endsWith("8"))) {
            return false;
        }


        for (Long num : listOfPrimes) {
            if (num > Math.sqrt(n)) {
                break;
            }
            if (n % num.longValue() == 0) {
                return false;
            }
        }


        listOfPrimes.add(new Long(n));
        return true;
    }
}
