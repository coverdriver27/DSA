public class Node {
  public String data;
  public Node prev;
  public Node next;
  
  public Node(String data){
    this.data = data;
  }
  
  public void display(){
    System.out.println("Data inside node: " + data);
  }
   
  public static void main(String[] args){
    LinkList theLinkList = new LinkList();
    theLinkList.insertAtFront("May");
    theLinkList.insertAt(0, "the");
    theLinkList.insertAt(0, "force");
    theLinkList.insertAt(0, "be");
    theLinkList.insertAt(0, "with");
    theLinkList.insertAtEnd("You");
    
    theLinkList.deleteAtEnd();
    theLinkList.deleteAtFront();
    theLinkList.deleteAt(1);
    
    theLinkList.display();
  }
}