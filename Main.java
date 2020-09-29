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






public class Main
{

    public static void main(String[] args)
    {
	// write your code here
    }
}
