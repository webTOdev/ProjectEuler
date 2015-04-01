/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projectuler.net;

import java.math.BigDecimal;

/**
 *
 * @author nut
 * How many routes are there through a 20×20 grid?
 * 
 */
public class Problem15 {
    
    public static void main(String args[]){
    
        double c =combinations(40, 20);
    System.out.println("No of Combination "+BigDecimal.valueOf(c).toPlainString());
    }
    
    public static long findCombination(long n,long k){
    
        if(k==0)
            return 1;
        if(n==0)
            return 0;
        if(n==k)
            return 1;
        return findCombination(n-1, k-1)+findCombination(n-1, k);
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
/*In order to pose the question as a combinatorics question, we must realise a few things. I have generalised the observations to an NxN grid.

    All paths can be described as a series of directions. And since we can only go down and right, we could describe the paths as a series of Ds and Rs. In a 2×2 grid all paths are 1) DDRR 2) DRDR 3) DRRD 4) RDRD 5) RDDR 6) RRDD.
    Based on the example we can see that all paths have exactly size 2N of which there are N Rs and N Ds.
    If we have 2N empty spaces and place all Rs, then the placement of the Ds are given

Once we have made these realisations, we can repose the question as

    In how many ways can we choose N out of 2N possible places if the order does not matter?*/