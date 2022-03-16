import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.xdevapi.PreparableStatement;

public class db_test1 {
	private Connection con;
	private Statement st;
	private ResultSet rs;
	private PreparedStatement ps;
	public db_test1() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/customer_db?serverTimezone=UTC","root","root1234");
			st = con.createStatement();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public boolean isChecked(String PhoneN){ //번호유무 체크
		try {
			String Sql = "SELECT * FROM customer WHERE id = '" + PhoneN +"'";
			rs = st.executeQuery(Sql);
			if(rs.next()) {
				System.out.println("번홎ㄴ재");
				return true;
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}

		return false;
	}
	
	public boolean add_PN(String PhoneN){ //번호 추가
		try {
			String Sql = "INSERT INTO customer VALUES('" + PhoneN+"',0)" ;
			
			if(st.execute(Sql)) {
				return true;
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public void plus_coupon(String number, int coupon) {
		try {
			String Sql = "update customer set coupon = coupon + ? where id =?";
			ps = con.prepareStatement(Sql);
			ps.setInt(1, coupon);
			ps.setString(2, number);
			ps.execute();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void dbClose() {
		try {
			if (rs != null)
				rs.close();
			if (st != null)
				st.close();
			if (ps != null)
				ps.close();
		} catch (Exception e) {
			System.out.println(e + "=> dbClose fail");
		}
	}
	
}
