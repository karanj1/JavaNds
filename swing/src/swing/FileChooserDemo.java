package swing;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileFilter;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class FileChooserDemo  extends JFrame {
	static JFileChooser f=new JFileChooser();
	FileChooserDemo()
	{
		setSize(400,300);
		setTitle("Image");
		setLayout(new BorderLayout());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		final JLabel l=new JLabel();
		add(l);//center
		
		JButton b1=new JButton("Select Image");
		add(b1,BorderLayout.SOUTH);
		
		setVisible(true);
		
		f.setFileFilter(new javax.swing.filechooser.FileFilter() {
			
			@Override
			public String getDescription() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public boolean accept(File arg0) {
				// TODO Auto-generated method stub
				return (arg0.getName().endsWith(".jpg")|| arg0.getName().endsWith(".gif"));
			}
		});
		
		//f.setDialogTitle("Select Image");
		//f.setCurrentDirectory(new File("D:\\Gif"));
		
		b1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				int r=f.showOpenDialog(getContentPane());
				if(r==JFileChooser.APPROVE_OPTION)
				{
					File f1=f.getSelectedFile();
					System.out.println(f1);		 //prints path in console
					ImageIcon img=new ImageIcon(f1.toString());
					l.setIcon(img);
					pack(); // auto resize
					
				
				}
				else
					JOptionPane.showMessageDialog(getContentPane(), "Please select the file ");
				
			}
		});
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new FileChooserDemo();
	}

}