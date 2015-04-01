/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projectuler.net;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author nut
 */
public class Problem67 {
      private static int triangle[][] = new int[100][100];
   
    
    public static void main(String args[]) {
        readTriangle();
        count();
    }
    
    private static void count(){
    
        int depth = triangle.length - 2;

        while ( depth >= 0) {
            for (int j = 0; j <= depth; j++) {
                triangle[depth][j] += Math.max( triangle[depth+1][j], triangle[depth+1][j+1]);
            }
            depth += -1;
        }
        
        System.out.println("The maximum path sum is: " + triangle[0][0]);


    }
    private static void countMaxFromTopToBottom(){
        int count =triangle[0][0];
        int j=0;
        
        for(int i=0;i<14;i++){
            if(triangle[i+1][j] >= triangle[i+1][j+1]){
               
                count+=triangle[i+1][j];
               
                System.out.println("j="+j+" "+triangle[i+1][j]);
            }
            else{
                count+=triangle[i+1][j+1];
                System.out.println("j="+j+" "+triangle[i+1][j+1]);
                j=j+1;
           
            }
         
            
        }
        
        System.out.println("Count "+count);
    
    }
    private static void readTriangle() {
        File file;
        FileReader fd;
        BufferedReader bd;
        StringTokenizer st;
        String strArray[] = new String[100];

        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                triangle[i][j] = 0;
            }
        }
        try {
            file = new File("d://problem67.txt");
            fd = new FileReader(file);
            bd = new BufferedReader(fd);
            String str1;
            int k = 0;
            while ((str1 = bd.readLine()) != null) {
                strArray[k++] = str1;
            }
            for (int i = 0; i < 100; i++) {
                st = new StringTokenizer(strArray[i]);
                for (int j = 0; j <= i; j++) {
                    triangle[i][j] = Integer.parseInt(st.nextToken());
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(Problem18.class.getName()).log(Level.SEVERE, null, ex);
        }
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print(triangle[i][j] + " ");
            }
            System.out.println();
        }
    }
}
