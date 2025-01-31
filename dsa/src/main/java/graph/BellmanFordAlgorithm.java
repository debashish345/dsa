package graph;

/*
* Problem link : https://www.geeksforgeeks.org/problems/distance-from-the-source-bellman-ford-algorithm/
* */
public class BellmanFordAlgorithm {
    static int[] bellmanFord(int V, int[][] edges, int src) {
        int[] cost = new int[V];
        Arrays.fill(cost, (int)1e8);
        cost[src] = 0;

        // relax edges V-1 times
        for(int i=0; i<V; i++) {
            for(int[] edge: edges) {
                int source = edge[0];
                int dest = edge[1];
                int pathCost = edge[2];

                if(cost[source] != 1e8 && cost[dest] > cost[source]+pathCost) {
                    // if the edge still relax for V time, means it contains neg edge
                    if(i == V-1) {
                        return new int[]{-1};
                    }
                    cost[dest] = cost[source]+pathCost;
                }
            }
        }
        return cost;
    }
}