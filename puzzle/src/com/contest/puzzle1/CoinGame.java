package com.contest.puzzle1;

public class CoinGame {

	public static Integer noCoins = 1100;

	public static void main(String[] args) {
		CoinGame game = new CoinGame();
		int headsCount = game.calculateTotalHeads();
		System.out.println("Total coins with head count - " + headsCount);
	}
	
	/**
	 * Returns the total number of heads at the end of the game
	 * @return
	 */
	private int calculateTotalHeads() { //kept a separate method with a specific purpose instead of writing code in main
		//no need to static method, althouth static won't hurt in such a small code
		int headsCount = 0;
		for (int currentCoinNo = 1; currentCoinNo <= noCoins; currentCoinNo++) { 
			if(isHead(currentCoinNo)) {
				headsCount++;
			}
		}
		return headsCount;
	}
	
	/**
	 * Returns true is the Coin's head is facing up else return false
	 * @param currentCoinNo - current coin number
	 * @return
	 */
	private boolean isHead(int currentCoinNo) {  //you must focus on access modifier and naming. Instead of reurning the string anf then 
		//comparing later, i changed it to return boolean (hence the name isHead)
		int divisibleCount = 0;   //Interger object was not required, rest all good in this method!
		System.out.print("currentCoinNo=" + currentCoinNo + "(");  //so that logs are very clear
		for (int i = 1; i <= currentCoinNo; i++) {  //changed it to covers 1 to n so that its easy to explain on paper
			if (currentCoinNo % i == 0) {  //changed to i instead of i-1 so that i looks simple
				System.out.print(i + " ");  
				divisibleCount += 1;
			}
		}
		if (divisibleCount % 2 == 0) {
			System.out.println(") Tails");  //so that logs are very clear
			return false;  
		}
		else {
			System.out.println(") Heads");
			return true;
		}
			
	}
}
