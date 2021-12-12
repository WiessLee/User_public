package User;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import wiess.jdbc.JDBC;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JPasswordField;
import java.awt.Color;
import java.awt.Font;
public class Change_Password extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JDBC db=new JDBC();
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
					Change_Password frame = new Change_Password();
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
	public Change_Password() {
		setTitle("\u4FEE\u6539\u5BC6\u7801");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("  \u7528\u6237\u540D");
		lblNewLabel.setFont(new Font("新宋体", Font.ITALIC, 18));
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setBounds(54, 37, 96, 21);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(175, 37, 146, 21);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("  \u65E7\u5BC6\u7801");
		lblNewLabel_1.setFont(new Font("新宋体", Font.ITALIC, 18));
		lblNewLabel_1.setForeground(Color.BLACK);
		lblNewLabel_1.setBounds(54, 68, 96, 21);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("  \u65B0\u5BC6\u7801");
		lblNewLabel_2.setFont(new Font("新宋体", Font.ITALIC, 18));
		lblNewLabel_2.setForeground(Color.BLACK);
		lblNewLabel_2.setBounds(54, 99, 96, 21);
		contentPane.add(lblNewLabel_2);
		
		JButton btnNewButton = new JButton("\u786E\u8BA4\u4FEE\u6539");
		btnNewButton.setFont(new Font("新宋体", Font.ITALIC, 18));
		btnNewButton.setForeground(Color.BLACK);
		btnNewButton.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				if(textField.getText().equals("")||passwordField.getText().equals("")||passwordField_1.getText().equals("")){
					JOptionPane.showMessageDialog(null, "用户名和密码不能为空！");
				}else
				if(passwordField.getText().equals(passwordField_1.getText())){
					JOptionPane.showMessageDialog(null, "新老密码不能一样！");
				}else if(db.update(textField.getText(), passwordField.getText(), passwordField_1.getText())>0){
					JOptionPane.showMessageDialog(null, "修改成功！");
					setVisible(false);
					new Login().setVisible(true);
					}else{
						JOptionPane.showMessageDialog(null, "用户名或密码错误！");
						}
				}
			});
		btnNewButton.setBounds(175, 155, 146, 23);
		contentPane.add(btnNewButton);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(175, 68, 146, 21);
		contentPane.add(passwordField);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(175, 99, 146, 21);
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
		button.setBounds(175, 200, 146, 23);
		contentPane.add(button);
	}
}
