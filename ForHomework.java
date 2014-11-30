import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class ForHomework extends JFrame
{
   private JButton button;
   private JLabel pic;
   private ImageIcon front,back;
   public ForHomework(String s)
   {
      super(s);
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
   public static void main(String [] args)
   {
  
      JFrame frame = new ForHomework("New Frame ...");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.pack();
      frame.setVisible(true);
   
   }


}