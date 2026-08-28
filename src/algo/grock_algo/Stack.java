package algo.grock_algo;


public class Stack<T> {
    private Node<T> head;

    T push(T toAdd) {
        if (toAdd == null) {
            System.out.println("Fuck you");
        }
        if (head == null) {
            head = new Node<>(toAdd);
        } else {
            Node<T> newHead = new Node<>(toAdd);
            newHead.next = head;
            head = newHead;
        }
        return toAdd;
    }

    T pop() {
        if (head != null) {
            Node<T> next = head.next;
            head = next;
            return head.element;
        } else {
            return null;
        }
    }

    T peek() {
        return this.head.getElement();
    }

    class Node<T> {
        private T element;
        private Node<T> next;

        public Node(T element) {
            this.element = element;
        }

        public Node(T element, Node<T> next) {
            this.element = element;
            this.next = next;
        }

        public T getElement() {
            return element;
        }

        public void setElement(T element) {
            this.element = element;
        }

        public Node<T> getNext() {
            return next;
        }

        public void setNext(Node<T> next) {
            this.next = next;
        }
    }

    public Node<T> getHead() {
        return head;
    }

    public void setHead(Node<T> head) {
        this.head = head;
    }
}
