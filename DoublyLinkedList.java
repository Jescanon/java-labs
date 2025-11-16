public class DoublyLinkedList {

    private static class Node {
        int data;
        Node prev;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    private Node head;
    private Node tail;
    private int size;

    public DoublyLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    public void addFirst(int data) {
        Node newNode = new Node(data);
        if (isEmpty()) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        size++;
    }

    public void addLast(int data) {
        Node newNode = new Node(data);
        if (isEmpty()) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        size++;
    }

    public Integer removeFirst() {
        if (isEmpty()) return null;
        int removed = head.data;
        if (head == tail) {
            head = tail = null;
        } else {
            head = head.next;
            head.prev = null;
        }
        size--;
        return removed;
    }

    public Integer removeLast() {
        if (isEmpty()) return null;
        int removed = tail.data;
        if (head == tail) {
            head = tail = null;
        } else {
            tail = tail.prev;
            tail.next = null;
        }
        size--;
        return removed;
    }

    public boolean contains(int data) {
        Node cur = head;
        while (cur != null) {
            if (cur.data == data) return true;
            cur = cur.next;
        }
        return false;
    }

    public boolean removeByValue(int data) {
        if (isEmpty()) return false;
        if (head.data == data) {
            removeFirst();
            return true;
        }
        Node cur = head.next;
        while (cur != null) {
            if (cur.data == data) {
                if (cur == tail) {
                    removeLast();
                } else {
                    cur.prev.next = cur.next;
                    cur.next.prev = cur.prev;
                    size--;
                }
                return true;
            }
            cur = cur.next;
        }
        return false;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void display() {
        Node cur = head;
        System.out.print("[");
        while (cur != null) {
            System.out.print(cur.data);
            if (cur.next != null) System.out.print(", ");
            cur = cur.next;
        }
        System.out.println("]");
    }

    public void add(int index, int data) {
        if (index < 0 || index > size) throw new IndexOutOfBoundsException();
        if (index == 0) {
            addFirst(data);
            return;
        }
        if (index == size) {
            addLast(data);
            return;
        }
        Node newNode = new Node(data);
        Node cur = getNode(index);
        newNode.prev = cur.prev;
        newNode.next = cur;
        cur.prev.next = newNode;
        cur.prev = newNode;
        size++;
    }

    public int remove(int index) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException();
        if (index == 0) return removeFirst();
        if (index == size - 1) return removeLast();
        Node cur = getNode(index);
        int removed = cur.data;
        cur.prev.next = cur.next;
        cur.next.prev = cur.prev;
        size--;
        return removed;
    }

    public int get(int index) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException();
        return getNode(index).data;
    }

    private Node getNode(int index) {
        Node cur;
        if (index < size / 2) {
            cur = head;
            for (int i = 0; i < index; i++) cur = cur.next;
        } else {
            cur = tail;
            for (int i = size - 1; i > index; i--) cur = cur.prev;
        }
        return cur;
    }

    public void displayReverse() {
        Node cur = tail;
        System.out.print("[");
        while (cur != null) {
            System.out.print(cur.data);
            if (cur.prev != null) System.out.print(", ");
            cur = cur.prev;
        }
        System.out.println("]");
    }

    public int getFirst() {
        if (isEmpty()) throw new IllegalStateException();
        return head.data;
    }

    public int getLast() {
        if (isEmpty()) throw new IllegalStateException();
        return tail.data;
    }

    public static void main(String[] args) {
        DoublyLinkedList list = new DoublyLinkedList();
        list.addLast(10);
        list.addFirst(5);
        list.addLast(20);
        list.display();

        list.add(1, 99);
        list.display();

        list.displayReverse();

        System.out.println(list.get(2));

        list.remove(1);
        list.display();

        System.out.println(list.getFirst());
        System.out.println(list.getLast());
    }
}
