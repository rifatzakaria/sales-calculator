
import java.util.Scanner;

public class salesreceiptv3 {

	
	//all global variables
		
	static  String productName;
	static	double quantityPurchased;
	static	double productPrice;
	static  double subTotal;
	static  double discount;
	static  double grandTotal;
	static  double cash;
	static	double change;
	
	//module 1
	public static void welcome() {

		System.out.println("========welcome to my store========");
		System.out.println("***please follow the instruction***");
		System.out.println();

	}

		
	//module 2
	public static void getinput() {

		Scanner myscanner = new Scanner(System.in); 

		System.out.println();
		System.out.print("Enter product name= ");
		productName = myscanner.nextLine();



		boolean pp=false;
		while (pp==false)

		{

			try
			{
				Scanner pscan = new Scanner(System.in);
				System.out.println();
				System.out.print("Enter number of product purchased= ");
				quantityPurchased= pscan.nextDouble();

				if (quantityPurchased>0 && quantityPurchased<=100)

				{
					pp=true;
				}
				else
				{
					pp=false;
					System.out.println("*invalid enrty...please enter valid input[1-100]* ");
					System.out.println();
				}
			}


			catch(Exception e)
			{
				pp= false;
				System.out.println("*Invalid Entry...please enter number only* ");
				System.out.println();
			}

		}


		boolean pprice=false;
		while (pprice==false)

		{
			try
			{
				Scanner ppscan = new Scanner(System.in);
				System.out.println();
				System.out.print("Enter product price= ");
				productPrice = ppscan.nextDouble();

				if (productPrice>=1 && productPrice<=500)

				{
					pprice=true;
				}

				else
				{
					pprice=false;
					System.out.println("*Invalid enrty...please enter valid input[1-500]* ");
					System.out.println();
				}

			}
			catch(Exception e)
			{
				pprice=false;
				System.out.println("*Invalid Entry...please enter number only* ");
				System.out.println();

			}
		}

		System.out.println();
		System.out.print("Enter amount of cash recieved= ");
		cash = myscanner.nextDouble();
	}

		
	//module 3
		public static void subTotal() 
		{
			subTotal =  quantityPurchased * productPrice ;
			
		
		} 
		
		
		//module 4
		
		public static void discount() 
		{
		if (subTotal>=100 && subTotal<200)
		{
			discount= subTotal * (1-.10);
		}
		else if (subTotal>=200 && subTotal<300)
		{
			discount= subTotal * (1- .15);
		}
		else if (subTotal>=300 && subTotal<400)
		{
			discount= subTotal * (1- .18);
		}
		else if (subTotal>=400 && subTotal<500)
		{
			discount= subTotal * (1- .20);
		}
		else if (subTotal>=500)
		{
			discount= subTotal * (1- .25);
		}
		
		else
		{
			System.out.println(" something went wrong ");
		}
		}
		
		
		//module 5
		
		public static void grandTotal() 
		{
			grandTotal =  subTotal - discount ;
			
		
		} 
		
		//module 6
		
		public static void change()
		{
			change = cash - discount ; 
		}
		

		
		//module 6
		
		public static void displayoutput() {

			System.out.println("");
			System.out.println("");
			System.out.println("********** Sales Receipt ***********");
			System.out.println("");
			System.out.println(" Product name is: " + productName);
			System.out.println(" Number of product purchased is: " + quantityPurchased);
			System.out.println(" Product price is: " + productPrice);
			System.out.println("");
			System.out.println("====================================");
			System.out.println();
			System.out.println(" Sub Total is: " + subTotal);
			System.out.println("");
			System.out.println(" Total  discount is: " + grandTotal);
			System.out.println("");
			System.out.println(" Grand Total after discount is: " + discount );
			System.out.println("");
			System.out.println(" Total amount of cash received: " + cash);
			System.out.println();
			System.out.println(" Total change is: " + change);
			System.out.println();
			System.out.println("===================================");
			System.out.println("*Thanks for shopping with us*");


		}
		
		
		//main module
		public static void main(String[] args) {

		     welcome();
		     
		     int maxProduct= 10;
			 for (int i=1; i<=maxProduct; i++) 
			 {

				 System.out.println(" Product No: " + i);

				 getinput();
				 subTotal();
				 discount();
				 grandTotal();
				 change();
				 displayoutput();

				 if (i==maxProduct)
				 {
					 break;
				 }


				 String nextProduct;
				 Scanner scan = new Scanner(System.in); 
				 System.out.println();
				 System.out.print(" Next Product [no to stop]: ");
				 nextProduct = scan.nextLine();
				 if (nextProduct.equals("no"))
				 {
					 break;
				 }

			 }

}
}