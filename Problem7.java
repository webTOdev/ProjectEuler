/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projectuler.net;

/**
 *
 * @author nut
 */
public class Problem7 {
    
    public static void main(String args[]){
        System.out.println("iPrime "+ isPrime(5));
        
        int count =0;
        int i=2;
        while(true){
            if(isPrime(i)){
                count++;
                System.out.print(i+" ");
            }
            i++;
            if(count%20 == 0)
                System.out.println();
            if(count == 10001)
                break;
            
        }
    
    }
    
    private static boolean isPrime(long n){
    
        String strFromN = new Long(n).toString();
        if((strFromN.length()!=1) && (strFromN.endsWith("2") || strFromN.endsWith("4") || strFromN.endsWith("5") || strFromN.endsWith("6") || strFromN.endsWith("8")))
            return false;
            
            
            for(long i = 2; i<= n/2 ;i++){
                if(n%i == 0)
                    return false;
            }
        
        
        return true;
    }
    
}
