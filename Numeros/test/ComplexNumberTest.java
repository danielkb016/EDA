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
        ComplexNumber instance = new ComplexNumber(2.2, 2.0);
        double expResult = 2.2;
        double result = instance.realPart();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of imaginaryPart method, of class ComplexNumber.
     */
    @Test
    public void testImaginaryPart() {
        System.out.println("imaginaryPart");
        ComplexNumber instance = new ComplexNumber(7.0, 2.0);
        double expResult = 2.0;
        double result = instance.imaginaryPart();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of add method, of class ComplexNumber.
     */
    @Test
    public void testAdd() {
        System.out.println("add");
        ComplexNumber c = new ComplexNumber(7.0, 2.0);
        ComplexNumber instance = new ComplexNumber(7.0, 2.0);
        ComplexNumber expResult = new ComplexNumber(14.0, 4.0);
        ComplexNumber result = instance.add(c);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of subtract method, of class ComplexNumber.
     */
    @Test
    public void testSubtract() {
        System.out.println("subtract");
         ComplexNumber c = new ComplexNumber(7.0, 2.0);
        ComplexNumber instance = new ComplexNumber(7.0, 2.0);
        ComplexNumber expResult = new ComplexNumber(0.0, 0.0);
        ComplexNumber result = instance.subtract(c);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.

    }

    /**
     * Test of multiply method, of class ComplexNumber.
     */
    @Test
    public void testMultiply() {
        System.out.println("multiply");
        ComplexNumber c = new ComplexNumber(0.0, 0.0);
        ComplexNumber instance = new ComplexNumber(0.0, 0.0);
        ComplexNumber expResult = new ComplexNumber(0.0, 0.0);
        ComplexNumber result = instance.multiply(c);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of division method, of class ComplexNumber.
     */
    @Test
    public void testDivision() {
        System.out.println("division");
        ComplexNumber c = new ComplexNumber(0.0, 0.0);
        ComplexNumber instance = new ComplexNumber(0.0, 0.0);
        ComplexNumber expResult = new ComplexNumber(0.0, 0.0);
        ComplexNumber result = instance.division(c);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of conjugate method, of class ComplexNumber.
     */
    @Test
    public void testConjugate() {
        System.out.println("conjugate");
        ComplexNumber instance = new ComplexNumber(1.0, 2.0);
        ComplexNumber expResult = new ComplexNumber(1.0, -2.0);
        ComplexNumber result = instance.conjugate();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of module method, of class ComplexNumber.
     */
    @Test
    public void testModule() {
        System.out.println("module");
        ComplexNumber instance = new ComplexNumber(0.0, 0.0);
        double expResult = 0.0;
        double result = instance.module();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
    }
    
}
