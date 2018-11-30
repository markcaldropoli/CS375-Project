import java.util.concurrent.ThreadLocalRandom;
import java.util.*;

public class Tests
{
	public static void main(String[] args)
	{
		int[][] graph1Dense = new int[5][5];

		for(int i = 0;i < 5; i++)
		{
			for(int j = 0; j < 5; j++)
			{
				graph1Dense[i][j] = 0;
			}
		}

		for(int i = 0;i < 5; i++)
		{
			for(int j = 0; j < 5; j++)
			{
				if(graph1Dense[j][i] == 0)
				{
					int rand = ThreadLocalRandom.current().nextInt(1, 9 + 1);
					graph1Dense[i][j] = rand;
				}
				else
				{
					graph1Dense[i][j] = graph1Dense[j][i];
				}

			}

		}

		int[][] graph2Dense = new int[100][100];

		for(int i = 0;i < 100; i++)
		{
			for(int j = 0; j < 100; j++)
			{
				graph2Dense[i][j] = 0;
			}
		}

		for(int i = 0;i < 100; i++)
		{
			for(int j = 0; j < 100; j++)
			{
				if(graph2Dense[j][i] == 0)
				{
					int rand = ThreadLocalRandom.current().nextInt(1, 9 + 1);
					graph2Dense[i][j] = rand;
				}
				else
				{
					graph2Dense[i][j] = graph2Dense[j][i];
				}
				//System.out.print(graph2Dense[i][j]);
			}
			//System.out.println();
		}



		int[][] graph1Sparse = new int[5][5];
		for(int i = 0;i < 5; i++)
		{
			for(int j = 0; j < 5; j++)
			{
				graph1Sparse[i][j] = 0;
			}
		}

		int count = 0;

		for(int i = 0;i < 5; i++)
		{
			for(int j = 0; j < 5; j++)
			{
				int rand = ThreadLocalRandom.current().nextInt(1, 9 + 1);
				if(count < 5 && graph1Sparse[j][i] == 0)
				{
					graph1Sparse[i][j] = rand;
					count++;
				}
				else
				{
					graph1Sparse[i][j] = graph1Sparse[j][i];
				}

			}

		}

		int[][] graph2Sparse = new int[100][100];
		for(int i = 0;i < 100; i++)
		{
			for(int j = 0; j < 100; j++)
			{
				graph2Sparse[i][j] = 0;
			}
		}

		count = 0;

		for(int i = 0;i < 100; i++)
		{
			for(int j = 0; j < 100; j++)
			{
				int rand = ThreadLocalRandom.current().nextInt(1, 9 + 1);

				if(count < 100 && graph2Sparse[j][i] == 0)
				{
					graph2Sparse[i][j] = rand;
					count++;
				}
				else
				{
					graph2Sparse[i][j] = graph2Sparse[j][i];
				}

			}

		}

		ArrayList<Edge>[] list1Dense = (ArrayList<Edge>[])new ArrayList[5];

		for(int i = 0 ;i < 5; i++)
		{
			list1Dense[i] = new ArrayList();
		}

		for(int i = 0;i < 5; i++)
		{
			for(int j = 0; j < 5; j++)
			{
				if(graph1Dense[i][j] != 0)
				{
					list1Dense[i].add(new Edge(j, graph1Dense[i][j]));
				}
			}
		}

		ArrayList<Edge>[] list2Dense = (ArrayList<Edge>[])new ArrayList[100];

		for(int i = 0 ;i < 100; i++)
		{
			list2Dense[i] = new ArrayList();
		}

		for(int i = 0;i < 100; i++)
		{
			for(int j = 0; j < 100; j++)
			{
				if(graph2Dense[i][j] != 0)
				{
					list2Dense[i].add(new Edge(j, graph2Dense[i][j]));
				}
			}
		}

		ArrayList<Edge>[] list1Sparse = (ArrayList<Edge>[])new ArrayList[5];

		for(int i = 0 ;i < 5; i++)
		{
			list1Sparse[i] = new ArrayList();
		}

		for(int i = 0;i < 5; i++)
		{
			for(int j = 0; j < 5; j++)
			{
				if(graph1Sparse[i][j] != 0)
				{
					list1Sparse[i].add(new Edge(j, graph1Sparse[i][j]));
				}
			}
		}

		ArrayList<Edge>[] list2Sparse = (ArrayList<Edge>[])new ArrayList[100];

		for(int i = 0 ;i < 100; i++)
		{
			list2Sparse[i] = new ArrayList();
		}

		for(int i = 0;i < 100; i++)
		{
			for(int j = 0; j < 100; j++)
			{
				if(graph2Sparse[i][j] != 0)
				{
					list2Sparse[i].add(new Edge(j, graph2Sparse[i][j]));
				}
			}
		}


	}
}
