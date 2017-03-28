import java.io.IOException;
import java.io.InputStream;
import java.util.*;
class SumDigits{
	public static void main(String[] args){
            try {
                int t=0;
		FasterScanner in = new FasterScanner();
		StringBuilder res = new StringBuilder("");
		
                int N = in.nextInt();
                //in.nextLine();
                
                //read();
                long[] digVal = new long[N];
                for(int i=0; i < N;i++){
                    //int temp = in.nextInt();
                    digVal[i] = read(in);
                }
                
                Arrays.sort(digVal);
                
                long ans = 0;
                
                int mod = 1000000007;
                for(int i=0;i < N;i++){
//                    long pow = (long)java.lang.Math.pow(2, i) % mod;
//                    ans += (pow * digVal[i])% mod;

                      ans = (ans + (digVal[i]*get2power(i))%mod)%mod;
                }
                
                //long d = 1000000000000000000L;
                System.out.println(ans);
                
            } catch (Exception e) {
                
                System.out.println(e);
            }
		
	}
        
        static long get2power(long exp){
            long M = 1000000007;
            long base = 2;
            long res=1;
            while(exp>0) {
               if(exp%2==1) res=(res*base)%M;
               base=(base*base)%M;
               exp/=2;
            }
            return res%M;
        
    }
        
        
        
        static long read(FasterScanner is){
            //InputStream is = System.in;
            
            int ch = is.read();
            long sum = 0;
            while(!is.isEndOfLine(ch) && !is.isSpaceChar(ch)){
                int c = ch - '0';
                //System.out.println(c);
                sum += c;
                //sum %= 100000007;
                ch = is.read();
            }
            
            return sum;
        }
            
    static class FasterScanner {

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
        
        public boolean isSpaceChar(int c) {
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }
        
        public boolean isEndOfLine(int c) {
            return c == '\n' || c == '\r' || c == -1;
        }
    }
        
}

