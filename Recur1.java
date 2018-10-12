/*
 *Recur1.java
 *Usman Farooqi
 *This program takes an amount of money from the user and outputs the max amount of food with 15% tip
 */
import java.util.*;
class Recur1{

	static Double optimumPrice = Double.POSITIVE_INFINITY; // set optimum price to highest
	static String optimumorder = ""; // set the bestorder to empty
	static double minimum = 5.35 * 1.15; // minimum amount needed to buy an item with tip
	
	public static void food(double money){
		if(money > minimum){
			food("",0,money);
		}
		
		else{
			
			System.out.println("You can not afford to buy anything!!!"); // if they can not afford anything
		}
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
			if (leftover>(price[position]*1.15)){ // if the amount of money left over is greater than the price of item take the item
			food(sofar+","+ menu[position],position+1,leftover - (price[position]*1.15)); // take food item and multiply the price by 1.15 for tip
			} 
				
		}
			
	}
	
		public static void main(String [] args){

		System.out.println("Enter the amount of money");
		Scanner kb = new Scanner(System.in);
		double pay = kb.nextDouble();
		
		food(pay); 
		
		double cost = (pay - optimumPrice)/1.15; // finding how much was left with out any tips
		optimumPrice += (pay - optimumPrice) - cost; // amount of money left to use
		double tiptotal = (optimumPrice/cost)*100; // calculating the tital tip
		
			System.out.println("Your tip is: " + tiptotal);
			System.out.println("Your best order is: "+ optimumorder);
	}

}