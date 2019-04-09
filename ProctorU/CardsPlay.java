/*
 * 纸牌题
 * 有 54 张牌,牌面是数字加字母。如“1A, 2B, 3C, 4D, 5F, 6B, 7D”. 规则是,从左向右,四个为一组,这四个中,如果第一个和最后一个的数字相同,那么
 * 这四张牌都消掉,如果是字母相同的话中间两张消掉。每次发生消除的话都要从头开始。如果没有发生消除就看下一个 4张牌,例如“1A, 2B, 3C, 4D” 没有消除,
 * 就看“2B, 3C, 4D, 5F” 以此类推,每次发生消除了就从现有的牌的第一张开始
 * 输出,如果牌都消完了print “You win” ELSE print “You lose” and number of remained cards.
 */

import java.util.*;

public class CardsPlay {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		cardsPlay("1A2B3C");
		cardsPlay("1A2B3C4D5F");
		cardsPlay("1A2B3C4D5F6B4D");
		cardsPlay("1A2B3C4D5F6B7D");
	}

	public static void cardsPlay(String input) {
		if (input == null)
			throw new NullPointerException();
		if(input.length() % 2 == 1)
			throw new IllegalArgumentException();
		
		int idx = 0;
		int count = 0;
		List<Card> list = new ArrayList<>();
		while (idx < input.length() - 1) {
			while (idx < input.length() - 1 && list.size() < 4) {
				list.add(new Card(input.charAt(idx++), input.charAt(idx++)));
			} 
			if (list.size() == 4) {
				Card card1 = list.get(0);
				Card card4 = list.get(3);
				if (card1.number == card4.number) {
					list.clear();
				} else if (card1.letter == card4.letter) {
					list.remove(2);
					list.remove(1);
				} else {
					list.remove(0);
					count++;
				}
			}
		}
		
		int remain = count + list.size();
		if (remain == 0) {
			System.out.println("You win!");
		} else {
			System.out.println("You lose! " + remain + " cards remained.");
		}
	}
}

class Card {
	char number;
	char letter;
	
	public Card(char number, char letter) {
		this.number = number;
		this.letter = letter;
	}
}
