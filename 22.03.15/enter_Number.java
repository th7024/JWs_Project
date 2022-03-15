import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class enter_Number extends JFrame {

	private JPanel contentPane;
	private String cur;
	

	public void setData(JLabel j) {
		cur = j.getText();
		System.out.println("asdasd Ãâ·ÂÁ» ¤¸¹ß" + cur);
	}
	public String getData() {
		return cur;
	}
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					enter_Number frame = new enter_Number();
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
	public enter_Number() {
		super("Àû¸³Ã¢");
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 269, 482);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel answer = new JLabel("010 - ");
		answer.setFont(new Font("±¼¸²", Font.PLAIN, 22));
		answer.setBounds(12, 10, 228, 79);
		contentPane.add(answer);

		JButton btnNewButton = new JButton("1");
		btnNewButton.addActionListener(new NumberActionListener(answer, "1"));
		btnNewButton.setFont(new Font("±¼¸²", Font.PLAIN, 51));
		btnNewButton.setBounds(12, 99, 68, 73);
		contentPane.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("4");
		btnNewButton_1.addActionListener(new NumberActionListener(answer, "4"));
		btnNewButton_1.setFont(new Font("±¼¸²", Font.PLAIN, 51));
		btnNewButton_1.setBounds(12, 188, 68, 73);
		contentPane.add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton("7");
		btnNewButton_2.addActionListener(new NumberActionListener(answer, "7"));
		btnNewButton_2.setFont(new Font("±¼¸²", Font.PLAIN, 51));
		btnNewButton_2.setBounds(12, 271, 68, 73);
		contentPane.add(btnNewButton_2);

		JButton btnNewButton_2_1 = new JButton("8");
		btnNewButton_2_1.addActionListener(new NumberActionListener(answer, "8"));
		btnNewButton_2_1.setFont(new Font("±¼¸²", Font.PLAIN, 51));
		btnNewButton_2_1.setBounds(92, 271, 68, 73);
		contentPane.add(btnNewButton_2_1);

		JButton btnNewButton_1_1_1 = new JButton("0");
		btnNewButton_1_1_1.addActionListener(new NumberActionListener(answer, "0"));
		btnNewButton_1_1_1.setFont(new Font("±¼¸²", Font.PLAIN, 51));
		btnNewButton_1_1_1.setBounds(92, 360, 68, 73);
		contentPane.add(btnNewButton_1_1_1);

		JButton btnNewButton_1_2 = new JButton("5");
		btnNewButton_1_2.addActionListener(new NumberActionListener(answer, "5"));
		btnNewButton_1_2.setFont(new Font("±¼¸²", Font.PLAIN, 51));
		btnNewButton_1_2.setBounds(92, 188, 68, 73);
		contentPane.add(btnNewButton_1_2);

		JButton btnNewButton_3 = new JButton("2");
		btnNewButton_3.addActionListener(new NumberActionListener(answer, "2"));
		btnNewButton_3.setFont(new Font("±¼¸²", Font.PLAIN, 51));
		btnNewButton_3.setBounds(92, 99, 68, 73);
		contentPane.add(btnNewButton_3);

		JButton btnNewButton_2_2 = new JButton("9");
		btnNewButton_2_2.addActionListener(new NumberActionListener(answer, "9"));
		btnNewButton_2_2.setFont(new Font("±¼¸²", Font.PLAIN, 51));
		btnNewButton_2_2.setBounds(172, 271, 68, 73);
		contentPane.add(btnNewButton_2_2);

		JButton btnNewButton_1_3 = new JButton("6");
		btnNewButton_1_3.addActionListener(new NumberActionListener(answer, "6"));
		btnNewButton_1_3.setFont(new Font("±¼¸²", Font.PLAIN, 51));
		btnNewButton_1_3.setBounds(172, 188, 68, 73);
		contentPane.add(btnNewButton_1_3);

		JButton btnNewButton_4 = new JButton("3");
		btnNewButton_4.addActionListener(new NumberActionListener(answer, "3"));
		btnNewButton_4.setFont(new Font("±¼¸²", Font.PLAIN, 51));
		btnNewButton_4.setBounds(172, 99, 68, 73);
		contentPane.add(btnNewButton_4);
		
		JButton btnNewButton_1_1 = new JButton("c");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setData(answer);
				if (cur.length() > 6) {
					if (cur.charAt(cur.length() - 2) == ' ' && cur.length() != 7)
						cur = cur.substring(0, cur.length() - 4);
					else
						cur = cur.substring(0, cur.length() - 1);
					answer.setText(cur);
				}
			}
		});
		btnNewButton_1_1.setFont(new Font("±¼¸²", Font.PLAIN, 51));
		btnNewButton_1_1.setBounds(12, 360, 68, 73);
		contentPane.add(btnNewButton_1_1);

		JButton btnNewButton_1_1_2 = new JButton("o");
		btnNewButton_1_1_2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				setData(answer);
				if(cur.length()==17) {
					JOptionPane.showMessageDialog(null, cur);
					db_test1 con = new db_test1();
					getData();
					if(!con.isChecked(cur)) { //¹øÈ£ ¾øÀ½
						if(!con.add_PN(cur)) {
							System.out.println("Ãß°¡ ¿Ï·á");
							
						}
						else {
							System.out.println("Ãß°¡ ½ÇÆÐ");
						}
						//¼öÁ¤ÇØ¾ßÇÔ
					}
					else { //¹øÈ£ Á¸Àç
						System.out.println("¹øÈ£°¡ ÀÖ³×¿µ");
						
					}
				}
				
			}
		});
		btnNewButton_1_1_2.setFont(new Font("±¼¸²", Font.PLAIN, 51));
		btnNewButton_1_1_2.setBounds(172, 360, 68, 73);
		contentPane.add(btnNewButton_1_1_2);
		
		System.out.println("cur Ãâ·Â " + cur);
	}
}

class NumberActionListener implements ActionListener {
	private JLabel current_N;
	private String new_N;

	public NumberActionListener(JLabel l, String s) {
		current_N = l;
		new_N = s;

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String cur_label = current_N.getText();
		if (cur_label.length() == 10)
			current_N.setText(current_N.getText() + " - " + new_N);
		else if (cur_label.length() <= 16)
			current_N.setText(current_N.getText() + new_N);
	}

}
