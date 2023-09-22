//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int m=sc.nextInt();
            int[][] edge = new int[m][2];
            for(int i=0;i<m;i++){
                edge[i][0]=sc.nextInt();
                edge[i][1]=sc.nextInt();
            }
            int src=sc.nextInt();
            Solution obj = new Solution();
            int res[] = obj.shortestPath(edge,n,m,src);
            for(int i=0;i<n;i++){
                System.out.print(res[i]+" ");
            }
            System.out.println();
        }
    }
}

// } Driver Code Ends


class Solution {
    public void bfs(int src, int d, ArrayList<ArrayList<Integer>> adj, int[] ans)
    {
        int n = adj.size();
        boolean[] visited = new boolean[n];
        int[] level = new int[n];
        Queue<Integer> q = new LinkedList<>();
        visited[src] = true;
        q.add(src);
        level[src] = 0;
        int count = 0;
        while(!q.isEmpty())
        {
            int u = q.remove();
            if(u == d)
            {
                break;
            }
            
            for(int i = 0; i<adj.get(u).size(); i++)
            {
                int v = adj.get(u).get(i);
                if(!visited[v])
                {
                    visited[v] = true;
                    q.add(v);   
                    level[v] = level[u] + 1;
                }
            }
        }
        if(visited[d])
        {
            ans[d] = level[d];
        }
        else
        {
            ans[d] = -1;
        }
    }
    
    public int[] shortestPath(int[][] edges,int n,int m ,int src) {
        // Code here
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        int[] ans = new int[n];
        for(int i = 0; i<n; i++)
        {
            adj.add(new ArrayList<>());
        }
        for(int i = 0; i<edges.length; i++)
        {
            int u = edges[i][0];
            int v = edges[i][1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        
        for(int i = 0; i<n; i++)
        {
            bfs(src, i, adj, ans);
        }
        
        return ans;
    }
}