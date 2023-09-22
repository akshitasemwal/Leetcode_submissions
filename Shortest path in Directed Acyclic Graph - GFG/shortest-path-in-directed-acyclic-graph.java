//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		while (T-- > 0) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			int[][] edge = new int[m][3];
			for (int i = 0; i < m; i++) {
				edge[i][0] = sc.nextInt();
				edge[i][1] = sc.nextInt();
				edge[i][2] = sc.nextInt();
			}
			Solution obj = new Solution();
			int res[] = obj.shortestPath(n, m,edge);
			for (int i = 0; i < n; i++) {
				System.out.print(res[i] + " ");
			}
			System.out.println();
		}
	}
}
// } Driver Code Ends


//User function Template for Java
class Solution {
    public void dfs(int s, ArrayList<ArrayList<int[]>> adj, Stack<Integer> st, boolean[] visited)
    {
        int n = adj.size();
        visited[s] = true;
        for(int i = 0; i<adj.get(s).size(); i++)
        {
            int[] arr = adj.get(s).get(i);
            int v = arr[0];
            int wt = arr[1];
            if(!visited[v])
            {
                dfs(v, adj, st, visited);
            }
        }
        st.push(s);
    }
    

	public int[] shortestPath(int n, int m, int[][] edges) {
		ArrayList<ArrayList<int[]>> adj = new ArrayList<>();
        boolean[] visited = new boolean[n];
		int[] dist = new int[n];
        Stack<Integer> st = new Stack<>();
		for(int i = 0; i<n+1; i++)
		{
		    adj.add(new ArrayList<int[]>());
		}
		for(int i = 0; i<edges.length; i++)
		{
		    int u = edges[i][0];
		    int v = edges[i][1];
		    int wt = edges[i][2];
		    int[] arr = {v, wt};
		    adj.get(u).add(arr);
		}
		for(int i = 0; i<n; i++)
		{
		    if(!visited[i])
		    {
		        dfs(0, adj, st, visited);
		    }
		}
		
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[st.peek()] = 0;                  //
		while(!st.isEmpty())
		{
		    int u = st.pop();
		    for(int i = 0; i<adj.get(u).size(); i++)
		    {
		        int[] arr = adj.get(u).get(i);
		        int v = arr[0];
		        int wt = arr[1];
		        dist[v] = Math.min(dist[v], wt + dist[u]);
		    }
		}
		
		for(int i = 0; i<n; i++)
		{
		    if(dist[i] == Integer.MAX_VALUE)
		    {
		        dist[i] = -1;
		    }
		}
		return dist;
	}
}