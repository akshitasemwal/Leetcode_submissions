//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class DriverClass {
    public static void main(String args[]) throws IOException {

        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String str[] = read.readLine().trim().split(" ");
            int V = Integer.parseInt(str[0]);
            int E = Integer.parseInt(str[1]);

            ArrayList<ArrayList<Integer>> edges = new ArrayList<>();

            int i = 0;
            while (i++ < E) {
                String S[] = read.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                int w = Integer.parseInt(S[2]);
                ArrayList<Integer> t1 = new ArrayList<>();
                t1.add(u);
                t1.add(v);
                t1.add(w);
                edges.add(t1);
            }

            int S = Integer.parseInt(read.readLine());

            Solution ob = new Solution();

            int[] ptr = ob.bellman_ford(V, edges, S);

            for (i = 0; i < ptr.length; i++) System.out.print(ptr[i] + " ");
            System.out.println();
        }
    }
}
// } Driver Code Ends


// User function Template for Java

/*
*   edges: vector of vectors which represents the graph
*   S: source vertex to start traversing graph with
*   V: number of vertices
*/
class Solution {
    static int[] bellman_ford(int v, ArrayList<ArrayList<Integer>> edges, int s) {
        int[] dist = new int[v];
        for (int i = 0; i < v; i++) dist[i] = (int)(1e8);
        dist[s] = 0;
        for(int i = 0; i<v-1; i++)  //relaxation for n - 1 or v - 1 times
        {
            for(ArrayList<Integer> it : edges)
            {
                int u = it.get(0);
                int node = it.get(1);
                int wt = it.get(2);
                if( dist[u] != 1e8 && dist[u] + wt < dist[node])
                {
                    dist[node] = dist[u] + wt;
                }
            }
        }
        
        for(ArrayList<Integer> it : edges)
            {
                int u = it.get(0);
                int node = it.get(1);
                int wt = it.get(2);
                if( dist[u] != 1e8 && dist[u] + wt < dist[node])
                {
                    int temp[] = new int[1];
                    temp[0] = -1;
                    return temp;
                }
            }
        return dist;
    }
}
