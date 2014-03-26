package naftoreiclag.easypermsmaker;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTabbedPane;
import javax.swing.JButton;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.SpringLayout;

//I named this class "Main" just so java newbies can find the
//main method faster! Aren't I so nice? :)

@SuppressWarnings("serial")
public class Main extends JFrame
{
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
		tabHolder.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
		
		// Add these tabs to the main panel
		mainPanel.add(tabHolder);
		
		// CONTROLS PANEL TAB
		// ==================
		
		// Make a new panel and add it to our tabs
		tab_controls = new JPanel();
		tabHolder.addTab(null, icon_controls, tab_controls, null);
		
		// Add tool tip text (This doesn't work?)
		tab_controls.setToolTipText("Controls");
		
		// Set up layout
		tab_controls.setLayout(new SpringLayout());
		
		tab_controls.add(new JLabel("Permissions Plugin:"));
		
		SpringUtilities.makeCompactGrid(tab_controls, 2, 2, 5, 5, 5, 5);
		
		tab_classes = new JPanel();
		tab_classes.setToolTipText("Classes");
		tabHolder.addTab(null, icon_classes, tab_classes, null);
		tab_classes.setLayout(new SpringLayout());
		
		tab_permissions = new JPanel();
		tab_permissions.setToolTipText("Class Permissions");
		tabHolder.addTab(null, icon_permissions, tab_permissions, null);
		tab_permissions.setLayout(new BorderLayout(0, 0));
		
		tab_users = new JPanel();
		tab_users.setToolTipText("Users");
		tabHolder.addTab(null, icon_users, tab_users, null);
		tab_users.setLayout(new BorderLayout(0, 0));
	}
	
	// This is where the magic begins
	public static void main(String args[])
	{
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
