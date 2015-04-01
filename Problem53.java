/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projectuler.net;

/**
 *
 * @author nut
 */
public class Problem53 {
    
    public static void main(String args[]){
        int count=0;
        for(int i=23;i<=100;i++){
            for(int j=1;j<=i-1;j++)
            {
                double value = combinations(i, j);
                if(value>=1000000){
                    System.out.println("n "+i+" k "+j+" value "+value);
                    count++;
                }
            }
        }
        
        System.out.println("Count " + count);
    
    }


    static double combinations(int n, int k) {
        double coeff = 1;
        for (int i = n - k + 1; i <= n; i++) {
            coeff *= i;
        }
        for (int i = 1; i <= k; i++) {
            coeff /= i;
        }
        return coeff;
    }
}
