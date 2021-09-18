/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author DANI
 */
public class ComplexNumberTest {
    
    public ComplexNumberTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of realPart method, of class ComplexNumber.
     */
    @Test
    public void testRealPart() {
        System.out.println("realPart");
        ComplexNumber instance = null;
        double expResult = 0.0;
        double result = instance.realPart();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of imaginaryPart method, of class ComplexNumber.
     */
    @Test
    public void testImaginaryPart() {
        System.out.println("imaginaryPart");
        ComplexNumber instance = null;
        double expResult = 0.0;
        double result = instance.imaginaryPart();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of add method, of class ComplexNumber.
     */
    @Test
    public void testAdd() {
        System.out.println("add");
        ComplexNumber c = null;
        ComplexNumber instance = null;
        ComplexNumber expResult = null;
        ComplexNumber result = instance.add(c);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of subtract method, of class ComplexNumber.
     */
    @Test
    public void testSubtract() {
        System.out.println("subtract");
        ComplexNumber c = null;
        ComplexNumber instance = null;
        ComplexNumber expResult = null;
        ComplexNumber result = instance.subtract(c);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of multiply method, of class ComplexNumber.
     */
    @Test
    public void testMultiply() {
        System.out.println("multiply");
        ComplexNumber c = null;
        ComplexNumber instance = null;
        ComplexNumber expResult = null;
        ComplexNumber result = instance.multiply(c);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of division method, of class ComplexNumber.
     */
    @Test
    public void testDivision() {
        System.out.println("division");
        ComplexNumber c = null;
        ComplexNumber instance = null;
        ComplexNumber expResult = null;
        ComplexNumber result = instance.division(c);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of conjugate method, of class ComplexNumber.
     */
    @Test
    public void testConjugate() {
        System.out.println("conjugate");
        ComplexNumber instance = null;
        ComplexNumber expResult = null;
        ComplexNumber result = instance.conjugate();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of module method, of class ComplexNumber.
     */
    @Test
    public void testModule() {
        System.out.println("module");
        ComplexNumber instance = null;
        double expResult = 0.0;
        double result = instance.module();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
