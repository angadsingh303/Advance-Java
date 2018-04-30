package customerRecord;

import java.util.ArrayList;

public class TestCode {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Product> productList = new ArrayList<>();
		for(int i=1,j=5;i<=5;i++,j--){
			productList.add(new Product(i,"MOBILE"+i,"Samsung",i,9000+(j*10)));
		}
	}

}
