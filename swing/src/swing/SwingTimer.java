package swing;

// Timer 
//Fires one or more ActionEvents at specified intervals. 
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class SwingTimer{
	final static int interval = 4000;//ms
	int i=1;  
	Timer timer;
	public SwingTimer() {    
		final JFrame frame = new JFrame("Swing Timer");
		frame.setSize(300,100);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		//Create a timer.
		//Timer(int delay, ActionListener listener) 
		//  Creates a Timer that will notify its listeners
		//after every delay milliseconds.

		timer = new Timer(interval, new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				JOptionPane.showMessageDialog(frame,"Tick : "+i);
				if (i == 3){
					timer.stop();
				}
				i = i + 1;
			}
		});
		timer.start(); //Invokes "timer = new Timer(Interval,....)"
	}   
	public static void main(String[] args) {
		SwingTimer st = new SwingTimer();
	}
}

//Try below program also, but comment out above program before running below program
/*public class SwingTimer {

	  public static void main(String[] args) {
	    Timer timer = new Timer(1000, new MyTimerActionListener());		//after timer starts, this keeps on creating instance of 
																		//"MyTimerActionListener" 	every 1000 ms

	    timer.start();	//Invokes "timer = new Timer(Interval,....)"
	    try {
	      Thread.sleep(10000);
	    } catch (InterruptedException e) {
	    }
	    timer.stop();
	  }

	}

class MyTimerActionListener implements ActionListener {
	  public void actionPerformed(ActionEvent e) {

	    System.out.println("asdf");

	  }
	}*/
	
/*
steps to create swing timer:

--create the actionlistener
--create the timer constructor then pass time and actionlistener in that
--implement the actionPerformed() function in which do your task
--use timer.start() for start the task between the time specified in timer constructor, use timer.stop() for stop the task
-*Example:

ActionListener al=new ActionListener(
public void actionPerformed(ActionEvent ae)
{
 //do your task
 if(work done)
   timer.stop();//stop the task after do the work
}
);
Timer timer=new Timer(1000,al);//create the timer which calls the actionperformed method for every 1000 millisecond(1 second=1000 millisecond)
timer.start();//start the task
*/