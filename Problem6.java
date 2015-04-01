/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projectuler.net;

/**
 *
 * @author nut
 */
public class Problem6 {
    public static void main(String args[]){
        
         long diff = squaresOfSums(100) - sumOfSquares(100);
         System.out.println("Diff "+diff);
    }
    
    private static long sumOfSquares(int n){
    
      long  sum = n*(n+1)*(2*n+1)/6;
      return sum;
    }
    
       private static long squaresOfSums(int n){
    
      long  sum = n*(n+1)/2;
      return sum*sum;
    }
    
}
