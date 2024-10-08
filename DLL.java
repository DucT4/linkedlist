public class DLL {

    private Node head;
    private Node tail;
    private int size;

    public DLL() {
        this.size = 0;
    }

    public void insertDoublyFirst(int val) {
        Node node = new Node(val);
        if (head == null) {
            head = node;
            tail = node;
        } else {
            node.next = head;
            head.prev = node;
            head = node;
            node.prev = null;
        }
        size++;
    }

    public void insertDoublyLast(int val) {
        Node node = new Node(val);
        if (tail == null) {
            head = node;
            tail = node;
        } else {
            tail.next = node;
            node.prev = tail;
            tail = node;
            node.next = null;
        }
        size++;
    }

    public void insertDoubly(int index, int val) {
        if (index == 0) {
            insertDoublyFirst(val);
            return;
        }
        if (index == size) {
            insertDoublyLast(val);
            return;
        }

        Node tmp = head;
        for (int i = 1; i < index; i++) {
            tmp = tmp.next;
        }
        Node node = new Node(val);
        node.next = tmp.next;
        node.prev = tmp;
        tmp.next.prev = node;
        tmp.next = node;
        size++;
    }
    // delete

    public void deleteFirst() {

        if (head == null) {
            return;
        }

        head.next.prev = null;
        head = head.next;
        size--;
    }

    public void deleteLast() {
        if (tail == null) {
            return;
        }

        tail.prev.next = null;
        tail = tail.prev;
        size--;
    }

    public void delete(int index) {

        if (index == 0) {
            deleteFirst();
            return;
        }
        if (index == size) {
            deleteLast();
            return;
        }
        Node tmp = head;
        for (int i = 1; i < index; i++) {
            tmp = tmp.next;
        }

        tmp.next = tmp.next.next;
        if (tmp.next.next != null) {
            tmp.next.next.prev = tmp;
        }

        size--;
    }

    public void display() {
        Node temp = head;
        Node last = null;
        while (temp != null) {
            System.out.print(temp.value + " -> ");
            last = temp;
            temp = temp.next;
        }
        System.out.println("END.");
        System.out.println("Print in reverse");
        while (last != null) {
            System.out.print(last.value + " -> ");
            last = last.prev;
        }
        System.out.println("END.");

    }
    public void Sort() {
        boolean flag;
        if (head == null) {
            return;
        }

        do {
            Node current = head;
            flag = false;
            while (current.next != null) {

                if (current.value > current.next.value) {
                    int temp = current.value;
                    current.value = current.next.value;
                    current.next.value = temp;
                    flag = true;
                }
                current = current.next;
            }
        } while (flag);

    }


    private class Node {
        private int value;
        private Node next;
        private Node prev;

        public Node(int value) {
            this.value = value;
        }

        public Node(int value, Node next, Node prev) {
            this.value = value;
            this.next = next;
            this.prev = prev;
        }
    }
}
