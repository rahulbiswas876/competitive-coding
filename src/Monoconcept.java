

import java.io.IOException;
import java.util.Arrays;
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
public class Monoconcept {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        try {
        FasterScanner in = new FasterScanner();
        
        int capac = in.nextInt();
        
        int N = in.nextInt();
        
        Obj[] objects = new Obj[N];
        
        for(int i = 0; i< N;i++){
            int w = in.nextInt();
            int p = in.nextInt();
            
            objects[i] = new Obj(w,p);
        }
        
        Arrays.sort(objects);
        
//        for(Obj obj: objects){
//            System.out.println(obj.pPerW);
//        }
        long sum = 0;
        int i = 0;
        while(capac != 0 && i < objects.length){
            if(capac >= objects[i].w){
                int canHold = capac / objects[i].w;
                
                sum += canHold * objects[i].p;
                
                capac -= (canHold * objects[i].w);
            }
            
            i++;
        }
        
        System.out.println(sum);
        }catch(Exception e){
            System.out.println(e.getMessage());
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

class Obj implements  Comparable<Obj>{
    int w;
    int p;
    
    float pPerW;
    
    public Obj(int w,int p){
        this.w = w;
        this.p = p;
        this.pPerW = (float)p / (float)w;
    }

    @Override
    public int compareTo(Obj ob) {
        //return this.pPerW - ob.pPerW;
        return  Float.compare( ob.pPerW,this.pPerW);
    }
}