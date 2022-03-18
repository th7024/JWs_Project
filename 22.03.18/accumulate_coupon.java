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
	public static String p_number = "";
	private String[] str= {};
	public static int coupon_count;
	public static int add_couponN;
	public static int use_couponN;
	public static JLabel show_coupon;
	public static JLabel using_coupon;
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
		super("적립창");
		setVisible(true);	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
		setBounds(100, 100, 642, 547);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		show_coupon = new JLabel();
		show_coupon.setBounds(305, 152, 272, 28);
		contentPane.add(show_coupon);

		using_coupon = new JLabel();
		using_coupon.setBounds(305, 200, 272, 28);
		contentPane.add(using_coupon);
		
		enter_Number en = new enter_Number();
		p_number = en.getData();
		print_label();
		make_couponList();
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("굴림", Font.BOLD, 15));
		comboBox.setEditable(true);
		comboBox.setToolTipText("");
		comboBox.setModel(new DefaultComboBoxModel(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10" }));
		comboBox.setBounds(12, 138, 99, 42);
		comboBox.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				add_couponN = Integer.parseInt(comboBox.getSelectedItem().toString());
			}
		});
		contentPane.add(comboBox);
		
		JComboBox coupon_num = new JComboBox();
		coupon_num.setFont(new Font("굴림", Font.BOLD, 15));
		coupon_num.setEditable(true);
		coupon_num.setModel(new DefaultComboBoxModel(str));
		coupon_num.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				use_couponN = Integer.parseInt(coupon_num.getSelectedItem().toString());
			}
		});
		coupon_num.setBounds(305, 261, 97, 28);
		contentPane.add(coupon_num);

		JLabel Phone_N = new JLabel(p_number);
		Phone_N.setFont(new Font("굴림", Font.BOLD, 34));
		Phone_N.setBounds(12, 21, 390, 71);
		contentPane.add(Phone_N);

		JLabel lblNewLabel_1 = new JLabel("\uACE0\uAC1D\uB2D8 \uC801\uB9BD or \uC0AC\uC6A9");
		lblNewLabel_1.setFont(new Font("굴림", Font.PLAIN, 28));
		lblNewLabel_1.setBounds(349, 34, 265, 49);
		contentPane.add(lblNewLabel_1);

		JButton update_coupon = new JButton("\uCFE0\uD3F0 \uC801\uB9BD");
		update_coupon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				db_test1 dt = new db_test1();
				dt.plus_coupon(p_number, add_couponN);
				print_label();
				make_couponList();
			}
		});
		update_coupon.setBounds(133, 157, 97, 23);
		contentPane.add(update_coupon);

		JButton use_coupon = new JButton("\uCFE0\uD3F0 \uC0AC\uC6A9");
		use_coupon.addActionListener(new ActionListener() { // 쿠폰 몇장 사용할지 처리해얗라거 같은데
			public void actionPerformed(ActionEvent e) {
				db_test1 dt = new db_test1();
				dt.use_coupon(p_number, use_couponN);
				print_label();
				make_couponList();
			}
		});
		use_coupon.setBounds(428, 264, 97, 23);
		contentPane.add(use_coupon);
	
	}
	public void make_couponList() {
		db_test1 dt = new db_test1();
		coupon_count =dt.checked_coupon(p_number);
		if(coupon_count!=0) {
			str = new String[coupon_count/10];
			for(int i =0; i<coupon_count/10;i++) {
				str[i] = Integer.toString(i+1);
			}
		}
	}
	
	public void print_label() {
		db_test1 dt = new db_test1();
		coupon_count =dt.checked_coupon(p_number);
		show_coupon.setText("도장 개수 : "+coupon_count+ "장 입니다.");
		using_coupon.setText("사용 가능한 쿠폰 : "+coupon_count/10 + "장 입니다.");
	}
}
