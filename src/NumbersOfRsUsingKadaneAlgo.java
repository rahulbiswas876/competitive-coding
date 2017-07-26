
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
public class NumbersOfRsUsingKadaneAlgo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        FasterScanner in = new FasterScanner();
        int T = in.nextInt();
        StringBuilder res = new StringBuilder("");
        
        
        while(T-- > 0) {
            String str = in.nextString();
            int[] arry = new int[str.length()];
            int[] countR = new int[str.length()];
            int[] countK = new int[str.length()];
            
            initialize(str, arry, countR, countK);
            
//            for(int i = 0; i<  arry.length ;i++){
//                System.out.print(  i + "( " + str.charAt(i) + " , " + arry[i] + " ) ,");
//            }
//            
//            System.out.println();
            
            KadaneResult kadaneResult = kadaneAlgo(arry);
            
            
            
            int result = countK[kadaneResult.right] - countK[kadaneResult.left] +
                         (str.charAt(kadaneResult.left) == 'K' ? 1 : 0);
            
                        
            if(kadaneResult.left - 1 >= 0){
                result += countR[kadaneResult.left - 1] - countR[0] +
                         (str.charAt(0) == 'R' ? 1 : 0);
            }
            
            if(kadaneResult.right + 1 <= str.length()-1){
                result += countR[str.length() - 1] - countR[kadaneResult.right + 1] +
                         (str.charAt(kadaneResult.right + 1) == 'R' ? 1 : 0);
            }
            
            res.append(result + "\n");
            
//            System.out.println("maximum sum = " + kadaneResult.maxGlobal);
//            System.out.println("array is [ " + kadaneResult.left + " , " + kadaneResult.right +" ]");
//            
//            System.out.println("************");
//            KadaneAlgo.kadaneAlgo(arry);
//            
        }
        
        System.out.println(res);
        
                
    }
    
    public static void initialize(String str, int [] arry,int [] countR,int[] countK) {
        for(int i=0; i < str.length();i++ ) {
            if(str.charAt(i) == 'R'){
                arry[i] = -1;

                countR[i] = i== 0 ? 1 : countR[i-1] + 1;
                countK[i] = i== 0 ? 0 : countK[i - 1];
            }else{
                arry[i] = 1;

                countK[i] = i== 0 ? 1 : countK[i-1] + 1;
                countR[i] = i== 0 ? 0 : countR[i - 1];
            }
        }
            
    }
    
    public static KadaneResult kadaneAlgo(int [] arry) {
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
        
                
        return new KadaneResult(maxGlobal, maxLeft, maxRight);
            
    }
    
    static class KadaneResult{
        int maxGlobal;
        int left;
        int right;

        public KadaneResult(int maxGlobal, int left, int right) {
            this.maxGlobal = maxGlobal;
            this.left = left;
            this.right = right;
        }
        
        
        
        
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
KKRRKKKRKRRKRRRKRRRRRKKRKKRKRRKKRKRRKRRRRKRRKKKKRRKRRRR
maximum sum = 4
array is [ 44 , 54 ]

BUILD SUCCESSFUL (total time: 2 seconds)


*/