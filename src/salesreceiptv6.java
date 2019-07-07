
import java.util.Scanner;

public class salesreceiptv6 {


	//all global variables

	static  final int maxProduct = 5;
	static  int totalArrayCounter = 0;
	
	static int[] serialNo=new int[maxProduct];
	static  String[] productName = new String[maxProduct];
	static	double[] quantityPurchased = new double[maxProduct];
	static	double[] productPrice = new double[maxProduct];
	
	static  double[] subTotal=new double [maxProduct];
	static  double[] grandTotal=new double [maxProduct];
	static  double[] cash=new double [maxProduct] ;
	static	double[] change=new double [maxProduct];

	//module 1 welcome
	public static void welcome() {

		System.out.println("========welcome to my store========");
		System.out.println();
		}


	//module 2 getting input
	public static void getinput(int arrayCounter) {
		
		
		boolean isValid = false;
		serialNo [arrayCounter]= arrayCounter;
		System.out.println("Product no :  " + serialNo [arrayCounter]);
		
		
		//product name
		Scanner myscanner = new Scanner(System.in); 
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
				System.out.print("Enter amount of cash recieved= ");
				cash[arrayCounter] = cashscan.nextDouble();
				
			}
			catch(Exception e)
			{
				System.out.println("*ERROR...please enter number only* ");
				System.out.println();
			}
			
	}
	
	
	//module 3 edit data
	public static void editData(int arrayCounter ) {

		Scanner editscan = new Scanner(System.in);
		System.out.print("Edit By Serial No. (Type SN) or By Product Name (type PN) :   ");
		String cMenueSelection = editscan.nextLine();

		switch(cMenueSelection) {

		case "SN" : 
			System.out.println("");
			System.out.print("Enter Serial No to EDIT :   ");
			String sSerialNo = editscan.nextLine();
			
			for(int i=0;i<totalArrayCounter;i++) {

				if(serialNo[i]==Integer.parseInt(sSerialNo) )	
				{
					getinput(i);
					calculateTotal(i);
					displayoutput(i);
					break;
				}
			}
			
		case "PN"  :
				System.out.println("");
				System.out.print("Enter Product Name to EDIT :   ");
				String pName = editscan.nextLine();
				
		
			break;

		default:

			System.out.println("[" + cMenueSelection + "] is not a valid.]");
			editData(arrayCounter) ;
		}
	}
	
	
	
	//module 4 calculate  total 
	public static void calculateTotal(int arrayCounter) {
		subTotal[arrayCounter] = calculatesubTotal(arrayCounter);
		grandTotal[arrayCounter] = calculateGrandTotal(arrayCounter);
		change(arrayCounter);
		discount(arrayCounter);
	}


	//module 5 sub total
	public static double calculatesubTotal (int arrayCounter ) {
		return quantityPurchased[arrayCounter] * productPrice[arrayCounter];
	}
			

			
	//module 6 grand total
	public static double calculateGrandTotal(int arrayCounter) {

		double tempGT = 0;

		if (subTotal[arrayCounter]>=100 && subTotal[arrayCounter]<200)
		{
			tempGT= subTotal[arrayCounter] * (1-.10);
		}
		else if (subTotal[arrayCounter]>=200 && subTotal[arrayCounter]<300)
		{
			tempGT= subTotal[arrayCounter] * (1- .15);
		}
		else if (subTotal[arrayCounter]>=300 && subTotal[arrayCounter]<400)
		{
			tempGT= subTotal[arrayCounter] * (1- .18);
		}
		else if (subTotal[arrayCounter]>=400 && subTotal[arrayCounter]<500)
		{
			tempGT= subTotal[arrayCounter] * (1- .20);
		}
		else if (subTotal[arrayCounter]>=500)
		{
			tempGT= subTotal[arrayCounter] * (1- .25);
		}

		else
		{
			System.out.println(" something went wrong ");
		}
		return tempGT;
	}


	//module 7 discount
	public static double discount(int arrayCounter) {

		double discount =  grandTotal[arrayCounter] - subTotal[arrayCounter]  ;
		return discount;
	} 


	//module 8 change
	public static void change(int arrayCounter) {

		change[arrayCounter] = cash[arrayCounter] - grandTotal[arrayCounter];
	}



	//module 9 display output
	public static void displayoutput(int arrayCounter) {

		System.out.println("");
		System.out.println("*********** Sales Receipt  ************");
		System.out.println("");
		System.out.println(" Product name is: " + productName[arrayCounter]);
		System.out.println(" Number of product purchased is: " + quantityPurchased[arrayCounter]);
		System.out.println(" Product price is: " + productPrice[arrayCounter]);
		System.out.println("");
		System.out.println("========================================");
		System.out.println();
		System.out.println(" Sub Total is: " + subTotal[arrayCounter]);
		System.out.println(" Total  discount is: " + discount(arrayCounter));
		System.out.println(" Grand Total after discount is: " + grandTotal[arrayCounter]);
		System.out.println(" Total amount of cash received: " + cash[arrayCounter]);
		System.out.println(" Total change is: " + change[arrayCounter]);
		System.out.println();
		
	}

    //module 10 table head
	public static void displayTableHead() {

		System.out.println("----------------------------------------------------------------------------------------------------------------");
		System.out.printf("%10s %10s %10s %10s %10s %10s %12s %10s %10s","SerialNo" ,"ProductName", "productpurchased", "Productprice", "subTotal", "discount", "grandTotal", "cash", "change");
		System.out.println();
		System.out.println("----------------------------------------------------------------------------------------------------------------");
	}
	
	//module 11 table data
	public static void displayTableData(int arrayCounter) {
		
        System.out.format("%5s %10s %15s %15s %13s %10s %10s %15s %10s",serialNo[arrayCounter],productName[arrayCounter], quantityPurchased[arrayCounter], productPrice[arrayCounter], subTotal[arrayCounter], discount(arrayCounter), grandTotal[arrayCounter], cash[arrayCounter], change[arrayCounter] );
        System.out.println();
	}
	
	//module 12 display table
	public static void displayTable() {
		
		displayTableHead();
		for(int i=0; i<=totalArrayCounter;i++) {
			if(productName[i]!=null) {
				displayTableData(i);
			}
				
		}
	}
	
	
	//module 13 display menu selection
	public static void displayMenueSelection(int arrayCounter) {

		Scanner scan = new Scanner(System.in);
		System.out.print("Select an Action [ Add = A | Edit = E | Delete = D ] :  ");
		String cMenueSelection = scan.nextLine();

		switch(cMenueSelection) {

		case "A" : 
			System.out.println();
			System.out.println("Enter Product Name, product Purchased  & Product Price ");

			getinput(arrayCounter);
			calculateTotal(arrayCounter);
			displayoutput(arrayCounter);
			displayTable();
			totalArrayCounter++;
			break;

		case "E" : 
			System.out.println("Edit Infomration : ");
			editData(arrayCounter);
			displayTable();
			break;

		case "D" : 
			System.out.println("Delete Infomration : ");
			break;

		default:
			
			System.out.println(" [" + cMenueSelection + "] Invalid Entry !!!!]");
			displayMenueSelection(arrayCounter) ;
		}
	}


	//module 14 ask to continue
	public static boolean doYouWantToContinue() {

		Scanner scan = new Scanner(System.in);

		System.out.println("");
		System.out.print("Do you want to continue? [No = N | Yes = Y] : ");
		char cContinue = scan.next().charAt(0);
		if(Character.toUpperCase(cContinue)=='Y') {
			return true;
		}

		return false;
	}

	//main module
	public static void main(String[] args) {

		welcome();


		do {
			displayMenueSelection(totalArrayCounter);
			if(doYouWantToContinue()==false) 
				break;
		} 

		while (true);

		System.out.println("*Thanks for shopping with us*");
	}

		}
