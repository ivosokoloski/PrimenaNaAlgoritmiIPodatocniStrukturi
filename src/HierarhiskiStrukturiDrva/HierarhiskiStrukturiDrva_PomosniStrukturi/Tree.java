package HierarhiskiStrukturiDrva.HierarhiskiStrukturiDrva_PomosniStrukturi;

import java.util.Iterator;

public interface Tree<E> {
    // //////////Accessors ////////////

    public Node<E> root();

    public Node<E> parent(Node<E> node);

    public int childCount(Node<E> node);

    // //////////Transformers ////////////
    public void makeRoot(E elem);

    public Node<E> addChild(Node<E> node, E elem);

    public void remove(Node<E> node);

    // //////////Iterators ////////////
    public Iterator<E> children(Node<E> node);

    public Iterable<Node<E>> childrenNodes(Node<E> node);

    // //////Inner interface for tree nodes ////////
    public interface Node<E> {

        public E getElement();

        public void setElement(E elem);

    }
}
