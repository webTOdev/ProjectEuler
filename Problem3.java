/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projectuler.net;

/**
 *
 * @author nut
 */
public class Problem3 {
    
    public static void main(String args[]){
        System.out.println("Largest "+largestPrimeFactor(600851475143L));
        long i =600851475143L ;
        System.out.println(i);
    }
    public static int largestPrimeFactor(long number) {
        int i;

        for (i = 2; i <= number; i++) {
            if (number % i == 0) {
                number /= i;
                i--;
            }
        }

        return i;
    }

    
}
