
package examenExtra;

import examenExtra.MultidimensionalTable;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author mayte
 */
public class MultidimensionalTableTest {
    

    /**
     * Test of insert method, of class MultidimensionalTable.
     */
    @Test
    public void testInsert() {
        System.out.println("insert");
        MultidimensionalTable<String> instance = new MultidimensionalTable<>();
        instance.insert(7, 5, "Juan");
    }

    /**
     * Test of get method, of class MultidimensionalTable.
     */
    @Test
    public void testGet() {
        System.out.println("get");
        MultidimensionalTable<String> instance = new MultidimensionalTable<>();
        instance.insert(7, 5, "Juan");
        assertEquals("Juan", instance.get(7, 5));
    }

    /**
     * Test of shape method, of class MultidimensionalTable.
     */
    @Test
    public void testShape() {
        System.out.println("shape");
        MultidimensionalTable<String> instance = new MultidimensionalTable<>();
        instance.insert(3, 3, "Pedro");
        instance.insert(7, 5, "Juan");
        assertEquals(7, instance.shape().getFirst().intValue());
        assertEquals(5, instance.shape().getFirst().intValue());
    }

    /**
     * Test of delete method, of class MultidimensionalTable.
     */
    @Test
    public void testDelete() {
        System.out.println("delete");
        MultidimensionalTable<String> instance = new MultidimensionalTable<>();
        instance.insert(7, 5, "Juan");
        instance.delete(7, 5);
        assertEquals(null, instance.get(7, 5));
    }

    /**
     * Test of getColum method, of class MultidimensionalTable.
     */
    @Test
    public void testGetColum() {
        System.out.println("getColum");
        MultidimensionalTable<String> instance = new MultidimensionalTable<>();
        instance.insert(7, 5, "Juan");
        instance.insert(3, 5, "Pedro");
        instance.insert(3, 4, "Andres");
        List<String> column = instance.getColum(5);
        assertTrue(column.contains("Juan"));
        assertTrue(column.contains("Pedro"));
    }

    /**
     * Test of getRow method, of class MultidimensionalTable.
     */
    @Test
    public void testGetRow() {
        System.out.println("getColum");
        MultidimensionalTable<String> instance = new MultidimensionalTable<>();
        instance.insert(7, 5, "Juan");
        instance.insert(3, 5, "Pedro");
        instance.insert(3, 4, "Andres");
        List<String> row = instance.getRow(3);
        assertTrue(row.contains("Andres"));
        assertTrue(row.contains("Pedro"));

    }

    /**
     * Test of deleteColum method, of class MultidimensionalTable.
     */
    @Test
    public void testDeleteColum() {
        System.out.println("deleteColum");
        MultidimensionalTable<String> instance = new MultidimensionalTable<>();
        instance.insert(7, 5, "Juan");
        instance.insert(3, 5, "Pedro");
        instance.insert(3, 4, "Andres");
        instance.deleteColum(5);
        assertEquals(4, instance.shape().getSecond().intValue());
    }

    /**
     * Test of deleteRow method, of class MultidimensionalTable.
     */
    @Test
    public void testDeleteRow() {
        System.out.println("deleteRow");
        MultidimensionalTable<String> instance = new MultidimensionalTable<>();
        instance.insert(7, 5, "Juan");
        instance.insert(3, 5, "Pedro");
        instance.insert(3, 4, "Andres");
        instance.deleteRow(7);
        assertEquals(3, instance.shape().getSecond().intValue());
    }
    
}
