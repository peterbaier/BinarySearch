package linkedList;


public class MyList {

    private Link head;

    public void add(Link link) {
        Link current = head;
        if (current == null) head = link;
        else {
            while (head.getNext() != null) {
                current = current.getNext();
            }
            current.setNext(link);
        }
    }

    public void addAll(Link[] arg) {
        for (Link piece : arg) {
            add(piece);
        }
    }

    public void remove(Link link) {

    }

    public Link findLink(String name) {
        Link current = head;


        return current;
    }

    public int size() {
        int sum = head == null ? 0 : 1;
        Link current = head;
        while (current.getNext() != null) {
            sum++;
            current = current.getNext();
        }

        return sum;
    }

    public void print() {
        if (head == null) {
            System.out.println("The List is empty!");
            return;
        }
        Link current = head;
        while (current != null) {
            System.out.println("[ " + current.getName() + " , " + current.getAge() + " ]");
            current = current.getNext();
        }

    }
}
