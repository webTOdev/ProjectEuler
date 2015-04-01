/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projectuler.net;

import foo.utils.UtilityClass;
import java.math.BigInteger;

/**
 *
 * @author nut
 */
public class Problem20 {
    
    public static void main(String args[]){
    
        long start = System.currentTimeMillis();
        BigInteger factorial = factorial(new BigInteger("100"));
        System.out.println("100 ! = "+factorial);
        long sumOfDigits=UtilityClass.sumOfDigits(factorial.toString());
        System.out.println(sumOfDigits);
        
        System.out.println("Execution time "+(System.currentTimeMillis()-start)+" ms");
    }
    
   private static BigInteger factorial(BigInteger n){
       if(n.compareTo(BigInteger.ZERO) == 0)
           return BigInteger.ONE;
       else
           return n.multiply(factorial(n.subtract(BigInteger.ONE)));
   
   }
}
