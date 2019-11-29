// Ryan Draper, TTh 4-5pm
package naturalmergesort;

import java.util.*;

public class NaturalMergesort {

    private Node first;
    private int N;

    private class Node {
        int item;
        Node next;
        public String toString() {
            return Integer.toString(item);
        }
        public int compareTo(Node n) {
            return ((Integer)item).compareTo(((Integer)n.item));
        }
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    public Node getFirst() {
        return first;
    }

    public void setFirst(Node node) {
        first = node;
    }

    public void add(int item) {
        Node oldfirst = first;
        first = new Node();
        first.item = item;
        first.next = oldfirst;
        N++;
    }

    public Node sort() {
        return sort(first);
    }

    public Node sort(Node node) {
        if (node == null || node.next == null)
            return node;
        Node mid = getEdge(node);
        Node half = mid.next;
        mid.next = null;
        return merge(sort(node), sort(half));
    }

    public Node merge(Node one, Node two) {
        Node current;
        Node temp;
        temp = new Node();
        current = temp;
        while (one != null && two != null) {
            if (one.item < two.item) {
                current.next = one;
                one = one.next;
            } else {
                current.next = two;
                two = two.next;
            }
            current = current.next;
        }
        if (one == null)
            current.next = two;
        else
            current.next = one;
        return temp.next;
    }

    public Node getEdge(Node n) {
        if (n == null)
            return n;
        Node edge = n;
        // exploiting exisiting order
        while(edge.next.next != null && edge.compareTo(edge.next) < 0)
            edge = edge.next;
        return edge;
    }

    public void print() {
        Node current = first;
        while (current.next != null) {
            System.out.println(current);
            current = current.next;
        }
    }
}

/*
SAMPLE OUTPUT:

Enter size N: 
10

Unsorted: 
49
92
35
46
89
25
80
76
48

Sorted: 
25
35
46
48
49
75
76
80
89
 */
