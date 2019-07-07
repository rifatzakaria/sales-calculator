import java.util.Scanner;

public class salesreceiptv1 {

	public static void main(String[] args) {
		
		String customername;
		double quantitypurchased;
		double productprice;
		double totalprice;
		
		System.out.println("===Sales Calculator v1.0===");
		System.out.println("*please follow the instruction*");
		
		Scanner myscanner = new Scanner(System.in); 
		
		System.out.println("Enter customer name= ");
		customername = myscanner.nextLine();
		
		System.out.println("Enter number of product purchased= ");
		quantitypurchased= myscanner.nextDouble();
		
		System.out.println("Enter product price= ");
		productprice = myscanner.nextDouble();
		
		totalprice =  quantitypurchased * productprice ;

		System.out.println("");
		System.out.println("*** Sales Receipt ***");
		
		System.out.println("Customer name is " + customername);
		System.out.println("Number of product purchased is " + quantitypurchased);
		System.out.println("Product price is " + productprice);
		System.out.println("===================================");
		System.out.println("Total price is " + totalprice);
		

		}

}
