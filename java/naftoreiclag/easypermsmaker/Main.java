package naftoreiclag.easypermsmaker;

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
		// Setup the LAF (Look and Feel)
		setupLAF();
		
		EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
				try
				{
					ProgramWindow programWindow = new ProgramWindow("Easy Perms Maker");
					programWindow.setVisible(true);
				} catch (Exception e)
				{
					e.printStackTrace();
				}
			}
		});
		
		/*
		// Setup frame
		frame = new JFrame("Easy Perms Maker");
		
		// Close when you click the X
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// Set the default size
		frame.setSize(800, 600);
		
		// Put it in the middle
		frame.setLocationRelativeTo(null);
		
		// Reveal our frame to the user
		frame.setVisible(true);
		*/
	}
	
	// Set the LAF to something that looks cool
	private static void setupLAF()
	{
		// Try set it to nimbus
		try
		{
			for(LookAndFeelInfo laf : UIManager.getInstalledLookAndFeels())
			{
				if(laf.getName().equalsIgnoreCase("Nimbus"))
				{
					UIManager.setLookAndFeel(laf.getClassName());
					return;
				}
			}
		}
		catch(Exception e)
		{
			System.err.println("Could not set LAF to Nimbus!");
		};
		
		// Try set it to native LAF
		try
		{
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		}
		catch(Exception e)
		{
			System.err.println("Could not use the native LAF!");
		};
		
		// Try set it to metal
		try
		{
			UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
		}
		catch(Exception e)
		{
			System.err.println("Could not use the fall-back LAF either... I wonder what will happen...");
		};
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
