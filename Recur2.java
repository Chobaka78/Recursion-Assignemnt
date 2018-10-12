/*
 *Recur2.java
 *Usman Farooqi
 *This program takes a 8x8 grid and then outputs the shortest possible way to get to the end and shortest possible time
 *
 */

import java.util.*;
public class Recur2{
	
	static int optimumTime = 1000; // set the optimum time to really high in the beginining
	static String bestnav = ""; // empty string for the best way to get to end 
		
	public static void move(int[][]grid){ // move method that calls the recursive method then out puts the best time and set of directions
		move(grid,0,0,0,"");
		System.out.println(optimumTime);
		System.out.println(bestnav);
		
	}
	
	public static void move(int[][] grid, int x, int y, int time, String navigate){
		// BASE CASE
		if (x == 7 && y == 7){ // if the tank as reached the end x= 7 and y =7 
			time += grid[x][y];// add the values of the grid to the time
			if(time < optimumTime){ // if the time it took is less than the optimumTime (1st time it will obviously be less than 1000)
				optimumTime = time; // set the current time as the optimum time
				bestnav = navigate; // set the current path as the best path
			}
		}
		
		else {
			if(x == 7){ // if the tank reaches farthest right 
				move(grid, x, y + 1, time + grid[x][y], navigate + "D"); // move the tank down
			}
			else if (y == 7){ // if the tank reaches all the way to the bottom 
				move(grid, x + 1, y, time + grid[x][y], navigate + "R"); // move the tank to the right
				}
		
			else {
				move(grid, x, y + 1, time + grid[x][y], navigate + "R"); // moving the tank right
				move(grid, x + 1, y, time + grid[x][y], navigate + "D"); // moving the tank left 
			}
		}
	}
	
	public static void main(String [] args){
		// this is the 8x8 grid
		int[][]grid = {{0, 21,	20,	5,	25,	25,	35,	15},
		{12, 26, 43, 29, 15, 26, 15, 12},
		{7,	18,	23,	28,	36,	32,	12, 18},
		{43, 34, 35, 18, 25, 18, 21, 25},
		{32, 41, 23, 9,	21,	17,	24,	14},
		{12, 9,	20,	42, 9, 19, 26, 22},
		{30, 17, 17, 35, 14, 25, 14, 21},
		{15, 21, 37, 24, 19, 15, 35, 15}};
		move(grid); // calls the recursion function using the set gird provided above
		
	}
}