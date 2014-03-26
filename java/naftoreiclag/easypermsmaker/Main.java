package naftoreiclag.easypermsmaker;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTabbedPane;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.SpringLayout;

import java.awt.Color;

//I named this class "Main" just so java newbies can find the
//main method faster! Aren't I so nice? :)

@SuppressWarnings("serial")
public class Main extends JFrame
{
	public static boolean isNimbus;
	
	public final JPanel mainPanel;
	
	public final JTabbedPane tabHolder;
	public final JPanel tab_controls;
	public final JPanel tab_classes;
	public final JPanel tab_permissions;
	public final JPanel tab_users;
	
	public final ImageIcon icon_controls;
	public final ImageIcon icon_classes;
	public final ImageIcon icon_permissions;
	public final ImageIcon icon_users;

	public Main()
	{
		// SET UP THE WINDOW
		// =================
		
		// Set the display name
		super("Easy Perms Maker");
		
		// Close when we click the X
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// Default size
		setBounds(100, 100, 450, 300);
		
		// Make a new panel
		mainPanel = new JPanel();
		//mainPanel.setBackground(new Color(0x6D89BC));
		
		// Make stuff in the panel fit to max size
		mainPanel.setBorder(new EmptyBorder(0, 0, 0, 0));
		mainPanel.setLayout(new BorderLayout(0, 0));
		
		// This panel is now the main content provider
		setContentPane(mainPanel);
		
		// LOAD BEAUTIFUL ICONS
		// ====================
		
		// Load our cool icons
		icon_controls = new ImageIcon("resources/images/preferences-desktop.png", null);
		icon_classes = new ImageIcon("resources/images/preferences-system-windows.png", null);
		icon_permissions = new ImageIcon("resources/images/accessories-text-editor.png", null);
		icon_users = new ImageIcon("resources/images/system-users.png", null);
		
		// SET UP TABS
		// ===========
		
		// Set up the tabs
		tabHolder = new JTabbedPane(JTabbedPane.TOP);
		
		// We always want the tabs to be horizontal
		//tabHolder.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
		
		// Add these tabs to the main panel
		mainPanel.add(tabHolder);
		
		// CONTROLS PANEL TAB
		// ==================
		
		// Make a new panel and add it to our tabs
		tab_controls = new JPanel();
		tabHolder.addTab(null, icon_controls, tab_controls, "Controls");
		
		// Set up layout
		tab_controls.setLayout(new SpringLayout());
		
		tab_controls.add(new JLabel("Permissions Plugin:"));
		String[] options = { "foo", "bar", "quux", "dylan", "seven" };

		//Create the combo box, select item at index 4.
		//Indices start at 0, so 4 specifies the pig.
		JComboBox jcombo1 = new JComboBox(options);
		jcombo1.setSelectedIndex(3);
		jcombo1.setMaximumSize(jcombo1.getPreferredSize());
		
		tab_controls.add(jcombo1);
		
		tab_controls.add(new JLabel("Permissions Plugin:"));

		//Create the combo box, select item at index 4.
		//Indices start at 0, so 4 specifies the pig.
		JComboBox jcombo2 = new JComboBox(options);
		jcombo2.setSelectedIndex(3);
		jcombo2.setMaximumSize(jcombo2.getPreferredSize());
		
		tab_controls.add(jcombo2);
		
		
		SpringUtilities.makeCompactGrid(tab_controls, 2, 2, 5, 5, 5, 5);
		
		tab_classes = new JPanel();
		tabHolder.addTab(null, icon_classes, tab_classes, "Classes");
		tab_classes.setLayout(new SpringLayout());
		
		tab_permissions = new JPanel();
		tabHolder.addTab(null, icon_permissions, tab_permissions, "Class Permissions");
		tab_permissions.setLayout(new BorderLayout(0, 0));
		
		tab_users = new JPanel();
		tabHolder.addTab(null, icon_users, tab_users, "Users");
		tab_users.setLayout(new BorderLayout(0, 0));
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
					
					isNimbus = true;
					
					return;
				}
			}
		}
		catch(Exception e)
		{
			System.err.println("Could not set LAF to Nimbus!");
		};
	}

	// This is where the magic begins
	public static void main(String args[])
	{
		// Make it look cool
		setupLAF();
		
		// Do this stuff later (which in java-ese it means that we do it almost now)
		EventQueue.invokeLater(new Runnable()
		{
			// Do this
			public void run()
			{
				// Try
				try
				{
					// Make a new me
					Main main = new Main();
					
					// And then show it
					main.setVisible(true);
				}
				
				// If you fail
				catch (Exception e)
				{
					// Bleh
					e.printStackTrace();
				}
			}
		});
	}

}
