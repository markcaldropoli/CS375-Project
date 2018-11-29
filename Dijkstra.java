public class Dijkstra {
    private static int n;

    public static void DijkstraAdjMatrix(int[][] graph, int nVertices, int start) {
        this.n = nVertices;
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
    }

    public static int findMinDist(int paths[], boolean spt[]) {
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
