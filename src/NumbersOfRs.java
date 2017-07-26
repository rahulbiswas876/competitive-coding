
import java.io.IOException;
import java.util.InputMismatchException;
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

//https://www.hackerearth.com/practice/algorithms/dynamic-programming/introduction-to-dynamic-programming-1/practice-problems/algorithm/number-of-rs-1/
public class NumbersOfRs {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        StringBuilder res = new StringBuilder("");
        
        
        while(T-- > 0) {
            String str = in.next();
            
            int R[][] = new int[str.length()][str.length()];
            int K[][] = new int[str.length()][str.length()];
            
            int maxI=0, maxJ=0;
            
            for(int i=0 ;i < str.length() ;i++){
                for(int j= i; j < str.length();j++){
                    if( i == j){
                        switch(str.charAt(j)){
                            case 'R' :
                                R[i][j] = 1;
                                K[i][j] = 0;
                                break;
                            case 'K' :
                                R[i][j] = 0;
                                K[i][j] = 1;
                                break;
                        }
                    }else {
                        /*code where i left after copied*/
                        switch(str.charAt(j)){
                            case 'R' :
                                R[i][j] = R[i][j-1] + 1;
                                K[i][j] = K[i][j-1];
                                break;
                            case 'K' :
                                R[i][j] = R[i][j-1];
                                K[i][j] = K[i][j-1] + 1;
                                break;
                        }
                    }
                    
                    if((K[maxI][maxJ]- R[maxI][maxJ]) < (K[i][j]- R[i][j])){
                        maxI = i;
                        maxJ = j;
                    }
                }
            }
            
            int result = 0;
            
            System.out.println("maxI" + maxI + ",maxJ" + maxJ);
            System.out.println("max = " + (K[maxI][maxJ]- R[maxI][maxJ]));
            result = K[maxI][maxJ];
            
            if(maxI - 1 >= 0){
                result += R[0][maxI-1];
            }
            
            if(maxJ + 1 <= str.length()-1){
                result += R[maxJ + 1][str.length() - 1];
            }
            
            res.append(result + "\n");
        }
        
        System.out.println(res);
        
                
    }
    
    public static class FasterScanner {

        private byte[] buf = new byte[1024];
        private int curChar;
        private int numChars;
        
        public int read() {
            if (numChars == -1) {
                throw new InputMismatchException();
            }
            if (curChar >= numChars) {
                curChar = 0;
                try {
                    numChars = System.in.read(buf);
                } catch (IOException e) {
                    throw new InputMismatchException();
                }
                if (numChars <= 0) {
                    return -1;
                }
            }
            return buf[curChar++];
        }
        
        public String nextLine() {
            int c = read();
            while (isSpaceChar(c)) {
                c = read();
            }
            StringBuilder res = new StringBuilder();
            do {
                res.appendCodePoint(c);
                c = read();
            } while (!isEndOfLine(c));
            return res.toString();
        }
        
        public String nextString() {
            int c = read();
            while (isSpaceChar(c)) {
                c = read();
            }
            StringBuilder res = new StringBuilder();
            do {
                res.appendCodePoint(c);
                c = read();
            } while (!isSpaceChar(c));
            return res.toString();
        }
        
        public long nextLong() {
            int c = read();
            while (isSpaceChar(c)) {
                c = read();
            }
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = read();
            }
            long res = 0;
            do {
                if (c < '0' || c > '9') {
                    throw new InputMismatchException();
                }
                res *= 10;
                res += c - '0';
                c = read();
            } while (!isSpaceChar(c));
            return res * sgn;
        }
        
        public int nextInt() {
            int c = read();
            while (isSpaceChar(c)) {
                c = read();
            }
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = read();
            }
            int res = 0;
            do {
                if (c < '0' || c > '9') {
                    throw new InputMismatchException();
                }
                res *= 10;
                res += c - '0';
                c = read();
            } while (!isSpaceChar(c));
            return res * sgn;
        }
        
        public int[] nextIntArray(int n) {
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = nextInt();
            }
            return arr;
        }
        
        public long[] nextLongArray(int n) {
            long[] arr = new long[n];
            for (int i = 0; i < n; i++) {
                arr[i] = nextLong();
            }
            return arr;
        }
        
        private boolean isSpaceChar(int c) {
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }
        
        private boolean isEndOfLine(int c) {
            return c == '\n' || c == '\r' || c == -1;
        }
    }
    
}


/*

run:
1
KKRRKKKRKRRKRRRKRRRRRKKRKKRKRRKKRKRRKRRRRKRR[KKKK]RRKRRRR
maxI 44,maxJ 47
36

BUILD SUCCESSFUL (total time: 3 seconds)

*/