package deque;



/**
 * @author Sen Yan
 * @create 2021-04-11-13:48
 */
public class LinkedListDeque {
    private class Node{
        private Node pre;
        private int item;
        private Node next;

        public Node(Node pre, int item, Node next){
            this.pre = pre;
            this.item = item;
            this.next = next;
        }
    }

    private Node sentF;
    private int size;
    private Node sentB;

    public LinkedListDeque(){
        sentF = new Node(null, 63, null);
        sentB = new Node(null, 63, null);
        sentF.next = sentB;
        sentB.pre = sentF;
        size = 0;
    }

    public void addFirst(int item){
        size += 1;
        Node newNode = new Node(null, item,null);
        Node oldNode = sentF.next;
        oldNode.pre = newNode;
        newNode.pre = sentF;
        newNode.next = oldNode;
        sentF.next = newNode;
    }

    public void addLast(int item){
        size += 1;
        Node newNode = new Node(null, item, null);
        Node oldNode = sentB.pre;
        oldNode.next = newNode;
        newNode.next = sentB;
        newNode.pre = oldNode;
        sentB.pre = newNode;
    }

    public boolean isEmpty(){
        return sentF.next == sentB;
    }

    public int size(){
        return size;
    }

    public void printDeque(){
        Node p = this.sentF;
        while(p.next != sentB){
            System.out.print(p.next.item + " ");
            p = p.next;
        }
        System.out.println();
    }

    public Integer removeFirst(){
        size -= 1;
        if(sentF.next == sentB){
            return null;
        }else{
            Integer result =  sentF.next.item;
            sentF.next = sentF.next.next;
            sentF.next.pre = sentF;
            return  result;
        }
    }

    public Integer removeLast(){
        size -= 1;
        if(sentB.pre == sentF){
            return null;
        }else{
            Integer result = sentB.pre.item;
            sentB.pre = sentB.pre.pre;
            sentB.pre.next = sentB;
            return result;
        }
    }

    public Integer get(int index){
        Node p = sentF.next;
        while (index > 0){
            p = p.next;
            index -= 1;
        }
        return p.item;
    }

    public LinkedListDeque(LinkedListDeque other){
        int sizeOther = other.size();
        size = sizeOther;
        sentF = new Node(null, 63, null);
        sentB = new Node(null, 63, null);
        sentF.next = sentB;
        sentB.pre = sentF;
        while(sizeOther > 0){
            Integer temp = other.get(sizeOther - 1);
            Node newNode = new Node(null, temp,null);
            Node oldNode = sentF.next;
            oldNode.pre = newNode;
            newNode.pre = sentF;
            newNode.next = oldNode;
            sentF.next = newNode;
            sizeOther -= 1;
        }
    }



    public static void main(String[] args) {
        LinkedListDeque deque = new LinkedListDeque();
        System.out.println(deque.isEmpty());
        deque.addFirst(5);
        deque.addFirst(10);
        deque.addFirst(15);
        deque.addFirst(20);
        deque.addLast(25);
        deque.removeLast();
        System.out.println("size:"+deque.size());
        deque.printDeque();
        System.out.println("first item:"+deque.get(0));
        System.out.println("second item:"+deque.get(1));

        LinkedListDeque listDeque = new LinkedListDeque(deque);
        listDeque.printDeque();
    }

}
