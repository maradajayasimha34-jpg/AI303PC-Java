import java.util.*;
// Problem: Simulate FIFO customers and emergency-priority patients.
public class AssignmentB2 {
 static class Patient {
 String name; int emergencyLevel;
 Patient(String n,int e){name=n;emergencyLevel=e;}
 public String toString(){return name+"-"+emergencyLevel;}
 }
 public static void main(String[] args) {
 Queue<String> q=new ArrayDeque<>();
 q.offer("Ravi"); q.offer("Sita"); q.offer("Anil");
 System.out.println("Next: "+q.peek());
 while(!q.isEmpty())
 {
 System.out.println("Serving "+q.poll()+"; remaining "+q);
 }
 String empty=q.poll(); // null when empty, no exception
 System.out.println("Empty poll: "+empty);
 Queue<Patient> pq=new PriorityQueue<>(Comparator.comparingInt((Patient p)->p.emergencyLevel).reversed());
 pq.offer(new Patient("Charan",1));
 pq.offer(new Patient("Bala",2));
 pq.offer(new Patient("Amit",3));
 System.out.print("Priority service: ");
 while(!pq.isEmpty())
 System.out.print(pq.poll()+" ");
 Queue<String> linked=new LinkedList<>(); 
linked.offer("Ravi");
 linked.offer("Sita");
 System.out.println("\nLinkedList FIFO first: "+linked.poll());
 System.out.println("Deque operations: ArrayDeque provides efficient operations at both ends; LinkedList also implements Deque.");
 System.out.println("Final sizes: FIFO="+q.size()+", priority="+pq.size());
 }
}

//Output:-
 Next: Ravi
Serving Ravi; remaining [Sita, Anil]
Serving Sita; remaining [Anil]
Serving Anil; remaining []
Empty poll: null
Priority service: Amit-3 Bala-2 Charan-1
LinkedList FIFO first: Ravi
Deque operations: ArrayDeque provides efficient operations at both ends; LinkedList also implements Deque.
Final sizes: FIFO=0, priority=0
