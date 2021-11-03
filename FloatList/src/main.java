/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author DANI
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       LinkedList f1 = new LinkedList();
        Float e,f,g,h,i;
        e =  2.3f;
        f =  2.4f;
        g =  2.5f;
         i = 2.0f;
        h = 1.0f;
        f1.add(e);
        f1.add(f);
        f1.add(g);
        System.out.println(f1.isempty() + f1.toString());
        f1.add(1, h);
        System.out.println(f1.isempty() + f1.toString());
        f1.remove(2);        
        System.out.println(f1.search(i));
        System.out.println(f1.isempty() + f1.toString());
    }
    
}
