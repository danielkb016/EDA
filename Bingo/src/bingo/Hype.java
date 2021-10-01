/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bingo;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author jose.velez
 */
class Hype {
    private List<Integer> bombo = new LinkedList();
    private final static int NUMBERS = 90;
    
    public Hype() {
        for (int i = 1; i <=NUMBERS;i++)
            bombo.add(i);
        Collections.shuffle(bombo); //Para "barajar o mezclar" la lista
    }

    boolean hasNumbers() {
        return bombo.isEmpty();
    }

    int getNumber() {
        return bombo.remove(0);
    }
    
}
