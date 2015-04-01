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
 * 
 * the pattern is to simply add the previous two terms ...but if the term is a multiple of 3 then multiply i-1 with the n-1 th term */
public class Problem65 {
    
    public static void main(String args[]){
    BigInteger  x = new BigInteger("1");
    BigInteger  y =  new BigInteger("2");
    
    for(int i=2;i<=100;i++){
        BigInteger  temp = x;         
       
        Integer c = (i % 3 == 0 )? 2 * (i/3) : 1;
        x=y;
        y = x.multiply(new BigInteger(c.toString())).add(temp);
        
        
            
    }
    
    System.out.println("nth Numerator is "+y);
     System.out.println("Sum of digits "+UtilityClass.sumOfDigits(y.toString()));
    
} 
}
