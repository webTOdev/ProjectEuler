/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projectuler.net;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author nut
 */
public class Problem46 {
    
    public static List<Long> compositeOdds = new ArrayList<Long>();
    public static void main(String args[]){
    boolean flag = false;
    long i,j,k=new Long(999999999);
    for(i=9 ;;i+=2){
     flag = false;
        if(! isPrime(i)){
            for(j=2;j<i;j++){
                if(isPrime(j)){
                    for(k=1;k<i;k++){
                        if(j+(2*k*k) == i){
                            compositeOdds.add(i);
                             System.out.println(i);
                             flag = true;
                            break;
                        }
                        else
                            if(j+(2*k*k) > i)
                                break;
                    }
                }
                
                if(flag == true)
                {
                    break;
                }
            }
            
            if(j==i){
                break;
            }
        
        }
    
    }
    
    System.out.println("The first number that breaks rule "+i);
    }
    
     public static boolean isPrime(long n) {

        String strFromN = new Long(n).toString();

        if (strFromN.endsWith("4") || strFromN.endsWith("6") || strFromN.endsWith("8")) {
            return false;
        }

        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }


        return true;
    }
}
