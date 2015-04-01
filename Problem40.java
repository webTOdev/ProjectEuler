/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projectuler.net;

/**
 *
 * @author nut
 */
public class Problem40 {
    
    private static long max = 1000000;

    public static void main(String args[]) {

        long start = System.currentTimeMillis();

        String str = "";

        for (int i = 1;; i++) {
            str += i;

            if (str.length() >= max) {
                break;
            }
        }


        long end = System.currentTimeMillis();
      

        long result = 1;


        int index;
        for (int i = 1; i <= max; i *= 10) {
            index = i - 1;
            result *= str.charAt(index) - 48;
       //     System.out.println("i" + index + " " + str.charAt(index));
        }

        System.out.println("Result " + result);
          System.out.println("Execution time " + (end - start) + " ms");

    }
}
