import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Frame extends JFrame
{
   private WarGame game;
   private String winner;
   private int countNum1 = 26, countNum2 = 26, warPile = 0, middle = 0;
   private JButton next, war, newGame;
   private JLabel downPic1, downPic2, upPic1, upPic2, result, player1, player2, count1, count2, round, middleCount;
   private JPanel panel = new JPanel(new BorderLayout()),
            p = new JPanel(new BorderLayout()),
            p1 = new JPanel(new BorderLayout()),
            p2 = new JPanel(new BorderLayout()),
            pTop = new JPanel(new BorderLayout()),
            pBot = new JPanel(new BorderLayout()),
            pUp = new JPanel(new BorderLayout());
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
   private int roundNum = 0;
      
   public Frame(String s)
   {
      super(s);
      game = new WarGame();
      
      //create frame with title "s"
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
      //add picture
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
      
      //result.setVisible(false);
      war.setVisible(false);
      add(panel);
      pack();
      
   
   }
   
   private class nextButtonListener implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
         System.out.println("next");
         roundNum++;
         round.setText("round: " + roundNum);
         winner = game.battle();
         
         upPic1.setIcon(game.getCurr1().toImage());
         upPic2.setIcon(game.getCurr2().toImage());
         
         
         if (winner == "tie")
         {
            //war
//             countNum1--;
//             countNum2--;
//             warPile+=2;
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
//             countNum1++;
//             countNum2--;
//             warPile = 0;
            countNum1 = game.getUpPile1().getCount() + game.getDownPile1().getCount();
            countNum2 = game.getUpPile2().getCount() + game.getDownPile2().getCount();
            middle = game.getMiddlePile().getCount();
            middleCount.setText("Middle Count: " + middle);
            count1.setText("Count: " + countNum1);
            count2.setText("Count: " + countNum2);
            result.setText("Player 1 wins the round");
            next.setVisible(true);
            war.setVisible(false);
         }   
         else if (winner == "Player 2")
         {
            //player 2 wins the round
//             countNum1--;
//             countNum2++;
//             warPile = 0;
            countNum1 = game.getUpPile1().getCount() + game.getDownPile1().getCount();
            countNum2 = game.getUpPile2().getCount() + game.getDownPile2().getCount();
            middle = game.getMiddlePile().getCount();
            middleCount.setText("Middle Count: " + middle);
            count1.setText("Count: " + countNum1);
            count2.setText("Count: " + countNum2);
            result.setText("Player 2 wins the round");
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
         //else
            //no winner?
   
      }
   
   }
   
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
//             countNum1--;
//             countNum2--;
//             warPile+=2;
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
//             countNum1+=(warPile+1);
//             countNum2--;
//             warPile = 0;
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
//             countNum1--;
//             countNum2+=(warPile+1);
//             warPile = 0;
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
         //else
            //no winner?
   
      }
   
   }
   
   private class newGameButtonListener implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
         Frame frame = new Frame("Game of War");
         frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         frame.pack();
         frame.setSize(1000,600);
         frame.setVisible(true);
      }
   
   }
   
   public void setRoundNum(int j)
   {
      roundNum = j;
   }
   
   // public class Panel extends JPanel implements ActionListener
//    {
//       //public panel
//    
//    }
   
   public static void main(String [] args)
   {
  
      Frame frame = new Frame("Game of War");
      //frame.setRoundNum(1);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.pack();
      frame.setSize(1000,600);
      frame.setVisible(true);
   
   }


}