import java.util.Scanner;



class Node
{
    private String value;
    private Node next;
    private Node previous;



    public Node()
    {
    }



    public Node(String inValue)
    {
        this.value = inValue;
    }



    String getValue()
    {
        return value;
    }



    void setValue(String inValue)
    {
        this.value = inValue;
    }



    Node getPrevious()
    {
        return previous;
    }



    Node getNext()
    {
        return next;
    }



    void setPrevious(Node inNode)
    {
        previous = inNode;
    }



    void setNext(Node inNode)
    {
        next = inNode;
    }
}






class Doubly
{
    private Node head = null;
    private Node tail = null;



    public Doubly()
    {
    }



    void add(String inValue)
    {
        Node newNode = new Node(inValue);

        if (head == null)
        {
            head = newNode;
            tail = newNode;
        }

        else
        {
            // If newNode comes before head
            if (newNode.getValue().compareTo(head.getValue()) < 0)
            {
                newNode.setNext(head);
                newNode.setPrevious(null);
                head.setPrevious(newNode);
                head = newNode;
            }

            // If newNode comes after tail
            else if (newNode.getValue().compareTo(tail.getValue()) > 0)
            {
                newNode.setNext(null);
                newNode.setPrevious(tail);
                tail.setNext(newNode);
                tail = newNode;
            }

            // If newNode is somewhere in the middle
            else
            {
                for (Node current = head; current != null; current = current.getNext())
                {
                    // If the name is already present in the list, ignore it
                    if (current.getValue().equals(newNode.getValue()))
                    {
                        break;
                    }

                    if (newNode.getValue().compareTo(current.getValue()) > 0 &&
                            newNode.getValue().compareTo(current.getNext().getValue()) < 0)
                    {
                        Node temp = current.getNext();

                        current.setNext(newNode);
                        newNode.setPrevious(current);
                        newNode.setNext(temp);
                        temp.setPrevious(newNode);

                        break;
                    }

                }
            }
        }
    }



    void traverse()
    {
        for (Node current = head; current != null; current = current.getNext())
        {
            System.out.println(current.getValue());
        }

        System.out.println();
    }
}






public class Main
{

    public static void main(String[] args)
    {
        Doubly list = new Doubly();

        list.add("Banana");

        list.traverse();

        list.add("Durian");

        list.traverse();

        list.add("Apple");

        list.traverse();

        list.add("Fig");

        list.traverse();

        list.add("Cherry");

        list.traverse();

        list.add("Elderberry");

        list.traverse();
    }
}
