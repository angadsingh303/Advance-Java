import java.util.HashSet;

class Customer{
	private int id;
	private String name;
	private String city;
	Customer(int id,String name, String city){
		this.id=id;
		this.name=name;
		this.city=city;
	}
	
	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getCity() {
		return city;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setCity(String city) {
		this.city = city;
	}
	@Override
	public boolean equals(Object object){
		if(this==object){
			return true;
		}
		if(object instanceof Customer){
			Customer customer = (Customer) object;
			if(this.id == customer.id &&
					(this.name.equals(customer.name))
					&& (this.city.equals(customer.city))){
				return true;
			}
		}
		return false;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", city=" + city + "]\n";
	}
	@Override
	public int hashCode(){
		return city.equals("Delhi")?100:200;
	}
}
public class HashSetDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashSet<Customer> customerSet = new HashSet<>();
		Customer ram = new Customer(1001,"Ram","Delhi");
		Customer ram2 = new Customer(1001,"Ram","Delhi");
		Customer shyam = new Customer(1002,"Shyam","Mumbai");
		Customer mike = new Customer(1003,"Mike","Delhi");
		Customer shyam2 = new Customer(1002,"Shyam","Mumbai");
		customerSet.add(ram);
		customerSet.add(ram2);
		customerSet.add(shyam);
		customerSet.add(mike);
		customerSet.add(shyam2);
		System.out.println(customerSet);

		for(Customer customer : customerSet){
			System.out.println("Name "+customer.getName()+" Hash Code "+customer.hashCode());
		}
	}

}
