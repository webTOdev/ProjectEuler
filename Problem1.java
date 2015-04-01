/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projectuler.net;

/**
 *
 * @author nut
 */
public class Problem1 {
    
    public static void main(String args[]){
    
        System.out.println("\nTotal "+countNoOfMultipleOfThreeNFive(1000));
    }
    private static int countNoOfMultipleOfThreeNFive(int boundary){
    int count =0;
        for(int i =1;i<boundary;i++){
            if(checkIfDividible(i))
                count+=i;
         }
        return count;
    }
    private static boolean checkIfDividible(int n){
    if((n%3 ==0)||(n%5==0)){
        System.out.print(" "+n);
        return true;
    }
    return false;
        
    }
}
