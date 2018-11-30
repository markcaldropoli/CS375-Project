package project;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import javafx.util.Pair;

public class Dijkstra {
    private int n;
    private LinkedList<Edge>[] adjList;

    @SuppressWarnings("unchecked")
	public Dijkstra(int nVertices) {
        this.n = nVertices;
        this.adjList = new LinkedList[n];
    }

    public int[] DijkstraAdjList(ArrayList<Edge>[] graph, int start) {
        boolean[] spt = new boolean[n];
        int[] paths = new int[n];

        for(int i = 0; i < n; i++) paths[i] = Integer.MAX_VALUE;

        PriorityQueue<Pair<Integer, Integer>> pq = new PriorityQueue<>(n, new Comparator<Pair<Integer, Integer>>() {
            @Override
            public int compare(Pair<Integer,Integer> p1, Pair<Integer, Integer> p2) {
                int v1 = p1.getVertex();
                int v2 = p2.getVertex();
                return v1-v2;
            }
        });

        paths[0] = 0;
        Pair<Integer, Integer> pair0 = new Pair<>(paths[0], 0);
        pq.offer(pair0);

        while(!pq.isEmpty()) {
            Pair<Integer, Integer> pair = pq.poll();

            int vert = pair.getValue();
            if(!spt[vert]) {
                spt[vert] = true;

                LinkedList<Edge> list = adjList[vert];

                for(int i = 0; i < list.size(); i++) {
                    Edge e = list.get(i);
                    int endVertex = e.getVertex();
                    if(!spt[endVertex]) {
                        int key = paths[vert] + e.getWeight();
                        int currKey = paths[endVertex];
                        if(currKey > key) {
                            Pair<Integer, Integer> p = new Pair<>(key, endVertex);
                            pq.offer(p);
                            paths[endVertex] = key;
                        }
                    }
                }
            }
        }
        return paths;
    }

    public int[] DijkstraAdjMatrix(int[][] graph, int start) {
        int[] paths = new int[n]; //shortest paths from start vertex to vertex i
        boolean[] spt = new boolean[n]; //i = true if i is in shortest path tree

        for(int i = 0; i < n; i++) {
            paths[i] = Integer.MAX_VALUE;
            spt[i] = false;
        }

        paths[start] = 0;

        for(int i = 0; i < n-1; i++) {
            int d = findMinDist(paths, spt);
            spt[d] = true;

            for(int j = 0; j < n; j++) {
                if(!spt[j] && graph[i][j] != 0 && paths[i] != Integer.MAX_VALUE &&
                (paths[i] + graph[i][j]) < paths[j]) {
                    paths[j] = paths[i] + graph[i][j];
                }
            }
        }
        return paths;
    }

    public int findMinDist(int paths[], boolean spt[]) {
        int index = -1;
        int min = Integer.MAX_VALUE;

        for(int i = 0; i < n; i++) {
            if(!spt[i] && paths[i] <= min) {
                index = i;
                min = paths[i];
            }
        }

        return index;
    }
}
