public class Node {
    int data;
    Node next;
    public Node(int data){
        this.data = data;
    }
}

public class LinkedList {
    Node head;

    void addFirst(int data){
        if(head == null) head = new Node(data);
        else{
            Node newNode = new Node(data);
            newNode.next = head;
            head = newNode;
        }
    }

    void addLast(int data){
        if(head == null) head = new Node(data);
        else{
            Node temp = head;
            while(temp.next != null) temp = temp.next;
            temp.next = new Node(data);
        }
    }

    void add(int data, int index){
        if(head == null) head = new Node(data);
        else if(index == 0){
            Node node = new Node(data);
            node.next = head;
            head = node;
        }
        else{
            int count = 0;
            Node previous = head;
            Node current = head;
            while(count != index){
                previous = current;
                current = current.next;
                count++;
            }
            Node node = new Node(data);
            previous.next = node;
            node.next = current;
        }
    }

    void deleteFirst(){
        if(head == null) return;
        if(head.next == null) {
            head = null;
            return;
        }
        Node temp = head;
        head = head.next;
        temp.next = null;
    }

    void deleteLast(){
        if(head == null) return;
        if(head.next == null) {
            head = null;
            return;
        }
        Node temp = head;
        Node tempTwo = head;
        while(temp.next != null) {
            tempTwo = temp;
            temp = temp.next;
        }
        tempTwo.next = null;
    }

    void delete(int index){
        if(head == null) return;
        else if(index == 0){
            head = head.next;
        }
        else{
            int count = 0;
            Node previous = head;
            Node current = head;
            while(count != index){
                previous = current;
                current = current.next;
                count++;
            }
            previous.next = current.next;
        }
    }

    boolean contains(int data){
        if(head == null) return false;
        Node temp = head;
        while(temp != null){
            if(temp.data == data) return true;
            temp = temp.next;
        }
        return false;
    }

    int indexOf(int data){
        if(head == null) return -1;
        Node temp = head;
        int index = 0;
        while(temp!=null){
            if(temp.data == data) return index;
            index++;
            temp = temp.next;
        }
        return -1;
    }

    void reverseList(){
        if(head == null) return;
        Node previous = head;
        Node current = head.next;
        previous.next = null;
        while(current!=null ){
            Node next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        head = previous;
    }

    void deleteDuplicates(){
        if(head == null) return;
        Node current = head;
        Node nextNode = head.next;
        while(nextNode!=null){
            if(current.data == nextNode.data){
                current.next = nextNode.next;
                nextNode = nextNode.next;
            }else{
                current = current.next;
                nextNode = nextNode.next;
            }
        }
    }

    void print(){
        Node temp = head;
        while(temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }
}
