package doublyLinkedList;

import java.util.*;

public class CustomDoublyLinkedList<T> {
    private Node<T> first;
    private Node<T> last;
    private int size = 0;

//    Map to maintain record of all the indices of an element in the linked list to provide access to it in O(1);
//    Map<Object, ArrayList<Integer>> indexMap = new HashMap<>();

    public int getSize() {
        return size;
    }

    public void addAtFirst(T element) {
        Node<T> node = new Node<>(element);
        if (first == null) {
            first = node;
            last = node;
            size = 1;

//            indexMap.put(node.data, new ArrayList<>() {{
//                add(0);
//            }});

        } else {
            node.next = first;
            first.previous = node;
            first = node;
            size++;

//            if (indexMap.containsKey(node.data)) {
//                ArrayList<Integer> temp = new ArrayList<>();
//                temp.add(0);
//                if (indexMap.containsKey(node.data)) {
//                    ArrayList<Integer> indexes = indexMap.get(node.data);
//                    for (int i = 0; i < indexes.size(); i++) {
//                        temp.add(indexes.get(i) + 1);
//                    }
//                }
//                indexMap.put(node.data, temp);
//            }
        }
    }

    public void addAtLast(T element) {
        Node<T> node = new Node<>(element);
        if (last == null) {
            first = node;
            last = node;
            size = 1;

//            indexMap.put(node.data, new ArrayList<>() {{
//                add(0);
//            }});

        } else {
            node.previous = last;
            last.next = node;
            last = node;

//            if (indexMap.containsKey(node.data)) indexMap.get(node.data).add(size);
//            else indexMap.put(node.data, new ArrayList<>() {{
//                add(0);
//            }});

            size++;
        }
    }

    public void addAtIndex(int index, T element) {
        Node<T> node = new Node<>(element);
        if (index < size && index >= 0) {
            if(index == size-1) {
                addAtLast(element);
                return;
            }
            if (index == 0) {
                addAtFirst(element);
                return;
            }

            Node ptr = nodeAt(index);
            node.next = ptr.next;
            node.previous = ptr;
            ptr.next.previous = node;
            ptr.next = node;

//            if (indexMap.containsKey(node.data)) {
//                ArrayList<Integer> indexes = indexMap.get(node.data);
//                ArrayList<Integer> temp = new ArrayList<>();
//                for (int i = 0; i <= indexes.size(); i++) {
//                    if (i<indexes.size() && indexes.get(i) < index)
//                        temp.add(indexes.get(i));
//                    else if (i == index)
//                        temp.add(index);
//                    else {
//                        temp.add(indexes.get(i - 1) + 1);
//                    }
//                }
//                indexMap.put(node.data, temp);
//            } else {
//                indexMap.put(node.data, new ArrayList<>() {{
//                    add(index);
//                }});
//            }

            size++;
        } else throw new IndexOutOfBoundsException(index);
    }

    public T removeFirst() {
        if (size > 0) {
            if (last == first) last = null;
            Node<T> temp = first;
            first = first.next;
            if (first != null) {
                first.previous.next = null;
                first.previous = null;
            }

//            indexMap.get(temp.data).remove(0);
//            removeMapEntry(temp);

            size--;
            return temp.data;
        } else throw new NullPointerException("No nodes present in the list to remove.");
    }

    public T removeLast() {
        if (size > 0) {
            if (last == first) first = null;
            Node<T> temp = last;
            last = last.previous;
            if (last != null) {
                last.next.previous = null;
                last.next = null;
            }

//            indexMap.get(temp.data).remove(indexMap.get(temp.data).size()-1);
//            removeMapEntry(temp);

            size--;
            return temp.data;
        } else throw new NullPointerException("No nodes present in the list to remove.");
    }

    public T removeAtIndex(int index) {
        if (index < size && index >= 0) {
            if(index == size-1) return removeLast();
            if (index == 0) return removeFirst();

            Node<T> ptr = nodeAt(index);

            if (ptr.next != null) ptr.next.previous = ptr.previous;
            if (ptr.previous != null) ptr.previous.next = ptr.next;
            ptr.next = null;
            ptr.previous = null;

//            indexMap.get(ptr.data).remove(Integer.valueOf(index));
//            removeMapEntry(ptr);

            size--;
            return ptr.data;
        } else throw new IndexOutOfBoundsException(index);
    }

//    private void removeMapEntry(Node node) {
//        if (indexMap.get(node.data).size() == 0) indexMap.remove(node.data);
//    }

    public int firstIndexOf(T element) {
        int index = -1;
        for(Node x = first; x != null; x = x.next){
            index++;
            if(x.data == element) return index;
        }
        return -1;
    }

    public int lastIndexOf(T element) {
        int index = size;
        for(Node x = last; x != null; x = x.previous){
            index--;
            if(x.data == element) return index;
        }
        return -1;
    }

    public List<Integer> allIndicesOf(T element) {
        List<Integer> indices = new ArrayList<>();
        int index = -1;
        for(Node x = first; x != null; x = x.next){
            index++;
            if(x.data == element) indices.add(index);
        }
        return indices;
    }

    public void printAllElements(){
        for(Node x = first; x != null; x = x.next){
            System.out.print(x.data+" ");
        }
    }

    public void printAllElementsInReverse(){
        for(Node x = last; x != null; x = x.previous){
            System.out.print(x.data+" ");
        }
    }

    private Node<T> nodeAt(int index) {
        if (index < (size >> 1)) {
            Node<T> x = first;
            for (int i = 0; i < index; i++)
                x = x.next;
            return x;
        } else {
            Node<T> x = last;
            for (int i = size - 1; i > index; i--)
                x = x.previous;
            return x;
        }
    }

    public T elementAt(int index){
        if (index < size && index >= 0)
            return nodeAt(index).data;
        else throw new IndexOutOfBoundsException(index);
    }
}
