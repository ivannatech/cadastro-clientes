package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controler.Criptografia;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.management.remote.JMXPrincipal;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JLogin extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldUsuario;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JLogin frame = new JLogin();
					frame.setLocationRelativeTo(null);
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
	public JLogin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 28, 84));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(93, 24, 251, 214);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("Bem vindo(a)!");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setBounds(74, 24, 119, 14);
		panel.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Usuário");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_1.setBounds(36, 63, 87, 14);
		panel.add(lblNewLabel_1);

		textFieldUsuario = new JTextField();
		textFieldUsuario.setBounds(36, 78, 183, 20);
		panel.add(textFieldUsuario);
		textFieldUsuario.setColumns(10);

		JLabel lblNewLabel_1_1 = new JLabel("Senha");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_1_1.setBounds(36, 109, 46, 14);
		panel.add(lblNewLabel_1_1);

		passwordField = new JPasswordField();
		passwordField.setBounds(36, 124, 183, 20);
		panel.add(passwordField);

		JButton btnNewButton = new JButton("Entrar");
		btnNewButton.setBackground(new Color(0, 28, 89));
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Criptografia criptografia = new Criptografia(passwordField.getText(), Criptografia.MD5);
				System.out.println(criptografia.criptografar());
				if (textFieldUsuario.getText() != null && !textFieldUsuario.getText().isEmpty()
						&& passwordField.getText() != null && !passwordField.getText().isEmpty()) {
					if (criptografia.criptografar().equals("E10ADC3949BA59ABBE56E057F20F883E")) {
						JOptionPane.showMessageDialog(btnNewButton, "Informações válidas");
						dispose();
						JPrincipal jPrincipal = new JPrincipal();
						jPrincipal.setLocationRelativeTo(jPrincipal);
						jPrincipal.setVisible(true);
					}
				} else {
					JOptionPane.showMessageDialog(btnNewButton,
							"Verifique se as informações foram inseridas corretamente", "Aviso",
							JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		btnNewButton.setBounds(89, 166, 89, 23);
		panel.add(btnNewButton);

	}
}
