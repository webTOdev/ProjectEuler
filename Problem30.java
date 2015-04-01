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
public class Problem30 {
    
    private static double squares[]=new double[10];
    private static double MAX = 5*Math.pow(9,5);
    private static List<Long> numbersEqualDigitSum = new ArrayList<Long>();
    
    public static void main(String args[]){
    
        calculateSquares();
        long digitSum=0;
        
        for(long i=2;i<=MAX;i++){
            digitSum=sumOfFifthPowerOfDigits(new Long(i).toString());
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
    
    private static void calculateSquares(){
    
        for(int i=0;i<10;i++){
            squares[i]=Math.pow(i, 5);
        }
    }
    
  
    
    
    
    public static long sumOfFifthPowerOfDigits(String bigNum) {
        int length = bigNum.length();
        long sum=0;
        for (int i = 0; i < length; i += 3) {
            String digits = bigNum.substring(i, (i + 3) > length ? length : i + 3);
           
            int threeDigitNum = Integer.parseInt(digits);
            sum = sumOfThreeDigit(threeDigitNum,sum);
        }
        return sum;
    }

    private static long sumOfThreeDigit(int n,long sum) {

        do {
            sum += squares[n % 10];

            n = n / 10;
        } while (!(n == 0));

        return sum;
    }
    
}
