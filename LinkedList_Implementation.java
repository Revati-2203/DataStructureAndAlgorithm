class MyLinkedList {
    
    private static class Node{
        int val;
        Node next;
        public Node(int val){
            this.val = val;
        }
    }
    
    Node head = null;
    Node tail = null;
    int current_size = 0;


    public MyLinkedList() {
        
    }
    
    public int get(int index) {
        if(index<0 || index>current_size)
            return -1;

        Node temp = head;    
        int counter=1;
        while(temp!=null && counter<index){
            temp=temp.next;
            counter++;
        }
        return temp.val;
    }
    
    public void addAtHead(int val) {
        Node newHead = new node(val);
        newHead.next=head;
        head=newHead;
        if(current_size==0){
            tail=newHead;
        }
        current_size++;
    }
    
    public void addAtTail(int val) {
        Node temp=head;
        while(temp.next!=null){
            temp=temp.next;
        }
        temp.next = new Node(val);
        tail=temp.next;
        current_size++;
    }
    
    public void addAtIndex(int index, int val) {
        
    }
    
    public void deleteAtIndex(int index) {
        
    }
}

/**
 * Your MyLinkedList object wiclass MyLinkedList {

    private static class Node{
        int val;
        Node next;
        public Node(int val){
            this.val = val;
        }
    }

    Node head = null;
    Node tail = null;
    int current_size = 0;

    public MyLinkedList() {
        
    }

    public int get(int index) {
        if(index < 0 || index >= current_size)
            return -1;

        Node temp = head;    
        for(int i = 0; i < index; i++){
            if(temp == null)
                return -1;
            temp = temp.next;
        }
        return temp.val;
    }

    public void addAtHead(int val) {
        Node newHead = new Node(val);
        newHead.next = head;
        head = newHead;
        if(current_size == 0){
            tail = newHead;
        }
        current_size++;
    }

    public void addAtTail(int val) {
        Node newNode = new Node(val);
        if(current_size == 0){
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        current_size++;
    }

    public void addAtIndex(int index, int val) {
        if(index < 0 || index > current_size)
            return;

        if(index == 0){
            addAtHead(val);
        } else if(index == current_size){
            addAtTail(val);
        } else {
            Node newNode = new Node(val);
            Node temp = head;
            for(int i = 0; i < index - 1; i++){
                temp = temp.next;
            }
            newNode.next = temp.next;
            temp.next = newNode;
            current_size++;
        }
    }

    public void deleteAtIndex(int index) {
        if(index < 0 || index >= current_size)
            return;

        if(index == 0){
            head = head.next;
            if(current_size == 1){
                tail = null;
            }
        } else {
            Node temp = head;
            for(int i = 0; i < index - 1; i++){
                temp = temp.next;
            }
            if(temp.next == tail){
                tail = temp;
            }
            temp.next = temp.next.next;
        }
        current_size--;
    }
}ll be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */