public class main {
    public static void main(String[] args) {
        LL linkedList = new LL();
        DLL List = new DLL();
        // linkedList.insertFirst(0);
        // linkedList.insertFirst(7);
        // linkedList.insertFirst(5);
        // linkedList.insertFirst(9);
        // linkedList.insertLast(11);
        // linkedList.insert(2, 2);
        // linkedList.display();
        // System.out.println(linkedList.deleteFirst());
        // linkedList.display();
        // System.out.println(linkedList.deleteLast());
        // linkedList.display();
        // System.out.println(linkedList.delete(2));
        // linkedList.display();
        // linkedList.deleteValue(2);
        // linkedList.display();
        // linkedList.Sort();
        // linkedList.display();

        List.insertDoublyFirst(0);
        List.insertDoublyFirst(4);
        List.insertDoublyFirst(2);
        List.insertDoublyFirst(3);
        List.insertDoublyLast(11);
        List.insertDoubly(2, 99);

        List.deleteFirst();

        List.delete(2);
        List.display();
     List.Sort();
      List.display();
    }
}
