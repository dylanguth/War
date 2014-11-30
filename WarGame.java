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
   public static CardPile War()
   {
      
   
   }
   
   public static void main(String[] args)
   {
      
      //Create a frame
      //add spots for the buttons and labels
      
      //create deck
      Deck deck = new Deck();
      
      //shuffle deck
      deck.shuffle();
      
      //start deal
      //while theres still cards left, deal a card to each spot in the arraylist 
      CardPile upPile1 = new CardPile();
      CardPile upPile2 = new CardPile();
      CardPile downPile1 = new CardPile();
      CardPile downPile2 = new CardPile();
      
      while (!(deck.isEmpty()))
      {
         upPile1.add(deck.dealCard());
         upPile2.add(deck.dealCard());
      }
      //end deal
      
      //start game of war >>while(!upPile1.isEmpty()||!downPile1.isEmpty()&&!upPile2.isEmpty()||downPile2.isEmpty())
      //peek/pop at top of each stack and display card
      Card curr1 = upPile1.remove();
      Card curr2 = upPile2.remove();
      
      CardPile middle = new CardPile();
      //determine which card is higher
      while (curr1.equals(curr2))
      {
         //store curr1 and curr2 in a middle pile
         middle.add(curr1,curr2);
         
         if (upPile1.isEmpty())
         {
            if (downPile1.isEmpty())
            {
               winner = player1;
               return winner;
            }
            upPile1 = downPile1;
            upPile1.shuffle();
         }   
         //remove a card from each uppile and assign them curr1 and curr2
         curr1 = upPile1.remove();
         curr2 = upPile2.remove();
         //if a pile is empty, make entire downpile into upPile
         //if both piles are empty
         
      
      }
      
      if (curr1.greaterThan(curr2))
      {
         downPile1.add(curr1, curr2);
      
      }
      
      else 
      {
         downPile2.add(curr1, curr2);
      
      }
      
      
      
   }

}