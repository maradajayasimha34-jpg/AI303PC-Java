import java.util.*;
import java.util.stream.*;
// Problem: Demonstrate Map implementations, word counts and merit-list sorting
public class AssignmentB4 {
 static class Student {
 String id,name; Student(String i,String n){id=i;name=n;}
 public boolean equals(Object o){return o instanceof Student && id.equals(((Student)o).id);}
 public int hashCode(){return Objects.hash(id);} // equals and hashCode must agree for hash keys
 }
 public static void main(String[] args) {
 Map<String,Integer> marks=new HashMap<>();
 marks.put("S102",92); marks.put("S104",88); marks.put("S101",76);
 System.out.println("S102="+marks.get("S102")+" contains S104="+marks.containsKey("S104"));
 marks.remove("S101"); System.out.println("size="+marks.size());
 System.out.println("keys="+marks.keySet()+" values="+marks.values());
 for(Iterator<Map.Entry<String,Integer>> it=marks.entrySet().iterator();it.hasNext();) System.out.println(it.next());
 String sentence="Java is easy and Java is useful";
 Map<String,Integer> freq=new HashMap<>();
 for(String w:sentence.toLowerCase().split("\\W+")) freq.merge(w,1,Integer::sum);
 freq.forEach((w,c)->{if(c>1)System.out.println(w+"="+c);});
 Map<String,Integer> merit=marks.entrySet().stream()
 .sorted(Map.Entry.<String,Integer>comparingByValue().reversed())
 .collect(Collectors.toMap(Map.Entry::getKey,Map.Entry::getValue,(x,y)->x,LinkedHashMap::new));
 System.out.println("Merit list="+merit);
 Map<String,Integer> insertion=new LinkedHashMap<>(); insertion.put("S102",92); insertion.put("S104",88);
 Map<String,Integer> rollOrder=new TreeMap<>(insertion);
 System.out.println("LinkedHashMap="+insertion+" TreeMap="+rollOrder);
 Map<Student,String> studentMap=new HashMap<>(); studentMap.put(new Student("1","Asha"),"CS");
 System.out.println("Student key lookup="+studentMap.get(new Student("1","Asha")));
 }
}

//Output:-
 S102=92 contains S104=true
size=2
keys=[S104, S102] values=[88, 92]
S104=88
S102=92
java=2
is=2
Merit list={S102=92, S104=88}
LinkedHashMap={S102=92, S104=88} TreeMap={S102=92, S104=88}
Student key lookup=CS