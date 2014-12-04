//Dylan Languth
//CS110: Java
//Homework 5
//Problem 3: Card class


import java.util.Scanner;
import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

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
   private final ImageIcon back = new ImageIcon("back.jpg"),
      s1 = new ImageIcon("aces.jpg"),
      s2 = new ImageIcon("2s.jpg"),
      s3 = new ImageIcon("3s.jpg"),
      s4 = new ImageIcon("4s.jpg"),
      s5 = new ImageIcon("5s.jpg"),
      s6 = new ImageIcon("6s.jpg"),
      s7 = new ImageIcon("7s.jpg"),
      s8 = new ImageIcon("8s.jpg"),
      s9 = new ImageIcon("9s.jpg"),
      s10 = new ImageIcon("10s.jpg"),
      sj = new ImageIcon("jacks.jpg"),
      sq = new ImageIcon("queens.jpg"),
      sk = new ImageIcon("kings.jpg"),
      c1 = new ImageIcon("acec.jpg"),
      c2 = new ImageIcon("2c.jpg"),
      c3 = new ImageIcon("3c.jpg"),
      c4 = new ImageIcon("4c.jpg"),
      c5 = new ImageIcon("5c.jpg"),
      c6 = new ImageIcon("6c.jpg"),
      c7 = new ImageIcon("7c.jpg"),
      c8 = new ImageIcon("8c.jpg"),
      c9 = new ImageIcon("9c.jpg"),
      c10 = new ImageIcon("10c.jpg"),
      cj = new ImageIcon("jackc.jpg"),
      cq = new ImageIcon("queenc.jpg"),
      ck = new ImageIcon("kingc.jpg"),
      d1 = new ImageIcon("aced.jpg"),
      d2 = new ImageIcon("2d.jpg"),
      d3 = new ImageIcon("3d.jpg"),
      d4 = new ImageIcon("4d.jpg"),
      d5 = new ImageIcon("5d.jpg"),
      d6 = new ImageIcon("6d.jpg"),
      d7 = new ImageIcon("7d.jpg"),
      d8 = new ImageIcon("8d.jpg"),
      d9 = new ImageIcon("9d.jpg"),
      d10 = new ImageIcon("10d.jpg"),
      dj = new ImageIcon("jackd.jpg"),
      dq = new ImageIcon("queend.jpg"),
      dk = new ImageIcon("kingd.jpg"),
      h1 = new ImageIcon("aceh.jpg"),
      h2 = new ImageIcon("2h.jpg"),
      h3 = new ImageIcon("3h.jpg"),
      h4 = new ImageIcon("4h.jpg"),
      h5 = new ImageIcon("5h.jpg"),
      h6 = new ImageIcon("6h.jpg"),
      h7 = new ImageIcon("7h.jpg"),
      h8 = new ImageIcon("8h.jpg"),
      h9 = new ImageIcon("9h.jpg"),
      h10 = new ImageIcon("10h.jpg"),
      hj = new ImageIcon("jackh.jpg"),
      hq = new ImageIcon("queenh.jpg"),
      hk = new ImageIcon("kingh.jpg");
   
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
      if (s > 4 || s < 0)
         System.out.println(s + " is not a valid suit assignment.");
      if (r > 13 || r < 0)
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
      else if (suit == 0)
         suitName = "Back";
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
      else if (rank == 0)
         rankName = "Back";
      else if (rank >= 2 && rank <= 10)
      {
         str = rank + " of " + suitName;
         return str;
      }
      else
         rankName = "Unknown rank";
      
      str2 = rankName + " of " + suitName;
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
   
   public ImageIcon toImage()
   {
      if (suit == 1)
      {
         if (rank == 1)
            return s1;
         else if (rank == 2)
            return s2;
         else if (rank == 3)
            return s3;
         else if (rank == 4)
            return s4;
         else if (rank == 5)
            return s5;
         else if (rank == 6)
            return s6;
         else if (rank == 7)
            return s7;
         else if (rank == 8)
            return s8;
         else if (rank == 9)
            return s9;
         else if (rank == 10)
            return s10;
         else if (rank == 11)
            return sj;
         else if (rank == 12)
            return sq;
         else if (rank == 13)
            return sk;
         else 
            return back;
      }
      else if (suit == 2)
      {
         if (rank == 1)
            return c1;
         else if (rank == 2)
            return c2;
         else if (rank == 3)
            return c3;
         else if (rank == 4)
            return c4;
         else if (rank == 5)
            return c5;
         else if (rank == 6)
            return c6;
         else if (rank == 7)
            return c7;
         else if (rank == 8)
            return c8;
         else if (rank == 9)
            return c9;
         else if (rank == 10)
            return c10;
         else if (rank == 11)
            return cj;
         else if (rank == 12)
            return cq;
         else if (rank == 13)
            return ck;
         else 
            return back;
      }
      else if (suit == 3)
      {
         if (rank == 1)
            return h1;
         else if (rank == 2)
            return h2;
         else if (rank == 3)
            return h3;
         else if (rank == 4)
            return h4;
         else if (rank == 5)
            return h5;
         else if (rank == 6)
            return h6;
         else if (rank == 7)
            return h7;
         else if (rank == 8)
            return h8;
         else if (rank == 9)
            return h9;
         else if (rank == 10)
            return h10;
         else if (rank == 11)
            return hj;
         else if (rank == 12)
            return hq;
         else if (rank == 13)
            return hk;
         else 
            return back;
      }
      else if (suit == 4)
      {
         if (rank == 1)
            return d1;
         else if (rank == 2)
            return d2;
         else if (rank == 3)
            return d3;
         else if (rank == 4)
            return d4;
         else if (rank == 5)
            return d5;
         else if (rank == 6)
            return d6;
         else if (rank == 7)
            return d7;
         else if (rank == 8)
            return d8;
         else if (rank == 9)
            return d9;
         else if (rank == 10)
            return d10;
         else if (rank == 11)
            return dj;
         else if (rank == 12)
            return dq;
         else if (rank == 13)
            return dk;
         else 
            return back;
      }
      else
         return back;
   
   }


   
}