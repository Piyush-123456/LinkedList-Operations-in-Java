public class Address {
    public static Node head;
    public static Node tail;
    public static int size;

    public static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public void addFirst(int data) {
        Node newNode = new Node(data);
        size++;
        if (head == null) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
    }

    public void addLast(int data) {
        Node newNode = new Node(data);
        size++;
        if (head == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
    }

    public static void print() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + "->");
            temp = temp.next;
        }
        System.out.print("null");
        System.out.println();
    }

    public static int sum() {
        Node temp = head;
        int sum = 0;
        while (temp != null) {
            sum = sum + temp.data;
            temp = temp.next;
        }
        return sum;
    }

    public void midNode(int data, int index) {
        if (index == 0) {
            addFirst(data);
            return;
        }
        Node newNode = new Node(data);
        size++;
        Node temp = head;

        int i = 0;
        while (i < index - 1) {
            temp = temp.next;
            i++;
        }
        newNode.next = temp.next;
        temp.next = newNode;
    }
    
    public static int removeFirst(){
        if(size==0){
            System.out.println("No node to delete");
            return Integer.MIN_VALUE;
        }

        else if(size==1){
            int val = head.data;
            head=tail=null;
            size=0;
            return Integer.MIN_VALUE;
        }

        else{
            int val = head.data;
            head = head.next;
            return val;
        }

    }

    public static int removeLast(){
        if(size==0){
            System.out.println("There's no node to delete");
            return Integer.MIN_VALUE;
        }
        else if(size==1){
            int val = head.data;
            head=tail=null;
            size=0;
            return val;
        }
        int count=countsize();
        Node prev = head;
        for(int i=0;i<count-2;i++){
            prev = prev.next;
        }
        int val = prev.next.data;
        prev.next = null;
        tail = prev;
        return val;
    }

    public static int countsize(){
        Node temp = head;
        int count=0;
        while(temp!=null){
            temp = temp.next;
            count++;
        }
        return count;
    }

    public void reverse(){
        Node prev = null;
        Node curr = head;
        Node next;
        while(curr!=null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head = prev;
    }

    public static int search(int key){
        int index=0;
        Node temp = head;
        while(temp!=null){
            if(temp.data==key){
                return index;
            }
            temp=temp.next;
            index++;
        }   
        return -1;
    }

    public static void removenthNode(int n){
        int sz = countsize();
        if(n==sz){
            head =  head.next;
            return;
        }
        int l = n - sz + 1;
        int i = 0;
        Node prev = head;
        while(i<l-1){
            prev = prev.next;
            i++;
        }
        prev.next = prev.next.next;
    }

    public static void main(String args[]) {
        Address list = new Address();
        list.addFirst(2);
        list.addFirst(1);
        list.addLast(3);
        list.addLast(4);
        list.addLast(5);
        
    }
}