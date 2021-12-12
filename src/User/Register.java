package User;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import wiess.jdbc.JDBC;

import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;

import java.awt.Color;
import java.awt.Font;

public class Register extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JDBC db=new JDBC();
	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Register frame = new Register();
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
	public Register() {
		setTitle("\u7528\u6237\u6CE8\u518C");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("  \u7528\u6237\u540D");
		lblNewLabel.setFont(new Font("新宋体", Font.ITALIC, 18));
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setBounds(59, 46, 92, 21);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(161, 46, 136, 21);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("    \u5BC6\u7801");
		lblNewLabel_1.setFont(new Font("新宋体", Font.ITALIC, 18));
		lblNewLabel_1.setForeground(Color.BLACK);
		lblNewLabel_1.setBounds(59, 77, 92, 21);
		contentPane.add(lblNewLabel_1);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(161, 77, 136, 21);
		contentPane.add(passwordField);
		
		JLabel lblNewLabel_2 = new JLabel("\u786E\u8BA4\u5BC6\u7801");
		lblNewLabel_2.setFont(new Font("新宋体", Font.ITALIC, 18));
		lblNewLabel_2.setForeground(Color.BLACK);
		lblNewLabel_2.setBounds(59, 108, 92, 21);
		contentPane.add(lblNewLabel_2);
		
		JButton btnNewButton = new JButton("\u6CE8\u518C");
		btnNewButton.setFont(new Font("新宋体", Font.ITALIC, 18));
		btnNewButton.setForeground(Color.BLACK);
		btnNewButton.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				if(textField.getText().equals("")||passwordField.getText().equals("")){
					JOptionPane.showMessageDialog(null, "用户名和密码不能为空！");
				}else if(!passwordField.getText().equals(passwordField_1.getText())){
					JOptionPane.showMessageDialog(null, "请重新确认密码！");
				}else
				if(db.insert(textField.getText(),passwordField.getText(), "用户")>0){
					JOptionPane.showMessageDialog(null, "恭喜您注册成功！\n请记住您的用户名："+textField.getText());
					setVisible(false);
					new Login().setVisible(true);
				}else{
					JOptionPane.showMessageDialog(null, "用户名已存在！");
				}
			}
		});
		btnNewButton.setBounds(161, 158, 136, 23);
		contentPane.add(btnNewButton);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(161, 108, 136, 21);
		contentPane.add(passwordField_1);
		
		JButton button = new JButton("\u9000\u51FA");
		button.setFont(new Font("新宋体", Font.ITALIC, 18));
		button.setForeground(Color.BLACK);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new Login().setVisible(true);
			}
		});
		button.setBounds(161, 191, 136, 23);
		contentPane.add(button);
	}
}
