/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projectuler.net;

/**
 *
 * @author nut
 * 	Find the only Pythagorean triplet, {a, b, c}, for which a + b + c = 1000.
 */
public class Problem9 {
    public static void main(String args[]){
    
       findPithagorianTriangle();
    }
    
    private static void findPithagorianTriangle(){
        boolean found = false;
        for(int i=1;;i++){
            for(int j=i;j<=999;j++){
                int root = (int) Math.sqrt(i*i + j*j);
                if(isPithagorianTriangle(i, j, root)){
                    System.out.println(i+" "+j+" "+root);
                    if(i+j+root == 1000){
                        System.out.println("The special is "+i+" "+j+" "+root + "result of product is "+i*j*root);
                        found = true;
                        break;
                        
                    }
                        
                }
            }
            if(found == true)
                break;
            
        }
        
    }
    
    
    private static boolean isPithagorianTriangle(int a, int b, int c){
    
        if(a*a + b*b == c*c)
            return true;
        else 
            return false;
    }
    
}
