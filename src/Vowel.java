import java.util.*;
public class Vowel{
	public static void main(String[] args){
		int t=0;
		Scanner in = new Scanner(System.in);
		StringBuilder res = new StringBuilder("");
		t = in.nextInt();
		while(t-- > 0){
                    
                    int strLen = in.nextInt();
                    String temp = in.next();
                    
                    int countVowels = 0;
                    int[] vowelAt = new int[strLen];
                    
                    for(int i=0;i < strLen;i++){
                        if(isVowel(temp.charAt(i))){
                            countVowels++;
                            vowelAt[countVowels] = i;
                        }
                    }
                    
                    long sum = 0;
                    
                    int i=1;
                    for(int j=3; j<= countVowels;j++, i++){
                        int countI = 0;
                        int countJ = 0;
                        
                        if(i==1){
                            countI = vowelAt[1]+1;
                        }else{
                            countI = vowelAt[i] - vowelAt[i-1];
                        }
                        
                        if(j== countVowels){
                            countJ = strLen - vowelAt[j];
                        }else{
                            countJ = vowelAt[j+1] - vowelAt[j];
                        }
                        
                        sum += (countI * countJ);
                    }
                    
                    res.append(sum + "\n");
		}
		System.out.print(res);
	}
        
        private static boolean isVowel(char c){
            if(c == 'a' || c == 'e' || c== 'i' || c== 'o' || c== 'u')
                return true;
            
            return false;
        }
}