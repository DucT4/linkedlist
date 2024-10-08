/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Admin
 */
public class LL {
    private Node head;
    private Node tail;
    private int size;

    public LL() {
        this.size = 0;
    }

    public void insertFirst(int val) {
        Node node = new Node(val);
        node.next = head;
        head = node;
        if (tail == null) {
            tail = head;
        }
        size += 1;
    }

    public void insertLast(int val) {
        Node node = new Node(val);
        tail.next = node;
        tail = node;
        if (head == null) {
            head = tail;
        }
        node.next = null;
        size += 1;
    }
    // public void doubleSort() {
    // if (head == null) {
    // return;
    // }
    // boolean swapped;
    // do {
    // swapped = false;
    // Node current = head;
    // while (current.next != null) {
    // if (current.value > current.next.value) {
    // int temp = current.value;
    // current.value = current.next.value;
    // current.next.value = temp;
    // swapped = true;
    // }
    // current = current.next;
    // }
    // } while (swapped);
    // }

    public void insert(int val, int index) {
        if (index == 0) {
            insertFirst(val);
            return;
        }
        if (index == size) {
            insertLast(val);
            return;
        }

        Node temp = head;
        for (int i = 1; i < index; i++) {
            temp = temp.next;
        }

        Node node = new Node(val, temp.next);
        temp.next = node;

        size++;
    }

    // xóa
    public int deleteFirst() {
        int val = head.value;
        head = head.next;
        if (head == null) {
            tail = null;
        }
        size--;
        return val;
    }

    public int deleteLast() {
        int val = tail.value;
        Node secondLast = get(size - 2);
        tail = secondLast;
        tail.next = null;
        return val;
    }
    // delete theo gia tri

    public void deleteValue(int value) {
        Node prev = find(value);
        prev.next = prev.next.next;
        size--;
    }

    // lay gia tri value
    public Node find(int value) {
        Node node = head;
        while (node.next != null) {
            if (node.next.value == value) {
                // node = node.next;
                return node;
            }
            node = node.next;
        }
        return null;
    }

    public int delete(int index) {
        if (index == 0) {
            return deleteFirst();

        }
        if (index == size) {
            return deleteLast();
        }
        Node prev = get(index - 1);
        prev.next = prev.next.next;
        int val = prev.next.value;
        return val;
    }

    public Node get(int index) {
        Node node = head;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node;
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

    public void display() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.value + " -> ");
            temp = temp.next;
        }
        System.out.println("END.");
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
        for (int i = 1; i < index - 1; i++) {
            tmp = tmp.next;
        }
        Node node = new Node(val);
        node.next = tmp.next;
        node.prev = tmp;
        tmp.next.prev = node;
        tmp.next = node;
        size++;
    }

    private class Node {
        private int value;
        private Node next;
        private Node prev;

        public Node(int value) {
            this.value = value;
        }

        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }

        public Node(int value, Node next, Node prev) {
            this.value = value;
            this.next = next;
            this.prev = prev;
        }
    }

}
