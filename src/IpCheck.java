
import java.util.Scanner;
import java.util.StringTokenizer;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Naveen
 */
public class IpCheck {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        try{
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int i=1; i<= t;i++){
            String str1 = in.next();
            String str2 = in.next();
            String rs;
            
            System.out.println(possible(str1, str2));
            
                         
           
        }
        }catch(Exception e){
            
            System.out.println(e);
        }
        
        
    }

    

    private static int possible(String str1, String str2) {
       int shift = 0;
       int ch1 = str1.charAt(0) - 'A';
       int ch2 = str2.charAt(0) - 'A';
       while(ch1 != ch2){
           shift++;
           ch1 = (ch1 + 1) % 26;
       }
       
       
        boolean pos = true;
        
        for (int i = 0; i < str1.length(); i++) {
             ch1 = str1.charAt(i) - 'A';
             ch2 = str2.charAt(i) - 'A';
             
            
            if((ch1 + shift)% 26 != ch2){
                pos = false;
                shift = -1;
                break;
            }
        }
        return shift;

    }
    
    
    
      
   
}
