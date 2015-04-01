/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projectuler.net;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author nut
 */
public class Problem50 {

    private static List<Long> listOfPrimes = new ArrayList< Long>();
    private static int max = 0;
    private static long maxPrime = 0;

    public static void main(String args[]) {


        for (long i = 2; i < 1000000; i++) {
            if (isPrime(i)) {

                if (isEqualToSumOfConsecutivePrime(new Long(i))) {
                    System.out.print(i + " ");
                }
            }
            if (i % 1000 == 0) {
                System.out.println();
            }
        }

        System.out.println("\nMax no of comsucutive prime " + max + " for the number " + maxPrime);

    }

    private static boolean isEqualToSumOfConsecutivePrime(Long n) {

        long sum = 0;
        for (int j = 0; j < listOfPrimes.size() - 1; j++) {
            sum = 0;
            for (int i = j; i < listOfPrimes.size() - 1; i++) {

                long v = listOfPrimes.get(i);
                sum += v;

                if (sum == n) {
                    if (i - j + 1 > max) {
                        max = i - j + 1;
                        maxPrime = n;

                    }
                    return true;
                } else if (sum > n) {
                    break;
                }
            }
        }

        return false;

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
