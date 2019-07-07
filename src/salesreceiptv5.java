
import java.util.Scanner;

public class salesreceiptv5 {


	//all global variables

	static  final int maxProduct = 5;
	
	static  String[] productName = new String[maxProduct];
	static	double[] quantityPurchased = new double[maxProduct];
	static	double[] productPrice = new double[maxProduct];
	
	static  double subTotal;
	static  double grandTotal;
	static  double cash ;
	static	double change;

	//module 1 welcome
	public static void welcome() {

		System.out.println("========welcome to my store========");
		System.out.println();

	}


	//module 2 getting input
	public static void getinput(int arrayCounter) {

		Scanner myscanner = new Scanner(System.in); 
		
		//product name
		System.out.println();
		System.out.print("Enter product name= ");
		productName[arrayCounter] = myscanner.nextLine();

		//product quantity
		boolean pp=false;
		while (pp==false)

		{
			try
			{
				Scanner pscan = new Scanner(System.in);
				System.out.println();
				System.out.print("Enter number of product purchased= ");
				quantityPurchased[arrayCounter]= pscan.nextDouble();

				if (quantityPurchased[arrayCounter]>0 && quantityPurchased[arrayCounter]<=100)
				{
					pp=true;
				}
				else
				{
					pp=false;
					System.out.println("*ERROR...please enter valid input[1-100]* ");
					System.out.println();
				}
			}


			catch(Exception e)
			{
				pp= false;
				System.out.println("*ERROR...please enter number only* ");
				System.out.println();
			}

		}

		//product price 
		boolean pprice=false;
		while (pprice==false)

		{
			try
			{
				Scanner ppscan = new Scanner(System.in);
				System.out.println();
				System.out.print("Enter product price= ");
				productPrice[arrayCounter] = ppscan.nextDouble();

				if (productPrice[arrayCounter]>=1 && productPrice[arrayCounter]<=500)

				{
					pprice=true;
				}

				else
				{
					pprice=false;
					System.out.println("*ERROR...please enter valid input[1-500]* ");
					System.out.println();
				}

			}
			catch(Exception e)
			{
				pprice=false;
				System.out.println("*ERROR...please enter number only* ");
				System.out.println();

			}
		}

		//cash
		try
			{
				Scanner cashscan = new Scanner(System.in);
				System.out.println();
				System.out.print("Enter amount of cash recieved= ");
				cash = cashscan.nextDouble();
				
			}
			catch(Exception e)
			{
				System.out.println("*ERROR...please enter number only* ");
				System.out.println();
			}
			
	}
	
	
	//module 3 calculate  total 
	public static void calculateTotal(int arrayCounter) {
		subTotal = calculatesubTotal(arrayCounter);
		grandTotal = calculateGrandTotal();
		change();
		discount();
	}


	//module 4 sub total
	public static double calculatesubTotal (int arrayCounter ) {
		return quantityPurchased[arrayCounter] * productPrice[arrayCounter];
	}
			

			
	//module 5 grand total
	public static double calculateGrandTotal() {

		double tempGT = 0;

		if (subTotal>=100 && subTotal<200)
		{
			tempGT= subTotal * (1-.10);
		}
		else if (subTotal>=200 && subTotal<300)
		{
			tempGT= subTotal * (1- .15);
		}
		else if (subTotal>=300 && subTotal<400)
		{
			tempGT= subTotal * (1- .18);
		}
		else if (subTotal>=400 && subTotal<500)
		{
			tempGT= subTotal * (1- .20);
		}
		else if (subTotal>=500)
		{
			tempGT= subTotal * (1- .25);
		}

		else
		{
			System.out.println(" something went wrong ");
		}
		return tempGT;
	}


	//module 6 discount
	public static double discount() {

		double discount =  grandTotal - subTotal  ;
		return discount;
	} 


	//module 7 change
	public static void change() {

		change = cash - grandTotal;
	}



	//module 8 display output
	public static void displayoutput(int arrayCounter) {

		System.out.println("");
		System.out.println("");
		System.out.println("********** Sales Receipt ***********");
		System.out.println("");
		System.out.println(" Product name is: " + productName[arrayCounter]);
		System.out.println(" Number of product purchased is: " + quantityPurchased[arrayCounter]);
		System.out.println(" Product price is: " + productPrice[arrayCounter]);
		System.out.println("");
		System.out.println("====================================");
		System.out.println();
		System.out.println(" Sub Total is: " + subTotal);
		System.out.println("");
		System.out.println(" Total  discount is: " + discount());
		System.out.println("");
		System.out.println(" Grand Total after discount is: " + grandTotal);
		System.out.println("");
		System.out.println(" Total amount of cash received: " + cash);
		System.out.println();
		System.out.println(" Total change is: " + change);
		System.out.println();
		System.out.println("===================================");
		System.out.println("*Thanks for shopping with us*");


	}


	//module 9 display menu selection
	public static void displayMenueSelection(int arrayCounter) {

		Scanner scan = new Scanner(System.in);
		System.out.print(" Select an Action [ Add = A | Edit = E | Delete = D ] :  ");
		String cMenueSelection = scan.nextLine();

		switch(cMenueSelection) {

		case "A" : 
			System.out.println("");
			System.out.println(" Enter Product Name, product Purchased  & Product Price ");

			getinput(arrayCounter);
			calculateTotal(arrayCounter);
			displayoutput(arrayCounter);
			break;

		case "E" : 
			System.out.println(" Edit Infomration : ");
			break;

		case "D" : 
			System.out.println(" Delete Infomration : ");
			break;

		default:
			//System.out.println("[ Option Selected " + cMenueSelection + " is not available !!!!]");
			System.out.println(" [" + cMenueSelection + "] Invalid Entry !!!!]");
			displayMenueSelection(arrayCounter) ;
		}
	}


	//module 9 ask to continue
	public static boolean doYouWantToContinue() {

		Scanner scan = new Scanner(System.in);

		System.out.println("");
		System.out.print(" Do you want to continue? [No = N | Yes = Y] : ");
		char cContinue = scan.next().charAt(0);
		if(Character.toUpperCase(cContinue)=='Y') {
			return true;
		}

		return false;
	}





	//main module
	public static void main(String[] args) {

		welcome();

		int arrayCounter=0;

		do {
			displayMenueSelection(arrayCounter);
			if(doYouWantToContinue()==false) 
				break;
		} 

		while (true);


	}

		}
