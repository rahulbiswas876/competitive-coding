import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.InputMismatchException;
//import java.util.*;
public class SoroceSumDig{
	public static void main(String[] args) throws IOException{
		int t=0;
		FasterScanner in = new FasterScanner();
		StringBuilder res = new StringBuilder("");
                
                int N = in.nextInt();
                int Q = in.nextInt();
                
                //in.nextByte();
                int[] nums = new int[N];
                int[] sumMin = new int[N];
                int[] sumMax = new int[N];
                
                for(int i=0; i< N;i++){
                    //int num = in.nextInt();
                    //System.out.println(sumDig(num));
                    
                    nums[i] = sumDig(in);
                }
                //in = null;
                //in = new Scanner(System.in);
                Arrays.sort(nums);
                
                
                
                for(int i=0; i< N;i++){
                    if(i==0){
                        sumMin[0] = nums[0];
                    }
                    else{
                        sumMin[i] = sumMin[i-1] + nums[i];
                    }
                }
                
                for(int i=0; i< N;i++){
                    if(i==0){
                        sumMax[0] = nums[N-1];
                    }else{
                        sumMax[i] = sumMax[i-1] + nums[N -1- i];
                    }
                }
                
                
                
                
                for(int i= 1; i<=Q ;i++){
                    int q = in.nextInt();
                    int k = in.nextInt();
                    
                    if(q== 1){
                        res.append(sumMax[k-1] + "\n");
                    }else{
                        res.append(sumMin[k-1]+ "\n");
                    }
                }
                
                System.out.println(res);
                
		
	}
        
        static int sumDig(FasterScanner is) throws IOException{
            //InputStream is = System.in;
            
            int ch = is.read();
            int sum = 0;
            while(ch != '\n' && ch != ' '){
                int c = ch - '0';
                sum += c;
                int unit = sum % 10;
                sum /= 10;
                int tens = sum % 10;
                sum = unit + tens;
                ch = is.read();
            }
            
            
            
            
            
            
            return sum;
        
        }
        
       public static class FasterScanner
	{
		private byte[]	buf	= new byte[1024];
		private int		curChar;
		private int		numChars;
 
		public int read()
		{
			if(numChars == -1)
				throw new InputMismatchException();
			if(curChar >= numChars)
			{
				curChar = 0;
				try
				{
					numChars = System.in.read(buf);
				}
				catch(IOException e)
				{
					throw new InputMismatchException();
				}
				if(numChars <= 0)
					return -1;
			}
			return buf[curChar++];
		}
 
		public String nextLine()
		{
			int c = read();
			while(isSpaceChar(c))
				c = read();
			StringBuilder res = new StringBuilder();
			do
			{
				res.appendCodePoint(c);
				c = read();
			} while(!isEndOfLine(c));
			return res.toString();
		}
 
		public String nextString()
		{
			int c = read();
			while(isSpaceChar(c))
				c = read();
			StringBuilder res = new StringBuilder();
			do
			{
				res.appendCodePoint(c);
				c = read();
			} while(!isSpaceChar(c));
			return res.toString();
		}
 
		public long nextLong()
		{
			int c = read();
			while(isSpaceChar(c))
				c = read();
			int sgn = 1;
			if(c == '-')
			{
				sgn = -1;
				c = read();
			}
			long res = 0;
			do
			{
				if(c < '0' || c > '9')
					throw new InputMismatchException();
				res *= 10;
				res += c - '0';
				c = read();
			} while(!isSpaceChar(c));
			return res * sgn;
		}
 
		public int nextInt()
		{
			int c = read();
			while(isSpaceChar(c))
				c = read();
			int sgn = 1;
			if(c == '-')
			{
				sgn = -1;
				c = read();
			}
			int res = 0;
			do
			{
				if(c < '0' || c > '9')
					throw new InputMismatchException();
				res *= 10;
				res += c - '0';
				c = read();
			} while(!isSpaceChar(c));
			return res * sgn;
		}
 
		public int[] nextIntArray(int n)
		{
			int[] arr = new int[n];
			for(int i = 0; i < n; i++)
			{
				arr[i] = nextInt();
			}
			return arr;
		}
 
		public long[] nextLongArray(int n)
		{
			long[] arr = new long[n];
			for(int i = 0; i < n; i++)
			{
				arr[i] = nextLong();
			}
			return arr;
		}
 
		private boolean isSpaceChar(int c)
		{
			return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
		}
 
		private boolean isEndOfLine(int c)
		{
			return c == '\n' || c == '\r' || c == -1;
		}
	}
       
}

/*

5 5
1 1 1 1 1
9 9 9 9 1
1 3 3 3 1
1 9 9 9 9
1 1 1 1 1

*/