//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String[] S = br.readLine().trim().split(" ");
            int V = Integer.parseInt(S[0]);
            int E = Integer.parseInt(S[1]);
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            for(int i = 0; i < V; i++){
                adj.add(new ArrayList<Integer>());
            }
            for(int i = 0; i < E; i++){
                String[] s = br.readLine().trim().split(" ");
                int u = Integer.parseInt(s[0]);
                int v = Integer.parseInt(s[1]);
                adj.get(u).add(v);
                adj.get(v).add(u);
            }
            Solution obj = new Solution();
            boolean ans = obj.isBipartite(V, adj);
            if(ans)
                System.out.println("1");
            else System.out.println("0");
       }
    }
}
// } Driver Code Ends


class Solution
{
    // // public boolean bfs(ArrayList<ArrayList<Integer>>adj, int[] colors)
    // // {
    // //     Queue<Integer> q = new LinkedList<>();
    // //     int s = 0;
    // //     q.add(s);
    // //     colors[0] = 0;
    // //     while(!q.isEmpty())
    // //     {
    // //         int node = q.remove();
    // //         for(int i = 0; i<adj.get(node).size(); i++)
    // //         {
    // //             int v = adj.get(node).get(i);
    // //             if(colors[v] == -1)
    // //             {
    // //                 if(colors[node] == 0)
    // //                 {
    // //                     colors[v] = 1;
    // //                 }
    // //                 else
    // //                 {
    // //                     colors[v] = 0;
    // //                 }
    // //                 q.add(v);
    // //             }
    // //             else if( colors[node] == colors[v] )
    // //             {
    // //                 return false;
    // //             }
    // //         }
    // //     }
    // //     return true;
    // // }
    
    // public boolean isBipartite(int n, ArrayList<ArrayList<Integer>>adj)
    // {
    //     int[] colors = new int[n];
    //     Arrays.fill(colors, -1);
    //     for(int i = 0; i<n; i++)
    //     {
    //         if( colors[i] == -1 )
    //         {
    //             if (bfs(adj, colors) == false)
    //             {
    //                 return false;
    //             }
    //         }
    //     }
    //     return true;
    // }
    
    private boolean check(int start, int V, 
    ArrayList<ArrayList<Integer>>adj, int color[]) {
        Queue<Integer> q = new LinkedList<Integer>();
	    q.add(start); 
	    color[start] = 0; 
	    while(!q.isEmpty()) {
	        int node = q.peek();
	        q.remove(); 
	        
	        for(int it : adj.get(node)) {
	            // if the adjacent node is yet not colored
	            // you will give the opposite color of the node 
	            if(color[it] == -1) {
	                
	                color[it] = 1 - color[node]; 
	                q.add(it); 
	            }
	            // is the adjacent guy having the same color 
	            // someone did color it on some other path 
	            else if(color[it] == color[node]) {
	                return false; 
	            }
	        }
	    }
	    return true; 
    }

    public boolean isBipartite(int V, ArrayList<ArrayList<Integer>>adj)
    {
        int color[] = new int[V]; 
	    for(int i = 0;i<V;i++) color[i] = -1; 
	    
	    for(int i = 0;i<V;i++) {
	        if(color[i] == -1) {
	            if(check(i, V, adj, color) == false) {
	                return false; 
	            }
	        }
	    }
	    return true; 
    }
}