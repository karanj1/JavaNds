package swing;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.tree.*;
/*
<applet code="JTreeEvents" width=400 height=200>
</applet>
 */
public class JTreeEvents extends JApplet {
	JTree tree;//A control that displays a set of hierarchical data as an outline.
	JTextField jtf;
	public void init() {
		// Create top node of tree
		DefaultMutableTreeNode top = new DefaultMutableTreeNode("Options");
		//A DefaultMutableTreeNode is a general-purpose node in a tree data structure.

		// Create subtree of "A"
		DefaultMutableTreeNode a = new DefaultMutableTreeNode("A");
		top.add(a);

		DefaultMutableTreeNode a1 = new DefaultMutableTreeNode("A1");
		a.add(a1);
		DefaultMutableTreeNode a2 = new DefaultMutableTreeNode("A2");
		a.add(a2);

		// Create subtree of "B"
		DefaultMutableTreeNode b = new DefaultMutableTreeNode("B");
		top.add(b);

		DefaultMutableTreeNode b1 = new DefaultMutableTreeNode("B1");
		b.add(b1);
		DefaultMutableTreeNode b2 = new DefaultMutableTreeNode("B2");
		b.add(b2);
		DefaultMutableTreeNode b3 = new DefaultMutableTreeNode("B3");
		b.add(b3);

		// Create tree
		tree = new JTree(top); // root node

		// Add tree to a scroll pane
		int v = ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED;
		int h = ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED;
		JScrollPane jsp = new JScrollPane(tree, v, h);

		// Add scroll pane to the content pane
		add(jsp);

		// Add text field to applet
		jtf = new JTextField("", 20);
		add(jtf, BorderLayout.SOUTH);

		// Anonymous inner class to handle mouse clicks
		//Anonymous inner class is extending  MouseAdapter class
		tree.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent me) {
				doMouseClicked(me);
			}
		});
	}
	
	// any user defined method
	void doMouseClicked(MouseEvent me) {
		//public TreePath getPathForLocation(int x,          int y)
		TreePath tp = tree.getPathForLocation(me.getX(), me.getY());
		//System.out.println(me.getX()+ "  " +me.getY());
		//Represents a path from root to a node. 
		if(tp != null)
			jtf.setText(tp.toString());
		else
			jtf.setText("");
	}
}