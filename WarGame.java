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
      
      //peek/pop at top of each stack and display card
      Card curr1 = upPile1.pop();
      Card curr2 = upPile2.pop();
      
      //determine which card is higher
      if (curr1.equals(curr2))
         war();
      else if (curr1.greaterThan(curr2))
      {
         downPile1.add(curr1, curr2);
      
      }
      
      
      
   }

}