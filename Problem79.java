/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projectuler.net;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author nut
 */
public class Problem79 {
    
    private static Set<String> codes = new TreeSet<String>();
    private static Map<Character,Character[]> before = new HashMap<Character,Character[]>();
    private static Map<Character,Character[]> after = new HashMap<Character,Character[]>();
    
    private static int[][] beforeList = new int[10][10];
     private static int[][] afterList = new int[10][10];
    public static void main(String args[]){
        readFile();
        
       
        Iterator it = codes.iterator();
        while(it.hasNext()){
            constructPreAndPostNumbers(numOfDigits(Long.parseLong((String)it.next())));
        }
        
        for(int i=0;i<10;i++){
             System.out.print("Element before "+i +" -> ");
            for(int j=0;j<10;j++){
                if(beforeList[i][j] >0){
                    System.out.print(j+" ");
                }
                
                
            }
             System.out.println();
        }
         for(int i=0;i<10;i++){
             System.out.print("Element After "+i +" -> ");
            for(int j=0;j<10;j++){
                if(afterList[i][j] >0){
                    System.out.print(j+" ");
                }
                
                
            }
             System.out.println();
        }
          
    }
    
    private static void constructSuperString(){
    
        String s="";
        
    
    }
    
     private static int[] numOfDigits(long number){
    
        int array[] = new int[3];
        int i=2;
        while (number > 0) {

            int digit = (int) (number % 10);
            number = number / 10;

           array[i--]=digit;
        }
        
        return array;
        
        
    }
   
    private static void constructPreAndPostNumbers( int array[]){
    
      {
     
          int a=array[0];
          int b=array[1];
          int c=array[2];
          
          afterList[a][b]++;
          afterList[a][c]++;
          
          afterList[b][c]++;
          beforeList[b][a]++;
          
          beforeList[c][a]++;
          beforeList[c][b]++;
          
        
      
        
        
    }
    
    }
     private static void readFile() {

        File file;
        FileReader fd;
        BufferedReader bd;
        StringTokenizer st;



        try {
            file = new File("d://problem79.txt");
            fd = new FileReader(file);
            bd = new BufferedReader(fd);
            String str1;
            int k = 0;
            while ((str1 = bd.readLine()) != null) {

                codes.add(str1);
                //strArray[k++] = str1;
            }

        } catch (IOException ex) {
            Logger.getLogger(Problem89.class.getName()).log(Level.SEVERE, null, ex);
        }
        
     //   System.out.println(codes);


    }
    
}
