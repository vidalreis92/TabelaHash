package linked_link;

public class SimpleLinkedList<T> {

    private BST<T> binarySearchTree;
    private int size;

    public SimpleLinkedList() {
        this.binarySearchTree = new BST<T>();
        this.size = 0;
    }

    public void insert(T value, int index) throws IndexOutOfBoundsException {
        if (index < 0 || index > this.size) {
            throw new IndexOutOfBoundsException("");
        }
        binarySearchTree.insert(value);
        this.size++;
    }

    public T get(int index) throws IndexOutOfBoundsException {
        if (index < 0 || index >= this.size) {
            throw new IndexOutOfBoundsException("");
        }
        return binarySearchTree.find(index);
    }

    @Override
    public String toString() {
        return binarySearchTree.toString();
    }

    public static void main(String[] args) {
        SimpleLinkedList<String> sll = new SimpleLinkedList<String>();
        sll.insert("aa", 0);
        sll.insert("bb", 0);
        sll.insert("cc", 2);
        sll.insert("dd", 1);
        System.out.println(sll.toString());

        System.out.println(sll.get(0));
        System.out.println(sll.get(1));
        System.out.println(sll.get(2));
        System.out.println(sll.get(3));
        System.out.println(sll.get(4));
    }
}
