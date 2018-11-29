import java.util.Arrays;

public class Bellman_Ford {
	private int V;
	private int d[];
	public Bellman_Ford(int V) {
		this.V = V;
		d = new int[V+1];
	}
	public int[] BellmanFord_Matrix(int start, int matrix[][]) {
		Arrays.fill(d, Integer.MAX_VALUE);
		d[start] = 0;
		for(int i = 1; i < V-1; i++) {
			for(int source = 1; source <= V; source++) {
				for(int dest = 1; dest <= V; dest++) {
					if(matrix[source][dest] != Integer.MAX_VALUE) {
						if(d[dest] > d[source] + matrix[source][dest]) {
							d[dest] = d[source] + matrix[source][dest];
						}
					}
				}
			}
		}
		for(int i = 1; i <= V; i++) {
			for(int dest = 1; dest <= V; dest++) {
				if(matrix[i][dest] != Integer.MAX_VALUE) {
					if(d[dest] > d[i] + matrix[i][dest]) {
						System.out.println("Negative edge cycle");
					}
				}
			}
		}
		return d;
	}
	public int[] BellmanFord_List(int start, int list) {
		Arrays.fill(d, Integer.MAX_VALUE);
		d[start] = 0;
		for(int i = 0; i < V - 1; i++) {
			for(list<pair of integers> edges : list>) {
				for(<pair of integers> edge : edges) {
					if(d[i] + edge.weight < d[edge.end]) {
						d[edge.end] = d[i] + edge.weight;
					}
				}
			}
		}
		for(int i = 0; i < V - 1; i++) {
			for(list<pair of integers> edges : list>) {
				for(<pair of integers> edge : edges) {
					if(d[i] + edge.weight < d[edge.end]) {
						System.out.println("Negative cycle");
					}
				}
			}
		}
		return d;
	}
}
