/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projectuler.net;

/**
 *
 * @author nut
 */
public class Problem14 {

    private static long count = 0;
    private static long maxChainLength = 0;
    private static long maxChainStarter = 2;

    public static void main(String args[]) {
        
        long startTime = System.currentTimeMillis();
      
        for (long i = 2; i <= 1000000; i++) {
            count = 0;
            generateSequence(i);
            if (count > maxChainLength) {
                maxChainLength = count;
                maxChainStarter = i;

            }

        }
        
         long endTime = System.currentTimeMillis();
         long executionTime=endTime-startTime;
        
        
         System.out.println("Max Chain length " + count);
         System.out.println(" Max Chain starter " + maxChainStarter);
         
         System.out.println("Execution time "+ executionTime +" ms");
        
    }

    private static long generateSequence(long n) {

        count++;
        if (n == 1) {
            return 1;
        }
        if (n % 2 == 0) {
            return generateSequence(n / 2);
        } else {
            return generateSequence(3 * n + 1);
        }


    }
}
