/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projectuler.net;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * got idea from http://eli.thegreenplace.net/2009/02/20/project-euler-problem-012/
 *
 * @author nut
 */
public class Problem12 {

    private static Map<Long, Long> mapToNumOfFactor = new HashMap<Long, Long>();
    private static List<Long> factor;

    public static void main(String args[]) {
        long num;

        for (long i = 2;; i++) {
              num = findTriangleNumber(i);
            numOfPrimeFactors(num);
            long sum = 1;
            for (Map.Entry<Long, Long> entry : mapToNumOfFactor.entrySet()) {
                   // System.out.println("Num "+num+" Key " + entry.getKey() + " has exponential " + entry.getValue());
                sum *= entry.getValue()+1;
            }
            mapToNumOfFactor.clear();
            System.out.println("Triangle "+i +" has triangle value  " + num + " has " + sum+ " factors");
            
            if(sum >=500){
                break;
            }
                
    
        }
    }

    private static long findTriangleNumber(long numberOfDigit) {
        long sum = numberOfDigit * (numberOfDigit + 1) / 2;

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
        
 
        if ( strFromN.endsWith("4") || strFromN.endsWith("6") || strFromN.endsWith("8")) {
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
