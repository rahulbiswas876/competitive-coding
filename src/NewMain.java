
import java.io.IOException;
import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Set;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Naveen
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //FasterScanner in = new FasterScanner();
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        in.nextLine();
        Set<String> set = new HashSet<String>();
        
        for(int i=1; i<= N;i++){
            String temp = in.nextLine();
            int ind = temp.indexOf('=') - 1;
            String var = temp.substring(0, ind);
            set.add(var);
        }
        
        System.out.println(set.size());
    }
    
    
    
}
