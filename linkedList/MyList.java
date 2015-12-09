package linkedList;

/**
 * Created by Lion on 09/12/2015.
 */
public class MyList {

    Link head;

    public void add(Link link){
        Link current = head;
        if(current == null) head = link;
        else{
            while(head.getNext() != null){
                current = current.getNext();
            }
            current.setNext(link);
        }
    }

    public void addAll(Link[] arg){
        for(Link piece : arg){
            add(piece);
        }
    }

    public void remove(Link link){

    }

    public void findLink(String name){

    }

    public int size(){
        int sum = head == null ? 0 : 1;
        Link current = head;
        while (current.getNext() != null){
            sum++;
            current = current.getNext();
        }

        return sum;
    }
}
