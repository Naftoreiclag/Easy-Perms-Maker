package naftoreiclag.easypermsmaker;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JTabbedPane;
import javax.swing.JButton;
import javax.swing.JLabel;

import java.awt.BorderLayout;

import javax.swing.BoxLayout;

@SuppressWarnings("serial")
public class ProgramWindow extends JFrame
{
	private JPanel mainPane;
	private ImageIcon icon_controls;
	private ImageIcon icon_classes;
	private ImageIcon icon_permissions;
	private ImageIcon icon_users;

	/**
	 * Create the frame.
	 */
	public ProgramWindow(String displayName)
	{
		super(displayName);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		mainPane = new JPanel();
		mainPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(mainPane);
		mainPane.setLayout(new BorderLayout(0, 0));
		
		icon_controls = new ImageIcon("resources/images/preferences-desktop.png", null);
		icon_classes = new ImageIcon("resources/images/preferences-system-windows.png", null);
		icon_permissions = new ImageIcon("resources/images/accessories-text-editor.png", null);
		icon_users = new ImageIcon("resources/images/system-users.png", null);
		
		JTabbedPane mainTabs = new JTabbedPane(JTabbedPane.TOP);
		mainTabs.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
		mainPane.add(mainTabs);
		
		JPanel tab1 = new JPanel();
		tab1.setToolTipText("Controls");
		mainTabs.addTab(null, icon_controls, tab1, null);
		
		JPanel tab2 = new JPanel();
		mainTabs.addTab("New tab", null, tab2, null);
	}

}
