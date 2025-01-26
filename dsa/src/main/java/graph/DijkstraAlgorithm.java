package graph;

/*
* Problem link : https://www.geeksforgeeks.org/problems/shortest-path-in-undirected-graph-having-unit-distance/
* */
public class DijkstraAlgorithm {

    public int[] shortestPath(ArrayList<ArrayList<Integer>> adj, int src) {
        int vertices = adj.size();
        int[] dist = new int[vertices];
        Arrays.fill(dist, vertices+1);
        dist[src] = 0;

        Queue<Integer[]> minHeap = new PriorityQueue<>((a,b) -> a[1]-b[1]);
        minHeap.offer(new Integer[]{src, 0});

        while(!minHeap.isEmpty()) {
            Integer[] currNode = minHeap.poll();

            for(Integer cn: adj.get(currNode[0])) {
                if(dist[cn] < currNode[1]+1) continue;
                int newCost = currNode[1] + 1;
                dist[cn] = newCost;
                minHeap.offer(new Integer[]{cn, newCost});
            }
        }

        for(int i=0; i<dist.length; i++) {
            if(dist[i] == vertices+1) dist[i] = -1;
        }

        return dist;
    }

}