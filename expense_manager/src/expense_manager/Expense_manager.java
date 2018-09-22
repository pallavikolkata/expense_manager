/**
 * Class name: Expense_manager
 * @version 1.8.0_181
 * @author ShrutiSinha 
 * @date 22 Sept 2018
 * 
 * Description:
 * The program maintains the expense of the user.
 * Display the expense on user's choice.
 * It terminates on user's entered choice.
 * 
 * Expected Output 
 *  
1.Add Expense
2.See Report
3.Exit
Enter choice(1,2&3): 
1
Description of Expense: 
food
Enter an amount: 
23000.567
1.Add Expense
2.See Report
3.Exit
Enter choice(1,2&3): 
1
Description of Expense: 
clothes
Enter an amount: 
5698.89
1.Add Expense
2.See Report
3.Exit
Enter choice(1,2&3): 
2

----------------------------------------------
Description	Amount
----------------------------------------------
food		23000.567
clothes		5698.89
----------------------------------------------
Total:		28699.457
----------------------------------------------

1.Add Expense
2.See Report
3.Exit
Enter choice(1,2&3): 
5
Wrong Input
1.Add Expense
2.See Report
3.Exit
Enter choice(1,2&3): 
3

 * 
 */
package expense_manager;

import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.InputMismatchException;

/*
 * A class to calculate and display expense 
 */
public class Expense_manager{
  /*
   * Method to print the choices the user have 
   * */
  void choice() {
    System.out.println("1.Add Expense");//giving choices
    System.out.println("2.See Report");
    System.out.println("3.Exit");
    System.out.println("Enter choice(1,2&3): "); 	  
  }
  
   /*
   * A method to take user's choice input 
   */
  int input(){
    Scanner s = new Scanner(System.in);
    choice();
    int ch = 0;
    boolean validInput = false;
    while(!validInput) {//giving exception for invalid inputs
        try {
        	ch = s.nextInt();//storing user's choice
            validInput = true;
        } catch(InputMismatchException e) {
            System.out.println("Please Enter a Valid Choice!");
            choice();
            s.next();
        } 
    }
    return ch;
  }
  
  /*
   * Main Method  
   */
  public static void main(String[] args){
    List<Double> amount = new ArrayList<Double>();//to store the amount
    List<String> expense = new ArrayList<String>();//to store expense 
    Scanner sc =new Scanner(System.in);
    Expense_manager ob = new Expense_manager();
    int c = ob.input();
    double sum = 0;//declaring variables
    
    while(c!=3){    	
      if (c == 1) {//adding the expense
        System.out.println("Description of Expense: ");
	    expense.add(sc.next());
	    System.out.println("Enter an amount: ");
	    double k =0;
	    boolean validInput = false;
	    while(!validInput) {//giving exception on invalid iput
	        try {
	        	k = sc.nextDouble();
	            validInput = true;
	        } catch(InputMismatchException e) {
	            System.out.println("Invalid Input!!");
	            System.out.println("Enter an amount: ");
	            sc.next();
	        }
	    }	        
	    amount.add(k);
	    sum = sum+k;
	    c = ob.input();
	    continue; 
        } else if (c==2) {//if user choose to see expense list
	    int i;
	    System.out.println();
	    System.out.println("----------------------------------------------");
	    System.out.println("Description\tAmount");
	    System.out.println("----------------------------------------------");
    
	    for(i=0;i<amount.size();i++){
	      System.out.println(expense.get(i)+ "\t\t"+amount.get(i));
	    }
	   
	    System.out.println("----------------------------------------------");
	    System.out.println("Total:\t\t"+sum);
	    System.out.println("----------------------------------------------");
	    System.out.println();
	    c = ob.input();
	    continue;
	  } else {
          System.out.println("Please Enter a Valid Choice!");
	      c = ob.input();
	      continue;
        }
    }
    sc.close();    
  }//end of main method
  
}//end of class