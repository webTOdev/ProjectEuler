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
public class Problem81 {
 
    public static int[][] list = new int[80][80];
    public static int[][] path = new int[80][80];
    
    public static void main(String args[]){
    
        Long start = System.currentTimeMillis();
       matrixConstruct();
       System.out.println();
       shortestCommonPath();
       Long end = System.currentTimeMillis();
       
        System.out.println("Execution time "+(end-start)+"ms");
         System.out.println("Minimal path sum "+path[79][79]);
        
       
    }
    
    private static void shortestCommonPath(){
        
        path[0][0]=list[0][0];
        
        for(int k=1;k<80;k++){
           path[0][k]=list[0][k]+path[0][k-1];
           path[k][0]=list[k][0]+path[k-1][0];
           
        }
                
        for(int i=1;i<80;i++){
            for(int j=1;j<80;j++){
                if(path[i-1][j]+list[i][j] < path[i][j-1]+list[i][j]){
                    path[i][j] = path[i-1][j]+list[i][j];
                }
                else
                   path[i][j]= path[i][j-1]+list[i][j];
            }
        }
    
         for(int i=0;i<80;i++){
            for(int j=0;j<80;j++){
                System.out.print(path[i][j]+" | ");
            }
            System.out.println();
         }
    }
    
    private static void matrixConstruct(){
    
       File file;
        FileReader fd;
        BufferedReader bd;
        StringTokenizer st;
        String strArray[] = new String[80];


        try {
            file = new File("d://problem81.txt");
            fd = new FileReader(file);
            bd = new BufferedReader(fd);
            String str1;
            int k = 0;
            while ((str1 = bd.readLine()) != null) {
                
                strArray[k++] = str1;
            }
            for (int i = 0; i < 80; i++) {
                st = new StringTokenizer(strArray[i],",");
                for (int j = 0; j <80; j++) {
                    list[i][j] = Integer.parseInt(st.nextToken());
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(Problem81.class.getName()).log(Level.SEVERE, null, ex);
        }
        
//         for(int i=0;i<80;i++){
//            for(int j=0;j<80;j++){
//                System.out.print(list[i][j]+" | ");
//            }
//            System.out.println();
//         }
       
    }
    
    
    
}
