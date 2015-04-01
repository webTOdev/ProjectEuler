/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projectuler.net;

import foo.utils.UtilityClass;
import java.util.*;

/**
 *
 * @author nut
 * http://mathafou.free.fr/themes_en/kdivs.html
 */
public class Problem21 {
    
    private static Map<Long, Long> mapToNumOfFactor = new HashMap<Long, Long>();
    private static Map<Long, Long> mapFromNumToFactor = new HashMap<Long, Long>();
    private static List<Long> amicableNumbers = new ArrayList<Long>();

    public static void main(String args[]) {

        long start = System.currentTimeMillis();
        long sum = 0;
        for (long i = 2; i < 10000; i++) {
            if (isAmicable(i)) {
                // System.out.println("Amicable "+i);
                
            }
        }
      
        for(long amicable : amicableNumbers){
            sum+=amicable;
        }
        System.out.println(sum);
        long end = System.currentTimeMillis()-start;
        System.out.println("Execution time "+end+" ms");


    }

    private static boolean isAmicable(long i) {

        if (amicableNumbers.contains(i)) {
            return true;
        }

        long sumOfAllDivisor1 = 1;
        long sumOfAlldivisors2 = 1;
        long properDivisor1 = 0;
        long properDivisor2 = 0;
        mapToNumOfFactor.clear();
        if (!mapFromNumToFactor.containsKey(i)) {
            numOfPrimeFactors(i);
            sumOfAllDivisor1 = 1;
            for (Map.Entry<Long, Long> entry : mapToNumOfFactor.entrySet()) {
                // A simple algorithm that is described to find the sum of the factors is using prime factorization.
                //1225=52⋅72, therefore the sum of factors is (1+5+25)(1+7+49)=1767
                sumOfAllDivisor1 *= sumUpToR(entry.getKey(), entry.getValue());
            }
            properDivisor1 = sumOfAllDivisor1 - i;
            mapFromNumToFactor.put(i, properDivisor1);   //We want proper divisors except the number itself

        } else {
            properDivisor1 = mapFromNumToFactor.get(i);
        }
        mapToNumOfFactor.clear();
        if (!mapFromNumToFactor.containsKey(properDivisor1)) {
            numOfPrimeFactors(properDivisor1);
            sumOfAlldivisors2 = 1;
            for (Map.Entry<Long, Long> entry : mapToNumOfFactor.entrySet()) {

                sumOfAlldivisors2 *= sumUpToR(entry.getKey(), entry.getValue());
            }
            properDivisor2 = sumOfAlldivisors2 - properDivisor1;
            mapFromNumToFactor.put(properDivisor1, properDivisor2);

        } else {
            properDivisor2 = mapFromNumToFactor.get(properDivisor1);
        }
        mapToNumOfFactor.clear();

          //  System.out.println("Factors sum of " + i + " is " + properDivisor1 + "Factors of " + properDivisor1 + " is " + properDivisor2);

        if ((i == properDivisor2) && (i!=properDivisor1)) {
        // if ((properDivisor1 == properDivisor2) && (i!=properDivisor1)) {
            if (!amicableNumbers.contains(properDivisor1)) {
                amicableNumbers.add(properDivisor1);
            }
            if (!amicableNumbers.contains(properDivisor2)) {
                amicableNumbers.add(properDivisor2);
            }
            System.out.println(properDivisor1 + " " + properDivisor2);
            return true;

        }
        return false;

    }

    private static long sumUpToR(long n, long r) {

        long sum = 0;
        for (int i = 0; i <= r; i++) {
            sum += Math.pow(n, i);
        }
        return sum;

    }

    private static void numOfPrimeFactors(long num) {

        if (num == 1) {
            return;
        }

        if (isPrime(num)) {
            insertInMap(num);
            return;
        }
        for (long i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                numOfPrimeFactors(i);

                numOfPrimeFactors(num / i);
                break;
            }
        }


    }

    private static void insertInMap(long key) {

        if (mapToNumOfFactor.containsKey(key)) {
            long value = mapToNumOfFactor.get(key);
            mapToNumOfFactor.put(key, ++value);
        } else {
            mapToNumOfFactor.put(key, 1L);
        }

    }

    private static boolean isPrime(long n) {

        String strFromN = new Long(n).toString();


        if (strFromN.endsWith("4") || strFromN.endsWith("6") || strFromN.endsWith("8")) {
            return false;
        }

        for (long i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }


        return true;
    }
}
