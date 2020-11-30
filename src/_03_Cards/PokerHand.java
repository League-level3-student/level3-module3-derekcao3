package _03_Cards;

public class PokerHand extends Hand {
	public enum HandTypes {
		Nothing,   
		Pair,         
		JacksOrBetter,
		TwoPairs,
		ThreeOfAKind, 
		Straight,     
		Flush,          
		FullHouse,    
		FourOfAKind,  
		StraightFlush,
		RoyalStraightFlush
	}
	
	private boolean hasJacksOrBetter() {
		for (int i = 0; i < size() - 1; i++) {
			if (get(i).getValue() == get(i + 1).getValue() &&
			 (get(i).getValue() == 1 || get(i).getValue() > 10)) return true;
		}
		return false;
	}
	
	private boolean hasFlush() {
		for (int i = 0; i < size() - 1; i++) {
			if (get(i).getSuit() != get(i + 1).getSuit()) return false;
		}
		return true;
	}
	
	private boolean hasStraight() {
		// Check for "A"-high straight
		if (get(0).getValue() == 1 &&
			get(1).getValue() == 10 &&
			get(2).getValue() == 11 &&
			get(3).getValue() == 12 && 
			get(4).getValue() == 13) {
			return true;
		}
		
		for (int i = 0; i < size() - 1; i++) {
			if (get(i).getValue() != get(i + 1).getValue() - 1) {
				return false;
			}
		}
		return true;
	}
	
	private boolean hasFullHouse() {
		if ( 
			(get(0).getValue() == get(1).getValue() &&
			 get(2).getValue() == get(4).getValue())
			||
			(get(0).getValue() == get(2).getValue() &&
			 get(3).getValue() == get(4).getValue()) 
		   )
			return true;
		return false;
	}
	
	private boolean hasTwoPairs() {
		if ( 
			(get(0).getValue() == get(1).getValue() &&
			 get(2).getValue() == get(3).getValue())
			||
			(get(0).getValue() == get(1).getValue() &&
			 get(3).getValue() == get(4).getValue()) 
			||
			(get(1).getValue() == get(2).getValue() &&
			 get(3).getValue() == get(4).getValue()) 
		   )
			return true;
		return false;
	}
	
	private boolean hasFourOfAKind() {
		if (get(0).getValue() == get(3).getValue() ||
			get(1).getValue() == get(4).getValue()) 
			return true;
		return false;
	}
	
	private boolean hasThreeOfAKind() {
		if (get(0).getValue() == get(2).getValue() ||
			get(1).getValue() == get(3).getValue() ||
			get(2).getValue() == get(4).getValue() ) 
			return true;
		return false;
	}
	
	private boolean hasPair() {
		if (get(0).getValue() == get(1).getValue() ||
			get(1).getValue() == get(2).getValue() ||
			get(2).getValue() == get(3).getValue() ||
			get(3).getValue() == get(4).getValue()) 
			return true;
		return false;
	}
	
	public HandTypes getHandType() {
		if (size() != 5) return HandTypes.Nothing;
		sort();
		
		if (get(0).getValue() == 1 && get(4).getValue() == 13 &&
				hasFlush() && hasStraight()) {
			return HandTypes.RoyalStraightFlush;
		}
		else if (hasFlush() && hasStraight()) {
			return HandTypes.StraightFlush;
		}
		else if (hasFourOfAKind()) {
			return HandTypes.FourOfAKind;
		}
		else if (hasFullHouse()) {
			return HandTypes.FullHouse;
		}
		else if (hasFlush()) {
			return HandTypes.Flush;
		}
		else if (hasStraight()) {
			return HandTypes.Straight;
		}
		else if (hasThreeOfAKind()) {
			return HandTypes.ThreeOfAKind;
		}
		else if (hasTwoPairs()) {
			return HandTypes.TwoPairs;
		}
		else if (hasJacksOrBetter()) {
			return HandTypes.JacksOrBetter;
		}
		else if (hasPair()) {
			return HandTypes.Pair;
		}
		
		return HandTypes.Nothing;
	}
	
	
	public void sort() {
		for (int i = 0; i < this.size() - 1; i++) {
			for (int j = i+1; j < this.size(); j++) {
				Card a = this.get(i);
				Card b = this.get(j);
				if (a.getValue() > b.getValue()) {
					this.set(i, b);
					this.set(j, a);
				}
			}
		}
	}
	
	@Override
	public String toString() {
		return super.toString() + ": " + getHandType();
	}
}
