package naftoreiclag.easypermsmaker;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.FlowLayout;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JTabbedPane;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

import java.awt.BorderLayout;

import javax.swing.BoxLayout;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.SwingConstants;
import javax.swing.JList;
import javax.swing.JComboBox;

import java.awt.Component;

import javax.swing.Box;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.SpringLayout;

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
		
		JPanel controlsPanel = new JPanel();
		mainTabs.addTab(null, icon_controls, controlsPanel, null);
		controlsPanel.setBackground(new Color(0xC8DDF2));
		controlsPanel.setToolTipText("Controls");
		controlsPanel.setLayout(new SpringLayout());

		for(int i = 0; i < 4; i++)
		{
			JButton butt = new JButton(Integer.toString(i));
			controlsPanel.add(butt);
		}
		
		SpringUtilities.makeCompactGrid(controlsPanel, 2, 2, 5, 5, 5, 5);
		
		JPanel classesPanel = new JPanel();
		classesPanel.setToolTipText("Classes");
		mainTabs.addTab(null, icon_classes, classesPanel, null);
		classesPanel.setLayout(new SpringLayout());
		
		JPanel permissionsPanel = new JPanel();
		permissionsPanel.setToolTipText("Class Permissions");
		mainTabs.addTab(null, icon_permissions, permissionsPanel, null);
		permissionsPanel.setLayout(new BorderLayout(0, 0));
		
		JPanel usersPanel = new JPanel();
		usersPanel.setToolTipText("Users");
		mainTabs.addTab(null, icon_users, usersPanel, null);
		usersPanel.setLayout(new BorderLayout(0, 0));
	}

}
