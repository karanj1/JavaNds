package com;

import java.applet.Applet;
import java.awt.Graphics;

public class HelloJava extends Applet {
@Override
public void paint(Graphics g) {
	// TODO Auto-generated method stub
	g.drawString("Hello Java",80,150);
	g.drawOval(40,40,120,140);
}
}
