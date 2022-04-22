import doublyLinkedList.CustomDoublyLinkedList;

public class Main {
    private static void printElements(CustomDoublyLinkedList linkedList) {
        System.out.println("Forward->");
        linkedList.printAllElements();
        System.out.println("\nReverse->");
        linkedList.printAllElementsInReverse();
    }
    public static void main(String[] args) {
        CustomDoublyLinkedList<Integer> customDoublyLinkedList = new CustomDoublyLinkedList<>();
        customDoublyLinkedList.addAtFirst(3);
        customDoublyLinkedList.addAtFirst(2);
        customDoublyLinkedList.addAtFirst(3);
        customDoublyLinkedList.addAtLast(1);
        customDoublyLinkedList.addAtLast(5);
        customDoublyLinkedList.addAtIndex(2, 7);

        System.out.println("Original list->");
        printElements(customDoublyLinkedList);

        System.out.println("\n\nRemoving first->");
        customDoublyLinkedList.removeFirst();
        printElements(customDoublyLinkedList);

        System.out.println("\n\nRemoving last->");
        customDoublyLinkedList.removeLast();
        printElements(customDoublyLinkedList);

        System.out.println("\n\nRemoving at index 3->");
        customDoublyLinkedList.removeAtIndex(3);
        printElements(customDoublyLinkedList);

        System.out.println("\n\nRemoving at index 0->");
        customDoublyLinkedList.removeAtIndex(0);
        printElements(customDoublyLinkedList);

        System.out.println("\n\nAdding at index 0->");
        customDoublyLinkedList.addAtFirst(3);
        printElements(customDoublyLinkedList);

        System.out.println("\n");
        System.out.println("First index of 3: "+customDoublyLinkedList.firstIndexOf(3));
        System.out.println("Last index of 3: "+customDoublyLinkedList.lastIndexOf(3));
        System.out.println("All indices of 3: "+customDoublyLinkedList.allIndicesOf(3));
        System.out.println("First index of 5: "+customDoublyLinkedList.firstIndexOf(5));

    }
}
