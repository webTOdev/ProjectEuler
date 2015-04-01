/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projectuler.net;

/**
 *
 * @author nut
 * 

2520 is the smallest number that can be divided by each of the numbers from 1 to 10 without any remainder.

What is the smallest positive number that is evenly divisible by all of the numbers from 1 to 20?

 */
public class Problem5LCM {
    
    public static void main(String args[]){
        long result = 2L;
        for(int i=3;i<=20;i++)
            result = lcm(result,i);
           System.out.println("lcm is "+result);
    }
    
    private static long lcm(long a,long b){
    
        return a*b/gcd(a,b);
    }
    private static long gcd(long a,long b){
        if(b==0)
            return a;
        if(a>=b)
        return gcd(b,a%b);
        else
           return gcd(a,b%a);
    }
}
