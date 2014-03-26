package naftoreiclag.easypermsmaker;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

// I named this class "Main" just so java newbies can find the
// main method faster! Aren't I so nice? :)

public class Main
{
	// Frame
	private JFrame frame;
	
	// Constructor; maybe put something here?
	private Main(String args[])
	{
	}
	
	// Call this to begin the program
	private void begin()
	{
		EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
				try
				{
					ProgramWindow programWindow = new ProgramWindow();
					programWindow.setVisible(true);
				}
				catch (Exception e)
				{
					e.printStackTrace();
				}
			}
		});
	}

	// This is where the magic begins
	public static void main(String args[])
	{
		// Make a new program instance
		Main main = new Main(args);
		
		// Start the program!
		main.begin();
	}
}
