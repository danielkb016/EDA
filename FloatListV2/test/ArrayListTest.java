

import org.junit.AfterClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.BeforeClass;

/**
 *
 * @author mayte
 * @param <F>
 */
public class ArrayListTest<F> {
    
    public ArrayListTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    public ArrayList inicializa(){
       
        ArrayList instance = new ArrayList<F>(6);
        
        instance.add(new Float(3));
        instance.add(new Float(8));
        instance.add(new Float(12));
        
        return instance; //[12, 8, 3]
    }
    /**
     * Test of size method, of class FArrayList.
     */
    @Test
    public void testSize() {
        System.out.println("size");
        ArrayList instance = inicializa();
              
        int expResult = 3;
        int result = instance.size();
        assertEquals(expResult, result);
    }

    /**
     * Test of isempty method, of class FArrayList.
     */
    @Test
    public void testIsempty1() {
        System.out.println("isempty");
        ArrayList instance = inicializa();
        boolean expResult = false;
        boolean result = instance.isempty();
        assertEquals(expResult, result);
       
    }

    /**
     * Test of isempty method, of class FArrayList.
     */
    @Test
    public void testIsempty2() {
        System.out.println("isempty");
        ArrayList instance = new ArrayList<F>(2);
        boolean expResult = true;
        boolean result = instance.isempty();
        assertEquals(expResult, result);
       
    }
    
    /**
     * Test of add method, of class FArrayList.
     */
    @Test
    public void testAdd() {
        System.out.println("add");
        F value = null;
        ArrayList instance = new ArrayList<F>(3);
        assertTrue(instance.isempty());
        instance.add(new Float(2));
        assertFalse(instance.isempty());
        assertEquals(instance.size(),1);
    }

    /**
     * Test of add and remove methods, of class FArrayList.
     */
    @Test
    public void testAdd_int_Remove() {
        System.out.println("add");
        int index = 3;
        Float value = new Float(5);
        ArrayList instance = inicializa(); // [12, 8, 3]
        instance.add(index, value); // [12, 8, 5, 3]
        assertEquals(instance.size(),4);
        F remove = (F) instance.remove();
        assertEquals(12.0,remove,0.01);
        remove = instance.remove();
        assertEquals(8.0,remove,0.01);
        remove = instance.remove();
        assertEquals(5.0,remove,0.01);
        remove = instance.remove();
        assertEquals(3.0,remove,0.01);
        assertTrue(instance.isempty());
    }

    /**
     * Test of remove method, of class FArrayList.
     */
    @Test
    public void testRemove_int() {
        System.out.println("remove");
        int index = 2;
        ArrayList instance = inicializa(); // [12, 8, 3]
        F result = instance.remove(index);// 8
        assertEquals(8.0, result,0.01);
       
    }

    /**
     * Test of get method, of class FArrayList.
     */
    @Test
    public void testGet_0args() {
        System.out.println("get");
        FArrayList instance = inicializa(); // [12, 8, 3]
        F result = instance.get();//12
        assertEquals(12.0, result,0.01);
        
    }

    /**
     * Test of get method, of class FArrayList.
     */
    @Test
    public void testGet_int() {
        System.out.println("get");
        int index = 2;
        ArrayList instance = inicializa(); // [12, 8, 3]
        F result = instance.get(index);// 8
        assertEquals(8.0, result,0.01);
       
    }

    /**
     * Test of search method, of class FArrayList.
     */
    @Test
    public void testSearch() {
        System.out.println("search");
        F value = new F(5);
        FArrayList instance = inicializa();// [12, 8, 3]
        int expResult = 0;
        int result = instance.search(value);
        assertEquals(expResult, result);
        value = new F(3);
        expResult = 3;
        result = instance.search(value);
        assertEquals(expResult, result);
    }

    /**
     * Test of contains method, of class FArrayList.
     */
    @Test
    public void testContains() {
        System.out.println("contains");
        F value = new F(5);
        FArrayList instance = inicializa();// [12, 8, 3]
        boolean result = instance.contains(value);
        assertFalse(result);
        value = new F(12);
        result = instance.contains(value);
        assertTrue(result);
    }

    /**
     * Test of isempty method, of class ArrayList.
     */
    @Test
    public void testIsempty() {
        System.out.println("isempty");
        ArrayList instance = null;
        boolean expResult = false;
        boolean result = instance.isempty();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of add method, of class ArrayList.
     */
    @Test
    public void testAdd_GenericType() {
        System.out.println("add");
        Object value = null;
        ArrayList instance = null;
        instance.add(value);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of add method, of class ArrayList.
     */
    @Test
    public void testAdd_int_GenericType() {
        System.out.println("add");
        int index = 0;
        Object value = null;
        ArrayList instance = null;
        instance.add(index, value);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of remove method, of class ArrayList.
     */
    @Test
    public void testRemove_0args() {
        System.out.println("remove");
        ArrayList instance = null;
        Object expResult = null;
        Object result = instance.remove();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
