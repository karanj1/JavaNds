package swing;

import javax.swing.*;
import java.awt.event.*;
 
public class JPopupMenuDemo {
 
    public static void main(String[] args) {
        final JFrame frame = new JFrame("Popup Menu Demo");
 
        // build poup menu
        final JPopupMenu popup = new JPopupMenu();
        // New project menu item
        JMenuItem menuItem = new JMenuItem("Red");
       
       
        menuItem.addActionListener(new ActionListener() {
 
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(frame, "Red color selected!");
            }
        });
        
        popup.add(menuItem);
        // New File menu item
        
        menuItem = new JMenuItem("Green");
       
        menuItem.addActionListener(new ActionListener() {
 
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(frame, "Green color selected!");
            }
        });
        
        popup.add(menuItem);
 
        // add mouse listener
        frame.addMouseListener(new MouseAdapter() {
 
            public void mousePressed(MouseEvent e) {
				
                showPopup(e);
				
            }
           
            public void mouseReleased(MouseEvent e) {
                showPopup(e);
            }
 
            // any user defined method
            private void showPopup(MouseEvent e) {
             if (e.isPopupTrigger()) {
                    popup.show(frame,
                            e.getX(), e.getY());
					 }
              
            }
        });
 
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);
        frame.setVisible(true);
 
    }
}