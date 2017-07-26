
import java.io.IOException;
import java.util.InputMismatchException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Naveen
 */

//https://www.hackerearth.com/practice/algorithms/searching/binary-search/practice-problems/algorithm/student-arrangement-6/description/
public class StudentArrangement {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
//        try{
//            FasterScanner in = new FasterScanner();
//
//            int N = in.nextInt();
//            int M = in.nextInt();
//            int K = in.nextInt();
//
//            int count[] = new int[M + 1];
//
//            int ans = 0;
//
//            for(int i= 1; i<= java.lang.Math.min(N, M*K);i++){
//                int preferedRow = in.nextInt();
//                int allowedRow = getAllowedRow(count,K, preferedRow, M);
//
//                if(allowedRow == -5){
//                    allowedRow = getAllowedRowFromAsc(count, K, 1, preferedRow-1);
//                }
//
//                count[allowedRow]++;
//                if(preferedRow != allowedRow)
//                    ans++;
//
//            }
//
//            if(N > (M*K)){
//                ans = ans + (N - (M*K));
//            }
//
//            System.out.println(ans);
//        }catch(Exception e){
//            System.out.println(e.getMessage());
//        }
          System.out.println(getAllowedRow(new int[]{-4,2,2,1,2,2,2,2,1,1}, 2, 1, 9));
    }
    
    static int getAllowedRow(int count[], int K, int L , int R){
        int row = -5;
                
        while( L <= R){
            int mid = (L+R)/2;
            if(!isRowFilled(count,mid, K)){
                row = mid;
                R = mid -1;
            }else{
                L = mid+1;
            }
        }
        return row;
    }
    
    static int getAllowedRowFromAsc(int count[], int K, int L , int R){
        int row = -5;
                
        while( L <= R){
            int mid = (L+R)/2;
            if(!isRowFilled(count, mid, K)){
                row = mid;
                R = mid - 1;
            }else{
                R = mid -1;
            }
        }
        return row;
    }
    
    static boolean isRowFilled(int [] count,int i, int capacity){
        return count[i] < capacity ? false : true;
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
