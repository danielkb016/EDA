package examen;

import java.util.HashMap;
import java.util.Iterator;
import material.Position;
import material.tree.narytree.LinkedTree;

public class QuickTree<E> extends LinkedTree<E> {
	private HashMap<E,Position<E>> mapa = new HashMap<>();
	public QuickTree() {
		super();
	}
	
	@Override
	public Position<E> add(E element, Position<E> p) {
		Position<E> node = super.add(element, p);
		return node;
	}
	
	@Override
	public Position<E> addRoot(E e) {
		Position<E> node = super.addRoot(e);
		return node;
	}
	
	@Override
	public Position<E> add(E element, Position<E> p, int n) {
		Position<E> node = super.add(element, p, n);
		return node;
	}
	
	@Override
	public void remove(Position<E> p) {
		super.remove(p);
	}
	
	public Position<E> search(E element) {
            Iterator<Position<E>> iterator = this.iterator();
            for (Position<E> position : ) {
                
            }
	}
}
