/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author mayte
 */

public class ComplexNumber {
    
    
    /**
     * Constructor of the ComplexNumber
     * @param a real part
     * @param b imaginary part
     */
    private double realpart, imagpart;
    ComplexNumber(double a, double b){
        realpart = a;
        imagpart = b;
    }
    
    /**
     * 
     * @return the real part of the ComplexNumber
     */
    public double realPart(){
        return this.realpart;
    }
    
    /**
     * 
     * @return the imaginary part of the ComplexNumber
     */
    public double imaginaryPart(){
        return this.imagpart;
    }
    
    /**
     * Adds c to the ComplexNumber
     * 
     * @param c
     *        number to add
     * @return 
     *        this + c
     */
    public ComplexNumber add (ComplexNumber c){
        return new ComplexNumber(this.realpart+c.realpart, this.imagpart + c.imagpart);
      }
    
    /**
     * Returns the result of subtracting c from the ComplexNumber
     * 
     * @param c
     *        subtracting
     * @return 
     *        this - c
     */
    public ComplexNumber subtract (ComplexNumber c){
        return new ComplexNumber(this.realpart-c.realpart, this.imagpart - c.imagpart);
    }
    
    /**
     * Returns multiplication of c and the ComplexNumber
     * 
     * @param c
     *        multiplying
     * @return 
     *          this * c2
     */
    public ComplexNumber multiply (ComplexNumber c){
    }
    
   /**
     * Returns the division of the ComplexNumber by c 
     *
     * @param c
     *        divider
     * @return 
     *        this / c
     */
    public ComplexNumber division (ComplexNumber c){
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.

    } 
    
    /**
     * Returns the conjugate of the ComplexNumber
     * 
     * @return 
     *        a - ib
     */
    public ComplexNumber conjugate (){
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.

    } 
    
    /**
     * Returns the module of the ComplexNumber
     * 
     * @return 
     *      sqrt (a² + b²)
     */
    public double module (){
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.

    } 

   
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ComplexNumber other = (ComplexNumber) obj;
        if (Double.doubleToLongBits(this.realpart) != Double.doubleToLongBits(other.realpart)) {
            return false;
        }
        if (Double.doubleToLongBits(this.imagpart) != Double.doubleToLongBits(other.imagpart)) {
            return false;
        }
        return true;
    }

}
