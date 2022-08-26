public class LinkList{
  public Node firstLink;
  public Node currentLink;
  public Node tempLink;
  public Node lastLink;
  public int size = 0;
   
  LinkList(){
    firstLink = null;
    size = 0;
  }
  
  //Insert Link at given Index
  public void insertAt(int index, String data){
    Node newLink = new Node(data);
    currentLink = firstLink;
    if ( index > size){
      System.out.println("You entered an invalid index");
    }
    else {
      for (int i = 0; i <= size; i++){
        if ( i == index ){
          newLink.next = currentLink;
          if ( currentLink != null ){
            newLink.prev = currentLink.prev;
            if ( currentLink.prev != null){
              tempLink = currentLink.prev;
              tempLink.next = newLink;
              
            }
            currentLink.prev = newLink;
          }
          size++;
          if ( index == 0 ){
            firstLink = newLink;
          }
          tempLink = firstLink;
          while ( tempLink != null ){
            lastLink = tempLink;
            tempLink = tempLink.next;
          }
        }
        else {
          if (currentLink != null ){
            currentLink = currentLink.next;
          }  
        }
      }
    }
  }
  
  //Insert Node at the Front of the Linked List
  public void insertAtFront(String data){
   insertAt(0, data);
  }
  
  //Insert Node at the End of the Linked List
  public void insertAtEnd(String data){
   insertAt((size - 1), data);
  }
  
  //Delete Node at given Index
  public void deleteAt(int index){
    currentLink = firstLink;
    if ( index > size){
      System.out.println("You entered an invalid index");
    }
    else {
      for (int i = 0; i <= size; i++){
        if ( i == index ){
          tempLink = currentLink.next;
          if (tempLink != null)tempLink.prev = currentLink.prev;
          tempLink = currentLink.prev;
          if (tempLink != null) tempLink.next = currentLink.next;
          size--;
          if ( index == 0 ){
            firstLink = currentLink.next;
          }
          tempLink = firstLink;
          while ( tempLink != null ){
            lastLink = tempLink;
            tempLink = tempLink.next;
          }
        }
        else {
          if (currentLink != null ){
            currentLink = currentLink.next;
          }  
        }
      }
    }
  }
  
  //Delete Node located at the Front of the Linked List
  public void deleteAtFront(){
    deleteAt(0);
  }
  
  //Delete Node located at the End of the Linked List
  public void deleteAtEnd(){
    deleteAt((size - 1));
  }
  
  //Display all Nodes inside of the Linked List
  public void display(){
    Node displayLink = firstLink;
    while(displayLink != null){
      displayLink.display();
      System.out.println("Next Link: " + displayLink.next);
      displayLink = displayLink.next;
      System.out.println();
    }
  }
}