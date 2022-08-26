public class CircLinkList {

  public int size =0;
  public CircNode head=null;
  public CircNode tail=null;
  static long startTime;
  static long endTime;
  
  public void display(){
    CircNode temp = head;
    System.out.println("Contents of Link List: ");
    for ( int i = 0; i < size; i++ ){
      temp.display();
      temp = temp.next;
    }
    System.out.println("");
  }

  //add a new node to the start of the circular linked list
  public void insertAtFront(int data){
    CircNode newLink = new CircNode(data);
      if(size==0){
        head = newLink;
        tail = newLink;
        newLink.next = head;
      }
      else{
        CircNode temp = head;
        newLink.next = temp;
        head = newLink;
        tail.next = head;
      }
      size++;
  }
  
  //delete a node from the start of the circular linked list
  public void deleteAtFront(){
    if(size==0){
      System.out.println("\nList is Empty");
    }
    else{
      head = head.next;
      tail.next=head;
      size--;
    }
  }
    
  public static void main(String[] args) {
    CircLinkList cLinkList = new CircLinkList();
    startTime = System.currentTimeMillis();
    for ( int i = 0; i < 100; i++){
      cLinkList.insertAtFront(i);
    }
    endTime = System.currentTimeMillis();
    cLinkList.display();
    System.out.print("Add 100 nodes time: " + (endTime - startTime));
    System.out.println(" milliseconds");
    System.out.println();
    startTime = System.currentTimeMillis();
    for ( int i = 0; i < 100; i++){
      cLinkList.deleteAtFront();
    }
    endTime = System.currentTimeMillis();
    cLinkList.display();
    System.out.print("Delete 100 nodes time: " + (endTime - startTime));
    System.out.println(" milliseconds");
    System.out.println();
    startTime = System.currentTimeMillis();
    for ( int i = 0; i < 1000; i++){
      cLinkList.insertAtFront(i);
    }
    endTime = System.currentTimeMillis();
    cLinkList.display();
    System.out.print("Add 1000 nodes time: " + (endTime - startTime));
    System.out.println(" milliseconds");
    System.out.println();
    startTime = System.currentTimeMillis();
    for ( int i = 0; i < 1000; i++){
      cLinkList.deleteAtFront();
    }
    endTime = System.currentTimeMillis();
    cLinkList.display();
    System.out.print("Delete 1000 nodes time: " + (endTime - startTime));
    System.out.println(" milliseconds");
    System.out.println();
    startTime = System.currentTimeMillis();
    for ( int i = 0; i < 10000; i++){
      cLinkList.insertAtFront(i);
    }
    endTime = System.currentTimeMillis();
    cLinkList.display();
    System.out.print("Add 10000 nodes time: " + (endTime - startTime));
    System.out.println(" milliseconds");
    System.out.println();
    startTime = System.currentTimeMillis();
    for ( int i = 0; i < 10000; i++){
      cLinkList.deleteAtFront();
    }
    endTime = System.currentTimeMillis();
    cLinkList.display();
    System.out.print("Delete 10000 nodes time: " + (endTime - startTime));
    System.out.println(" milliseconds");
    System.out.println();
    startTime = System.currentTimeMillis();
    for ( int i = 0; i < 100000; i++){
      cLinkList.insertAtFront(i);
    }
    endTime = System.currentTimeMillis();
    cLinkList.display();
    System.out.print("Add 100000 nodes time: " + (endTime - startTime));
    System.out.println(" milliseconds");
    System.out.println();
    startTime = System.currentTimeMillis();
    for ( int i = 0; i < 100000; i++){
      cLinkList.deleteAtFront();
    }
    endTime = System.currentTimeMillis();
    cLinkList.display();
    System.out.print("Delete 100000 nodes time: " + (endTime - startTime));
    System.out.println(" milliseconds");
        
  }

}