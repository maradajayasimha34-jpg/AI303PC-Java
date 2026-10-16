import java.util.*;
// Problem: Show Set ordering, duplicate removal, set algebra and comparator ordering.
public class AssignmentB3 {
 static class Student { 
String name; int marks;
 Student(String n,int m){
 name=n;marks=m;
}
 public String toString(){
return name+":"+marks;
 } 
}
 public static void main(String[] args) {
 List<String> data=Arrays.asList("Java","C","Python","Java","C","Go","Ruby","Go","JS","Rust");
 Set<String> h=new HashSet<>(data), l=new LinkedHashSet<>(data), t=new TreeSet<>(data);
 System.out.println("HashSet (unordered): "+h);
 System.out.println("LinkedHashSet (insertion): "+l);
 System.out.println("TreeSet (sorted): "+t);
 List<String> names=Arrays.asList("C","Java","C","Go","Java","C");
 Set<String> seen=new HashSet<>(), dup=new LinkedHashSet<>();
 for(String s:names) 
if(!seen.add(s)) dup.add(s);
 System.out.println("Duplicates: "+dup);
 Set<Integer> A=new HashSet<>(Arrays.asList(2,4,6,8,10)), B=new HashSet<>(Arrays.asList(4,8,12));
 Set<Integer> union=new HashSet<>(A); union.addAll(B);
 Set<Integer> inter=new HashSet<>(A); inter.retainAll(B);
 Set<Integer> diff=new HashSet<>(A); diff.removeAll(B);
 System.out.println("Union="+union+" Intersection="+inter+" A-B="+diff);
 TreeSet<String> students=new TreeSet<>(Arrays.asList("Ravi","Anu","Kiran"));
 System.out.println("Ascending="+students+" Descending="+students.descendingSet());
 Set<Student> byMarks=new TreeSet<>(Comparator.comparingInt((Student s)->s.marks).reversed().thenComparing(s->s.name));
 byMarks.add(new Student("Anu",91));
 byMarks.add(new Student("Ravi",84));
 System.out.println("Marks="+byMarks);
 }
}

//Output:-
 HashSet (unordered): [Java, C, Rust, Go, JS, Ruby, Python]
LinkedHashSet (insertion): [Java, C, Python, Go, Ruby, JS, Rust]
TreeSet (sorted): [C, Go, JS, Java, Python, Ruby, Rust]
Duplicates: [C, Java]
Union=[2, 4, 6, 8, 10, 12] Intersection=[4, 8] A-B=[2, 6, 10]
Ascending=[Anu, Kiran, Ravi] Descending=[Ravi, Kiran, Anu]
Marks=[Anu:91, Ravi:84]
