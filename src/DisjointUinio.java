import java.util.*;
public class DisjointUinio{
        static int root[];
        static boolean isRoot[];
        static int size[];
	public static void main(String[] args){
		int t=0;
		Scanner in = new Scanner(System.in);
		StringBuilder res = new StringBuilder("");
		
                int N = in.nextInt();
                int M = in.nextInt();
                
                //N+1 because we are using 1 based indexing
                root = new int[N+1];
                isRoot = new boolean[N +1];
                size = new int[N+1];
                
                //initialize loop
                for(int i=1 ;i < root.length ;i++){
                    root[i] = i;
                    size[i] = 1;
                    isRoot[i] = true;
                }
                
                for(int i=1;i <= M;i++){
                    int nodeA = in.nextInt();
                    int nodeB = in.nextInt();
                    union(nodeA, nodeB);
                    displayResult();
                }
	}
        
        static void union(int nodeA, int nodeB){
            int rootA = root(nodeA);
            int rootB = root(nodeB);
            
            //condition to optimize. smaller component will be finded and attatched to larger component
            if(size[rootA] > size[rootB]){
                //since rootB is smaller, therefore rootB will be attatched to rootA
                root[rootB] = rootA;
                size[rootA] += size[rootB];
                isRoot[rootB] = false;
            }else{
                root[rootA] = rootB;
                size[rootB] += size[rootA];
                isRoot[rootA] = false;
            }
            
        }
        
        static int root(int node){
            if(root[node] == node)
                return node;
                
            return root(root[node]);
            
        }
        
        static void displayResult(){
            ArrayList cmpSize;
            cmpSize = new ArrayList<Integer>();
            for(int i=1;i < root.length;i++){
                if(isRoot[i]){
                    cmpSize.add(size[i]);
                }
            }
            
            Collections.sort(cmpSize);
            
            for(int i=0;i < cmpSize.size();i++)
                System.out.print(cmpSize.get(i) + " ");
            
            System.out.print("\n");
        }
}