/*
 *Recur1.java
 *Usman Farooqi
 *This program takes an amount of money from the user and outputs the max amount of food with 15% tip
 */
import java.util.*;
class Recur1{

	static double optimumPrice; // the best price as a static double
	static String optimumorder; // the best order as a static double 
	static double tipbef; // the tip before as a static double
	
	public static void food(double amount){
		food("",0,amount);
	}
	
	public static void food(String sofar, int position, double leftover){
		String[] menu = {"Bandera Pizza Bread", "Boston's Pizza Bread", "Garlic Twist Bread", "Milkshake", "Sun-Dried Tomato Bruschetta", "Three Cheese Toast",
		"Three Cheese Toast + Bolognese Dip","Double Order Wings", "Starter Size Wings", "Cactus Nachos","Cactus Nachos + Spicy Chicken", "Baked Ravioli Bites", "Southwest Quesadilla"};
		double []price= {6.49,5.35,7.49,5.35,6.99,6.35,8.34,16.49,8.99,10.29,12.29,8.49,9.25};
		
		if (position == menu.length){ // if the position is the same as length of menu items
			if(leftover < optimumPrice){ // if the amount of money left over is less than the bestprice
				optimumPrice = leftover; // set the best price as the amount of money left over
				optimumorder = sofar; // set the best order as the current order
			}
		}
		else{
			food(sofar,position+1,leftover); // dont take item
			if (leftover>price[position]){ // if the amount of money left over is greater than the price of item take the item
			food(sofar+","+ menu[position],position+1,leftover - price[position]); // take food item
			} 
				
		}
			
	}
	
		public static void main(String [] args){

		System.out.println("Enter the amount of money");
		Scanner kb = new Scanner(System.in);
		double before = kb.nextDouble();
		tipbef = before/1.15; // to get the amount of money pre tip 
		
		optimumPrice = Double.POSITIVE_INFINITY; // set optimum price to highest
		optimumorder = ""; // set the bestorder to empty
		
		food(tipbef); // calls the recursion method using the amount before tip (for example if money entered is 100 tipbef is aproxx 86)
		
		double cost = tipbef - optimumPrice; // calculates the cost remaining 
		double percent = (optimumPrice/cost); // take the percent of that cost
		double tiptotal = percent + 15; // adds that precent to the current 15 percent tip
		
		System.out.println("Your tip is: " + tiptotal);
		System.out.println("Your best order is: "+ optimumorder);
	}

}