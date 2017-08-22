package swing;

//JColorChooser
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class ColChooser 
{
	static Container cp;
	public static void main(String[] args) {
		final JFrame frame = new JFrame("Color Choice");
		cp = frame.getContentPane( );
		frame.setLayout(new FlowLayout());
		
		JButton button = new JButton("select color");
		cp.add(button);
		
		button.addActionListener(new ActionListener( ) {
			public void actionPerformed(ActionEvent e) {
				Color c = JColorChooser.showDialog(frame,"Choose a color", Color.red);
				cp.setBackground(c);
			}
		});
		frame.setSize(200, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}