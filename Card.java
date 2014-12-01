//Dylan Languth
//CS110: Java
//Homework 5
//Problem 3: Card class


import java.util.Scanner;
import java.io.*;

public class Card
{
   //Assign a value to non-numerical ranks and suits
   public static final int SPADES = 1;
   public static final int CLUBS = 2;
   public static final int HEARTS = 3;
   public static final int DIAMONDS = 4;
   public static final int ACE = 1;
   public static final int JACK = 11;
   public static final int QUEEN = 12;
   public static final int KING = 13;
   
   //declare variables
   private final int rank, suit;
   private static String rankName, suitName;
   
   /**
   Constructor
   creates a card with a suit and a rank
   @param suit The card's suit
   @param rank The card's rank
   */
   public Card(int s, int r)
   {
      if (s > 4 || s < 1)
         System.out.println(s + " is not a valid suit assignment.");
      if (r > 13 || r < 1)
         System.out.println(r + " is not a valid suit assignment.");

      suit = s;
      rank = r;
      
   }
   
   /**
   @return suit The card's suit
   */
   public int getSuit()
   {
      return suit;
   
   }
   
   /**
   @return rank The card's rank
   */
   public int getRank()
   {
      return rank;
   
   }
   
   /**
   returns a message stating what the card name is
   @return str Card name if rank is numerical
   @return str2 Card name if rank is a name
   */
   public String toString()
   {
      String str, str2;
      
      if (suit == 1)
         suitName = "Spades";
      else if (suit == 2)
         suitName = "Clubs";
      else if (suit == 3)
         suitName = "Hearts";
      else if (suit == 4)
         suitName = "Diamonds";
      else
         suitName = "Unknown suit";
         
      if (rank == 1)
         rankName = "Ace";
      else if (rank == 11)
         rankName = "Jack";
      else if (rank == 12)
         rankName = "Queen";
      else if (rank == 13)
         rankName = "King";
      else if (rank >= 2 && rank <= 10)
      {
         str = "Your card is the " + rank + " of " + suitName;
         return str;
      }
      else
         rankName = "Unknown rank";
      
      str2 = "Your card is the " + rankName + " of " + suitName;
      return str2;
   
   }
   
   /**
   allows user to see if the card rank is the same as another card
   @param otherCard A second card
   @return boolean 
   */
   public boolean equals(Card otherCard)
   {
      if (rank == otherCard.rank)
         return true;
      return false;
   
   }
   
   public boolean greaterThan(Card otherCard)
   {
      if (rank >= otherCard.rank)
         return true;
      return false;
   
   }
   
   public boolean lessThan(Card otherCard)
   {
      if (rank <= otherCard.rank)
         return true;
      return false;
   
   }


   
}