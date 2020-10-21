import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

class LCATest {

    @Test
    public void LCAtest1()
    {
        LCA tree = new LCA(); 
        tree.root = new Node(1); 
        tree.root.left = new Node(2); 
        tree.root.right = new Node(3); 
        tree.root.left.left = new Node(4); 
        tree.root.left.right = new Node(5); 
        tree.root.right.left = new Node(6); 
        tree.root.right.right = new Node(7);
        
       int expectedResult = 2;
  
       assertEquals(expectedResult, tree.findLCA(4,5));

    }
    
    @Test
    public void LCAtest2()
    {
        LCA tree = new LCA(); 
        tree.root = new Node(1); 
        tree.root.left = new Node(2); 
        tree.root.right = new Node(3); 
        tree.root.left.left = new Node(4); 
        tree.root.left.right = new Node(5); 
        tree.root.right.left = new Node(6); 
        tree.root.right.right = new Node(7);
        
       int expectedResult = 1;
  
       assertEquals(expectedResult, tree.findLCA(4,6));

    }
    
    @Test
    public void LCAtest3()
    {
        LCA tree = new LCA(); 
        tree.root = new Node(1); 
        tree.root.left = new Node(2); 
        tree.root.right = new Node(3); 
        tree.root.left.left = new Node(4); 
        tree.root.left.right = new Node(5); 
        tree.root.right.left = new Node(6); 
        tree.root.right.right = new Node(7);
        
       int expectedResult = 1;
  
       assertEquals(expectedResult, tree.findLCA(3,4));

    }
    
    @Test
    public void LCAtest4()
    {
        LCA tree = new LCA(); 
        tree.root = new Node(1); 
        tree.root.left = new Node(2); 
        tree.root.right = new Node(3); 
        tree.root.left.left = new Node(4); 
        tree.root.left.right = new Node(5); 
        tree.root.right.left = new Node(6); 
        tree.root.right.right = new Node(7);
        
       int expectedResult = 2;
  
       assertEquals(expectedResult, tree.findLCA(2,4));

    }
    
    

}
