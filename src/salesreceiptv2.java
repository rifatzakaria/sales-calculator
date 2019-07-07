import java.util.Scanner;

public class salesreceiptv2 {

	
	//all global variables
		
	static  String customername;
	static	double quantitypurchased;
	static	double productprice;
	static  double total;
	static  double cash;
	static	double change;
	
	//module 1
		public static void welcome() {
			
			System.out.println("===welcome to my store===");
			System.out.println("*please follow the instruction*");
			
		}

		//module 2
		public static void getinput() {
		
			Scanner myscanner = new Scanner(System.in); 
			
			System.out.println("Enter customer name= ");
			customername = myscanner.nextLine();
			
			System.out.println("Enter number of product purchased= ");
			quantitypurchased= myscanner.nextDouble();
			
			System.out.println("Enter product price= ");
			productprice = myscanner.nextDouble();
			
			System.out.println("Enter amount of cash recieved= ");
			cash = myscanner.nextDouble();
		}

		
		//module 3
		public static void process() {
			
			total =  quantitypurchased * productprice ;
			change= cash - total ; 
		} 

		
		//module 4
		public static void displayoutput() {
			
        System.out.println("");
		System.out.println("*** Sales Receipt ***");
		
		System.out.println("Customer name is " + customername);
		System.out.println("Number of product purchased is " + quantitypurchased);
		System.out.println("Product price is " + productprice);
		System.out.println("");
		System.out.println("====================================");
		System.out.println("Total price is " + total);
		System.out.println("");
		System.out.println("Total amount of cash received " + cash);
		System.out.println("Total change " + change);
		System.out.println("===================================");
		System.out.println("*Thanks for shopping with us*");
		
		
		}
		
		
		//main module
		public static void main(String[] args) {

		     welcome();
		     getinput();
		     process();
		     displayoutput();

		}

}
