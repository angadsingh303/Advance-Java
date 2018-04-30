package customerRecord;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


class SortByName implements Comparator<Product>{
	@Override
	public int compare(Product firstObject, Product secondObject){
		return firstObject.getName().compareTo(secondObject.getName());
	}
}
class SortByQuantity implements Comparator<Product>{
	@Override
	public int compare(Product firstObject,Product secondObject){
		return ((Integer)firstObject.getQty()).compareTo(secondObject.getQty());
	}
}





class Product implements Comparable<Product>{
	private int id;
	private String name;
	private String desc;
	private int qty;
	private float price;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public String getDesc() {
		return desc;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}
	
	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}
	

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	Product(int id,String name,String desc, int qty, float price){
		this.id=id;
		this.name=name;
		this.desc=desc;
		this.price=price;
		this.qty=qty;
	}
	@Override
	public int compareTo(Product prod){
		return ((Float)this.price).compareTo(prod.getPrice());
	}
}
public class Order {
	int id;
	String name;
	String date;
	
	
	public int getId() {
		return id;
	}


	public String getName() {
		return name;
	}


	public String getDate() {
		return date;
	}


	

	public void setId(int id) {
		this.id = id;
	}


	public void setName(String name) {
		this.name = name;
	}


	public void setDate(String date) {
		this.date = date;
	}
	
	public static ArrayList<Product> getProdlist() {
		return prodlist;
	}


	public static void setProdlist(ArrayList<Product> prodlist) {
		Order.prodlist = prodlist;
	}
	@Override
	public String toString() {
		return "Order [id=" + id + ", name=" + name + ", date=" + date + "]";
	}
	private static ArrayList<Product> prodlist = new ArrayList<>();
	public static String addNewRecord(Product product){
		//Employee emp = new Employee(id, name, salary, city);
		prodlist.add(product);
		return "Record added";
	}
	
	
	private static ArrayList<Product> getProdList(){
		return prodlist;
	}
	public static void sortByPrice(){
		Collections.sort(prodlist);					  // Sort comparable
	}
	public static void sortByName(){
		Collections.sort(prodlist, new SortByName());	// Sort comparator
	}
	public static void sortByQuantity(){
		Collections.sort(prodlist, new SortByQuantity());
	}
	
	public Order(int id, String name, ArrayList<Product> prodList){
		this.id=id;
		this.name=name;
		this.prodlist=prodList;
	}
}




