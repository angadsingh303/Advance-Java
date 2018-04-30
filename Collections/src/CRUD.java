import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class CRUD {

	/**
	 * @param args
	 */
	static int sum2=0;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//ArrayList<String> songslist = new ArrayList<>();
		List<String> songslist = new ArrayList<>();
		//songslist = new Vector<>();
		//songslist = new LinkedList,();
		songslist.add("Its My life");
		songslist.add("Illahi");
		songslist.add(0,"Summer of 69");
		System.out.println(songslist);
		//songslist.remove(0);
		//songslist.remove("Illahi");
		songslist.set(0, "Hi");
		System.out.println(songslist);
		Collections.sort(songslist);
		System.out.println("After Sort "+songslist);
		if(songslist.contains("Hi")){
			System.out.println("found");
		}
		else{
			System.out.println("not found");
			
		}
	
	Integer x[]={10,20,30,40,50};	
	List<Integer> l = Arrays.asList(x);
	int sum=0;
	//1st Way
	/*for(int i=0;i<l.size();i++){
		sum = sum + l.get(i);
	}*/
	//2nd Way (v1.4)
	/*Iterator<Integer> i = l.iterator();
	while(i.hasNext()){
		sum = sum + i.next();
	}*/
	
	//3rd way
	/*ListIterator<Integer> j = l.listIterator();
	while(j.hasNext()){
		sum = sum+j.next();
	}
	while(j.hasPrevious()){
		sum = sum+j.previous();
	}*/
	//4th way(Enhanced for loop) v1.5
	/*for(int i : l){
		sum = sum+i;
	}*/
	//5th way
	l.forEach((q)->{
		sum2 =sum2+q;
	});
	System.out.println(sum2);
	}

}
