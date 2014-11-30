//Dylan Languth
//CS110: Java
//Homework 
//Problem 


import java.util.Scanner;
import java.io.*;
import java.util.ArrayList;
import java.util.Random;

public class CardPile extends Deck
{
   public static int cardsInPile = 26;
   private int ct;
   private ArrayList<Card> pile;
   
   private StackReferenceBased stack = new StackReferenceBased();
   
   public CardPile()
   {
      //create an empty arraylist of cards called pile
      pile = new ArrayList<Card>();
      
      //ct=number of cards in pile
      ct=cardsInPile;
   }
   
   public CardPile(ArrayList<Card> c1)
   {
      //create an arraylist of cards called pile
      //create a stack out of the arraylist
      ct=cardsInPile;
      pile = c1;
      //shuffle cards
      shuffle();
      /////int i = 0;
      for(int i=0; i<ct; i++)
      /////while(pile.hasNext())
      {
         stack.push(pile.get(i));
         
      }
      
   }
   
   public void add(Card c1)
   {
      pile.add(c1);
      
      stack.push(c1);
      
      ct++;
      
   }
   
   public void add(Card c1, Card c2)
   {
      pile.add(c1);
      pile.add(c2);
      
      stack.push(c1);
      stack.push(c2);
      
      ct+=2;
   
   }
   
   public void add(Card c1, Card c2, Card c3, Card c4)
   {
      pile.add(c1);
      pile.add(c2);
      pile.add(c3);
      pile.add(c4);
      
      stack.push(c1);
      stack.push(c2);
      stack.push(c3);
      stack.push(c4);
      
      ct+=4;
   
   }
   
   public void shuffle()
   {
      //pop entire stack into arraylist
      
   
      //Deck's shuffle method
      int randNum;
      Card temp;
      Random r = new Random();
      for (int i = 0; i < ct; i++)
      {
         randNum = r.nextInt(ct);
         temp = pile.get(i);
         pile.set(i,pile.get(randNum));
         pile.set(randNum,temp);
      }
      
      //push entire arraylist back into pile
      
   }
   
   
//    public void freshDeck()
//    {
//       deck = new Card[CardsInPile];
//       for (int r = Card.ACE; r<=Card.KING;r++)
//       {
//          for (int s=Card.SPADES;s<=Card.CLUBS;s++)
//          {
//             deck[ct]=new Card(r,s);
//             ct = ct + 1;
//          }
//       }
//      
//    
//    }

}