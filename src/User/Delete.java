package User;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import wiess.jdbc.JDBC;

import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Delete extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JDBC db=new JDBC();
	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Delete frame = new Delete();
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
	public Delete() {
		setTitle("\u5220\u9664\u7528\u6237");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u7528\u6237\u540D");
		lblNewLabel.setFont(new Font("新宋体", Font.ITALIC, 18));
		lblNewLabel.setBounds(79, 53, 54, 21);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(169, 53, 129, 21);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("\u5220\u9664\u8BE5\u7528\u6237");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textField.getText().equals("")){
					JOptionPane.showMessageDialog(null, "用户名不能为空！");
				}else
				if(db.select(textField.getText()).equals("管理员")){
					JOptionPane.showMessageDialog(null, "您无权删除该用户！");
				}else if(db.delete(textField.getText())>0){
					JOptionPane.showMessageDialog(null, "已删除该用户！");
					textField.setText("");
				}else{
					JOptionPane.showMessageDialog(null, "该用户不存在！");
				}
			}
		});
		btnNewButton.setFont(new Font("新宋体", Font.ITALIC, 18));
		btnNewButton.setBounds(169, 134, 129, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\u8FD4\u56DE");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new Admin().setVisible(true);
			}
		});
		btnNewButton_1.setFont(new Font("新宋体", Font.ITALIC, 18));
		btnNewButton_1.setBounds(169, 185, 129, 23);
		contentPane.add(btnNewButton_1);
	}
}
