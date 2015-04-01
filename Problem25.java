/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projectuler.net;

import foo.utils.UtilityClass;
import java.math.BigDecimal;
import java.math.BigInteger;

/**
 *
 * @author nut
 * Idea from here http://www.mathblog.dk/project-euler-25-fibonacci-sequence-1000-digits/
 */
public class Problem25 {
    
    private static double PHI =( 1+Math.sqrt(5))/2;
    public static void main(String args[]){
    
       System.out.println(indexOfFib(1000));      // I have thought that my Fibonacci number > 10^999 , then calculated the n 
    }
    
    
    private static double indexOfFib(int n){
    
    
      double numerator = (Math.log(10)*(999))+Math.log(5)/2   ;   
      System.out.println(numerator);
      double fib = numerator /Math.log(PHI);
      return fib;
    }
    
   
}
