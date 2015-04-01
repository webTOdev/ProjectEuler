/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projectuler.net;

import java.math.BigInteger;

/**
 *
 * @author nut
 */
public class Problem48 {
    
    public static void main(String args[]){
    
        BigInteger sumOfSeries = sumOfSeries(10);
        int length = sumOfSeries.toString().length();
        System.out.println("Sum of Series "+sumOfSeries);
        System.out.println("Last 10 digits are "+sumOfSeries.toString().substring(length-10));
    }
    private static BigInteger sumOfSeries(int n){
    
        BigInteger sum = BigInteger.ZERO;
        BigInteger pow =BigInteger.ZERO;
        for(int i=1;i<=1000;i++){
            BigInteger iAsBigInt = new BigInteger(""+i);
            pow = iAsBigInt.pow(i);

            sum =  sum.add(pow);
        }
        
        return sum;
    }
}
