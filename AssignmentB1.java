import java.util.*;
// Problem: Manage products using List and compare ArrayList with LinkedList
public class AssignmentB1 {
 static class Product implements Comparable<Product> {
 int id, quantity; String name; double price;
 Product(int id, String name, double price, int quantity) {
 this.id=id;
 this.name=name;
 this.price=price; 
 this.quantity=quantity;
 }
 public int compareTo(Product p) { 
return name.compareToIgnoreCase(p.name); 
}
 public boolean equals(Object o) {
 return o instanceof Product && id==((Product)o).id;
 }
 public int hashCode() { 
 return Integer.hashCode(id);
 }
 public String toString() { 
return name+":"+price+"(qty="+quantity+")"; 
 }
}
 static void show(String label, List<Product> xs) { 
System.out.println(label+xs);
 }
 public static void main(String[] args) {
 List<Product> a = new ArrayList<>(Arrays.asList(
 new Product(1,"Keyboard",499,4), new Product(2,"Mouse",299,5),
 new Product(3,"Monitor",7999,2), new Product(4,"Cable",99,0),
 new Product(5,"Speaker",1299,3), new Product(6,"Webcam",1899,1)));

 a.add(1,new Product(7,"Wireless Mouse",599,2)); // second position
 for(Product p:a) if(p.id==2) p.price=349; // update by id
 int removed=0;
 for(Iterator<Product> it=a.iterator();it.hasNext();)
 if(it.next().quantity==0){
it.remove();removed++;
}
 System.out.println("Removed zero-quantity products: "+removed);
 Product key=new Product(7,"Wireless Mouse",599,2);
 int foundIndex=a.indexOf(key);
 Product found=foundIndex>=0?a.get(foundIndex):null;
 System.out.println("contains search key: "+a.contains(key));
 System.out.println("Search: "+found);
 a.sort(Comparator.comparingDouble(p->p.price));
 show("Price ascending: ",a);
 Collections.sort(a); show("Name ascending: ",a);
 System.out.print("Iterator: ");
 for(Iterator<Product> it=a.iterator();it.hasNext();)
 System.out.print(it.next()+" ");
 System.out.println(); 
for(Product p:a) System.out.println("For-each: "+p);
 a.forEach(p->System.out.println("Lambda: "+p));
 Object[] arr=a.toArray();
 System.out.println("Array: "+Arrays.toString(arr));
 List<Product> linked=new LinkedList<>(a);
 linked.sort(Comparator.comparingDouble(p->p.price));
 Collections.sort(linked);
 for(Iterator<Product> it=linked.iterator();it.hasNext();)
 System.out.println("LinkedList iterator: "+it.next());
 Object[] linkedArray=linked.toArray(); 
show("LinkedList copy: ",linked);
 System.out.println("LinkedList array length: "+linkedArray.length);
 System.out.println("ArrayList offers fast indexed reads; LinkedList has efficient end operations but more node overhead.");
 }
}

//Output:-
 Removed zero-quantity products: 1
contains search key: true
Search: Wireless Mouse:599.0(qty=2)
Price ascending: [Mouse:349.0(qty=5), Keyboard:499.0(qty=4), Wireless Mouse:599.0(qty=2), Speaker:1299.0(qty=3), Webcam:1899.0(qty=1), Monitor:7999.0(qty=2)]
Name ascending: [Keyboard:499.0(qty=4), Monitor:7999.0(qty=2), Mouse:349.0(qty=5), Speaker:1299.0(qty=3), Webcam:1899.0(qty=1), Wireless Mouse:599.0(qty=2)]
Iterator: Keyboard:499.0(qty=4) Monitor:7999.0(qty=2) Mouse:349.0(qty=5) Speaker:1299.0(qty=3) Webcam:1899.0(qty=1) Wireless Mouse:599.0(qty=2)
For-each: Keyboard:499.0(qty=4)
For-each: Monitor:7999.0(qty=2)
For-each: Mouse:349.0(qty=5)
For-each: Speaker:1299.0(qty=3)
For-each: Webcam:1899.0(qty=1)
For-each: Wireless Mouse:599.0(qty=2)
Lambda: Keyboard:499.0(qty=4)
Lambda: Monitor:7999.0(qty=2)
Lambda: Mouse:349.0(qty=5)
Lambda: Speaker:1299.0(qty=3)
Lambda: Webcam:1899.0(qty=1)
Lambda: Wireless Mouse:599.0(qty=2)
Array: [Keyboard:499.0(qty=4), Monitor:7999.0(qty=2), Mouse:349.0(qty=5), Speaker:1299.0(qty=3), Webcam:1899.0(qty=1), Wireless Mouse:599.0(qty=2)]
LinkedList iterator: Keyboard:499.0(qty=4)
LinkedList iterator: Monitor:7999.0(qty=2)
LinkedList iterator: Mouse:349.0(qty=5)
LinkedList iterator: Speaker:1299.0(qty=3)
LinkedList iterator: Webcam:1899.0(qty=1)
LinkedList iterator: Wireless Mouse:599.0(qty=2)
LinkedList copy: [Keyboard:499.0(qty=4), Monitor:7999.0(qty=2), Mouse:349.0(qty=5), Speaker:1299.0(qty=3), Webcam:1899.0(qty=1), Wireless Mouse:599.0(qty=2)]
LinkedList array length: 6
ArrayList offers fast indexed reads; LinkedList has efficient end operations but more node overhead.
