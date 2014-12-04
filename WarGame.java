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
   public Frame frame;
   private JButton button;
   private JLabel pic;
   private ImageIcon front,back;
   private String winner = "none";
   private static CardPile upPile1, upPile2, downPile1, downPile2, middle;
   private Card curr1 = new Card(0,0), curr2 = new Card(0,0);
   private static Deck deck = new Deck();
   private int j = 0;
   
   public WarGame()
   {//start warGame
      deal();
      
            
   }//end wargame
   
   public String battle()
   {
//       while(!upPile1.isEmpty()||!downPile1.isEmpty()&&!upPile2.isEmpty()||downPile2.isEmpty())
//       {//start battle
      if (!upPile1.isEmpty()||!downPile1.isEmpty()&&!upPile2.isEmpty()||downPile2.isEmpty())
      {
         j++;
         System.out.println("round " + j);
         //pop at top of each stack and display card
         curr1 = upPile1.remove();
         curr2 = upPile2.remove();
   
         middle = new CardPile();
         //determine which card is higher
         
         //start war
         if (curr1.equals(curr2))
         {
            winner = "tie";
            return winner;
         }
         //end war
   
         if (curr1.greaterThan(curr2))
         {
            winner = "Player 1";
            downPile1.add(curr1, curr2);
            //add middle pile too
            while (!middle.isEmpty())
            {
               curr1 = middle.remove();
               downPile1.add(curr1);
               
            }
   
         }
   
         else
         {
            winner = "Player 2";
            downPile2.add(curr1, curr2);
            //add middle pile too
            while (!middle.isEmpty())
            {
               curr2 = middle.remove();
               downPile2.add(curr2);
               
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
               //System.exit(0);
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
         
      }//end battle
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
   
   public String war()
   {
      //store curr1 and curr2 in a middle pile
      middle.add(curr1,curr2);

      //start find winner
      if (upPile1.isEmpty())
      {
         if (downPile1.isEmpty())
         {
            winner = "Player 2 wins!";
            //quit game and announce winner
            System.out.println(this.getWinner());
            return winner;
            //System.exit(0);
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
      
      //remove a card from each uppile and assign them curr1 and curr2
      curr1 = upPile1.remove(); //can't do this if one of the players has no cards left
      curr2 = upPile2.remove();
      if (curr1.greaterThan(curr2))
      {
         winner = "Player 1";

      }
      else
      {
         winner = "Player 2";

      }
      return winner;
   
   }

   public void deal()
   {
      //while theres still cards left, deal a card to each spot in the arraylist 
      upPile1 = new CardPile(); //implements deck constructor before cardPile constructor. ct in deck is always 52, but count can change in pile
      upPile2 = new CardPile();
      downPile1 = new CardPile();
      downPile2 = new CardPile();
      
      //shuffle deck
      deck.shuffle();
      while (!(deck.isEmpty()))
      {
         upPile1.add(deck.dealCard());
         upPile2.add(deck.dealCard());
      }

   
   }
   
   public static void main(String[] args)
   {
      //create deck
//       deck = new Deck();
      
      //create a frame
//       JFrame frame = new Frame("Game of War");
//       frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//       frame.pack();
//       frame.setVisible(true);
      //start game >>>>>Deal in constructor (warGame)
      WarGame game = new WarGame();
      //end game
             
   }
}