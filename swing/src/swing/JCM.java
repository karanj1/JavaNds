//JCheckBoxMenu ---JCM
package swing;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;

class Test extends JFrame
{
	JLabel l1=new JLabel("Testing");
	Test()
	{
		super("MyFrame");
		setSize(300, 300);
		setLayout(null);
		
		l1.setBounds(50,50,200,30);
		l1.setFont(new Font("Arial",Font.PLAIN,20));
		add(l1);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar jm=new JMenuBar();
		JMenu st=new JMenu("Style");
		final JCheckBoxMenuItem m1=new JCheckBoxMenuItem("Bold");
		jm.add(st);
		st.add(m1);		//menubar >> menu >> JCheckBoxMenuItem
		
		m1.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent arg0) {
				if(m1.isSelected())
				{
					l1.setFont(new Font("Arial",Font.BOLD,20));
				}
				else
				{
					l1.setFont(new Font("Arial",Font.PLAIN,20));
				}
			}
		});
		
		setJMenuBar(jm);
		setVisible(true);
	}
}
public class JCM {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Test();

	}

}