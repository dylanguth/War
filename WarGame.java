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
   private JButton button;
   private JLabel pic;
   private ImageIcon front,back;
   private String winner = "none";
   
   public WarGame()
   {
      super("Game of War");
      setLayout(new FlowLayout());
      button = new JButton("flip");
      button.addActionListener(new ButtonListener());
      add(button);
      
      front = new ImageIcon("aces.jpg");
      back = new ImageIcon("back.jpg");
      pic = new JLabel(back);     
      add(pic);
      
   
   
   }
   //class to handle button press
   class ButtonListener implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
         if (pic.getIcon() == back)
            pic.setIcon(front);
         else
            pic.setIcon(back);
      
      }
   }
   
   public String getWinner()
   {
      return winner;
   }
   
   public static void main(String[] args)
   {
      JFrame frame = new WarGame();
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.pack();
      frame.setVisible(true);
      
      CardPile upPile1, upPile2, downPile1, downPile2, middle;
      Card curr1, curr2;
      
      //Create a frame
      //add spots for the buttons and labels and images of the backs and fronts of the cards
      //labels: winner (of round and game), players, count, round
      //buttons: New Game, Next, War, 
      
      //create deck
      Deck deck = new Deck();
      
      //shuffle deck
      //deck.shuffle();
      
      //start deal
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
      //end deal
      int j=0;
      //start game of war 
      while(!upPile1.isEmpty()||!downPile1.isEmpty()&&!upPile2.isEmpty()||downPile2.isEmpty())
      {
         j++;
         System.out.println("round" + j);
         //pop at top of each stack and display card
         curr1 = upPile1.remove();
         curr2 = upPile2.remove();
   
         middle = new CardPile();
         //determine which card is higher
         
         //start war
         while (curr1.equals(curr2))
         {
            //store curr1 and curr2 in a middle pile
            middle.add(curr1,curr2);
   
            //start find winner
            if (upPile1.isEmpty())
            {
               if (downPile1.isEmpty())
               {
                  winner = "player2";
                  //quit game and announce winner
                  System.out.println("this.get");
                  
                  System.exit(0);
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
                  winner = "player1";
                  //quit game and announce winner
                  
                  System.out.println("Player 1 wins!");
                  
                  System.exit(0);
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
   
   
         }
         //end war
   
         if (curr1.greaterThan(curr2))
         {
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
               winner = "player2";
               //quit game and announce winner
               System.out.println("Player 1 wins!");
                  
               System.exit(0);
            }
            
            //while downPile has next push the popped cards from downpile into uppile
            while (!downPile1.isEmpty())
            {
               curr1 = downPile1.remove();
               upPile1.add(curr1);
            
            }
            // upPile1 = downPile1;
//             downPile1.removeAll(); //this changes the count of upPile1 to 0...not good. need to make it so it only removes all for downpile
            upPile1.shuffle();
         }
         
         if (upPile2.isEmpty())
         {
            if (downPile2.isEmpty())
            {
               winner = "player1";
               //quit game and announce winner
               System.out.println("Player 1 wins!");
                  
               System.exit(0);
            } 
            
            while (!downPile2.isEmpty())
            {
               curr2 = downPile2.remove();
               upPile2.add(curr2);
            
            }
            upPile2.shuffle();
         }
            //end find winner
         
      }
      String winMessage;
      if (winner == "player 1")
      {
         winMessage = "Player 1 wins!";
      }
      else if (winner == "player 2")
      {
         winMessage = "Player 2 wins!";
      }
      
   }

}