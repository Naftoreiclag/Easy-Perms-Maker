package naftoreiclag.easypermsmaker;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.FlowLayout;

import javax.swing.JTabbedPane;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.BoxLayout;

@SuppressWarnings("serial")
public class ProgramWindow extends JFrame
{
	private JPanel mainPane;

	/**
	 * Create the frame.
	 */
	public ProgramWindow(String displayName)
	{
		super(displayName);
		
		setName("a");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		mainPane = new JPanel();
		mainPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(mainPane);
		mainPane.setLayout(new BorderLayout(0, 0));
		
		JTabbedPane mainTabs = new JTabbedPane(JTabbedPane.TOP);
		mainTabs.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
		mainPane.add(mainTabs);
		
		JPanel tab1 = new JPanel();
		mainTabs.addTab("New tab", null, tab1, null);
		
		JPanel tab2 = new JPanel();
		mainTabs.addTab("New tab", null, tab2, null);
	}

}