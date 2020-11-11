import static org.junit.Assert.*;
import org.junit.Test;

public class DAGTest {
	
	//Tests DAG constructor 
	@Test
	public void testDAGConstruct() 
	{
		DAG graph = new DAG(20);
		
		assertEquals(true, graph.validGraph);
	}

	//Test empty DAG
	@Test
	public void testIsEmpty() 
	{
		DAG graph = new DAG(0);
		
		assertEquals(true, graph.isEmpty());
	}

	//Tests DAG with negative amount of vertices
	@Test
	public void testNegaVerts()
	{
		DAG graph = new DAG(-8);
		
		assertEquals(false, graph.validGraph);
	}


	//Test to check if vertices are valid 
	@Test
	public void testValidateVertex()
	{
		DAG graph = new DAG(15);
		
		assertEquals(-1, graph.isVertexValid(15));
		assertEquals(1, graph.isVertexValid(6));
		assertEquals(1, graph.isVertexValid(0));
		assertEquals(-1, graph.isVertexValid(-5));
		assertEquals(-1, graph.isVertexValid(16));
	}


	//Test to check if edges are valid and being added correctly 
	@Test
	public void testAddEdge()
	{
		DAG graph = new DAG(15);
		graph.addEdge(1,2);
		graph.addEdge(1,3);
		graph.addEdge(0,-1);
		graph.addEdge(2,4);
		graph.addEdge(4,5);
		graph.addEdge(2,5);
		graph.addEdge(3,5);
		graph.addEdge(1,5);
		

		assertEquals(7, graph.edges);
		
	}

	//Test to ensure cycles are found correctly
	@Test
	public void testFindCycle()
	{ 
		DAG graphA = new DAG(15);
		graphA.addEdge(0,1);
		graphA.addEdge(1,2);
		graphA.addEdge(2,3);
		graphA.addEdge(3,4);
		graphA.addEdge(4,5);
		graphA.addEdge(5,0);

		graphA.findCycle(0);
		assertEquals(true, graphA.hasACycle);

		DAG graphB = new DAG(15);
		graphB.addEdge(0,1);
		graphB.addEdge(0,2);
		graphB.addEdge(0,3);
		graphB.addEdge(0,4);
		graphB.addEdge(1,3);
		graphB.addEdge(2,3);
		graphB.addEdge(2,4);
		graphB.addEdge(3,4);

		graphB.findCycle(0);
		assertEquals(false, graphB.hasACycle);

	}

	//Tests LCA for DAG
	@Test
	public void testFindLCA()
	{
		DAG graph = new DAG(15);
		
		graph.addEdge(0,1);
		graph.addEdge(0,2);
		graph.addEdge(0,3); 
		graph.addEdge(0,4);
		graph.addEdge(1,3);
		graph.addEdge(2,3);
		graph.addEdge(2,4);
		graph.addEdge(3,4);


		assertEquals(0, graph.LCA(0,1));
		assertEquals(2, graph.LCA(2,3));
		assertEquals(0, graph.LCA(0,4));
		assertEquals(1, graph.LCA(1,3));
		assertEquals(1, graph.LCA(1,4));
		assertEquals(3, graph.LCA(3,4));

		


	}

}