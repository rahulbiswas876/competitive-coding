
import java.util.Scanner;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Naveen
 */
public class NewClass {
    
    public static void main(String a[]){  
        
          Scanner in = new Scanner(System.in);
          int N = in.nextInt();
          long[] num = new long[N];
          long[] num2 = new long[N];
          for(int i=0;i < N;i++){
              num[i] = in.nextLong();
              num2[i] = num[i];
          }
              
          
          System.out.println(java.lang.Math.min(insertionSort(num), insertionSortReverse(num2)));
    }    
    
    public static long  insertionSort(long array[]) {
        long count = 0;
        int n = array.length;  
        for (int j = 1; j < n; j++) {  
            long key = array[j];  
            int i = j-1;  
            while ( (i > -1) && ( array [i] > key ) ) {  
                array [i+1] = array [i];  
                i--;  
            }  
            if(i+1 != j){
                array[i+1] = key; 
                count++;
            }
             
        }  
        return count;
    }  
    
    public static long  insertionSortReverse(long array[]) {
        long count = 0;
        int n = array.length;  
        for (int j = 1; j < n; j++) {  
            long key = array[j];  
            int i = j-1;  
            while ( (i > -1) && ( array [i] < key ) ) {  
                array [i+1] = array [i];  
                i--;  
            }  
            if(i+1 != j){
                array[i+1] = key; 
                count++;
            }
             
        }  
        return count;
    }  
    
}
