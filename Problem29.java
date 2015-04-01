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
public class Problem29 {
    
    private static List<Double> listOfDistinctNumbers = new ArrayList<Double>();
    
    public static void main(String args[]){
    
        calculateDistinctNumbers();
        System.out.println(listOfDistinctNumbers.size());
        
        for(double l : listOfDistinctNumbers){
        //    System.out.println(l);
        }
    }
    
    private static void calculateDistinctNumbers(){
    
        for(int a=2;a<=100;a++){
            for(int b=2;b<=100;b++){
            
             double value = Math.pow(a, b);
             
             if(! listOfDistinctNumbers.contains(value)){
                 listOfDistinctNumbers.add(value);
            }
            }
        }
    
    }
    
}
