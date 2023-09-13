//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String[] s = br.readLine().trim().split(" ");
            int V = Integer.parseInt(s[0]);
            int E = Integer.parseInt(s[1]);
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            for (int i = 0; i < V; i++) adj.add(i, new ArrayList<Integer>());
            for (int i = 0; i < E; i++) {
                String[] S = br.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                adj.get(u).add(v);
                adj.get(v).add(u);
            }
            Solution obj = new Solution();
            boolean ans = obj.isCycle(V, adj);
            if (ans)
                System.out.println("1");
            else
                System.out.println("0");
        }
    }
}
// } Driver Code Ends


class Solution {
    // Function to detect cycle in an undirected graph.
    public boolean bfs(int n, ArrayList<ArrayList<Integer>> adj, boolean[] visited, int src) 
    {
        Queue<int[]> q = new LinkedList<>();
        int[] s = {src, -1};
        visited[src] = true;
        q.add(s);
        while( !q.isEmpty() )
        {
            int[] u = q.remove();
            int node = u[0];
            int parent = u[1];
            for(int i = 0; i<adj.get(node).size(); i++)
            {
                int v = adj.get(node).get(i);
                if( visited[v] == false )
                {
                    visited[v] = true;
                    int[] arr = {v, node};
                    q.add(arr);
                }
                else if( parent != v )
                {
                    return true;
                }
            }
        }
        return false;
    }
    
    public boolean isCycle(int n, ArrayList<ArrayList<Integer>> adj)
    {
        boolean[] visited = new boolean[n];
        for(int i = 0; i<n; i++)
        {
            if(visited[i] == false)
            {
                if( bfs(n, adj, visited, i) == true )
                {
                    return true;
                }
            }
        }
        return false;
    }
}