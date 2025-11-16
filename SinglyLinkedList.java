public class SinglyLinkedList {
    private static class Node {
        int data;
        Node next;
        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node head;
    private int size;

    public SinglyLinkedList() {
        head = null;
        size = 0;
    }

    public void addFirst(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
        size++;
    }

    public void addLast(int data) {
        Node newNode = new Node(data);

        if (isEmpty()) {
            head = newNode;
        } else {
            Node cur = head;
            while (cur.next != null) {
                cur = cur.next;
            }
            cur.next = newNode;
        }
        size++;
    }

    public Integer removeFirst() {
        if (isEmpty()) return null;

        int removed = head.data;
        head = head.next;
        size--;
        return removed;
    }

    public Integer removeLast() {
        if (isEmpty()) return null;

        if (head.next == null) {
            int removed = head.data;
            head = null;
            size = 0;
            return removed;
        }

        Node prev = head;
        Node cur = head.next;

        while (cur.next != null) {
            prev = cur;
            cur = cur.next;
        }

        int removed = cur.data;
        prev.next = null;
        size--;
        return removed;
    }

    public boolean remove(int data) {
        if (isEmpty()) return false;

        if (head.data == data) {
            removeFirst();
            return true;
        }

        Node prev = head;
        Node cur = head.next;

        while (cur != null) {
            if (cur.data == data) {
                prev.next = cur.next;
                size--;
                return true;
            }
            prev = cur;
            cur = cur.next;
        }
        return false;
    }

    public boolean contains(int data) {
        Node cur = head;
        while (cur != null) {
            if (cur.data == data) return true;
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
        if (isEmpty()) {
            System.out.println("[]");
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        Node cur = head;
        while (cur != null) {
            sb.append(cur.data);
            if (cur.next != null) sb.append(", ");
            cur = cur.next;
        }
        sb.append("]");
        System.out.println(sb.toString());
    }

    public void clear() {
        head = null;
        size = 0;
    }

    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();
        list.addLast(10);
        list.addFirst(5);
        list.addLast(20);
        list.display();
        System.out.println(list.contains(10));
        System.out.println(list.size());
        list.remove(10);
        list.display();
        list.removeFirst();
        list.display();
        list.removeLast();
        System.out.println(list.isEmpty());
    }
}
