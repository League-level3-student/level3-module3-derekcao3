package _03_Cards;

import java.util.ArrayList;
import _03_Cards.Card.Suits;
import _03_Cards.PokerHand.HandTypes;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;


public class CardsTester {
	/*
	public static void main(String[] args) {
		Deck d = new Deck();
		for (Card c: d) {
			System.out.println(c);
		}
		
		System.out.println("===========================");
		d.shuffle();
		for (Card c: d) {
			System.out.println(c);
		}
		
		System.out.println("Deck size: " + d.size());
		Hand hand = d.deal(5);
		System.out.println("===========================");
		//for (Card c: hand) {
		//	System.out.println(c);
		//}
		System.out.println(hand);
		
		System.out.println("Deck size: " + d.size());
	
		System.out.println("===========================");
		PokerHand p = d.dealPokerHand();
		System.out.println(p);
		p.sort();
		System.out.println(p);
	}
	*/
	
	@Test
	void testPair() {
		PokerHand hand = new PokerHand();
		hand.add(new Card(10, Suits.CLUBS));
		hand.add(new Card(5, Suits.CLUBS));
		hand.add(new Card(10, Suits.DIAMONDS));
		hand.add(new Card(2, Suits.CLUBS));
		hand.add(new Card(12, Suits.CLUBS));
		assertEquals(hand.getHandType(), HandTypes.Pair);
		
		hand = new PokerHand();
		hand.add(new Card(12, Suits.CLUBS));
		hand.add(new Card(10, Suits.DIAMONDS));
		hand.add(new Card(7, Suits.CLUBS));
		hand.add(new Card(2, Suits.CLUBS));
		hand.add(new Card(12, Suits.CLUBS));
		assertNotEquals(hand.getHandType(), HandTypes.Flush);
	}
	
	@Test
	void testJacksOrBetter() {
		PokerHand hand = new PokerHand();
		hand.add(new Card(10, Suits.CLUBS));
		hand.add(new Card(5, Suits.CLUBS));
		hand.add(new Card(12, Suits.DIAMONDS));
		hand.add(new Card(2, Suits.CLUBS));
		hand.add(new Card(12, Suits.CLUBS));
		assertEquals(hand.getHandType(), HandTypes.JacksOrBetter);
		
		hand = new PokerHand();
		hand.add(new Card(10, Suits.CLUBS));
		hand.add(new Card(10, Suits.DIAMONDS));
		hand.add(new Card(7, Suits.CLUBS));
		hand.add(new Card(2, Suits.CLUBS));
		hand.add(new Card(12, Suits.CLUBS));
		assertNotEquals(hand.getHandType(), HandTypes.Flush);
	}
	
	@Test
	void testTwoPairs() {
		PokerHand hand = new PokerHand();
		hand.add(new Card(10, Suits.CLUBS));
		hand.add(new Card(10, Suits.DIAMONDS));
		hand.add(new Card(12, Suits.HEARTS));
		hand.add(new Card(2, Suits.SPADES));
		hand.add(new Card(12, Suits.CLUBS));
		assertEquals(hand.getHandType(), HandTypes.TwoPairs);
		
		hand = new PokerHand();
		hand.add(new Card(10, Suits.CLUBS));
		hand.add(new Card(10, Suits.DIAMONDS));
		hand.add(new Card(7, Suits.CLUBS));
		hand.add(new Card(2, Suits.CLUBS));
		hand.add(new Card(12, Suits.CLUBS));
		assertNotEquals(hand.getHandType(), HandTypes.TwoPairs);
	}
	
	@Test
	void testThreeOfAKind() {
		PokerHand hand = new PokerHand();
		hand.add(new Card(10, Suits.CLUBS));
		hand.add(new Card(5, Suits.CLUBS));
		hand.add(new Card(10, Suits.DIAMONDS));
		hand.add(new Card(10, Suits.SPADES));
		hand.add(new Card(7, Suits.HEARTS));
		assertEquals(hand.getHandType(), HandTypes.ThreeOfAKind);
		
		hand = new PokerHand();
		hand.add(new Card(10, Suits.CLUBS));
		hand.add(new Card(5, Suits.DIAMONDS));
		hand.add(new Card(10, Suits.DIAMONDS));
		hand.add(new Card(10, Suits.HEARTS));
		hand.add(new Card(10, Suits.SPADES));
		assertNotEquals(hand.getHandType(), HandTypes.ThreeOfAKind);
	}
	
