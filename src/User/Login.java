package User;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;

import java.awt.Font;

import javax.swing.JMenuItem;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JPasswordField;

import wiess.jdbc.JDBC;

public class Login extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JDBC db=new JDBC();
	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		setTitle("\u7528\u6237\u767B\u5F55\u7A0B\u5E8F");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 93, 21);
		contentPane.add(menuBar);
		
		JMenu mnNewMenu = new JMenu("\u9009\u9879");
		mnNewMenu.setFont(new Font("新宋体", Font.ITALIC, 18));
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("\u6CE8\u518C");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new Register().setVisible(true);
			}
		});
		mntmNewMenuItem.setFont(new Font("新宋体", Font.ITALIC, 18));
		mnNewMenu.add(mntmNewMenuItem);
		
		JMenuItem menuItem = new JMenuItem("\u9000\u51FA");
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		menuItem.setFont(new Font("新宋体", Font.ITALIC, 18));
		mnNewMenu.add(menuItem);
		
		JMenu mnNewMenu_1 = new JMenu("\u5E2E\u52A9");
		mnNewMenu_1.setFont(new Font("新宋体", Font.ITALIC, 18));
		menuBar.add(mnNewMenu_1);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("\u5173\u4E8E");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "李芮制作！");
			}
		});
		mntmNewMenuItem_1.setFont(new Font("新宋体", Font.ITALIC, 18));
		mnNewMenu_1.add(mntmNewMenuItem_1);
		
		JLabel lblNewLabel = new JLabel("\u7528\u6237\u540D");
		lblNewLabel.setFont(new Font("新宋体", Font.ITALIC, 18));
		lblNewLabel.setBounds(41, 57, 82, 21);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(133, 59, 139, 21);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("  \u5BC6\u7801");
		lblNewLabel_1.setFont(new Font("新宋体", Font.ITALIC, 18));
		lblNewLabel_1.setBounds(41, 90, 80, 21);
		contentPane.add(lblNewLabel_1);
		
		JButton button = new JButton("\u767B\u5F55");
		button.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				if(textField.getText().equals("")||passwordField.getText().equals("")){
					JOptionPane.showMessageDialog(null, "用户名和密码不能为空！");
				}else if(db.select(textField.getText(),passwordField.getText()).equals("管理员")){
					JOptionPane.showMessageDialog(null, "欢迎您！尊敬的管理员！");
					setVisible(false);
					new Admin().setVisible(true);
				}else if(db.select(textField.getText(),passwordField.getText()).equals("用户")){
					setVisible(false);
					new User().setVisible(true);
				}else{
					JOptionPane.showMessageDialog(null, "用户名或密码错误！");
				}
			}
		});
		button.setFont(new Font("新宋体", Font.ITALIC, 18));
		button.setBounds(133, 152, 139, 23);
		contentPane.add(button);
		
		JButton button_1 = new JButton("\u6CE8\u518C");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new Register().setVisible(true);
			}
		});
		button_1.setFont(new Font("新宋体", Font.ITALIC, 18));
		button_1.setBounds(282, 89, 118, 23);
		contentPane.add(button_1);
		
		JButton button_2 = new JButton("\u9000\u51FA");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		button_2.setFont(new Font("新宋体", Font.ITALIC, 18));
		button_2.setBounds(133, 203, 139, 23);
		contentPane.add(button_2);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(133, 90, 139, 21);
		contentPane.add(passwordField);
		
		JButton btnNewButton = new JButton("\u91CD\u7F6E");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText("");
				passwordField.setText("");
			}
		});
		btnNewButton.setFont(new Font("新宋体", Font.ITALIC, 18));
		btnNewButton.setBounds(282, 58, 118, 23);
		contentPane.add(btnNewButton);
	}
}
