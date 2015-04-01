/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projectuler.net;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author nut
 */
public class Problem34 {
    
        private static long factorials[]=new long[10];
        private static double MAX = factorial(9)*7;
    private static List<Long> numbersEqualDigitSum = new ArrayList<Long>();
       
        public static void main(String args[]){
        
            calculateFactorials();
            
           
            
             long digitSum=0;
        
        for(long i=3;i<=MAX;i++){
            digitSum=sumOfFactorialsOfDigits(new Long(i).toString());
            if(digitSum == i){
                numbersEqualDigitSum.add(i);
        System.out.println(i);
            }
        }
        
        long result =0;
        for(long numbers : numbersEqualDigitSum){
            result +=numbers;
        }
        
        System.out.println("Sum "+result);
        }
        
        private static void calculateFactorials(){
        
            for(int i=0;i<10;i++)
                factorials[i]=factorial(i);
        }
    
       private static long factorial(long n){
       if(n == 0)
           return 1;
       else
           return n*factorial(n-1);
   
   }
       
        public static long sumOfFactorialsOfDigits(String bigNum) {
        int length = bigNum.length();
        long sum=0;
        for (int i = 0; i < length; i += 3) {
            String digits = bigNum.substring(i, (i + 3) > length ? length : i + 3);
           
            int threeDigitNum = Integer.parseInt(digits);
            sum = sumOfThreeDigitFactorials(threeDigitNum,sum);
        }
        return sum;
    }

    private static long sumOfThreeDigitFactorials(int n,long sum) {

        do {
            sum += factorials[n % 10];

            n = n / 10;
        } while (!(n == 0));

        return sum;
    }
    
}
