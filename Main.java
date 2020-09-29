import java.io.File;
import java.io.FileNotFoundException;
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



    void delete(String target)
    {
        // If head Node is to be deleted
        if (head.getValue().equals(target))
        {
            Node newHead = head.getNext();
            newHead.setPrevious(null);
            head.setNext(null);
            head = newHead;
        }

        // If tail Node is to be deleted
        else if (tail.getValue().equals(target))
        {
            Node newTail = tail.getPrevious();
            newTail.setNext(null);
            tail.setPrevious(null);
            tail = newTail;
        }

        else
        {
            for (Node current = head; current != null; current = current.getNext())
            {
                if (current.getValue().equals(target))
                {
                    current.getPrevious().setNext(current.getNext());
                    current.getNext().setPrevious(current.getPrevious());

                    current.setPrevious(null);
                    current.setNext(null);
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
    static Doubly readFile(String fileName)
    {
        Doubly names = new Doubly();

        Scanner fileReader = null;

        try
        {
            fileReader = new Scanner(new File(fileName));
        }

        catch (FileNotFoundException fileError)
        {
            System.out.println(String.format("There was a problem opening file \"%s\": \n\tError = %s", fileName, fileError.getMessage()));

            System.out.println("Exiting program...");

            System.exit(1);
        }

        while (fileReader.hasNextLine())
        {
            String currentName = fileReader.next().trim();

            names.add(currentName);
        }

        return names;
    }



    public static void main(String[] args)
    {
        String file = "/home/izzy/IdeaProjects/DoublyLinkedList/src/input.txt";

        Doubly list = readFile(file);

        list.traverse();
    }
}
