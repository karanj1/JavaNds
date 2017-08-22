package swing;

import java.awt.*;  
import java.awt.event.*;  
  
import javax.swing.*;  
  
public class CardLayoutExample extends JFrame implements ActionListener{  
	
CardLayout card;  
JPanel p1,p2,p3;
JButton b1,b2,b3;  

    CardLayoutExample(){  
    	
    	super("Card Layout");
          
       p1=new JPanel();
       p2=new JPanel();
       p3=new JPanel();
       
       p1.setLayout(new FlowLayout());
       p2.setLayout(new FlowLayout());
       p3.setLayout(new FlowLayout());
       
        card=new CardLayout();  
       setLayout(card);  
          
        b1=new JButton("Apple");  
        b2=new JButton("Banana");  
        b3=new JButton("Mango"); 
        
        b1.addActionListener(this);  
        b2.addActionListener(this);  
        b3.addActionListener(this);  
              
        p1.add(new JLabel("Card1 : "));
        p1.add(b1);
        
        p2.add(new JLabel("Card2 : "));
        p2.add(b2);
        
        p3.add(new JLabel("Card3 : "));
        p3.add(b3);
        
        add("a",p1);//imp ,( name , control)
		add("b",p2);
		add("c",p3);  


                          
    }  
    public void actionPerformed(ActionEvent e) {  
    card.next(getContentPane());    
   
    
    }  
  
    public static void main(String[] args) {  
        CardLayoutExample cl=new CardLayoutExample();  
        cl.setSize(400,400);  
        cl.setVisible(true);  
        cl.setDefaultCloseOperation(EXIT_ON_CLOSE);  
    }  
}