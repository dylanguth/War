//Dylan Languth
//CS110: Java
//Homework 10
//War card game


import java.util.Scanner;
import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class WarGame extends JFrame
{
   //declare all variables and initialize
   private String winner = "none";
   private static CardPile upPile1, upPile2, downPile1, downPile2, middle = new CardPile();
   private Card curr1 = new Card(0,0), curr2 = new Card(0,0);
   private static Deck deck = new Deck();
   private int j = 0;
   
   /**
   Constructor
   deals the cards to each upPile
   */
   public WarGame()
   {
      deal();  
   }
   
   public String battle()
   {
      //start battle
      if (!upPile1.isEmpty()||!downPile1.isEmpty()&&!upPile2.isEmpty()||downPile2.isEmpty())
      {
         j++;
         System.out.println("round " + j);
         //pop at top of each stack and display card
         curr1 = upPile1.remove();
         curr2 = upPile2.remove();

         //start war
         if (curr1.equals(curr2))
         {
            winner = "tie";
            System.out.println(curr1 + " is equal to " + curr2);
            //store curr1 and curr2 in a middle pile
            middle.add(curr1,curr2);
            System.out.println(curr1 + " and " + curr2 + " added to middle");
         }//end war
         //if curr1>curr2
         else if (curr1.greaterThan(curr2))
         {
            winner = "Player 1";
            System.out.println(curr1 + " is larger than " + curr2);
            downPile1.add(curr1, curr2);
            System.out.println(curr1 + " and " + curr2 + " added to downPile1");
            //add middle pile to downPile1
            while (!middle.isEmpty())
            {
               curr1 = middle.remove();
               downPile1.add(curr1);
               System.out.println(curr1 + " transferred to downPile1");
               
            }
   
         }
         //if curr2>curr1
         else if (curr2.greaterThan(curr1))
         {
            winner = "Player 2";
            System.out.println(curr2 + " is larger than " + curr1);
            System.out.println(curr1 + " and " + curr2 + " added to downPile2");
            downPile2.add(curr1, curr2);
            //add middle pile to downPile2
            while (!middle.isEmpty())
            {
               curr2 = middle.remove();
               downPile2.add(curr2);
               System.out.println(curr2 + " transferred to downPile2");
               
            }
   
         }
         
         //start find winner
         if (upPile1.isEmpty())
         {
            if (downPile1.isEmpty())
            {
               winner = "Player 2 wins!";
               //quit game and announce winner
               System.out.println(this.getWinner());
               return winner;
            }
            
            //while downPile has next push the popped cards from downpile into uppile
            while (!downPile1.isEmpty())
            {
               curr1 = downPile1.remove();
               upPile1.add(curr1);
            
            }
            upPile1.shuffle();
         }
         
         if (upPile2.isEmpty())
         {
            if (downPile2.isEmpty())
            {
               winner = "Player 1 wins!";
               //quit game and announce winner
               System.out.println(this.getWinner());
               return winner;
            } 
            
            while (!downPile2.isEmpty())
            {
               curr2 = downPile2.remove();
               upPile2.add(curr2);
            
            }
            upPile2.shuffle();
         }
         //end find winner
         
      }//end battle
      System.out.println("Up1: " + getUpPile1().getCount() + "...Down1: " + getDownPile1().getCount() + "...Up2: " + getUpPile2().getCount() + "...Down2: " + getDownPile2().getCount() + "...Middle: " + getMiddlePile().getCount());
      return winner;

   
   }
   
   public String getWinner()
   {
      return winner;
   }
   
   public Card getCurr1()
   {
      return curr1;
   }
   
   public Card getCurr2()
   {
      return curr2;
   }
   
   private void setWinner(String winner)
   {
      this.winner = winner;
   
   }
   
   public CardPile getUpPile1()
   {
      return upPile1;
   
   }
   
   public CardPile getUpPile2()
   {
      return upPile2;
   
   }
   
   public CardPile getDownPile1()
   {
      return downPile1;
   
   }
   
   public CardPile getDownPile2()
   {
      return downPile2;
   
   }
   
   public CardPile getMiddlePile()
   {
      return middle;
   }
   
   public String war()
   {
      
      //start find winner
      if (upPile1.isEmpty())
      {
         if (downPile1.isEmpty())
         {
            winner = "Player 2 wins!";
            //quit game and announce winner
            System.out.println(this.getWinner());
            return winner;
         }
         
         while (!downPile1.isEmpty())
         {
            curr1 = downPile1.remove();
            upPile1.add(curr1);
         
         }
         upPile1.shuffle();
      }
      
      if (upPile2.isEmpty())
      {
         if (downPile2.isEmpty())
         {
            winner = "Player 1 wins!";
            //quit game and announce winner
            System.out.println(this.getWinner());
            return winner;
         }
         
         while (!downPile2.isEmpty())
         {
            curr2 = downPile2.remove();
            upPile2.add(curr2);
         
         }
         upPile2.shuffle();
      }
      //end find winner
      
      //remove a card from each uppile and assign them curr1 and curr2
      curr1 = upPile1.remove();
      curr2 = upPile2.remove();
      if (curr1.equals(curr2))
      {
         winner = "tie";
         System.out.println(curr1 + " is equal to " + curr2);
         //store curr1 and curr2 in a middle pile
         middle.add(curr1,curr2);
         System.out.println(curr1 + " and " + curr2 + " added to middle");
      
      }
      else if (curr1.greaterThan(curr2))
      {
         winner = "Player 1";
         System.out.println(curr1 + " is larger than " + curr2);
         downPile1.add(curr1, curr2);
         System.out.println(curr1 + " and " + curr2 + " added to downPile1");
         while (!middle.isEmpty())
         {
            curr1 = middle.remove();
            downPile1.add(curr1);
            System.out.println(curr1 + " transferred to downPile1");
         }
      }
      else
      {
         winner = "Player 2";
         System.out.println(curr2 + " is larger than " + curr1);
         downPile2.add(curr1, curr2);
         System.out.println(curr1 + " and " + curr2 + " added to downPile2");
         while (!middle.isEmpty())
         {
            curr2 = middle.remove();
            downPile2.add(curr2);
            System.out.println(curr2 + " transferred to downPile2");
         }

      }
      //start find winner
      if (upPile1.isEmpty())
      {
         if (downPile1.isEmpty())
         {
            winner = "Player 2 wins!";
            //quit game and announce winner
            System.out.println(this.getWinner());
            return winner;

         }
         
         while (!downPile1.isEmpty())
         {
            curr1 = downPile1.remove();
            upPile1.add(curr1);
         
         }
         upPile1.shuffle();
      }
      
      if (upPile2.isEmpty())
      {
         if (downPile2.isEmpty())
         {
            winner = "Player 1 wins!";
            //quit game and announce winner
            
            System.out.println(this.getWinner());
            return winner;
            //System.exit(0);
         }
         
         while (!downPile2.isEmpty())
         {
            curr2 = downPile2.remove();
            upPile2.add(curr2);
         
         }
         upPile2.shuffle();
      }
      //end find winner

      
      System.out.println("Up1: " + getUpPile1().getCount() + "...Down1: " + getDownPile1().getCount() + "...Up2: " + getUpPile2().getCount() + "...Down2: " + getDownPile2().getCount() + "...Middle: " + getMiddlePile().getCount());
      return winner;
      
      
   
   }

   public void deal()
   {
      //create a new deck and new card piles 
      deck = new Deck();
      upPile1 = new CardPile();
      upPile2 = new CardPile();
      downPile1 = new CardPile();
      downPile2 = new CardPile();
      middle = new CardPile();
      
      //shuffle deck
      deck.shuffle();
      while (!(deck.isEmpty()))
      {
         upPile1.add(deck.dealCard());
         upPile2.add(deck.dealCard());
      }

   
   }
   
}