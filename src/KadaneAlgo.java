/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Naveen
 */
public class KadaneAlgo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        kadaneAlgo(new int[]{1,1,-1,-1,1,1,1});
    }
    
    public static void kadaneAlgo(int [] arry) {
        int maxGlobal = arry[0];
        int maxSumEndingHere = arry[0];
        int tempLeft = 0, tempRight = 0;
        
        int maxLeft = 0, maxRight = 0;
        
        for(int i= 1; i < arry.length ;i++) {
            if(maxSumEndingHere + arry[i] > arry[i]){
                maxSumEndingHere += arry[i];
                
                tempRight = i;
                
                if(maxSumEndingHere > maxGlobal){
                    maxGlobal = maxSumEndingHere;
                    maxLeft = tempLeft;
                    maxRight = tempRight;
                }
            }else {
                maxSumEndingHere = arry[i];
                tempLeft = tempRight = i;
                
                if(maxSumEndingHere > maxGlobal){
                    maxGlobal = maxSumEndingHere;
                    maxLeft = tempLeft;
                    maxRight = tempRight;
                }
            }
        }
        
        System.out.println("maximum sum = " + maxGlobal);
        System.out.println("array is [ " + maxLeft + " , " + maxRight +" ]");
            
    }
    
}
