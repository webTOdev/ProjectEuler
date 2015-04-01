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
public class Problem38 {
    
    public static String max="987654321";
    
    private static Set<String> pandigitals = new TreeSet<String>();
    
    public static void main(String args[]){
    
        permutation(max);
        System.out.println(allPermutations.size());
        
        findPandigital();
        
        Long sum=new Long(0);;
        
        
      //  System.out.println("SUM  " + sum);
    }
    
    private static Set<Long> allPermutations = new TreeSet<Long>();

    public static void permutation(String str) {
        allPermutations.clear();
        permutation("", str);
        
     

    }
    
    private static void findPandigital(){
        
        Long product;
        String eq;
        for(long i=2;i<=987654321/9;i++){
         eq="";
            for(long j=1;j<=9;j++){
                product = i*j;
               
                eq = eq+product.toString();
              
                if(eq.length() >9)
                    break;
                if(allPermutations.contains(Long.parseLong(eq))){
                    System.out.println(eq);
                    pandigitals.add(eq);
                    
                    break;
                }
              
            }
        }
    }
    
    

    private static String constructEquation(long i,long j,long product){
        
        return ""+i+j+product;
    
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
