import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

class SortByName implements Comparator<Employee>{
	@Override
	public int compare(Employee firstObject, Employee secondObject){
		return firstObject.getName().compareTo(secondObject.getName());
	}
}
class SortBySalary implements Comparator<Employee>{
	@Override
	public int compare(Employee firstObject, Employee secondObject){
		return ((Double)firstObject.getSalary()).compareTo(secondObject.getSalary());
	}
}

class Employee implements Comparable<Employee>{
	private int id;
	private String name;
	private double salary;
	private String city;
	Employee(int id,String name, double salary, String city){
		this.id=id;
		this.name=name;
		this.salary=salary;
		this.city=city;	
	}
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public double getSalary() {
		return salary;
	}
	public String getCity() {
		return city;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public void setCity(String city) {
		this.city = city;
	}
	@Override
	public int compareTo(Employee emp){
		return ((Integer)this.id).compareTo(emp.id);
	}
	@Override
	public boolean equals(Object object){
		Employee emp;
		if(object instanceof Employee){
			emp = (Employee)object; //Downcasting
			if((this.id == emp.id) && 
					(this.name.equals(emp.name)) &&
					(this.city.equals(emp.city))){
				return true;
			}
		}
		return false;
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", salary=" + salary + ", city=" + city + "]";
	}
	
}



public class CRUDOperations {
	private static ArrayList<Employee> emplist = new ArrayList<>();
	
	public static String addNewRecord(Employee emp){
		//Employee emp = new Employee(id, name, salary, city);
		emplist.add(emp);
		return "Record added";
	}
	private static ArrayList<Employee> getEmpList(){
		return emplist;
	}
	
	public static void sortById(){
		Collections.sort(emplist);					  // Sort comparable
	}
	public static void sortByName(){
		Collections.sort(emplist, new SortByName());	// Sort comparator
	}
	public static void sortBySalary(){
		//Collections.sort(emplist, new SortBySalary());
		
		/*Collections.sort(emplist,new Comparator<Employee>(){			//Anonymous class
			@Override
			public int compare(Employee firstObject, Employee secondObject){
				return ((Double)firstObject.getSalary()).compareTo(secondObject.getSalary());
			}
		});*/
		
		Collections.sort(emplist,(firstObject,secondObject)			//Lambda
				->((Double)firstObject.getSalary())
				.compareTo(secondObject.getSalary()));
	}
	
	public static double totalSalary(){
		double sum =0.0;
		//1st way
		/*for (int i=0;i<emplist.size;i++){
			sum+=emplist.get(i).getSalary();
		}*/
		
		//2nd way enhanced for loop
		/*for(Employee emp : emplist){
			sum+=emp.getSalary();
		}*/
		//3rd way(Lambda expression)
		sum=emplist.parallelStream().filter((currentObject)->currentObject.getSalary()>3000)
				.mapToDouble((emp)->emp.getSalary()).sum();
		return sum;
	}
	
	public static String deleteRecord(Employee emp){
		int index = emplist.indexOf(emp);
		if(index>=0){
			emplist.remove(index);
			return "Record Deleted Succesfully";
			
		}
		else{
			return "No record found so can't delete";
		}
	}
	
	public static String search(Employee emp/*int id, String name, double Salary, String city*/){
		//Employee searchObject = new Employee(id, name, salary, city);
		return emplist.contains(emp)?"Record found...":"No Record found...";
	}
	public static Employee takeInput(Scanner scanner){
		System.out.println("Enter the Id ");
		int id = scanner.nextInt();
		System.out.println("Enter the Name");
		String name = scanner.next();
		System.out.println("Enter the Salary");
		double salary = scanner.nextDouble();
		System.out.println("Enter the City");
		String city = scanner.next();
		Employee emp = new Employee(id, name, salary, city);
		return emp;
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		myloop:
		while(true){
		System.out.println("1.Add a new record.");
		System.out.println("2.Delete Record");
		System.out.println("3.Update Record");
		System.out.println("4.Search Record");
		System.out.println("5.Sum of Salary");
		System.out.println("6.Count Employee");
		System.out.println("7.Sort by id");
		System.out.println("8.Sort by name");
		System.out.println("9.Sort by salary");
		System.out.println("10.Print all records");
		System.out.println("11.Exit");
		int choice = scanner.nextInt();
		
		switch(choice){
		case 1:
			Employee emp =takeInput(scanner);
			String message = addNewRecord(emp);
			System.out.println(message);
			break;
		case 2:
			System.out.println("enter info for deletion...");
			Employee emp3 = takeInput(scanner);
			System.out.println(deleteRecord(emp3));
			break;
		case 4:
			Employee emp2 = takeInput(scanner);
			System.out.println(search(emp2));
			break;
		case 5:
			System.out.println("Total Salary "+totalSalary());
			break;
		case 7: 
			sortById();
			System.out.println(getEmpList());
		case 8:
			sortByName();
			System.out.println(getEmpList());
		case 9:
			sortBySalary();
			System.out.println(getEmpList());
		case 10:
			System.out.println(getEmpList());
			break;
		case 11:
			System.out.println("Thanks for using");
			break myloop;
		}
	}
	}
}
