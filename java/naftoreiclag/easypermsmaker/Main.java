package naftoreiclag.easypermsmaker;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.FontUIResource;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;

import javax.swing.SpringLayout;

import naftoreiclag.easypermsmaker.customswings.JPanelTextured;
import naftoreiclag.easypermsmaker.utilities.SpringUtilities;

import java.awt.Color;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Enumeration;

//I named this class "Main" just so java newbies can find the
//main method faster! Aren't I so nice? :)

@SuppressWarnings("serial")
public class Main extends JFrame
{
	public static boolean isNimbus;
	
	public static final String dir_images = "resources/images/";
	
	public final JPanel mainPanel;
	
	public final JTabbedPane tabHolder;
	public final JPanel tab_controls;
	public final JPanel tab_classes;
	public final JPanel tab_permissions;
	public final JPanel tab_users;
	public final JPanel tab_worlds;
	public final JPanel tab_mirrors;
	
	public final JComboBox<String> combo_exportSelection;
	public final JTextField field_plugDir;
	public final JButton butt_browsePlugDir;
	public final JLabel label_exportStatus;
	
	public static ImageIcon icon_controls;
	public static ImageIcon icon_classes;
	public static ImageIcon icon_permissions;
	public static ImageIcon icon_users;
	public static ImageIcon icon_worlds;
	public static ImageIcon icon_mirrors;
	
	public static Image img_wallpaper;

	public Main()
	{
		// SET UP THE WINDOW
		// =================
		
		// Set the display name
		super("Naftoreiclag's Easy Perms Maker");
		
		// Close when we click the X
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// Default size
		setBounds(100, 100, 450, 300);
		
		// Make a new panel
		mainPanel = new JPanelTextured(img_wallpaper);
		//mainPanel.setBackground(new Color(0x6D89BC));
		
		// Make stuff in the panel fit to max size
		mainPanel.setBorder(new EmptyBorder(0, 0, 0, 0));
		mainPanel.setLayout(new BorderLayout(0, 0));
		
		// This panel is now the main content provider
		setContentPane(mainPanel);
		
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
		
		// Plugin directory prompt -----------
		tab_controls.add(new JLabel("Plugins Folder:"));
		
		// Plugin directory selection box
		Box plugDirSelContainer = Box.createHorizontalBox();
		
		// Field where we put stuff
		field_plugDir = new JTextField("aaaaa");
		plugDirSelContainer.add(field_plugDir);
		
		// Make a new button for browsing
		butt_browsePlugDir = new JButton("Browse...");
		plugDirSelContainer.add(butt_browsePlugDir);
		
		// Set the max size
		plugDirSelContainer.setMaximumSize(new Dimension(9999999, plugDirSelContainer.getPreferredSize().height));
		
		// Add this to the controls
		tab_controls.add(plugDirSelContainer);
		
		// Permissions selection prompt -------
		tab_controls.add(new JLabel("Permissions Plugin:"));

		// Combo selection
		combo_exportSelection = new JComboBox<String>(ExportCodeDatabase.getComboBoxSelectionStuff());
		combo_exportSelection.setSelectedIndex(0);
		combo_exportSelection.setPreferredSize(new Dimension(200, combo_exportSelection.getPreferredSize().height));
		combo_exportSelection.setMaximumSize(combo_exportSelection.getPreferredSize());
		tab_controls.add(combo_exportSelection);
		
		// Status prompt
		tab_controls.add(new JLabel("Status:"));
		
		label_exportStatus = new JLabel();
		tab_controls.add(label_exportStatus);
		
		label_exportStatus.setForeground(Color.RED);
		label_exportStatus.setText("NO PLUGIN FOLDER SELECTED");
		
		//
		SpringUtilities.makeCompactGrid(tab_controls, 3, 2, 15, 15, 15, 5);


		// WORLD SELECTION TAB
		// ===================
		
		tab_worlds = new JPanel();
		tabHolder.addTab(null, icon_worlds, tab_worlds, "World Selection");
		tab_worlds.setLayout(new BorderLayout(0, 0));
		
		tab_classes = new JPanel();
		tabHolder.addTab(null, icon_classes, tab_classes, "Classes");
		tab_classes.setLayout(new SpringLayout());
		
		tab_permissions = new JPanel();
		tabHolder.addTab(null, icon_permissions, tab_permissions, "Class Permissions");
		tab_permissions.setLayout(new BorderLayout(0, 0));
		
		tab_users = new JPanel();
		tabHolder.addTab(null, icon_users, tab_users, "Users");
		tab_users.setLayout(new BorderLayout(0, 0));
		
		tab_mirrors = new JPanel();
		tabHolder.addTab(null, icon_mirrors, tab_mirrors, "Mirroring");
		tab_mirrors.setLayout(new BorderLayout(0, 0));
	}

	// Load our pretty images
	private static void loadImagesAndIcons()
	{
		icon_controls = loadIcon("preferences-desktop.png");
		icon_classes = loadIcon("preferences-system-windows.png");
		icon_permissions = loadIcon("accessories-text-editor.png");
		icon_users = loadIcon("system-users.png");
		icon_worlds = loadIcon("internet-web-browser.png");
		icon_mirrors = loadIcon("system-software-update.png");
		
		img_wallpaper = loadImageWithComplaints("wallpaper.png");
	}
	
	// Auxilary method for loading images with "handled" errors
	private static Image loadImageWithComplaints(String filename)
	{
		Image returnVal = null;
		try
		{
			returnVal = ImageIO.read(new File(dir_images + filename));
		}
		catch (IOException e)
		{
			System.err.println("Could not load image: " + filename);
		}
		
		return returnVal;
	}
	
	// Auxilary method for loading icons
	private static ImageIcon loadIcon(String filename)
	{
		ImageIcon returnVal = null;
		
		returnVal = new ImageIcon(dir_images + filename, null);
		
		return returnVal;
	}
	

	// Set the LAF to something that looks cool
	private static void setupLookAndFeel()
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
		// Load export types
		ExportCodeDatabase.registerTypes();
		
		// Make it look cool
		loadImagesAndIcons();
		setupLookAndFeel();
		UIManager.getLookAndFeelDefaults().put("defaultFont", new Font("Arial", Font.PLAIN, 20));
		
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
