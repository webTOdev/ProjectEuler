/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projectuler.net;

import java.util.Set;
import java.util.TreeSet;

/**
 *
 * @author nut
 */
public class Problem52 {
    
    private static Set<Long> allPermutations = new TreeSet<Long>();

    public static void main(String args[]){
    
       long start = System.currentTimeMillis();
       boolean flag =false;
       long sixthMultiple = 1;
       long i;
       for(i=1;;i++){
       
           allPermutations.clear();
           sixthMultiple = 6*i;
           permutation(new Long(sixthMultiple).toString());
           
           if(allPermutations.contains(i*5)){
            if(allPermutations.contains(i*4)){
             if(allPermutations.contains(i*3)){
              if(allPermutations.contains(i*2)){
                  flag = true;
              }
             }
            }
           
           }
           
           if(flag == true)
               break;
           
       }
         long end = System.currentTimeMillis();
       
        System.out.println("Execution time " + (end - start) + " ms");
       System.out.println("The i which has equal multiple up to 6 is "+i);
    
    }
    public static void permutation(String str) {
        allPermutations.clear();
        permutation("", str);

    }

    private static void permutation(String prefix, String str) {
        int n = str.length();
        if (n == 0) {
            allPermutations.add(Long.parseLong(prefix));

        } else {
            for (int i = 0; i < n; i++) {
                permutation(prefix + str.charAt(i), str.substring(0, i) + str.substring(i + 1, n));
            }
        }

    }
    
}
