package User;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;

import java.awt.Font;

import javax.swing.JMenuItem;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;
import javax.swing.JLabel;

public class User extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					User frame = new User();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public User() {
		setTitle("\u7528\u6237\u754C\u9762");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("\u9009\u9879");
		mnNewMenu.setFont(new Font("新宋体", Font.ITALIC, 18));
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("\u4FEE\u6539\u5BC6\u7801");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new Change_Password().setVisible(true);
			}
		});
		mntmNewMenuItem.setFont(new Font("新宋体", Font.ITALIC, 18));
		mnNewMenu.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("\u9000\u51FA");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		mntmNewMenuItem_1.setFont(new Font("新宋体", Font.ITALIC, 18));
		mnNewMenu.add(mntmNewMenuItem_1);
		
		JMenu menu = new JMenu("\u5E2E\u52A9");
		menu.setFont(new Font("新宋体", Font.ITALIC, 18));
		menuBar.add(menu);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("\u5173\u4E8E");
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "李芮制作！");
			}
		});
		mntmNewMenuItem_2.setFont(new Font("新宋体", Font.ITALIC, 18));
		menu.add(mntmNewMenuItem_2);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		JPopupMenu popupMenu = new JPopupMenu();
		addPopup(contentPane, popupMenu);
		
		JMenu menu_1 = new JMenu("\u4FEE\u6539\u80CC\u666F\u989C\u8272");
		menu_1.setFont(new Font("新宋体", Font.ITALIC, 18));
		popupMenu.add(menu_1);
		
		JMenuItem menuItem = new JMenuItem("\u7EA2");
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				contentPane.setBackground(Color.red);
			}
		});
		menuItem.setForeground(Color.RED);
		menuItem.setFont(new Font("新宋体", Font.ITALIC, 18));
		menu_1.add(menuItem);
		
		JMenuItem menuItem_1 = new JMenuItem("\u84DD");
		menuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				contentPane.setBackground(Color.blue);
			}
		});
		menuItem_1.setForeground(Color.BLUE);
		menuItem_1.setFont(new Font("新宋体", Font.ITALIC, 18));
		menu_1.add(menuItem_1);
		
		JMenuItem menuItem_2 = new JMenuItem("\u9EC4");
		menuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				contentPane.setBackground(Color.yellow);
			}
		});
		menuItem_2.setForeground(Color.YELLOW);
		menuItem_2.setFont(new Font("新宋体", Font.ITALIC, 18));
		menu_1.add(menuItem_2);
		
		JMenuItem menuItem_3 = new JMenuItem("\u9ED1");
		menuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				contentPane.setBackground(Color.black);
			}
		});
		menuItem_3.setFont(new Font("新宋体", Font.ITALIC, 18));
		menu_1.add(menuItem_3);
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JLabel label = new JLabel("        \u6B22\u8FCE\uFF01");
		label.setFont(new Font("新宋体", Font.ITALIC, 40));
		contentPane.add(label, BorderLayout.CENTER);
	}

	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
}
