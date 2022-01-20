package material.tree.binarysearchtree;

import material.Position;
import material.tree.binarytree.LinkedBinaryTree;

/**
 * LinkedBinarySearchTree that implements the tri-node restructuration
 * @author jvelez
 */
class Reestructurator {
   /**
     * Performs a tri-node restructuring. Assumes the nodes are in one of
     * following configurations:
     *
     * <pre>
     *          z=c       z=c        z=a         z=a
     *         /  \      /  \       /  \        /  \
     *       y=b  t4   y=a  t4    t1  y=c     t1  y=b
     *      /  \      /  \           /  \         /  \
     *    x=a  t3    t1 x=b        x=b  t4       t2 x=c
     *   /  \          /  \       /  \             /  \
     *  t1  t2        t2  t3     t2  t3           t3  t4
     * </pre>
     *
     * @return the new root of the restructured subtree
     */ 
<<<<<<< HEAD
     public Position restructure(Position posNode, LinkedBinaryTree binTree){ //El nodo que pasan es x
        LinkedBinaryTree t1,t2,t3,t4,lowkey,midkey,highkey;
        Position parentNode = binTree.parent(posNode); // Y
        Position grandParent = binTree.parent(parentNode);//Z
        
        Position zParent = binTree.isRoot(grandParent)? null:binTree.parent(grandParent);
        
        boolean leftCase = zParent == null ? false: grandParent == binTree.left(zParent); //Para saber si zParent es hijo izq
        boolean leftParent = ((binTree.hasLeft(grandParent)) && (binTree.left(grandParent) == parentNode)); // Para saber si parentNode es hijo izq
        boolean leftNode = (binTree.hasLeft(parentNode)) && (binTree.left(parentNode) == posNode); //Si posNode es hijo izq
        
        if(leftNode && leftParent){ // Izq Izq
            lowkey = binTree.subTree(posNode);
            midkey = binTree.subTree(parentNode);
            highkey = binTree.subTree(grandParent);
            t1 = lowkey.hasLeft(lowkey.root()) ? lowkey.subTree(lowkey.left(lowkey.root())):null;
            t2 = lowkey.hasRight(lowkey.root()) ? lowkey.subTree(lowkey.right(lowkey.root())): null;
            t3 = midkey.hasRight(midkey.root()) ? midkey.subTree(midkey.right(midkey.root())): null;
            t4 = highkey.hasRight(highkey.root()) ? highkey.subTree(highkey.right(highkey.root())):null;
            
        }else if((!leftNode && !leftParent)){ // Dcha Dcha
        
        }else if(!leftNode && leftParent){ //Izq Dcha
         
        }else{ //Dcha Izq
        }
     return null;
=======
     public Position restructure(Position posNode, LinkedBinaryTree binTree){
         /*
         Primer paso: Identificar cual de las cuatro situaciones es
         Segundo paso: Obtener todos los nodos o subarboles necesarios para la reestructuración
         Tercer paso: Reasignar adecuadamente los nodos
          */
         Position parent = binTree.parent(posNode);
         boolean eshijoIzquierdo = false;
         if(binTree.hasLeft(parent)){
             eshijoIzquierdo = binTree.left(parent) == posNode;
         }
         Position abuelo = binTree.parent(parent);
         boolean padreHijoIzquierdo = ((binTree.hasLeft(abuelo)))&&(binTree.left(abuelo)) == parent;
         boolean esRaizAbuelo = binTree.isRoot(abuelo);
         boolean esAbueloIzquierdo; 
         Position padreAbuelo;
         if(!esRaizAbuelo){
              padreAbuelo = binTree.parent(abuelo);
              esAbueloIzquierdo = (binTree.hasLeft(padreAbuelo))&& (binTree.left(abuelo) == parent);
         }
         
        LinkedBinaryTree t2, t3, a = null, b, c = null;
      
        if(eshijoIzquierdo && padreHijoIzquierdo){ //izq-izq
            t2 = binTree.hasRight(posNode)?binTree.subTree(binTree.right(posNode)): null;
            t3 = binTree.hasRight(parent)?binTree.subTree(binTree.right(parent)): null;
            a = binTree.subTree(posNode);
            b = binTree.subTree(parent);
            c = binTree.subTree(abuelo);
        }else if(!eshijoIzquierdo && padreHijoIzquierdo){//der-izq
           t2 = binTree.hasLeft(posNode)?binTree.subTree(binTree.left(posNode)): null;
           t3 = binTree.hasRight(posNode)?binTree.subTree(binTree.right(posNode)): null;
           b = binTree.subTree(posNode); 
           a = binTree.subTree(parent);
           c = binTree.subTree(abuelo);
        }else if(eshijoIzquierdo && !padreHijoIzquierdo){//izq-der
           t2 = binTree.hasLeft(posNode)?binTree.subTree(binTree.left(posNode)): null;
           t3 = binTree.hasRight(posNode)?binTree.subTree(binTree.right(posNode)): null;
           b = binTree.subTree(posNode); 
           c = binTree.subTree(parent);
           a = binTree.subTree(abuelo);
        
        }else{//der-der
           t2 = binTree.hasLeft(parent)?binTree.subTree(binTree.left(parent)): null;
           t3 = binTree.hasLeft(posNode)?binTree.subTree(binTree.left(posNode)): null;
           
        }
        if(t2 != null) 
            a.attachRight(a.root(), t2);
         c.attachLeft(c.root(), t3);
         return null;
              
         
         
>>>>>>> origin/main
     }
}
