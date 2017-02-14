package swing;

// JTable
import java.awt.*;
import javax.swing.*;
/*
<applet code="JTableDemo" width=400 height=200>
</applet>
 */
public class JTableDemo extends JApplet {
	public void init() {

		// Initialize column headings
		final String[] colHeads = { "Name", "Phone", "Fax" };
		// Initialize data
		 Object[][] data = {
				{ "Geeta", "4567", "8675" },
				{ "Kavita", "7566", "5555" },
				{ "Vivek", "5634", "5887" },
				{ "Mala", "7345", "9222" },
				{ "Anita", "1237", "3333" },
				{ "John", "5656", "3144" },
				{ "Manasi", "5672", "2176" },
				{ "Taniya", "6741", "4244" },
				{ "Tara", "9023", "5159" },
				{ "Chandu", "1134", "5332" },
				{ "Jennifer", "5689", "1212" },
				{ "Kavya", "9030", "1313" },
				{ "Helen", "6751", "1415" }
		};
		// Create the table
		JTable table = new JTable(data, colHeads);
		//JTable table = new JTable(5,3); // rows,cols

		// Add table to a scroll pane
		//javax.swing   Interface ScrollPaneConstants
		int v = ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED;
		int h = ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED;
		JScrollPane jsp = new JScrollPane(table ,v, h);
		// Add scroll pane to JApplet

		add(jsp);
	}
}