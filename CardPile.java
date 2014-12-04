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
   private int count; //count can't be static. static means it belongs to class, not the object
   private ArrayList<Card> pile;
   private Card top;
   
   private StackReferenceBased stack = new StackReferenceBased();
   
   public CardPile() 
   {
      //create an empty arraylist of cards called pile
      pile = new ArrayList<Card>();

      count=0;
   }
   
   public CardPile(ArrayList<Card> c1)
   {
      //create an arraylist of cards called pile
      //create a stack out of the arraylist
      count=c1.size();
      pile = c1;
      //shuffle cards
      shuffle();
      /////int i = 0;
      for(int i=0; i<count; i++)
      /////while(pile.hasNext())
      {
         stack.push(pile.get(i));
         
      }
      
   }
   
   public void add(Card c1)
   {
      pile.add(c1);
      
      stack.push(c1);
      
      count++;
      
   }
   
   public void add(Card c1, Card c2)
   {
      pile.add(c1);
      pile.add(c2);
      
      stack.push(c1);
      stack.push(c2);
      
      count+=2;
   
   }
   
   public Card remove()
   {
      top = (Card)stack.pop();
      count--;
      return top; 
      
   }
   
   public void removeAll()
   {
      stack.popAll();
      count = 0;
   
   }
   
   public int getCount()
   {
      return count;
   
   }
   
   public void shuffle()
   {
      //pop entire stack into arraylist
      while (!stack.isEmpty())
      {
         top = (Card)stack.pop();
         pile.add(top);
      
      }
   
      //Deck's shuffle method
      int randNum;
      Card temp;
      Random r = new Random();
      for (int i = 0; i < count; i++)
      {
         randNum = r.nextInt(count);
         temp = pile.get(i);
         pile.set(i,pile.get(randNum));
         pile.set(randNum,temp);
         //push each card into stack
         stack.push(pile.get(i));
      }
      
   }
   
   public boolean isEmpty()
   {
      return (count == 0);
   }

}