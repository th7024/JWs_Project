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
	private String p_number = "";
	public int num;
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

	/**
	 * Create the frame.
	 */
	public accumulate_coupon() {
		super("Àû¸³Ã¢");
		setVisible(true);	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 642, 547);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		enter_Number en = new enter_Number();
		p_number = en.getData();
		
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("±¼¸²", Font.BOLD, 15));
		comboBox.setEditable(true);
		comboBox.setToolTipText("");
		comboBox.setModel(new DefaultComboBoxModel(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10" }));
		comboBox.setBounds(36, 138, 75, 42);
		comboBox.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				num = Integer.parseInt(comboBox.getSelectedItem().toString());
				db_test1 dt = new db_test1();
				dt.plus_coupon(p_number, num);
			}
		});
		contentPane.add(comboBox);

		JLabel Phone_N = new JLabel(p_number);
		Phone_N.setFont(new Font("±¼¸²", Font.BOLD, 34));
		Phone_N.setBounds(12, 21, 390, 71);
		contentPane.add(Phone_N);

		JLabel lblNewLabel_1 = new JLabel("\uACE0\uAC1D\uB2D8 \uC801\uB9BD or \uC0AC\uC6A9");
		lblNewLabel_1.setFont(new Font("±¼¸²", Font.PLAIN, 28));
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
				System.out.println(num + "ÄíÆù");
			}
		});
		btnNewButton.setBounds(233, 402, 97, 23);
		contentPane.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("\uCFE0\uD3F0 \uC0AC\uC6A9");
		btnNewButton_1.setBounds(419, 402, 97, 23);
		contentPane.add(btnNewButton_1);
	}
}
