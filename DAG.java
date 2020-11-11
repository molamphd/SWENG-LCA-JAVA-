import java.util.LinkedList;
import java.util.Iterator;
import java.util.ArrayList;

public class DAG 
{
	public int edges;
	public int verts;
	public int[] inDegree;
	public boolean[] visitedN;
	public boolean[] stack;
	public boolean hasACycle = false;
	public boolean validGraph = true;
	public ArrayList<Integer>[] adjacent;

	
	//Initializes DAG
	public DAG(int verts)
	{
		if(verts < 0)
		{
			validGraph = false;	
			System.out.print("Number of vertices in DAG must be > 0");
			return;
			
		}

		this.edges = 0; 
		this.verts = verts; 
		visitedN = new boolean[verts];
		inDegree = new int[verts];
		stack = new boolean[verts];
		adjacent = new ArrayList[verts];

		for(int i = 0; i < verts; i++)
		{
			adjacent[i] = new ArrayList<Integer>();
		}

	}

	//Checks if the graph is empty 
	public boolean isEmpty()
	{
		if(verts == 0) 
		{
			return true;						
		}
		
		else{			
			return false;			
		}
	}

	//Checks if a vertex is valid 
	public int isVertexValid(int vertex)
	{
		if(vertex < 0 || vertex >= verts) 
		{
			return -1;
		}
		
		else {
			return 1;
		}
	}
	

	//Edge vertex1 - vertex2 added to the graph
	public void addEdge(int vertex1, int vertex2)
	{
		if((isVertexValid(vertex1) > 0) && (isVertexValid(vertex2) > 0))
		{
			adjacent[vertex1].add(vertex2);
			inDegree[vertex2]++;
			edges++;
		}

	}
	

	//Checks for a cycle in the graph, returns true if cycle found, false otherwise
	public boolean findCycle(int vertex)
	{
		stack[vertex] = true;
		visitedN[vertex] = true;

		for(int a : adjacent[vertex])
		{
			if(!visitedN[a])
			{
				findCycle(a);
			}
			
			else if(stack[a])
			{
				hasACycle = true;
			}
		}

		stack[vertex] = false;
		
		return hasACycle;
	}

	
	//Breadth First Search
	public ArrayList<Integer> BFS(int vertex)
	{
		boolean[] checked = new boolean[verts];
		ArrayList<Integer> order = new ArrayList<Integer>();
		LinkedList<Integer> queue = new LinkedList<Integer>();
		checked[vertex] = true;
		queue.add(vertex);

		while(queue.size() > 0)
		{
			vertex = queue.poll();
			order.add(vertex);

			Iterator<Integer> i = adjacent[vertex].listIterator();

			while(i.hasNext())
			{
				int j = i.next();
				if(!checked[j])
				{
					checked[j] = true;
					queue.add(j);
				}
			}
		}

		return order;
	}

	//Invert DAG
	public DAG invert()
	{
		DAG invertDAG = new DAG(verts);
		
		for(int v = 0; v < verts; v++) { 
			for(int i : adjacent[v]){
				invertDAG.addEdge(i, v);
			}
		}
		
		return invertDAG;
		
	}
	
	//Find the lowest common ancestor between two nodes of DAG
	public int LCA(int vertex1, int vertex2)
	{
		findCycle(0);

		if(hasACycle == true || (isVertexValid(vertex1) < 0) || (isVertexValid(vertex2) < 0) || edges == 0)
		{
			 return -1;
		}

		DAG reverseDAG = invert();
		ArrayList<Integer> list1 = reverseDAG.BFS(vertex1);
		ArrayList<Integer> list2 = reverseDAG.BFS(vertex2);
		ArrayList<Integer> commonAncestors = new ArrayList<Integer>();
		boolean LCAFound = false;

		for(int i = 0; i < list1.size(); i++)
		{
			for(int c = 0; c < list2.size(); c++)
			{
				if(list1.get(i) == list2.get(c))
				{
					commonAncestors.add(list1.get(i));
					LCAFound = true;
				}
			}
		}

		if(LCAFound)
		{
			return commonAncestors.get(0);
		}
		
		else {
			return -1;
		}

	}


}
