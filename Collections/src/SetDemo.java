import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.TreeSet;

public class SetDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashSet<String> ts = new HashSet<>();
		//LinkedHashSet<String> ts = new LinkedHashSet<>();	no duplicate + insertion order
		//TreeSet<String> ts = new TreeSet<>();		no duplicate + sorted order
		ts.add("Ram");
		ts.add("Amit");
		ts.add("Ram");
		ts.add("Shyam");
		ts.add("Mike");
		ts.add("Ram");
		ts.add("John");
		ts.add("Amit");
		System.out.println(ts);
	}

}
