/*
 * The hit rate of the basketball game is given by the number of hits divided by the number of chances. For example, 
 * you have 73 chances but hit 15 times, then your hit rate is 15/73=0.205 (keep the last3 digits). On average, you 
 * have 4.5 chances in each basketball game. Assume the total number of games is 162. Write a function for a basketball 
 * player. He will input the number of hits he has made, the number of chances he had, and the number of remaining 
 * games. The function should return the number of future hits, so that he can refresh his hit rate to 0.45
 */

public class BasketballHitRate {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(futureHits (20, 300, 62));
	}
	
	// (currHit + futureHit) / (currChances + remainGames*4.5) => 0.45
	public static int futureHits(int currHit, int chance, int remain) {
		double totalChances = (chance + remain * 4.5) * 0.45;
		return (int)Math.ceil(totalChances - currHit);
	}

}
