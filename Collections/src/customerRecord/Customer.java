package customerRecord;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;

public class Customer {
	private int id;
	private String name;
	private String phone;
	private String email;
	
	private Map<String,/*ArrayList*/HashSet<Address>> addressMap = new HashMap<>();
	private Map<Integer, Order> orderMap = new LinkedHashMap<>();
	
	public Customer(int id, String name,Map<String,HashSet<Address>> addressMap,Map<Integer, Order> orderMap, String city, String phone, String email){
		this.id=id;
		this.name=name;
		this.phone=phone;
		this.email=email;
	}
	

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getPhone() {
		return phone;
	}

	public String getEmail() {
		return email;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public Map<String, HashSet<Address>> getAddressMap() {
		return addressMap;
	}


	public Map<Integer, Order> getOrderMap() {
		return orderMap;
	}


	public void setAddressMap(Map<String, HashSet<Address>> addressMap) {
		this.addressMap = addressMap;
	}


	public void setOrderMap(Map<Integer, Order> orderMap) {
		this.orderMap = orderMap;
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
					&& (this.phone.equals(customer.phone))
					&&(this.email.equals(customer.email))){
				return true;
			}
		}
		return false;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", phone=" + phone + ", email=" + email + "]";
	}

		
 		
}
 	