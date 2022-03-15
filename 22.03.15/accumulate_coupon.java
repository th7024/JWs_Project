import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class accumulate_coupon extends JFrame {

	private JPanel contentPane;
	static String p_number="";
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					accumulate_coupon frame = new accumulate_coupon();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public void reNum(String num) {
		System.out.println("ddd "+num);
		p_number = num;
	}
	/**
	 * Create the frame.
	 */
	public accumulate_coupon() {
		super("적립창");
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 642, 547);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		enter_Number en = new enter_Number();
		System.out.println(en.getData() + " 여기서 출력이 되야해");
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("굴림", Font.BOLD, 15));
		comboBox.setEditable(true);
		comboBox.setToolTipText("");
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"}));
		comboBox.setBounds(25, 138, 75, 42);
		contentPane.add(comboBox);
		System.out.println(p_number + " asdasd");
		
		JLabel Phone_N = new JLabel();
		Phone_N.setFont(new Font("굴림", Font.BOLD, 34));
		Phone_N.setBounds(12, 21, 390, 71);
		contentPane.add(Phone_N);
		
		JLabel lblNewLabel_1 = new JLabel("\uACE0\uAC1D\uB2D8 \uC801\uB9BD or \uC0AC\uC6A9");
		lblNewLabel_1.setFont(new Font("굴림", Font.PLAIN, 28));
		lblNewLabel_1.setBounds(349, 34, 265, 49);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setBounds(305, 152, 57, 15);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("New label");
		lblNewLabel_3.setBounds(305, 200, 57, 15);
		contentPane.add(lblNewLabel_3);
		
		JButton btnNewButton = new JButton("\uCFE0\uD3F0 \uC801\uB9BD");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnNewButton.setBounds(233, 402, 97, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\uCFE0\uD3F0 \uC0AC\uC6A9");
		btnNewButton_1.setBounds(419, 402, 97, 23);
		contentPane.add(btnNewButton_1);
	}
}