	@Test
	void testStraight() {
		PokerHand hand = new PokerHand();
		hand.add(new Card(1, Suits.DIAMONDS));
		hand.add(new Card(2, Suits.CLUBS));
		hand.add(new Card(3, Suits.CLUBS));
		hand.add(new Card(4, Suits.CLUBS));
		hand.add(new Card(5, Suits.CLUBS));
		System.out.println(hand);
		assertEquals(hand.getHandType(), HandTypes.Straight);
		
		hand = new PokerHand();
		hand.add(new Card(11, Suits.CLUBS));
		hand.add(new Card(10, Suits.CLUBS));
		hand.add(new Card(13, Suits.DIAMONDS));
		hand.add(new Card(12, Suits.CLUBS));
		hand.add(new Card(1, Suits.CLUBS));
		assertEquals(hand.getHandType(), HandTypes.Straight);
		
		hand = new PokerHand();
		hand.add(new Card(7, Suits.CLUBS));
		hand.add(new Card(5, Suits.DIAMONDS));
		hand.add(new Card(6, Suits.CLUBS));
		hand.add(new Card(4, Suits.CLUBS));
		hand.add(new Card(8, Suits.CLUBS));
		assertEquals(hand.getHandType(), HandTypes.Straight);
		
		hand = new PokerHand();
		hand.add(new Card(1, Suits.CLUBS));
		hand.add(new Card(2, Suits.CLUBS));
		hand.add(new Card(4, Suits.CLUBS));
		hand.add(new Card(3, Suits.CLUBS));
		hand.add(new Card(6, Suits.CLUBS));
		assertNotEquals(hand.getHandType(), HandTypes.Straight);
	}
	
	@Test
	void testFlush() {
		PokerHand hand = new PokerHand();
		hand.add(new Card(10, Suits.CLUBS));
		hand.add(new Card(5, Suits.CLUBS));
		hand.add(new Card(7, Suits.CLUBS));
		hand.add(new Card(2, Suits.CLUBS));
		hand.add(new Card(12, Suits.CLUBS));
		assertEquals(hand.getHandType(), HandTypes.Flush);
		
		hand = new PokerHand();
		hand.add(new Card(10, Suits.CLUBS));
		hand.add(new Card(5, Suits.DIAMONDS));
		hand.add(new Card(7, Suits.CLUBS));
		hand.add(new Card(2, Suits.CLUBS));
		hand.add(new Card(12, Suits.CLUBS));
		assertNotEquals(hand.getHandType(), HandTypes.Flush);
	}
	
	@Test
	void testFullHouse() {
		PokerHand hand = new PokerHand();
		hand.add(new Card(10, Suits.CLUBS));
		hand.add(new Card(10, Suits.DIAMONDS));
		hand.add(new Card(12, Suits.CLUBS));
		hand.add(new Card(12, Suits.DIAMONDS));
		hand.add(new Card(12, Suits.HEARTS));
		assertEquals(hand.getHandType(), HandTypes.FullHouse);
		
		hand = new PokerHand();
		hand.add(new Card(10, Suits.CLUBS));
		hand.add(new Card(5, Suits.DIAMONDS));
		hand.add(new Card(7, Suits.CLUBS));
		hand.add(new Card(2, Suits.CLUBS));
		hand.add(new Card(12, Suits.CLUBS));
		assertNotEquals(hand.getHandType(), HandTypes.FullHouse);
	}
	
	@Test
	void testFourOfAKind() {
		PokerHand hand = new PokerHand();
		hand.add(new Card(10, Suits.CLUBS));
		hand.add(new Card(5, Suits.CLUBS));
		hand.add(new Card(10, Suits.DIAMONDS));
		hand.add(new Card(10, Suits.SPADES));
		hand.add(new Card(10, Suits.HEARTS));
		assertEquals(hand.getHandType(), HandTypes.FourOfAKind);
		
		hand = new PokerHand();
		hand.add(new Card(10, Suits.CLUBS));
		hand.add(new Card(5, Suits.DIAMONDS));
		hand.add(new Card(10, Suits.DIAMONDS));
		hand.add(new Card(2, Suits.CLUBS));
		hand.add(new Card(10, Suits.SPADES));
		assertNotEquals(hand.getHandType(), HandTypes.FourOfAKind);
	}
	
	@Test
	void testStraightFlush() {
		PokerHand hand = new PokerHand();
		hand.add(new Card(9, Suits.CLUBS));
		hand.add(new Card(11, Suits.CLUBS));
		hand.add(new Card(10, Suits.CLUBS));
		hand.add(new Card(13, Suits.CLUBS));
		hand.add(new Card(12, Suits.CLUBS));
		assertEquals(hand.getHandType(), HandTypes.StraightFlush);
		
		hand = new PokerHand();
		hand.add(new Card(1, Suits.CLUBS));
		hand.add(new Card(11, Suits.CLUBS));
		hand.add(new Card(10, Suits.CLUBS));
		hand.add(new Card(13, Suits.CLUBS));
		hand.add(new Card(12, Suits.CLUBS));
		assertNotEquals(hand.getHandType(), HandTypes.StraightFlush);
	}
	
	@Test
	void testRoyalStraightFlush() {
		PokerHand hand = new PokerHand();
		hand.add(new Card(1, Suits.CLUBS));
		hand.add(new Card(11, Suits.CLUBS));
		hand.add(new Card(10, Suits.CLUBS));
		hand.add(new Card(13, Suits.CLUBS));
		hand.add(new Card(12, Suits.CLUBS));
		assertEquals(hand.getHandType(), HandTypes.RoyalStraightFlush);
		
		hand = new PokerHand();
		hand.add(new Card(9, Suits.CLUBS));
		hand.add(new Card(11, Suits.CLUBS));
		hand.add(new Card(10, Suits.CLUBS));
		hand.add(new Card(13, Suits.CLUBS));
		hand.add(new Card(12, Suits.CLUBS));
		assertNotEquals(hand.getHandType(), HandTypes.RoyalStraightFlush);
	}
	
	
	
	
	
}
