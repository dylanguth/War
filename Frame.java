import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Frame extends JFrame
{
   //declare and initialize variables
   private WarGame game;
   private String winner;
   private int countNum1 = 26, countNum2 = 26, warPile = 0, middle = 0;
   private JButton next, war, newGame;
   private JLabel downPic1, downPic2, upPic1, upPic2, result, player1, player2, count1, count2, round, middleCount;
   //create many different panels to organize menu
   private JPanel panel = new JPanel(new BorderLayout()),
            p = new JPanel(new BorderLayout()),
            p1 = new JPanel(new BorderLayout()),
            p2 = new JPanel(new BorderLayout()),
            pTop = new JPanel(new BorderLayout()),
            pBot = new JPanel(new BorderLayout()),
            pUp = new JPanel(new BorderLayout());
   private final ImageIcon back = new ImageIcon("back.jpg");
   private int roundNum = 0;
      
   public Frame(String s)
   {
      super(s);
      game = new WarGame();
      
      setLayout(new BorderLayout());
      
      //create buttons
      next = new JButton("Next");
      war = new JButton("War");
      newGame = new JButton("New Game");
      
      //add an action to the buttons
      next.addActionListener(new nextButtonListener());
      war.addActionListener(new warButtonListener());
      newGame.addActionListener(new newGameButtonListener());
      
      //add buttons to frame
      pBot.add(next,BorderLayout.CENTER);
      pBot.add(war,BorderLayout.WEST);
      pBot.add(newGame,BorderLayout.EAST);
      
      //initialize the main menu screen
      //make default picture the back of a card
      downPic1 = new JLabel(back); 
      downPic2 = new JLabel(back); 
      upPic1 = new JLabel(game.getCurr1().toImage()); 
      upPic2 = new JLabel(game.getCurr2().toImage()); 
      result = new JLabel("", SwingConstants.CENTER); 
      player1 = new JLabel("Player 1");
      player2 = new JLabel("Player 2");
      count1 = new JLabel("count: " + countNum1);
      count2 = new JLabel("count: " + countNum2);
      middleCount = new JLabel("middle count: " + middle, SwingConstants.CENTER);
      round =  new JLabel("round " + roundNum, SwingConstants.CENTER);
      
      //set the font for all the labels and buttons
      result.setFont(result.getFont().deriveFont(50.0f));
      round.setFont(round.getFont().deriveFont(50.0f));
      player1.setFont(player1.getFont().deriveFont(30.0f));
      player2.setFont(player2.getFont().deriveFont(30.0f));
      count1.setFont(count1.getFont().deriveFont(30.0f));
      count2.setFont(count2.getFont().deriveFont(30.0f));
      next.setFont(next.getFont().deriveFont(30.0f));
      war.setFont(war.getFont().deriveFont(30.0f));
      newGame.setFont(newGame.getFont().deriveFont(30.0f));
      player2.setFont(player2.getFont().deriveFont(30.0f));
      
      //add the labels to the frames
      p1.add(downPic1,BorderLayout.WEST);
      p1.add(downPic2,BorderLayout.EAST);
      pUp.add(upPic1,BorderLayout.WEST);
      pUp.add(upPic2,BorderLayout.EAST);
      pUp.add(middleCount,BorderLayout.CENTER);
      p2.add(result,BorderLayout.CENTER);
      pTop.add(player1,BorderLayout.WEST);
      pTop.add(player2,BorderLayout.EAST);
      p2.add(count1,BorderLayout.WEST);
      p2.add(count2,BorderLayout.EAST);
      pTop.add(round,BorderLayout.CENTER);
      
      //add all the panels together
      p1.add(pUp,BorderLayout.CENTER);
      p.add(p1,BorderLayout.NORTH);
      p.add(p2,BorderLayout.CENTER);
      panel.add(pTop,BorderLayout.NORTH);
      panel.add(p,BorderLayout.CENTER);
      panel.add(pBot,BorderLayout.SOUTH);
      
      //add panel to frame and pack the frame
      war.setVisible(false);
      add(panel);
      pack();
      
   
   }
   
   // class to decide what the next button does
   private class nextButtonListener implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
         //reference on CW for when the next button is pushed
         System.out.println("next");
         roundNum++;
         round.setText("round: " + roundNum);
         
         //battle
         winner = game.battle();
         
         //change pictures of cards
         upPic1.setIcon(game.getCurr1().toImage());
         upPic2.setIcon(game.getCurr2().toImage());
         
         
         if (winner == "tie")
         {
            //war
            //get the count for each pile and display on GUI
            countNum1 = game.getUpPile1().getCount() + game.getDownPile1().getCount();
            countNum2 = game.getUpPile2().getCount() + game.getDownPile2().getCount();
            middle = game.getMiddlePile().getCount();
            middleCount.setText("Middle Count: " + middle);
            count1.setText("Count: " + countNum1);
            count2.setText("Count: " + countNum2);
            result.setText("WAR!");
            //hide next button and show war button
            next.setVisible(false);
            war.setVisible(true);
         }   
         else if (winner == "Player 1")
         {
            //player 1 wins round
            //get the count for each pile and display on GUI
            countNum1 = game.getUpPile1().getCount() + game.getDownPile1().getCount();
            countNum2 = game.getUpPile2().getCount() + game.getDownPile2().getCount();
            middle = game.getMiddlePile().getCount();
            middleCount.setText("Middle Count: " + middle);
            count1.setText("Count: " + countNum1);
            count2.setText("Count: " + countNum2);
            result.setText("Player 1 wins the round");
            //hide war button and show next button
            next.setVisible(true);
            war.setVisible(false);
         }   
         else if (winner == "Player 2")
         {
            //player 2 wins the round
            //get the count for each pile and display on GUI
            countNum1 = game.getUpPile1().getCount() + game.getDownPile1().getCount();
            countNum2 = game.getUpPile2().getCount() + game.getDownPile2().getCount();
            middle = game.getMiddlePile().getCount();
            middleCount.setText("Middle Count: " + middle);
            count1.setText("Count: " + countNum1);
            count2.setText("Count: " + countNum2);
            result.setText("Player 2 wins the round");
            //hide war button and show next button
            next.setVisible(true);
            war.setVisible(false);
            
         }
         else if (winner == "Player 1 wins!")
         {
            //player 1 wins game
            //get the count for each pile and display on GUI
            countNum1 = game.getUpPile1().getCount() + game.getDownPile1().getCount();
            countNum2 = game.getUpPile2().getCount() + game.getDownPile2().getCount();
            middle = game.getMiddlePile().getCount();
            middleCount.setText("Middle Count: " + middle);
            count1.setText("Count: " + countNum1);
            count2.setText("Count: " + countNum2);
            result.setText(winner);
            //hide both next and war buttons
            next.setVisible(false);
            war.setVisible(false);
         }
         else if (winner == "Player 2 wins!")
         {
            //player 2 wins game
            //get the count for each pile and display on GUI
            countNum1 = game.getUpPile1().getCount() + game.getDownPile1().getCount();
            countNum2 = game.getUpPile2().getCount() + game.getDownPile2().getCount();
            middle = game.getMiddlePile().getCount();
            middleCount.setText("Middle Count: " + middle);
            count1.setText("Count: " + countNum1);
            count2.setText("Count: " + countNum2);
            result.setText(winner);
            //hide both next and war buttons
            next.setVisible(false);
            war.setVisible(false);
         }
   
      }
   
   }
   
   //class that decides what the war button does
   private class warButtonListener implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
         round.setText("round: " + roundNum);
         System.out.println("WAR");
         
         winner = game.war();
         
         upPic1.setIcon(game.getCurr1().toImage());
         upPic2.setIcon(game.getCurr2().toImage());
         
         if (winner == "tie")
         {
            //war
            countNum1 = game.getUpPile1().getCount() + game.getDownPile1().getCount();
            countNum2 = game.getUpPile2().getCount() + game.getDownPile2().getCount();
            middle = game.getMiddlePile().getCount();
            middleCount.setText("Middle Count: " + middle);
            count1.setText("Count: " + countNum1);
            count2.setText("Count: " + countNum2);
            result.setText("WAR!");
            next.setVisible(false);
            war.setVisible(true);
            
         }   
         else if (winner == "Player 1")
         {
            //player 1 wins round
            countNum1 = game.getUpPile1().getCount() + game.getDownPile1().getCount();
            countNum2 = game.getUpPile2().getCount() + game.getDownPile2().getCount();
            middle = game.getMiddlePile().getCount();
            middleCount.setText("Middle Count: " + middle);
            count1.setText("Count: " + countNum1);
            count2.setText("Count: " + countNum2);
            result.setText("Player 1 wins the war");
            next.setVisible(true);
            war.setVisible(false);
         }   
         else if (winner == "Player 2")
         {
            //player 2 wins the round
            countNum1 = game.getUpPile1().getCount() + game.getDownPile1().getCount();
            countNum2 = game.getUpPile2().getCount() + game.getDownPile2().getCount();
            middle = game.getMiddlePile().getCount();
            middleCount.setText("Middle Count: " + middle);
            count1.setText("Count: " + countNum1);
            count2.setText("Count: " + countNum2);
            result.setText("Player 2 wins the war");
            next.setVisible(true);
            war.setVisible(false);
            
         }
         else if (winner == "Player 1 wins!")
         {
            //player 1 wins game
            countNum1 = game.getUpPile1().getCount() + game.getDownPile1().getCount();
            countNum2 = game.getUpPile2().getCount() + game.getDownPile2().getCount();
            middle = game.getMiddlePile().getCount();
            middleCount.setText("Middle Count: " + middle);
            count1.setText("Count: " + countNum1);
            count2.setText("Count: " + countNum2);
            result.setText(winner);
            next.setVisible(false);
            war.setVisible(false);
            
         }
         else if (winner == "Player 2 wins!")
         {
            //player 2 wins game
            countNum1 = game.getUpPile1().getCount() + game.getDownPile1().getCount();
            countNum2 = game.getUpPile2().getCount() + game.getDownPile2().getCount();
            middle = game.getMiddlePile().getCount();
            middleCount.setText("Middle Count: " + middle);
            count1.setText("Count: " + countNum1);
            count2.setText("Count: " + countNum2);
            result.setText(winner);
            next.setVisible(false);
            war.setVisible(false);
         }
   
      }
   
   }
   
   //class that decides what new game button does
   private class newGameButtonListener implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
         //create a new frame
         Frame frame = new Frame("Game of War");
         frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         frame.pack();
         frame.setSize(1000,600);
         frame.setVisible(true);
      }
   
   }
   
   public static void main(String [] args)
   {
      //create frame
      Frame frame = new Frame("Game of War");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.pack();
      frame.setSize(1000,600);
      frame.setVisible(true);
   
   }


}