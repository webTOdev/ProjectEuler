/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projectuler.net;

/**
 *
 * @author nut
 */
public class Problem2 {

    public static void main(String args[]) {
       
        int count =0;
        int i=1;
        int value;
        while(true){
            value = fib(i);
             System.out.println("fib"+value);
            if(value>=4000000)
                break;
           if(value%2 == 0){
               count +=value;
               System.out.println("even "+value+" at "+i);
           }
           i++;
        }
         System.out.println("the count is "+count);
    }

    private static int fib(int n) {
      //  System.out.println(n);
        if (n == 1) {
            return 1;
        }

        if (n == 2) {
            return 2;
        } else {
            return fib(n - 1) + fib(n - 2);
        }

    }
}
